package business;

public class CalculoIrpfCompleto implements CalculoIrpf {
	private Pessoa contribuinte;
	
	public CalculoIrpfCompleto(Pessoa contribuinte) {
		this.contribuinte = contribuinte;
	}
	

	@Override
	public double calculaImposto(Pessoa contribuinte) {
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
