package tests;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.CalculoImposto;
import business.ListaContribuintes;
import business.Pessoa;
import business.TipoDeclaracao;

public class TestClasseCalculoImposto {
	private CalculoImposto calculo_imposto;
	private ListaContribuintes lista_contribuintes;
	
	private Pessoa pessoa_simples_com_renda_abaixo_de_doze_mil;
	private Pessoa pessoa_simples_com_renda_entre_doze_e_vinte_e_quatro_mil;
	private Pessoa pessoa_simples_com_renda_acima_de_vinte_e_quatro_mil;
	
	private Pessoa pessoa_completa_abaixo_da_idade_com_ate_dois_contribuintes_rendimento_menor_que_doze_mil;
	private Pessoa pessoa_completa_abaixo_da_idade_com_tres_ate_cinco_contribuintes_rendimento_menor_que_doze_mil;
	private Pessoa pessoa_completa_abaixo_da_idade_com_acima_de_cinco_contribuintes_rendimento_menor_que_doze_mil;
	

	
	private Pessoa pessoa_completa_abaixo_da_idade_com_ate_dois_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil;
	private Pessoa pessoa_completa_abaixo_da_idade_com_tres_ate_cinco_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil;
	private Pessoa pessoa_completa_abaixo_da_idade_com_acima_de_cinco_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil;
	
	@Before
	public void setUp() throws Exception{
		lista_contribuintes = new ListaContribuintes();
		calculo_imposto = new CalculoImposto(lista_contribuintes);		
		
		pessoa_simples_com_renda_abaixo_de_doze_mil = new Pessoa(TipoDeclaracao.SIMPLES, "Maria", "1", 10000, 20000);
		pessoa_simples_com_renda_entre_doze_e_vinte_e_quatro_mil = new Pessoa(TipoDeclaracao.SIMPLES, "Maria", "1", 10000, 30000);
		pessoa_simples_com_renda_acima_de_vinte_e_quatro_mil = new Pessoa(TipoDeclaracao.SIMPLES, "Maria", "1", 10000, 40000);
		
		
		pessoa_completa_abaixo_da_idade_com_ate_dois_contribuintes_rendimento_menor_que_doze_mil = new Pessoa(TipoDeclaracao.COMPLETA, "Maria", "1", 50, 2, 10000, 20000);
		pessoa_completa_abaixo_da_idade_com_tres_ate_cinco_contribuintes_rendimento_menor_que_doze_mil = new Pessoa(TipoDeclaracao.COMPLETA, "Maria", "1", 50, 4, 10000, 20000);
		pessoa_completa_abaixo_da_idade_com_acima_de_cinco_contribuintes_rendimento_menor_que_doze_mil = new Pessoa(TipoDeclaracao.COMPLETA, "Maria", "1", 50, 6, 10000, 20000);
		
		pessoa_completa_abaixo_da_idade_com_ate_dois_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil = new Pessoa(TipoDeclaracao.COMPLETA, "Maria", "1", 50, 2, 10000, 30000);
		pessoa_completa_abaixo_da_idade_com_tres_ate_cinco_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil = new Pessoa(TipoDeclaracao.COMPLETA, "Maria", "1", 50, 4, 10000, 30000);
		pessoa_completa_abaixo_da_idade_com_acima_de_cinco_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil = new Pessoa(TipoDeclaracao.COMPLETA, "Maria", "1", 50, 6, 10000, 30000);
				
	}
	
	
	//SIMPLES
	
	@Test
	public void testaSePessoaSimplesComRendimentoAbaixoDeDozeMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_simples_com_renda_abaixo_de_doze_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(0.0, actual, 0);
	}
	
	@Test
	public void testaSePessoaSimplesComRendimentoAcimaDeDozeMilEAbaixoDeVinteQuatroMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_simples_com_renda_entre_doze_e_vinte_e_quatro_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(1050.0, actual, 0);
	}

	@Test
	public void testaSePessoaSimplesComRendimentoAcimaDeVinteEQuatroMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_simples_com_renda_acima_de_vinte_e_quatro_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(1237.5, actual, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaSePessoaSimplesComCpfNaoCadastradoRetornaValor() {	
		lista_contribuintes.addContribuinte(pessoa_simples_com_renda_acima_de_vinte_e_quatro_mil);
		calculo_imposto.calculaImposto("2");		
	}	
	
	
	//COMPLEO
	
	
	//Menor que 65 e até 12000
	@Test
	public void testaSePessoaCompletaComIdadeMenorEAteDoisDependentesERendimentoAbaixoDeDozeMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_completa_abaixo_da_idade_com_ate_dois_contribuintes_rendimento_menor_que_doze_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(0.0, actual, 0);
	}
	
	@Test
	public void testaSePessoaCompletaComIdadeMenorEComTresAteCincoDependentesERendimentoAbaixoDeDozeMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_completa_abaixo_da_idade_com_tres_ate_cinco_contribuintes_rendimento_menor_que_doze_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(0.0, actual, 0);
	}
	
	@Test
	public void testaSePessoaCompletaComIdadeMenorEAcimaDeCincoDependentesERendimentoAbaixoDeDozeMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_completa_abaixo_da_idade_com_acima_de_cinco_contribuintes_rendimento_menor_que_doze_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(0.0, actual, 0);
	}
	
	
	
	//Menor que 65 e entre 12000 a 24000
	@Test
	public void testaSePessoaCompletaComIdadeMenorEAteDoisDependentesERendimentoEntreDozeEVinteEQuatroMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_completa_abaixo_da_idade_com_ate_dois_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(1140.0, actual, 0);
	}
	
	@Test
	public void testaSePessoaCompletaComIdadeMenorEComTresAteCincoDependentesERendimentoEntreDozeEVinteEQuatroMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_completa_abaixo_da_idade_com_tres_ate_cinco_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(1095.0, actual, 0);
	}
	
	@Test
	public void testaSePessoaCompletaComIdadeMenorEAcimaDeCincoDependentesERendimentoEntreDozeEVinteEQuatroMilRetornaValor() {
		lista_contribuintes.addContribuinte(pessoa_completa_abaixo_da_idade_com_acima_de_cinco_contribuintes_rendimento_entre_doze_e_vinte_e_quatro_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(1050.0, actual, 0);
	}
	
	
}
