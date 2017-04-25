package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.ListaContribuintes;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private ListaContribuintes lista_contribuintes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lista_contribuintes = new ListaContribuintes();
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCadastroContribuinte = new JButton("Cadastro Contribuinte");
		btnCadastroContribuinte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro tela_cadastro = new TelaCadastro(lista_contribuintes);
				tela_cadastro.setVisible(true);
			}
		});
		
		JButton btnCalculoImposto = new JButton("Calculo do Imposto");
		btnCalculoImposto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaImposto tela_imposto = new TelaConsultaImposto(lista_contribuintes);
				tela_imposto.setVisible(true);
			}			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(btnCadastroContribuinte)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(btnCalculoImposto)
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCalculoImposto, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastroContribuinte, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
