package exercicio;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exercicio.LeitorArquivo;
import exercicio.Pesquisas;

public class PerformaceDePesquisaTest {

	private static final String CAMINHO_ARQUIVO = LeitorArquivo.CAMINHO_AQRUIVO;
	private LeitorArquivo leitor;
	private Pesquisas algoritimoDePesquisa;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void pesquisaLinearComArquivo10Kb(){
		testePerformaceUtilizandoPesquisaLinear("arquivo10KB.txt"); 
	}

	@Test
	public void pesquisaBinariaComArquivo10Kb(){
		testePerformaceUtilizandoPesquisaBinaria("arquivo10KB.txt"); 
	}

	@Test
	public void pesquisaLinearComArquivo1Mb(){
		testePerformaceUtilizandoPesquisaLinear("arquivo1MB.txt"); 
	}

	@Test
	public void pesquisaBinariaComArquivo1MB(){
		testePerformaceUtilizandoPesquisaBinaria("arquivo1MB.txt"); 
	}

	@Test
	public void pesquisaLinearComArquivo10Mb(){
		testePerformaceUtilizandoPesquisaLinear("arquivo10MB.txt"); 
	}
	
	@Test
	public void pesquisaBinariaComArquivo10Mb(){
		testePerformaceUtilizandoPesquisaBinaria("arquivo10MB.txt"); 
	}
	
	private void testePerformaceUtilizandoPesquisaLinear(String arquivo) {
		//  DADO QUE POSSUO UMA ARQUIVO DE 10KB E REALIZE A LEITURA PARA UMA LISTA DAS PALAVRAS
		leituraDo(arquivo);
		
		// QUANDO EU EXECUTAR A PESQUISA LINEAR
		long tempoInicial = System.currentTimeMillis(); 
		@SuppressWarnings("static-access")
		int posicaoPalavraPesquisada = algoritimoDePesquisa.pesquisaLinear(leitor.getConjuntoPalavrasArquivo(), "casa");
		long tempoFinal = System.currentTimeMillis();  
		
		// ENTÃO ELE DEVE ACHAR A PALAVRA CHAVE E DEVO PRINTAR O TEMPO DE EXECUÇÃO NA TELA
		printResultado(arquivo, "Linear", posicaoPalavraPesquisada,tempoFinal - tempoInicial);
	}

	private void testePerformaceUtilizandoPesquisaBinaria(String arquivo) {
		//  DADO QUE POSSUO UMA ARQUIVO de X Bytes E REALIZE A LEITURA PARA UMA LISTA DAS PALAVRAS
		leituraDo(arquivo);
		leitor.ordenarComSort();
		
		// QUANDO EU EXECUTAR A PESQUISA LINEAR
		long tempoInicial = System.currentTimeMillis(); 
		@SuppressWarnings("static-access")
		int posicaoPalavraPesquisada = algoritimoDePesquisa.pesquisaBinaria(leitor.getConjuntoPalavrasArquivo(), "casa");
		long tempoFinal = System.currentTimeMillis();  
		
		// ENTÃO ELE DEVE ACHAR A PALAVRA CHAVE E DEVO PRINTAR O TEMPO DE EXECUÇÃO NA TELA
		printResultado(arquivo, "Binaria", posicaoPalavraPesquisada,tempoFinal - tempoInicial);
	}
	

	private void printResultado(String arquivo, String tipoPesquisa, int resultado, long tempo) {
		System.out.println( "--------------------------------------------------------------------------" );
		System.out.println("Teste executado no arquivo " + arquivo + " usando a pesquisa "+tipoPesquisa+"\n" );
		System.out.println("Total de Palavras que estão no arquivo : " + leitor.getConjuntoPalavrasArquivo().size() );
		System.out.println("Posição da palavra procurada : " + resultado );
		System.out.println( "Tempo de pesquisa : " + tempo + " milissegundos" );
		System.out.println( "--------------------------------------------------------------------------" );
		System.out.println( "\n" );
	}
	
	private void leituraDo(String arquivo) {		
		leitor = new LeitorArquivo(CAMINHO_ARQUIVO+arquivo);
		leitor.ler();
	}

}
