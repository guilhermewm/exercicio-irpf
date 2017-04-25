package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.ListaContribuintes;
import business.Pessoa;
import business.TipoDeclaracao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastro extends JFrame {
	
	private JPanel contentPane;	
	private ListaContribuintes lista_contribuintes;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldIdade;
	private JTextField textFieldNumeroDependentes;
	private JTextField textFieldContribuicaoOficial;
	private JTextField textFieldTotalRendimentos;


	/**
	 * Create the frame.
	 */
	public TelaCadastro(ListaContribuintes lista) {
		lista_contribuintes = lista;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTipoDeDeclarao = new JLabel("Tipo de declara\u00E7\u00E3o:");
		
		JRadioButton rdbtnSimplificada = new JRadioButton("Simplificada");			
		rdbtnSimplificada.setSelected(true);
		
		JRadioButton rdbtnCompleta = new JRadioButton("Completa");
		
		JLabel lblNumeroDependentes = new JLabel("Numero dependentes:");
		lblNumeroDependentes.setEnabled(false);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setEnabled(false);
		
		rdbtnSimplificada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCompleta.setSelected(false);
				textFieldIdade.setEnabled(false);
				textFieldNumeroDependentes.setEnabled(false);
				lblIdade.setEnabled(false);
				lblNumeroDependentes.setEnabled(false);
				
			}	
		});
		
		rdbtnCompleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSimplificada.setSelected(false);
				textFieldIdade.setEnabled(true);
				textFieldNumeroDependentes.setEnabled(true);
				lblIdade.setEnabled(true);
				lblNumeroDependentes.setEnabled(true);
			}	
		});
		
		JLabel lblNome = new JLabel("Nome:");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		
	
		
		textFieldIdade = new JTextField();
		textFieldIdade.setEnabled(false);
		textFieldIdade.setColumns(10);
		
		
		
		textFieldNumeroDependentes = new JTextField();
		textFieldNumeroDependentes.setEnabled(false);
		textFieldNumeroDependentes.setColumns(10);
		
		JLabel lblContribuioPrevidenciriaOficial = new JLabel("Contribui\u00E7\u00E3o previdenci\u00E1ria oficial:");
		
		textFieldContribuicaoOficial = new JTextField();
		textFieldContribuicaoOficial.setColumns(10);
		
		JLabel lblTotalDeRendimentos = new JLabel("Total de rendimentos:");
		
		textFieldTotalRendimentos = new JTextField();
		textFieldTotalRendimentos.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa;
				if(rdbtnSimplificada.isSelected()){
					pessoa = new Pessoa(TipoDeclaracao.SIMPLES, textFieldNome.getText(), textFieldCpf.getText(), Double.parseDouble(textFieldContribuicaoOficial.getText()), Double.parseDouble(textFieldTotalRendimentos.getText()));	
					lista_contribuintes.addContribuinte(pessoa);
				}else{
					pessoa = new Pessoa(TipoDeclaracao.COMPLETA, textFieldNome.getText(), textFieldCpf.getText(), Integer.parseInt(textFieldIdade.getText()), Integer.parseInt(textFieldNumeroDependentes.getText()), Double.parseDouble(textFieldContribuicaoOficial.getText()), Double.parseDouble(textFieldTotalRendimentos.getText()));	
					lista_contribuintes.addContribuinte(pessoa);					
				}
				
				System.out.println(lista_contribuintes.toString());
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTipoDeDeclarao)
									.addGap(29)
									.addComponent(rdbtnSimplificada)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnCompleta))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblContribuioPrevidenciriaOficial)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldContribuicaoOficial, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldIdade, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
									.addComponent(lblNumeroDependentes)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldNumeroDependentes, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldCpf, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
							.addGap(129))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTotalDeRendimentos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldTotalRendimentos, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeDeclarao)
						.addComponent(rdbtnSimplificada)
						.addComponent(rdbtnCompleta))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(textFieldCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade)
						.addComponent(lblNumeroDependentes)
						.addComponent(textFieldNumeroDependentes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContribuioPrevidenciriaOficial)
						.addComponent(textFieldContribuicaoOficial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalDeRendimentos)
						.addComponent(textFieldTotalRendimentos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
