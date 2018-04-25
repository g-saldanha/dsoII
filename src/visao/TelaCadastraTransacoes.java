package visao;

import Recursos.Mensagens;
import controlador.ControladorCarteira;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadastraTransacoes extends JFrame {

    private JTable jtpCarteira;
    private JPanel contentPane;
    private JTextField jtfQtd;
    private enum tiposTransacao{COMPRA, VENDA};
    private enum acao{GOOGLE, FACEBOOK, YOUTUBE};

    /**
     * Create the frame.
     */
    public TelaCadastraTransacoes() {
        setTitle(Mensagens.TRANSACOES);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(false);
        setBounds(100, 100, 892, 687);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(20,0));

        JLabel lblResumoDaCarteira = new JLabel(Mensagens.RESUMO_DA_CARTEIRA);
        lblResumoDaCarteira.setBounds(369, 44, 128, 16);
        lblResumoDaCarteira.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblResumoDaCarteira);

        jtpCarteira = new JTable();
        popularCampos();
        JScrollPane jtpCarteiraPane = new JScrollPane(this.jtpCarteira);
        jtpCarteira.setPreferredScrollableViewportSize(new Dimension(500,300));
        jtpCarteira.setFillsViewportHeight(true);
        contentPane.add(jtpCarteiraPane);

        JLabel lblRegistrarTransaes = new JLabel(Mensagens.REGISTRAR_TRANSACAO);
        lblRegistrarTransaes.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRegistrarTransaes.setBounds(369, 293, 144, 32);
        lblRegistrarTransaes.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblRegistrarTransaes);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(338, 341, 56, 16);
        contentPane.add(lblTipo);

        JComboBox jcbTipoDeAcao = new JComboBox();
        jcbTipoDeAcao.setBounds(432, 338, 116, 22);
        jcbTipoDeAcao.addItem(tiposTransacao.COMPRA);
        jcbTipoDeAcao.addItem(tiposTransacao.VENDA);
        contentPane.add(jcbTipoDeAcao);

        JLabel lblAo = new JLabel(Mensagens.ACAO + ":");
        lblAo.setBounds(338, 376, 56, 16);
        contentPane.add(lblAo);

        JComboBox jcbAcao = new JComboBox();
        jcbAcao.setBounds(432, 373, 116, 22);
        jcbAcao.addItem(acao.FACEBOOK);
        jcbAcao.addItem(acao.GOOGLE);
        jcbAcao.addItem(acao.YOUTUBE);
        contentPane.add(jcbAcao);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(338, 413, 82, 16);
        contentPane.add(lblQuantidade);

        jtfQtd = new JTextField();
        jtfQtd.setBounds(432, 410, 116, 22);
        contentPane.add(jtfQtd);
        jtfQtd.setColumns(10);

        JLabel lblCorretagem = new JLabel("Corretagem:");
        lblCorretagem.setBounds(338, 448, 82, 16);
        contentPane.add(lblCorretagem);

        JLabel lblJlbcorretagem = new JLabel("00%");
        lblJlbcorretagem.setHorizontalAlignment(SwingConstants.RIGHT);
        lblJlbcorretagem.setBounds(432, 448, 116, 16);
        contentPane.add(lblJlbcorretagem);

        JLabel lblImpostos = new JLabel("Impostos:");
        lblImpostos.setBounds(338, 477, 72, 16);
        contentPane.add(lblImpostos);

        JLabel jlbImposto = new JLabel("10%");
        jlbImposto.setHorizontalAlignment(SwingConstants.RIGHT);
        jlbImposto.setBounds(432, 477, 116, 16);
        contentPane.add(jlbImposto);

        JLabel lblVlUnitario = new JLabel(Mensagens.VALOR_UNITARIO);
        lblVlUnitario.setBounds(338, 515, 56, 16);
        contentPane.add(lblVlUnitario);

        JLabel lblVlUnitarioValue = new JLabel("R$ 123,00");
        lblVlUnitarioValue.setHorizontalAlignment(SwingConstants.RIGHT);
        lblVlUnitarioValue.setBounds(442, 515, 106, 16);
        contentPane.add(lblVlUnitarioValue);

        JLabel lblNewLabel = new JLabel("Total:");
        lblNewLabel.setBounds(338, 515, 56, 16);
        contentPane.add(lblNewLabel);

        JLabel lblR = new JLabel("R$ 123,00");
        lblR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblR.setBounds(442, 515, 106, 16);
        contentPane.add(lblR);

        JButton jbtRegistrar = new JButton(Mensagens.REGISTRAR_TRANSACAO);
        jbtRegistrar.setBounds(238, 555, 156, 25);
        contentPane.add(jbtRegistrar);

        JButton jbtCancelar = new JButton(Mensagens.CANCELAR);
        jbtCancelar.setBounds(502, 555, 97, 25);
        contentPane.add(jbtCancelar);

        jbtRegistrar.addActionListener(x->{
            JOptionPane.showMessageDialog(null, ControladorCarteira.cadAcao(jcbTipoDeAcao.getSelectedItem(), jcbAcao.getSelectedItem(), jtfQtd.getText(), jlbImposto.getText(), lblJlbcorretagem.getText(), lblVlUnitarioValue.getText()));
        });


    }

    private void popularCampos() {
        this.jtpCarteira = ControladorCarteira.popularCamposDaTabela();
    }


}