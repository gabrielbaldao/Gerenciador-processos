package processador;

import java.util.ArrayList;

import escalonadores.Escalonador;

public class Cpu {
	private ArrayList<Processo> listaProcessos;
	private ArrayList<Processo> listaBloqueado;
	private ArrayList<Processo> filaPronto;
	private Processo processoAtual;
	private Integer tempoAtual;
	private Escalonador escalonador;
	private Integer quantum;
	private Long trocaDeContexto;
	private Long tempoExecucao;

	public Cpu(ArrayList<Processo> listaProcessos, Escalonador escalonador) {
		this.listaProcessos = listaProcessos;
		this.listaBloqueado = new ArrayList<>();
		this.processoAtual = new Processo(0, 0, 0, 0);
		this.filaPronto = new ArrayList<>();

		this.escalonador = escalonador;
		this.tempoAtual = 0;
		this.quantum = 1;
		this.trocaDeContexto = (long) 0;
		this.tempoExecucao = (long) 0;
	}

	public void iteracao() {

		for (int i = 0; i < this.quantum; i++) {
			++this.tempoAtual;
			if (!this.listaProcessos.isEmpty()) {
				novosProntos(this.filaPronto, this.listaProcessos);
			}
			if (!this.filaPronto.isEmpty()) {
				this.filaPronto = escalonador.ordena(this.filaPronto);
				if (escalonador.consomeProcesso(this.filaPronto, this.tempoAtual) == null
						&& !this.filaPronto.isEmpty()) {
					trocaDeContexto();

				}
			}

			tempoClock();
			// Ou escalonador buscaProcesso
			// Algoritmo consome processo
			// Passa como parametro a lista e o tempoAtual
			// Assim, o escalonador verifica o tempo que esta, e qual processo deve ser
			// consumido, mudando seu tempo de vida
			/**
			 * Aqui deve-se executar o processo, ou seja, fazer o escalonador e tudo mais
			 * 
			 * 
			 */
		}

	}

	private void tempoClock() {
		try {
			Thread.sleep(this.tempoExecucao);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void trocaDeContexto() {
		++this.tempoAtual;
		try {
			Thread.sleep(this.trocaDeContexto);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void novosProntos(ArrayList<Processo> filaPronto, ArrayList<Processo> todos) {
		int i = 0;
		while (true) {
			if (!todos.isEmpty()) {
				if (todos.get(i).getTempoChegada() <= this.tempoAtual) {

					filaPronto.add(todos.remove(i));
				} else
					return;
			} else
				return;
		}
	}

	public void imprimeProntos() {
		System.out.println("Prontos");
		for (Processo e : this.filaPronto) {
			System.err.println(e.toString());
		}
	}

	public Integer getQuantum() {
		return quantum;
	}

	public void setQuantum(Integer quantum) {
		this.quantum = quantum;
	}

	public Long getTrocaDeContexto() {
		return trocaDeContexto;
	}

	public void setTrocaDeContexto(Long trocaDeContexto) {
		this.trocaDeContexto = trocaDeContexto;
	}

	public Long getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(Long tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

}
