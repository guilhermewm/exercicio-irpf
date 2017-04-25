package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.CalculoImposto;
import business.ListaContribuintes;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaImposto extends JFrame {

	private JPanel contentPane;
	private ListaContribuintes lista_contribuintes;
	private JTextField textFieldCpf;
	private CalculoImposto calculo_imposto;
	


	/**
	 * Create the frame.
	 * @param lista_contribuintes2 
	 * @param lista_contribuintes 
	 */
	public TelaConsultaImposto(ListaContribuintes lista) {
		lista_contribuintes = lista; 
		calculo_imposto = new CalculoImposto(lista);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCpf = new JLabel("CPF: ");
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		
		JLabel lblValorDoImposto = new JLabel("Valor do imposto:");
		
		JLabel labelResultadoImposto = new JLabel("0.0");
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCpf.getText();
				labelResultadoImposto.setText(String.valueOf(calculo_imposto.calculaImposto(cpf)));				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCpf)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCpf, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(130)
							.addComponent(btnConsultar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblValorDoImposto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelResultadoImposto)))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(textFieldCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConsultar)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorDoImposto)
						.addComponent(labelResultadoImposto))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
