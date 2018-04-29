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
    private enum tiposTransacao{COMPRA, VENDA};
    private enum acao{GOOGLE, FACEBOOK, YOUTUBE};

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
        tableResumo = new JTable(TableModelAcoes.getInstance());
        tableResumo.setBounds(66, 54, 852, 203);
        contentPane.add(tableResumo);

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
        jcbTipoDeAcao.addItem(tiposTransacao.COMPRA);
        jcbTipoDeAcao.addItem(tiposTransacao.VENDA);
        contentPane.add(jcbTipoDeAcao);

        JLabel lblAo = new JLabel(Mensagens.ACAO + ":");
        lblAo.setBounds(76, 378, 262, 40);
        contentPane.add(lblAo);

        JComboBox jcbAcao = new JComboBox();
        jcbAcao.setBounds(76, 418, 262, 40);
        jcbAcao.addItem(acao.FACEBOOK);
        jcbAcao.addItem(acao.GOOGLE);
        jcbAcao.addItem(acao.YOUTUBE);
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

        JLabel lblVlUnitarioValue = new JLabel("R$ 123,00");
        lblVlUnitarioValue.setBounds(76, 738, 262, 40);
        lblVlUnitarioValue.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblVlUnitarioValue);

        JLabel lblNewLabel = new JLabel(Mensagens.TOTAL + ":");
        lblNewLabel.setBounds(76, 778, 262, 40);
        contentPane.add(lblNewLabel);

        JLabel lblR = new JLabel("R$ 123,00");
        lblR.setBounds(76, 818, 262, 40);
        lblR.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblR);

        JButton jbtRegistrar = new JButton(Mensagens.REGISTRAR_TRANSACAO);
        jbtRegistrar.setBounds(86, 871, 165, 25);
        contentPane.add(jbtRegistrar);

        JButton jbtCancelar = new JButton(Mensagens.CANCELAR);
        jbtCancelar.setBounds(364, 871, 83, 25);
        jbtCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        contentPane.add(jbtCancelar);

        jbtRegistrar.addActionListener(x->{
            JOptionPane.showMessageDialog(null, ControladorCarteira.cadAcao(jcbTipoDeAcao.getSelectedItem(), jcbAcao.getSelectedItem(), jtfQtd.getText(), jlbImposto.getText(), lblJlbcorretagem.getText(), lblVlUnitarioValue.getText()));
        });


    }

    private void popularCampos() {
        //this.jtpCarteira = ControladorCarteira.popularCamposDaTabela();
        ControladorCarteira.popularCamposDaTabela();
    }


}
