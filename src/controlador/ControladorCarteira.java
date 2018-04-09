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

    public static ArrayList<Carteira> getListaDeCarteiras() {
        return listaDeCarteiras;
    }

    public static void setListaDeCarteiras(ArrayList<Carteira> listaDeCarteiras) {
        ControladorCarteira.listaDeCarteiras = listaDeCarteiras;
    }

    public boolean cadastrarCarteira(String cpf){
    	if(!existeUsuario(cpf)) {
    		getListaDeCarteiras().add(new Carteira(cpf));
    		return true;
    	}
		return false;
    }

	public boolean carregaUsuario(String text) {
		for(Carteira carteira: listaDeCarteiras) {
			if(carteira.getCpf().equals(text)) {
				carteiraEmUSo = carteira;
				return true;
			}			
		}
		return false;
		
	}
	
	public boolean existeUsuario(String text) {
		for(Carteira carteira: listaDeCarteiras) {
			if(carteira.getCpf().equals(text)) {
				return true;
			}			
		}
		return false;
	}

}
