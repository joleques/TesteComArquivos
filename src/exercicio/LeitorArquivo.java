package exercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeitorArquivo {
	public static final String CAMINHO_AQRUIVO = "/workspace/LeituraArquivo/src/arquivos/";
	private String palavraChave;
	private String caminhoDoArquivo;
	private ArrayList<String> conjuntoPalavrasArquivo;

	public LeitorArquivo(String caminhoDoArquivo) {
		this.caminhoDoArquivo = caminhoDoArquivo;
		this.conjuntoPalavrasArquivo = new ArrayList<String>();
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	@SuppressWarnings("unchecked")
	public int totalDePalavrasChave() {
		ordenarComSort();
		return Pesquisas.frequenciaBinaria((List<String>) conjuntoPalavrasArquivo.clone(), palavraChave);
	}

	public void ordenarComSort() {
		Collections.sort(conjuntoPalavrasArquivo);
	}
	


	public void ler() {
		FileInputStream entrada = null;
		InputStreamReader leitor = null;
		BufferedReader buffer_entrada = null;
		try {
			buffer_entrada = lerArquivoParaBuffer(entrada, leitor);
			inserirPalavrasNoBufferDeStrings(buffer_entrada);
		} catch (Exception e) {
			System.out.println("ERRO ao ler os docs: " + e.toString());
		} finally {
			try {
				if (entrada != null)
					entrada.close();
				if (leitor != null)
					leitor.close();
				if (buffer_entrada != null)
					buffer_entrada.close();
			} catch (Exception e) {
				System.out.println("ERRO ao fechar os manipuladores de arquivo: "+ e.toString());
			}
		}
	}

	private BufferedReader lerArquivoParaBuffer(FileInputStream entrada, InputStreamReader leitor) throws Exception {
		try {
			File arquivo = new File(caminhoDoArquivo);
			entrada = new FileInputStream(arquivo);
			leitor = new InputStreamReader(entrada, "UTF8");
			return new BufferedReader(leitor);
		} catch (IOException e) {
			throw new Exception("ERRO ao ler os docs: " + e.toString());
		}
	}
	
	private void inserirPalavrasNoBufferDeStrings(BufferedReader buffer_entrada)throws IOException {
		String linha;
		while ((linha = buffer_entrada.readLine()) != null) {
			String[] vetorPalavras = linha.split(" ");
			for (String palavra : vetorPalavras) {
				this.conjuntoPalavrasArquivo.add(palavra);
			}
		}
	}

	public ArrayList<String> getConjuntoPalavrasArquivo() {
		return conjuntoPalavrasArquivo;
	}
	
	

}
