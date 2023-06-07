package org.elecciones.entidades;

public class Sobre {
    private Object contenido;

    public Sobre(Object contenido) {
        this.contenido = contenido;
    }
    public Sobre(){
        this.contenido = "";
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        if (contenido == ""){
            this.contenido = "";
        }else {
            this.contenido = contenido;
        }

    }

    @Override
    public String toString() {
        return "Sobre{" +
                "contenido=" + contenido +
                '}';
    }
}
