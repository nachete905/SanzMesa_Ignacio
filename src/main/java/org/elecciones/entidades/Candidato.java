package org.elecciones.entidades;

public class Candidato extends Ciudadano {
    private int numeroLista;
    final static int MAX_NUMERO_LISTA = 50;

    /*public Candidato(String nombre, String dni, int numeroLista) {
        super(nombre, dni, sobre);
        this.numeroLista = numeroLista;
    }*/


    public Candidato(String nombre, String dni, int numeroLista) {
        super(nombre, dni);
        this.numeroLista = numeroLista;
    }

    public Candidato(int numeroLista) {
        this.numeroLista = numeroLista;
    }

    public int getNumeroLista() {
        return numeroLista;
    }

    public void setNumeroLista(int numeroLista) {
        this.numeroLista = numeroLista;
    }
}
