package org.elecciones.entidades;

import org.elecciones.interfaces.AccionesMesaElectoral;
import org.elecciones.interfaces.FicheroCiudadanos;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MesaElectoral implements AccionesMesaElectoral, FicheroCiudadanos {
    private String direccion;
    private Ciudadano componentes[] = new Ciudadano[NUM_COMPONENTES];
    private Urna urna;
    private List<Ciudadano> censoElectoral = new ArrayList<>();
    private List<Ciudadano> ciudadanosQueHanVotado = new LinkedList<>();
    final static int NUM_COMPONENTES = 5;


    public MesaElectoral(String direccion, Ciudadano[] componentes, Urna urna, List<Ciudadano> censoElectoral, List<Ciudadano> ciudadanosQueHanVotado) {
        this.direccion = direccion;
        this.componentes = new Ciudadano[NUM_COMPONENTES];
        this.censoElectoral = censoElectoral;
        for (int i = 0; i < componentes.length; i++) {
            componentes[i] = new Ciudadano();
        }
    }

    public MesaElectoral() {
        this.direccion = "";




    }


    public MesaElectoral(String s, ArrayList<Ciudadano> ciudadanos, Urna urna) {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null) {
            System.out.println("No puede ser nulo");
        } else {
            this.direccion = direccion.trim().toLowerCase();
        }

    }

    public Ciudadano[] getComponentes() {
        return componentes;
    }

    public void setComponentes(Ciudadano[] componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i] = new Ciudadano();
        }
        if (componentes == null) {
            System.err.println("No puede ser nulo");
        } else {
            this.componentes = componentes;
        }

    }

    public Urna getUrna() {
        return urna;
    }

    public void setUrna(Urna urna) {
        this.urna = urna;
    }

    public List<Ciudadano> getCensoElectoral() {
        return censoElectoral;
    }

    public void setCensoElectoral(List<Ciudadano> censoElectoral) {
        this.censoElectoral = censoElectoral;
    }

    public List<Ciudadano> getCiudadanosQueHanVotado() {
        return ciudadanosQueHanVotado;
    }

    public void setCiudadanosQueHanVotado(List<Ciudadano> ciudadanosQueHanVotado) {
        this.ciudadanosQueHanVotado = ciudadanosQueHanVotado;
    }

    @Override
    public boolean agnadirPresidente(Ciudadano ciudadano) throws ExceptionElementoRepetido {
        int index = buscarPresidente(ciudadano);
        if (ciudadano instanceof Presidente) {
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i].equals(ciudadano)) {
                    throw new ExceptionElementoRepetido("Presidente repetido");
                } else if (componentes[i].equals(new Ciudadano())) {
                    componentes[i] = ciudadano;
                    return true;
                }
            }
        }


        return false;
    }

    @Override
    public boolean agnadirMiembroMesa(Ciudadano ciudadano) throws ExceptionElementoRepetido {
        int index = -1;
        for (int i = 0; i < componentes.length; i++) {
            if (index == 0) {
                System.err.println("No hay espacio");
            } else if (componentes[i].equals(ciudadano)) {
                throw  new ExceptionElementoRepetido("Elemento repetido");
            }else if (index != 0) {
                if (componentes[i].equals(new Ciudadano())){
                    componentes[i]=ciudadano;
                    return true;
                }
            }

        }




        return false;
    }

    @Override
    public int buscarComponente(Ciudadano ciudadano) {
        int indice = -1;
        if (indice != 0) {
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i].equals(ciudadano)) {
                    return i;
                }


            }

        }


        return -1;
    }

    @Override
    public int buscarPresidente(Ciudadano ciudadano) {
        if (ciudadano instanceof Presidente) {
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i] instanceof Presidente) {
                    return i;
                }
            }
        }

        return -1;
    }



    @Override
    public List<Ciudadano> leerCiudadanos(String nombreFichero) {
        List<Ciudadano> ciudadanos = new ArrayList<>();

        try {
            FileReader fr = new FileReader(nombreFichero);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void guardarCiudadanos(String nombreFichero, List<Ciudadano> ciudadanos) {
        try {
            FileWriter fw = new FileWriter(nombreFichero);
            for (Ciudadano ciudadano: ciudadanos) {
                String linea = ciudadano.getNombre();
                fw.write(linea + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
