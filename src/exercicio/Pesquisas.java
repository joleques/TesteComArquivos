package exercicio;

import java.util.List;

public class Pesquisas {
	
	public static int frequenciaBinaria(List<String> a, String x){
		int low = 0;
		int total = 0;
		int high = a.size();
		while(low <= high){
			int i = (low + high) / 2;
			if(a.size() == 0){
				return 0;
			} else if(a.get(i).equals(x)){
				total++;
				a.remove(i);
				high = a.size();
			}else if(a.get(i).compareTo(x) < 0 ){
				low = i + 1;
			}else{
				high = i-1;
			}
		}
		return total;
	}
	
	public static int pesquisaBinaria(List<String> a, String x){
		return pesquisaBinariaImplementada(a, x);
	}

	private static int pesquisaBinariaImplementada(List<String> a, String x){
		int low = 0;
		int high = a.size();
		while(low <= high){
			int i = (low + high) / 2;
			if(a.size() == 0){
				return -1;
			} else if(a.get(i).equals(x)){
				return i;
			}else if(a.get(i).compareTo(x) < 0 ){
				low = i + 1;
			}else{
				high = i-1;
			}
		}
		return -1;
	}

	public static int pesquisaLinear(List<String> a, String x){
		for (String string : a) {
			if(string.equals(x)){
				return a.indexOf(string);
			}
		}
		return -1;
	}
}
