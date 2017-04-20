package business;

public class CalculoImposto {
	private ListaContribuintes lista = new ListaContribuintes();
	private Pessoa contribuinte;
	
	
	
	public double calculoDeclaracaoSimplificada(String cpf){
		contribuinte = lista.getContribuintePorCpf(cpf);
		double base_calculo = (contribuinte.getRendimento()-contribuinte.getContribuicao_previdencia())*1.05;
		if(base_calculo <= 12.000){
			return 0.0;
		}else if(base_calculo > 12.000 && base_calculo < 24.000){
			return base_calculo*0.15;
		}else{
			return base_calculo*0.275;
		}
	}
}
