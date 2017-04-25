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
	private Pessoa pessoa_completa_abaixo_da_idade_com_dois_contribuintes;
	
	@Before
	public void setUp() throws Exception{
		lista_contribuintes = new ListaContribuintes();
		calculo_imposto = new CalculoImposto(lista_contribuintes);		
		
		pessoa_simples_com_renda_abaixo_de_doze_mil = new Pessoa(TipoDeclaracao.SIMPLES, "Maria", "1", 10000, 20000);
		
				
	}
	
	
	@Test
	public void testaSePessoaSimplesComRendimentoAbaixoDeDozeMilRetornaZero() {
		lista_contribuintes.addContribuinte(pessoa_simples_com_renda_abaixo_de_doze_mil);
		double actual = calculo_imposto.calculaImposto("1");
		assertEquals(0.0, actual, 0);
	}

}
