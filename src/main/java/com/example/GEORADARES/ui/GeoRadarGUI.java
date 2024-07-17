package com.example.GEORADARES.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.time.LocalDate;

public class GeoRadarGUI extends JFrame {
    private JTable table;
    private GeoRadarTableModel tableModel;
    private Timer timer;
    private String username;
    private String password;

    public GeoRadarGUI(String username, String password) throws Exception {
        this.username = username;
        this.password = password;

        setTitle("GeoRadars Monitoring");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new GeoRadarTableModel();
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        timer = new Timer(5000, e -> fetchData());
        timer.start();

        fetchData();  // Initial data fetch
    }

    private void fetchData() {
        try {
            URL url = new URL("http://localhost:8080/api/georadars");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String contentType = conn.getContentType();
                if (contentType != null && contentType.contains("application/json")) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.registerModule(new JavaTimeModule());
                    List<GeoRadar> geoRadars = mapper.readValue(response.toString(), mapper.getTypeFactory().constructCollectionType(List.class, GeoRadar.class));
                    tableModel.setGeoRadars(geoRadars);
                } else {
                    System.out.println("Unexpected content type: " + contentType);
                }
            } else {
                System.out.println("GET request failed: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class GeoRadar {
        private String id;
        private String nombre;
        private int latitud;
        private int longitud;
        private int altitud;
        private String direccion;
        private String modelo;
        private String fabricante;
        private LocalDate fechaIns;
        private String estado;
        private String frecuencia;
        private int distanciaMax;
        private int sensibilidad;
        private String ultimaLectura;

        // Getters y setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public int getLatitud() { return latitud; }
        public void setLatitud(int latitud) { this.latitud = latitud; }
        public int getLongitud() { return longitud; }
        public void setLongitud(int longitud) { this.longitud = longitud; }
        public int getAltitud() { return altitud; }
        public void setAltitud(int altitud) { this.altitud = altitud; }
        public String getDireccion() { return direccion; }
        public void setDireccion(String direccion) { this.direccion = direccion; }
        public String getModelo() { return modelo; }
        public void setModelo(String modelo) { this.modelo = modelo; }
        public String getFabricante() { return fabricante; }
        public void setFabricante(String fabricante) { this.fabricante = fabricante; }
        public LocalDate getFechaIns() { return fechaIns; }
        public void setFechaIns(LocalDate fechaIns) { this.fechaIns = fechaIns; }
        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }
        public String getFrecuencia() { return frecuencia; }
        public void setFrecuencia(String frecuencia) { this.frecuencia = frecuencia; }
        public int getDistanciaMax() { return distanciaMax; }
        public void setDistanciaMax(int distanciaMax) { this.distanciaMax = distanciaMax; }
        public int getSensibilidad() { return sensibilidad; }
        public void setSensibilidad(int sensibilidad) { this.sensibilidad = sensibilidad; }
        public String getUltimaLectura() { return ultimaLectura; }
        public void setUltimaLectura(String ultimaLectura) { this.ultimaLectura = ultimaLectura; }
    }
}

class GeoRadarTableModel extends DefaultTableModel {
    private List<GeoRadarGUI.GeoRadar> geoRadars;

    public GeoRadarTableModel() {
        addColumn("ID");
        addColumn("Nombre");
        addColumn("Latitud");
        addColumn("Longitud");
        addColumn("Altitud");
        addColumn("Direccion");
        addColumn("Modelo");
        addColumn("Fabricante");
        addColumn("Fecha Instalacion");
        addColumn("Estado");
        addColumn("Frecuencia");
        addColumn("Distancia Max");
        addColumn("Sensibilidad");
        addColumn("Ultima Lectura");
    }

    public void setGeoRadars(List<GeoRadarGUI.GeoRadar> geoRadars) {
        this.geoRadars = geoRadars;
        setRowCount(0); // Clear existing data

        for (GeoRadarGUI.GeoRadar radar : geoRadars) {
            addRow(new Object[]{
                    radar.getId(),
                    radar.getNombre(),
                    radar.getLatitud(),
                    radar.getLongitud(),
                    radar.getAltitud(),
                    radar.getDireccion(),
                    radar.getModelo(),
                    radar.getFabricante(),
                    radar.getFechaIns(),
                    radar.getEstado(),
                    radar.getFrecuencia(),
                    radar.getDistanciaMax(),
                    radar.getSensibilidad(),
                    radar.getUltimaLectura()
            });
        }
    }
}






