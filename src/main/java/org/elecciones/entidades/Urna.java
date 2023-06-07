package org.elecciones.entidades;

import org.elecciones.interfaces.AccionesUrna;

import java.util.ArrayList;
import java.util.HashMap;

public class Urna implements AccionesUrna {
    private ArrayList<Sobre> sobres = new ArrayList<>();
    private HashMap <Papeleta, Integer> votos = new HashMap<>();

    public Urna(ArrayList<Sobre> sobres, HashMap<Papeleta, Integer> votos) {
        this.sobres = sobres;
        this.votos = votos;
    }
    public Urna() {

    }

    public ArrayList<Sobre> getSobres() {
        return sobres;
    }

    public void setSobres(ArrayList<Sobre> sobres) {
        this.sobres = sobres;
    }

    public HashMap<Papeleta, Integer> getVotos() {
        return votos;
    }

    public void setVotos(HashMap<Papeleta, Integer> votos) {
        this.votos = votos;
    }

    @Override
    public void introducirSobre(Sobre sobre) {
        sobres.add(sobre);



    }

    @Override
    public int getVotos(Papeleta papeleta) {
        return votos.getOrDefault(papeleta, 0);


    }


    @Override
    public void contabilizarVoto(Papeleta papeleta) {


    }

    @Override
    public String obtenerResultados() {
        votos.get(getVotos());

        return null;
    }
}
