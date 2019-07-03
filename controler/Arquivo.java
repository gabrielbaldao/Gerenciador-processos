package controler;

import processador.Processo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import processador.Processo;
import javax.swing.JFileChooser;

public class Arquivo {

	public ArrayList<Processo> leArquivo() {
		return null;
	}

	private File buscaArquivo() {
		return null;

	}

	public ArrayList<Processo> leituraDoArquivo() {
		System.out.println("Leitura");

		JFileChooser jfAbrir = new JFileChooser();
		// jfAbrir.setCurrentDirectory(new
		// File("C:\\Users\\Cristiano\\Dropbox\\Programas\\NetBeansProjects\\Protótipo
		// 1.0"));
		jfAbrir.setCurrentDirectory(new File("."));
		int retorno = jfAbrir.showOpenDialog(null);
		String caminho = null;

		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminho = jfAbrir.getSelectedFile().getAbsolutePath();
			String aux = jfAbrir.getSelectedFile().getName();
			String[] aux2 = aux.split("_");
			// this.Ativo = aux2[0];
			try {
				FileInputStream arquivo = new FileInputStream(caminho);
				 return leituraDosProcessos(arquivo);

			} catch (FileNotFoundException ex) {
				System.out.println(ex.toString());
			} catch (IOException ex) {
				System.out.println(ex.toString());
			}

		} else {
			System.out.println("Nenhum arquivo selecionado");
		}
		return new ArrayList<>();

	}

	private static ArrayList<Processo> leituraDosProcessos(FileInputStream arquivo) {
		ArrayList<Processo> lista = new ArrayList<>();
		InputStreamReader input = new InputStreamReader(arquivo);
		BufferedReader ler = new BufferedReader(input);
		try {
			int nome = 0;
			while (true) {
				
				String linha;

				linha = ler.readLine();

				if (!(linha == null)) {
					String[] valores = linha.split(",");
				
					Integer tempoChegada = Integer.parseInt(valores[0].trim());
					Integer tempoDeServico = Integer.parseInt(valores[1].trim());
					Integer prioridade = Integer.parseInt(valores[2].trim());

					Processo aux = new Processo(tempoChegada, tempoDeServico, prioridade,++nome);
					lista.add(aux);
					
				}
				else return lista;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
