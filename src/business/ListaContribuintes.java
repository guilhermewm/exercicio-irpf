package business;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.TreeTableRow;

public class ListaContribuintes {
	private Map<String, Pessoa> lista_contribuintes;
	
	public ListaContribuintes() {
		lista_contribuintes = new HashMap<>();
	}
	
	public void addContribuinte(Pessoa pessoa){
		if(pessoa.getCpf().isEmpty() || pessoa.getNome().isEmpty() || pessoa.getRendimento() < 0.0 || pessoa.getContribuicao_previdencia() < 0.0){
			throw new IllegalArgumentException("Faltam campos a serem preenchidos");
		}else{
			lista_contribuintes.put(pessoa.getCpf(), pessoa);
		}		
	}
	
	public Map getTodosOsContribuintes(){
		return lista_contribuintes;
	}

	public Pessoa getContribuintePorCpf(String cpf){
		if(lista_contribuintes.containsKey(cpf)){
			return lista_contribuintes.get(cpf);
		}else{
			throw new IllegalArgumentException("Não há usuario com esse cpf: " + cpf);			
		}	
	}
	
	@Override
	public String toString() {
		return "ListaContribuintes [lista_contribuintes=" + lista_contribuintes + "]";
	}
	
	
}
