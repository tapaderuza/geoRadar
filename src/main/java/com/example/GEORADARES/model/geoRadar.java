package com.example.GEORADARES.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class geoRadar {

    // Identificacion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;

    // Ubicacion
    private double latitud;
    private double longitud;
    private int altitud;
    private String direccion;

    // Espeficiaciones técnicas
    private String modelo;
    private String fabricante;
    private LocalDate fechaIns;
    private String estado;

    // Datos operativos
    private String frecuencia;
    private int distanciaMax;
    private int sensibilidad;

    //Datos de monitoreo
    private String ultimaLectura;
    @ElementCollection
    private List<String> historial;
    @ElementCollection
    private List<String> alertas;


    //Getter y Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(LocalDate fechaIns) {
        this.fechaIns = fechaIns;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getDistanciaMax() {
        return distanciaMax;
    }

    public void setDistanciaMax(int distanciaMax) {
        this.distanciaMax = distanciaMax;
    }

    public int getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(int sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public String getUltimaLectura() {
        return ultimaLectura;
    }

    public void setUltimaLectura(String ultimaLectura) {
        this.ultimaLectura = ultimaLectura;
    }

    public List<String> getHistorial() {
        return historial;
    }

    public void setHistorial(List<String> historial) {
        this.historial = historial;
    }

    public List<String> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<String> alertas) {
        this.alertas = alertas;
    }
}
