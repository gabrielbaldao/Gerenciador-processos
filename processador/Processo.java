package processador;

public class Processo {
	private Integer tempoChegada;
	private Integer	tempoConsumo;
	private Integer prioridade;
	private Integer nome;
	private Integer idadeAtual;
	
	
	public Processo(Integer tempoChegada, Integer tempoConsumo, Integer prioridade, Integer nome)
	{
		this.tempoChegada = tempoChegada;
		this.tempoConsumo = tempoConsumo;
		this.prioridade = prioridade;
		this.nome = nome;
		this.idadeAtual = 1;
	}
	public boolean isVivo(Integer tempoAtual)
	{
		if(this.getIdadeAtual() >= this.getTempoConsumo())
			return false;
		return true;
	}
	public Integer getTempoChegada() {
		return tempoChegada;
	}
	public void setTempoChegada(Integer tempoChegada) {
		this.tempoChegada = tempoChegada;
	}
	public Integer getTempoConsumo() {
		return tempoConsumo;
	}
	public void setTempoConsumo(Integer tempoConsumo) {
		this.tempoConsumo = tempoConsumo;
	}
	public Integer getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	public Integer getNome() {
		return nome;
	}
	public void setNome(Integer nome) {
		this.nome = nome;
	}
	public Integer getIdadeAtual() {
		return idadeAtual ; /**/
	}
	public Integer incrementaIdade()
	{
		return ++this.idadeAtual;
	}
	public String toString()
	{
		return this.nome + " Chegou "+ this.tempoChegada+" Tempo de Execucao "+this.tempoConsumo+"\n";
	}
//	public void setIdadeAtual(Integer idadeAtual) {
//		this.idadeAtual = idadeAtual;
//	}
	
	
}
