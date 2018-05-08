package controlador;

import modelo.Registro;

import java.util.ArrayList;

public class ControladorRelatorios {
    private ArrayList<Registro> listaDeRegistros;
    private static ControladorRelatorios instanceOfRelatorios;

    public ControladorRelatorios() {
        this.listaDeRegistros = new ArrayList<>();
    }

    public static ControladorRelatorios getInstanceOfRelatorios(){
        if (instanceOfRelatorios == null) {
            return instanceOfRelatorios = new ControladorRelatorios();
        } else {
            return instanceOfRelatorios;
        }
    }


    public void cadastraRegistro(String tipo, String nome, Integer qtd, Double valorUnitario) {
        listaDeRegistros.add(new Registro(nome, qtd, valorUnitario, tipo));
    }
}
