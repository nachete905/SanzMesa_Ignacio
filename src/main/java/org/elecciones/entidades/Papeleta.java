package org.elecciones.entidades;

import java.util.ArrayList;
import java.util.Collection;

public class Papeleta {

    enum PartidoPolitico {PP,PSOE,VOX,MOVIMIENTO_SUMAR,VACIO};

    private Papeleta.PartidoPolitico partidoPolitico;

    public Papeleta(Papeleta.PartidoPolitico movimientoSumar, Collection candidatos) {
        this.partidoPolitico = getPartidoPolitico();
    }

    public void setPartidoPolitico(Papeleta.PartidoPolitico pp) {

    }



    private ArrayList<String> candidatos = new ArrayList<>();


    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }
    public Papeleta(ArrayList<String> candidatos) {
        this.candidatos = candidatos;
    }
    public Papeleta(){
        this.candidatos = null;
    }

    public ArrayList<String> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<String> candidatos) {
        if (candidatos.contains(candidatos)){
            System.out.println("candidato repetido");
        }else {
            this.candidatos = candidatos;
        }

    }
}
