package org.elecciones.entidades;

import org.elecciones.interfaces.ValidarDNI;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ciudadano implements ValidarDNI {
    private String nombre;
    private String dni;
    private Sobre sobre;

    public Ciudadano(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        
    }

    public Ciudadano() {
        this.nombre = "";
        this.dni = "";
        this.sobre = null;
    }

    public Ciudadano(Ciudadano ciudadano1) {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null){
            this.nombre = "";
        }else {
            this.nombre = nombre.trim().toLowerCase();
        }

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Sobre getSobre() {
        return sobre;
    }

    public void setSobre(Sobre sobre) {
        this.sobre = sobre;
    }

    @Override
    public boolean validarDNI(String dni) {
        List<Integer> numeros = new LinkedList<>();
        int logitud = 9;
        if (dni.length() > 9)
        for (int i = 0; i < 10; i++){
            numeros.add(i);
        }


        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudadano ciudadano = (Ciudadano) o;
        return nombre.equals(ciudadano.nombre) && dni.equals(ciudadano.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni, sobre);
    }
}
