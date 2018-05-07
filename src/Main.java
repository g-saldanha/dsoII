import controlador.ControladorCarteira;
import controlador.ControladorPrincipal;
import modelo.Acao;
import modelo.Carteira;


public class Main {
    public static void main(String[] args) {
        Carteira gabriel = new Carteira("00955233917");
        gabriel.setSaldo(2000.0);
        gabriel.setNumeroDaCarteira("0001");
        gabriel.getAcoes().add(new Acao("Apple", 1, 38, 1, "00955233917"));
        ControladorCarteira.getInstanceCarteira().getListaDeCarteiras().add(gabriel);
        ControladorPrincipal.getInstance().abreTelaPrincipal();
    }
}
