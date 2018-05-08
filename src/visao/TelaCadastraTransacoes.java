package visao;

import Recursos.Mensagens;
import controlador.ControladorAcoes;
import controlador.ControladorCarteira;
import controlador.ControladorPrincipal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastraTransacoes extends JFrame {

    private JTable jtpCarteira;
    private JPanel contentPane;
    private JTextField jtfQtd;


    /**
     * Create the frame.
     */
    public TelaCadastraTransacoes() {
        setTitle(Mensagens.TRANSACOES);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(false);
        setBounds(100, 100, 892, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(30,0));

        JLabel lblResumoDaCarteira = new JLabel(Mensagens.RESUMO_DA_CARTEIRA);
        lblResumoDaCarteira.setBounds(369, 44, 128, 16);
        lblResumoDaCarteira.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblResumoDaCarteira);

        JLabel saldoLabel = new JLabel(Mensagens.VALOR_EM_CAIXA);
        saldoLabel.setBounds(369,44,128,16);
        saldoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(saldoLabel);

        JLabel saldoValue = new JLabel(ControladorCarteira.getInstanceCarteira().getValorEmCaixaCateira());
        saldoValue.setBounds(369,44,128,16);
        saldoValue.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(saldoValue);

        jtpCarteira = new JTable();
        popularCampos();
        JScrollPane jtpCarteiraPane = new JScrollPane(this.jtpCarteira);
        jtpCarteira.setPreferredScrollableViewportSize(new Dimension(500,300));
        jtpCarteira.setFillsViewportHeight(true);
        jtpCarteira.setPreferredSize(new Dimension(500,300));
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
        jcbTipoDeAcao.addItem(Mensagens.COMPRAR);
        jcbTipoDeAcao.addItem(Mensagens.VENDER);
        contentPane.add(jcbTipoDeAcao);

        JLabel lblAo = new JLabel(Mensagens.ACAO + ":");
        lblAo.setBounds(338, 376, 56, 16);
        contentPane.add(lblAo);

        JComboBox jcbAcao = ControladorAcoes.getInstanceAcoes().getComboAcoes();
        contentPane.add(jcbAcao);

        JLabel lblQuantidade = new JLabel(Mensagens.QTD+": ");
        lblQuantidade.setBounds(338, 413, 82, 16);
        contentPane.add(lblQuantidade);

        jtfQtd = new JTextField();
        jtfQtd.setBounds(432, 410, 116, 22);
        contentPane.add(jtfQtd);
        jtfQtd.setColumns(10);

        JLabel lblCorretagem = new JLabel("Corretagem:");
        lblCorretagem.setBounds(338, 448, 82, 16);
        contentPane.add(lblCorretagem);

        JLabel lblJlbcorretagem = new JLabel("0");
        lblJlbcorretagem.setHorizontalAlignment(SwingConstants.RIGHT);
        lblJlbcorretagem.setBounds(432, 448, 116, 16);
        contentPane.add(lblJlbcorretagem);

        JLabel lblImpostos = new JLabel("Impostos:");
        lblImpostos.setBounds(338, 477, 72, 16);
        contentPane.add(lblImpostos);

        JLabel jlbImposto = new JLabel("10");
        jlbImposto.setHorizontalAlignment(SwingConstants.RIGHT);
        jlbImposto.setBounds(432, 477, 116, 16);
        contentPane.add(jlbImposto);

        JLabel lblVlUnitario = new JLabel(Mensagens.VALOR_UNITARIO);
        lblVlUnitario.setBounds(338, 515, 56, 16);
        contentPane.add(lblVlUnitario);

        JLabel lblVlUnitarioValue = new JLabel(ControladorAcoes.getInstanceAcoes().getValorUnitario(jcbAcao.getSelectedItem()));
        lblVlUnitarioValue.setHorizontalAlignment(SwingConstants.RIGHT);
        lblVlUnitarioValue.setBounds(442, 515, 106, 16);
        contentPane.add(lblVlUnitarioValue);

        JLabel lblNewLabel = new JLabel("Total:");
        lblNewLabel.setBounds(338, 515, 56, 16);
        contentPane.add(lblNewLabel);

        Double calcVT = ControladorPrincipal.calculaValorTotal(jtfQtd, lblVlUnitarioValue);
        JLabel lblR = new JLabel("" + calcVT);
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
            if (jcbTipoDeAcao.getSelectedItem().toString().equals(Mensagens.COMPRAR)) {
                String mensagem = ControladorCarteira.cadAcao(jcbTipoDeAcao.getSelectedItem().toString(), jcbAcao.getSelectedItem().toString(), Integer.parseInt(jtfQtd.getText()), Double.parseDouble(jlbImposto.getText()), Double.parseDouble(lblVlUnitarioValue.getText()), Double.parseDouble(lblJlbcorretagem.getText()));
                popularCampos();
                JOptionPane.showMessageDialog(null, "" + mensagem);
            } else {
                JOptionPane.showMessageDialog(null, "algo");
            }
        });

        jcbAcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblVlUnitarioValue.setText(ControladorAcoes.getInstanceAcoes().getValorUnitario(jcbAcao.getSelectedItem()));
            }
        });

        jtfQtd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblR.setText("" + ControladorPrincipal.calculaValorTotal(jtfQtd, lblVlUnitarioValue));
            }
        });
    }

    private void popularCampos() {
        this.jtpCarteira = ControladorCarteira.popularCamposDaTabela();
    }


}