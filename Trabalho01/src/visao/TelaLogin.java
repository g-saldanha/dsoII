package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Recursos.Mensagens;
import controlador.ControladorPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtfCpfLogin;

	/**
	 * Create the dialog.
	 */
	public TelaLogin() {
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		setTitle(Mensagens.LOGIN);
		setBounds(100, 100, 415, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel(Mensagens.CPF + ":");
			lblNewLabel.setBounds(59, 48, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			jtfCpfLogin = new JTextField();
			jtfCpfLogin.setBounds(110, 45, 202, 22);
			contentPanel.add(jtfCpfLogin);
			jtfCpfLogin.setColumns(10);
		}
		{
			JButton okButton = new JButton(Mensagens.OK);
			okButton.setBounds(110, 90, 71, 25);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						ControladorPrincipal.getInstance().carregaUsuario(Integer.parseInt(jtfCpfLogin.getText()));
				}
			});
			okButton.setActionCommand(Mensagens.OK);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton(Mensagens.CANCELAR);
			cancelButton.setBounds(227, 90, 85, 25);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jtfCpfLogin.setText("");
					dispose();
				}
			});
			cancelButton.setActionCommand(Mensagens.CANCELAR);
		}
	}
}
