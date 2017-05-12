package business;

public class CalculoIrpfFactory {
	
	private static CalculoIrpfFactory cif = new CalculoIrpfFactory();
	
	private CalculoIrpfFactory(){		
	}
	
	public static CalculoIrpfFactory getInstance(){
		return cif;
	}
	
	public CalculoIrpf createInstance(Pessoa contribuinte){
		switch (contribuinte.getDeclaracao()) {
		case COMPLETA:
			return new CalculoIrpfCompleto(contribuinte);
		case SIMPLES:	
			return new CalculoIrpfSimplificado(contribuinte);
		}
		return null;
	}	
	
}
