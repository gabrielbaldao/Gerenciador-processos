package main;

import controler.Arquivo;
import escalonadores.FCFS;
import processador.Cpu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arquivo arq = new Arquivo();
		
		
		Cpu cpu = new Cpu(arq.leituraDoArquivo(), new FCFS());
		for(int i=1;i<20;i++)
		{
			System.out.println("Iteracao "+i);
			cpu.iteracao();
		}
	}

}
