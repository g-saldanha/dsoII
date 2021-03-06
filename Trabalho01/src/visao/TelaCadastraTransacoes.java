package visao;

import Recursos.Mensagens;
import controlador.ControladorAcoes;
import controlador.ControladorCarteira;
import controlador.ControladorPrincipal;
import controlador.ControladorRelatorios;
import modelo.TableModelAcoes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCadastraTransacoes extends JFrame {

    private JTable jtpCarteira;
    private JPanel contentPane;
    private JTextField jtfQtd;
    private JLabel lblVlUnitarioValue;
    private JComboBox jcbAcao;
    private JLabel lblR;
    private JLabel saldoValue;
    


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
        contentPane.setLayout(null);

        JLabel lblResumoDaCarteira = new JLabel(Mensagens.RESUMO_DA_CARTEIRA);
        lblResumoDaCarteira.setBounds(5, 16, 864, 24);
        lblResumoDaCarteira.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblResumoDaCarteira);

        JLabel saldoLabel = new JLabel(Mensagens.VALOR_EM_CAIXA);
        saldoLabel.setBounds(5, 40, 864, 24);
        saldoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(saldoLabel);

        saldoValue = new JLabel(ControladorCarteira.getInstanceCarteira().getValorEmCaixaCateira());
        saldoValue.setBounds(5, 64, 864, 24);
        saldoValue.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(saldoValue);

        jtpCarteira = new JTable();
        popularCampos();
        jtpCarteira.setModel(TableModelAcoes.getInstance());
        JScrollPane jtpCarteiraPane = new JScrollPane(this.jtpCarteira);
        jtpCarteiraPane.setBounds(5, 88, 864, 139);
        jtpCarteira.setPreferredScrollableViewportSize(new Dimension(500,300));
        jtpCarteira.setFillsViewportHeight(true);
        jtpCarteira.setPreferredSize(new Dimension(500,300));
        contentPane.add(jtpCarteiraPane);

        JLabel lblRegistrarTransaes = new JLabel(Mensagens.REGISTRAR_TRANSACAO);
        lblRegistrarTransaes.setBounds(5, 240, 864, 24);
        lblRegistrarTransaes.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRegistrarTransaes.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblRegistrarTransaes);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(5, 326, 864, 24);
        contentPane.add(lblTipo);

        JComboBox jcbTipoDeAcao = new JComboBox();
        jcbTipoDeAcao.setBounds(5, 289, 864, 24);
        jcbTipoDeAcao.addItem(Mensagens.COMPRAR);
        jcbTipoDeAcao.addItem(Mensagens.VENDER);
        contentPane.add(jcbTipoDeAcao);

        JLabel lblAo = new JLabel(Mensagens.ACAO + ":");
        lblAo.setBounds(5, 267, 864, 24);
        contentPane.add(lblAo);

        jcbAcao = ControladorAcoes.getInstanceAcoes().getComboAcoes();
        contentPane.add(jcbAcao);

        JLabel lblQuantidade = new JLabel(Mensagens.QTD+": ");
        lblQuantidade.setBounds(5, 378, 864, 24);
        contentPane.add(lblQuantidade);

        jtfQtd = new JTextField();
        jtfQtd.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent arg0) {
        		ControladorPrincipal.getInstance().iniciaThread();
        	}
        });
        jtfQtd.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		ControladorPrincipal.getInstance().iniciaThread();
        	}
        	
        });
        jtfQtd.setBounds(5, 400, 864, 24);
        contentPane.add(jtfQtd);
        jtfQtd.setColumns(10);

        JLabel lblCorretagem = new JLabel("Corretagem:");
        lblCorretagem.setBounds(5, 430, 864, 24);
        contentPane.add(lblCorretagem);

        JLabel lblJlbcorretagem = new JLabel("0");
        lblJlbcorretagem.setBounds(5, 304, 864, 24);
        lblJlbcorretagem.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblJlbcorretagem);

        JLabel lblImpostos = new JLabel("Impostos:");
        lblImpostos.setBounds(5, 459, 864, 24);
        contentPane.add(lblImpostos);

        JLabel jlbImposto = new JLabel("10");
        jlbImposto.setBounds(5, 459, 864, 24);
        jlbImposto.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(jlbImposto);

        JLabel lblVlUnitario = new JLabel(Mensagens.VALOR_UNITARIO);
        lblVlUnitario.setBounds(5, 497, 864, 24);
        contentPane.add(lblVlUnitario);

        lblVlUnitarioValue = new JLabel(ControladorAcoes.getInstanceAcoes().getValorUnitario(jcbAcao.getSelectedItem()));
        lblVlUnitarioValue.setBounds(5, 497, 864, 24);
        lblVlUnitarioValue.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblVlUnitarioValue);

        JLabel lblNewLabel = new JLabel("Total:");
        lblNewLabel.setBounds(5, 534, 806, 24);
        contentPane.add(lblNewLabel);

        Double calcVT = ControladorPrincipal.calculaValorTotal(jtfQtd, lblVlUnitarioValue);
        lblR = new JLabel("" + calcVT);
        lblR.setBounds(5, 534, 864, 24);
        lblR.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblR);

        JButton jbtRegistrar = new JButton(Mensagens.REGISTRAR_TRANSACAO);
        jbtRegistrar.setBounds(5, 571, 864, 24);
        contentPane.add(jbtRegistrar);

        JButton jbtCancelar = new JButton(Mensagens.CANCELAR);
        jbtCancelar.setBounds(5, 600, 864, 24);
        contentPane.add(jbtCancelar);

        jbtRegistrar.addActionListener(x->{
            String mensagem;
            if (jcbTipoDeAcao.getSelectedItem().toString().equals(Mensagens.COMPRAR)) {
                mensagem = ControladorCarteira.cadAcao(jcbTipoDeAcao.getSelectedItem().toString(), jcbAcao.getSelectedItem().toString(), Integer.parseInt(jtfQtd.getText()), Double.parseDouble(jlbImposto.getText()), Double.parseDouble(lblVlUnitarioValue.getText()), Double.parseDouble(lblJlbcorretagem.getText()));
                popularCampos();
                saldoValue.setText(ControladorCarteira.getInstanceCarteira().getValorEmCaixaCateira());
                JOptionPane.showMessageDialog(null, "" + mensagem);
            } else {
                mensagem = ControladorCarteira.venderAcao(jcbTipoDeAcao.getSelectedItem().toString(), Integer.parseInt(jtfQtd.getText()), jcbAcao.getSelectedItem().toString(), Double.parseDouble(jlbImposto.getText()), Double.parseDouble(lblJlbcorretagem.getText()), Double.parseDouble(lblVlUnitarioValue.getText()));
                popularCampos();
                saldoValue.setText(ControladorCarteira.getInstanceCarteira().getValorEmCaixaCateira());
                JOptionPane.showMessageDialog(null, "" + mensagem);
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

        jbtCancelar.addActionListener(
                x -> {
                    this.setVisible(false);
                }
        );
    }

    private void popularCampos() {
    	ControladorCarteira.popularCamposDaTabela();
        //this.jtpCarteira = ControladorCarteira.popularCamposDaTabela();
    }
    
    public void atualizaTotal() { 
    	try {
    		int qtd =  Integer.parseInt(jtfQtd.getText());
	    	Double valorUnitario = Double.parseDouble(ControladorAcoes.getInstanceAcoes().getValorUnitario(jcbAcao.getSelectedItem()));
	    	double valor = qtd * valorUnitario;
			lblR.setText(String.valueOf(valor));
    	}catch (NumberFormatException e) {
			lblR.setText("0");
		}
	}
    


}