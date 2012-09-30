package exercicio;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exercicio.LeitorArquivo;

public class LeitorArquivoTest {
	
	private static final String CAMINHO_ARQUIVO = LeitorArquivo.CAMINHO_AQRUIVO;
	private LeitorArquivo leitor;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		leitor = null;
	}
	
	@Test
	public void testarContagemDePalavraEmAqrquivoComUmLinha(){
		leitor = new LeitorArquivo(CAMINHO_ARQUIVO+"teste.txt");
		testarLeituraPalavrasNoArquivo("casa",2);
	}

	@Test
	public void testarContagemDePalavraEmAqrquivoComDuasLinha(){
		leitor = new LeitorArquivo(CAMINHO_ARQUIVO+"teste2.txt");
		testarLeituraPalavrasNoArquivo("casa",6);
	}

	@Test
	public void testarContagemDePalavraEmAqrquivoSemAPalavra(){
		leitor = new LeitorArquivo(CAMINHO_ARQUIVO+"teste2.txt");
		testarLeituraPalavrasNoArquivo("Hause",0);
	}
	
	@Test
	public void testarContagemDePalavraEmAqrquivoInexistente(){
		leitor = new LeitorArquivo(CAMINHO_ARQUIVO+"teste4.txt");
		testarLeituraPalavrasNoArquivo("casa",0);
	}

	private void testarLeituraPalavrasNoArquivo(String palavra,int totalPalavras) {
		//DADO QUE 
		leitor.setPalavraChave(palavra);
		
		//QUANDO
		leitor.ler();
		
		//ENTÃO 
		Assert.assertTrue(leitor.totalDePalavrasChave() == totalPalavras);
	}

}
