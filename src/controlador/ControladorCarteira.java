package controlador;

import modelo.Carteira;

import java.util.ArrayList;

public class ControladorCarteira {
    private static ControladorCarteira instanceCarteira;
    private static ArrayList<Carteira> listaDeCarteiras;
    private Carteira carteiraEmUSo;

    private ControladorCarteira() {
        listaDeCarteiras = new ArrayList();
    }

    public static ControladorCarteira getInstanceCarteira(){
        if (instanceCarteira == null) {
            return instanceCarteira = new ControladorCarteira();
        }
        return instanceCarteira;
    }

    public static ArrayList getListaDeCarteiras() {
        return listaDeCarteiras;
    }

    public static void setListaDeCarteiras(ArrayList listaDeCarteiras) {
        ControladorCarteira.listaDeCarteiras = listaDeCarteiras;
    }

    public void cadastrarCarteira(String cpf){
        getListaDeCarteiras().add(new Carteira(cpf));
    }

	public void carregaUsuario(String text) throws Exception {
		for(Carteira carteira: listaDeCarteiras) {
			if(carteira.getCpf().equals(text)) {
				carteiraEmUSo = carteira;
			}			
		}
		
	}

}
