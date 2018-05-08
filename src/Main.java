import controlador.ControladorCarteira;
import controlador.ControladorPrincipal;
import modelo.Acao;
import modelo.Carteira;


public class Main {
    public static void main(String[] args) {
        Carteira gabriel = new Carteira("00955233917");
        gabriel.setSaldo(2000.0);
        gabriel.setNumeroDaCarteira("0001");
        Acao acao = new Acao("Apple", 1, 38, 1);
        acao.setCpf("00955233917");
        gabriel.getAcoes().add(acao);
        ControladorCarteira.getInstanceCarteira().getListaDeCarteiras().add(gabriel);
        ControladorPrincipal.getInstance().abreTelaPrincipal();
    }
}
