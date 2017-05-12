package business;

public class CalculoIrpfSimplificado implements CalculoIrpf {
	private Pessoa contribuinte;
	
	public CalculoIrpfSimplificado(Pessoa contribuinte) {
		this.contribuinte = contribuinte;
	}

	@Override
	public double calculaImposto(Pessoa contribuinte) {
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

}
