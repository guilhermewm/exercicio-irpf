package business;

public class Pessoa {
	//campo obrigatorio para todos os contribuintes
	private TipoDeclaracao declaracao;	
	private String nome;
	private String cpf;
	
	//campo obrigatorio para declaração completa
	private int idade;	
	private int num_dependentes;
	
	//campo obrigatori para permitir o calculo para os demais
	private double contribuicao_previdencia;
	private double rendimento;
		
	public Pessoa(TipoDeclaracao declaracao, String nome, String cpf, int idade, int num_dependentes,
			double contribuicao_previdencia, double rendimento) {
		this.declaracao = declaracao;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.num_dependentes = num_dependentes;
		this.contribuicao_previdencia = contribuicao_previdencia;
		this.rendimento = rendimento;
	}
	
	public Pessoa(TipoDeclaracao declaracao, String nome, String cpf, double contribuicao_previdencia, double rendimento){
		this.declaracao = declaracao;
		this.nome = nome;
		this.cpf = cpf;		
		this.contribuicao_previdencia = contribuicao_previdencia;
		this.rendimento = rendimento;
	}

	public TipoDeclaracao getDeclaracao() {
		return declaracao;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

	public int getNum_dependentes() {
		return num_dependentes;
	}

	public double getContribuicao_previdencia() {
		return contribuicao_previdencia;
	}

	public double getRendimento() {
		return rendimento;
	}

	@Override
	public String toString() {
		return "Pessoa [declaracao=" + declaracao + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade
				+ ", num_dependentes=" + num_dependentes + ", contribuicao_previdencia=" + contribuicao_previdencia
				+ ", rendimento=" + rendimento + "]";
	}

	
	
	
	
}
