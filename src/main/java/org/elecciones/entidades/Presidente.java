package org.elecciones.entidades;

import org.elecciones.interfaces.AccionesPresidente;

public class Presidente extends Ciudadano implements AccionesPresidente {

    public Presidente(String nombre, String dni) {
        super(nombre, dni);
    }

    public Presidente() {
    }

    public Presidente(Ciudadano ciudadano1) {
        super(ciudadano1);
    }


    @Override
    public void introducirSobreUrna(Sobre sobre, Urna urna) {
        urna.getSobres().add(sobre);

    }

    @Override
    public Sobre comprobarCiudadano(Ciudadano ciudadano, MesaElectoral mesa) {
        if (mesa.getCiudadanosQueHanVotado().contains(ciudadano)){
            System.out.println("Este ciudadano ya ha votado");
        }
        return null;
    }

    @Override
    public Papeleta comprobarSobre(Sobre sobre) {
        return null;
    }
}
