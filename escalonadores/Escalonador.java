package escalonadores;

import java.util.ArrayList;

import processador.Processo;

public interface Escalonador {
	public ArrayList<Processo> ordena(ArrayList<Processo> lista);
	public Processo consomeProcesso(ArrayList<Processo> lista, Integer tempoAtual);
}
