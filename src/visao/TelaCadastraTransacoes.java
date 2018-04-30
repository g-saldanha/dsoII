package visao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import Recursos.Mensagens;
import controlador.ControladorCarteira;
import modelo.TableModelAcoes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastraTransacoes extends JFrame {

    private JTable jtpCarteira;
    private JPanel contentPane;
    private JTextField jtfQtd;
    private JTable tableResumo;

    /**
     * Create the frame.
     */
    public TelaCadastraTransacoes() {
        setTitle(Mensagens.TRANSACOES);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(false);
        setBounds(15, -47, 1011, 943);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblResumoDaCarteira = new JLabel(Mensagens.RESUMO_DA_CARTEIRA);
        lblResumoDaCarteira.setBounds(364, 13, 262, 40);
        lblResumoDaCarteira.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblResumoDaCarteira);

        
        //Criei um TableModel e Apliquei a tabela 
        tableResumo = new JTable();
        tableResumo.setModel(TableModelAcoes.getInstance());
        tableResumo.setBounds(66, 54, 852, 203);
        contentPane.add(tableResumo);

        JLabel lblValorEmCaixa = new JLabel(Mensagens.VALOR_EM_CAIXA);
        lblValorEmCaixa.setBounds(76, 258, 262, 40);
        lblValorEmCaixa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblValorEmCaixa.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblValorEmCaixa);

        double valorEmCaixa = ControladorCarteira.getInstanceCarteira().getValorEmCaixaCateira();
        JLabel fieldValorEmCaixa = new JLabel("" + valorEmCaixa);
        fieldValorEmCaixa.setBounds(76, 258, 262, 40);
        fieldValorEmCaixa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        fieldValorEmCaixa.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(fieldValorEmCaixa);


        JLabel lblRegistrarTransaes = new JLabel(Mensagens.REGISTRAR_TRANSACAO);
        lblRegistrarTransaes.setBounds(76, 258, 262, 40);
        lblRegistrarTransaes.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRegistrarTransaes.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblRegistrarTransaes);

        JLabel lblTipo = new JLabel(Mensagens.TIPO);
        lblTipo.setBounds(76, 298, 262, 40);
        contentPane.add(lblTipo);

        JComboBox jcbTipoDeAcao = new JComboBox();
        jcbTipoDeAcao.setBounds(76, 338, 262, 40);
        jcbTipoDeAcao.addItem(Mensagens.COMPRAR);
        jcbTipoDeAcao.addItem(Mensagens.VENDER);
        contentPane.add(jcbTipoDeAcao);

        JLabel lblAo = new JLabel(Mensagens.ACAO + ":");
        lblAo.setBounds(76, 378, 262, 40);
        contentPane.add(lblAo);

        JComboBox jcbAcao = new JComboBox();
        jcbAcao.setBounds(76, 418, 262, 40);
        jcbAcao.addItem(Mensagens.FACEBOOK);
        jcbAcao.addItem(Mensagens.GOOGLE);
        jcbAcao.addItem(Mensagens.YOUTUBE);
        contentPane.add(jcbAcao);

        JLabel lblQuantidade = new JLabel(Mensagens.QTD + ":");
        lblQuantidade.setBounds(76, 458, 262, 40);
        contentPane.add(lblQuantidade);

        jtfQtd = new JTextField();
        jtfQtd.setBounds(76, 498, 262, 40);
        contentPane.add(jtfQtd);
        jtfQtd.setColumns(10);

        JLabel lblCorretagem = new JLabel(Mensagens.CORRETAGEM + ":");
        lblCorretagem.setBounds(76, 538, 262, 40);
        contentPane.add(lblCorretagem);

        JLabel lblJlbcorretagem = new JLabel("00%");
        lblJlbcorretagem.setBounds(76, 578, 262, 40);
        lblJlbcorretagem.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblJlbcorretagem);

        JLabel lblImpostos = new JLabel(Mensagens.IMPOSTO + ":");
        lblImpostos.setBounds(76, 618, 262, 40);
        contentPane.add(lblImpostos);

        JLabel jlbImposto = new JLabel("10%");
        jlbImposto.setBounds(76, 658, 262, 40);
        jlbImposto.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(jlbImposto);

        JLabel lblVlUnitario = new JLabel(Mensagens.VALOR_UNITARIO);
        lblVlUnitario.setBounds(76, 698, 262, 40);
        contentPane.add(lblVlUnitario);

        JLabel lblVlUnitarioValue = new JLabel("1,23");
        lblVlUnitarioValue.setBounds(76, 738, 262, 40);
        lblVlUnitarioValue.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblVlUnitarioValue);

        JLabel lblNewLabel = new JLabel(Mensagens.TOTAL + ":");
        lblNewLabel.setBounds(76, 778, 262, 40);
        contentPane.add(lblNewLabel);

        JLabel lblR = new JLabel("123,00");
        lblR.setBounds(76, 818, 262, 40);
        lblR.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblR);

        JButton jbtRegistrar = new JButton(Mensagens.REGISTRAR_TRANSACAO);
        jbtRegistrar.setBounds(86, 871, 165, 25);
        jbtRegistrar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0) {
        	    if (jcbTipoDeAcao.getSelectedItem().equals(Mensagens.COMPRAR)) {
                    ControladorCarteira.getInstanceCarteira().cadAcao(jcbTipoDeAcao.getSelectedItem().toString(), jcbAcao.getSelectedItem().toString(), Integer.parseInt(jtfQtd.getText()), Double.parseDouble(jlbImposto.getText()), Double.parseDouble(lblJlbcorretagem.getText()));
                } else {
        	        ControladorCarteira.getInstanceCarteira().venderAcao(jtfQtd.getText(), jcbAcao.getSelectedItem().toString());                }

        	}
        });
        contentPane.add(jbtRegistrar);

        JButton jbtCancelar = new JButton(Mensagens.CANCELAR);
        jbtCancelar.setBounds(364, 871, 83, 25);
        jbtCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        contentPane.add(jbtCancelar);

        


    }

    private void popularCampos() {
        //this.jtpCarteira = ControladorCarteira.popularCamposDaTabela();
        ControladorCarteira.popularCamposDaTabela();
    }


}
