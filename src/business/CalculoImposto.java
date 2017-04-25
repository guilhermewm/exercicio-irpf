package business;

public class CalculoImposto {
	private ListaContribuintes lista;
	private Pessoa contribuinte;
	
	
	public CalculoImposto(ListaContribuintes lista) {
		this.lista = lista;
	}


	public double calculaImposto(String cpf){
		if(lista.getContribuintePorCpf(cpf).getDeclaracao().equals(TipoDeclaracao.SIMPLES)){
			System.out.println("simples");
			return calculoDeclaracaoSimplificada(cpf);
		}else{
			System.out.println("completa");
			return calculoDeclaracaoCompleta(cpf);
		}
	}
	
	
	public double calculoDeclaracaoSimplificada(String cpf){
		contribuinte = lista.getContribuintePorCpf(cpf);
		double base_calculo = (contribuinte.getRendimento()-contribuinte.getContribuicao_previdencia());
		base_calculo = base_calculo - base_calculo*0.05;
		if(base_calculo <= 12000){
			return 0.0;
		}else if(base_calculo > 12000 && base_calculo < 24000){
			return (base_calculo-12000)*0.15;
		}else{
			return (base_calculo-24000)*0.275;
		}
	}
	
	public double calculoDeclaracaoCompleta(String cpf){
		contribuinte = lista.getContribuintePorCpf(cpf);
		double base_calculo = (contribuinte.getRendimento()-contribuinte.getContribuicao_previdencia());		
		if(contribuinte.getIdade() < 65){
			if(contribuinte.getNum_dependentes() <= 2){
				base_calculo = base_calculo - base_calculo*0.02;
			}else if(contribuinte.getNum_dependentes() >= 3 && contribuinte.getNum_dependentes() <= 5){
				base_calculo = base_calculo - base_calculo*0.035;
			}else{
				base_calculo = base_calculo - base_calculo*0.05;
			}
		}else{
			if(contribuinte.getNum_dependentes() <= 2){
				base_calculo = base_calculo - base_calculo*0.03;
			}else if(contribuinte.getNum_dependentes() >= 3 && contribuinte.getNum_dependentes() <= 5){
				base_calculo = base_calculo - base_calculo*0.045;
			}else{
				base_calculo = base_calculo - base_calculo*0.06;
			}
		}				
		if(base_calculo <= 12000){
			return 0.0;
		}else if(base_calculo > 12000 && base_calculo < 24000){
			return (base_calculo-12000)*0.15;
		}else{
			return (base_calculo-24000)*0.275;
		}
	}
}
