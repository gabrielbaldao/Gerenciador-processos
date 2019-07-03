package escalonadores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import processador.Processo;

public class FCFS implements Escalonador {

	@Override
	public ArrayList<Processo> ordena(ArrayList<Processo> lista) {
		Comparator<Processo> ordenador = new Comparator<Processo>() {

			@Override
			public int compare(Processo arg0, Processo arg1) {

				return Integer.compare(arg0.getTempoChegada(), arg1.getTempoChegada());
			}
		};
		lista.sort(ordenador);
		return lista;

	}

	@Override
	public Processo consomeProcesso(ArrayList<Processo> lista, Integer tempoAtual) {
		if (!lista.isEmpty()) {
				Processo processo = lista.get(0);
				System.out.println("Processando "+processo.getNome() + " vida "+ processo.getIdadeAtual() + " ta vivo? "+ processo.isVivo(tempoAtual) + " idade "+ processo.getTempoConsumo());
		
			if (processo.isVivo(tempoAtual)) {
				processo.incrementaIdade();
				return processo;
			 // Posibilidade de remover aqui, conceito de quando se remove
			} else {
				lista.remove(0);
				return null;
			}
		}
		return null;

	}

}
