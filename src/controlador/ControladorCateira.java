package controlador;

import modelo.Carteira;

import java.util.ArrayList;

public class ControladorCateira {
    private static ControladorCateira instanceCarteira;
    private static ArrayList listaDeCarteiras;

    private ControladorCateira() {
        listaDeCarteiras = new ArrayList();
    }

    public static ControladorCateira getInstanceCarteira(){
        if (instanceCarteira == null) {
            instanceCarteira = new ControladorCateira();aa
        }
        return instanceCarteira;
    }

    public static ArrayList getListaDeCarteiras() {
        return listaDeCarteiras;
    }

    public static void setListaDeCarteiras(ArrayList listaDeCarteiras) {
        ControladorCateira.listaDeCarteiras = listaDeCarteiras;
    }

    public void cadastrarCarteira(String cpf){
        getListaDeCarteiras().add(new Carteira(cpf));
    }

}
