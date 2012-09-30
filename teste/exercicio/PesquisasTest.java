package exercicio;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exercicio.LeitorArquivo;
import exercicio.Pesquisas;


public class PesquisasTest {


	private static final String CAMINHO_AQRUIVO =LeitorArquivo.CAMINHO_AQRUIVO;
	private LeitorArquivo leitor;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		leitor = null;
	}
	
	@Test
	public void testarPesquisaLinear(){
		//DADO QUE
		leitor = new LeitorArquivo(CAMINHO_AQRUIVO+"teste3.txt");
		leitor.setPalavraChave("casa");
		
		//QUANDO
		leitor.ler();
		
		// ENTÃO
		int resultado = Pesquisas.pesquisaLinear(leitor.getConjuntoPalavrasArquivo(), "casa");
		Assert.assertTrue(4 == resultado);		
	}

	@Test
	public void testarPesquisaBianria(){
		//DADO QUE
		leitor = new LeitorArquivo(CAMINHO_AQRUIVO+"teste3.txt");
		leitor.setPalavraChave("casa");
		
		//QUANDO
		leitor.ler();
		leitor.ordenarComSort();
		
		// ENTÃO
		int resultado = Pesquisas.pesquisaBinaria(leitor.getConjuntoPalavrasArquivo(), "casa");
		Assert.assertTrue(0 == resultado);
		
	}
}
