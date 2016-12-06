package br.com.pw.antares.testes;

import br.com.pw.antares.febraban.segmentos.Header;

public class Teste {

	public static void main(String[] args) {
		escrever();
	}

	private static void ler(){
		Header dt = new Header();
		try {
			dt.fromLine("03240201 0000000 2112740770001760033304400490259985303044 0000130039357                                                                                                     00000                                   00000000                    ");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println(dt.toString());
			System.out.println(dt.CodigodoBanco.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void escrever(){
		Header dt = new Header();
		try {
			dt.fromLine("03240201 0000000 2112740770001760033304400490259985303044 0000130039357                                                                                                     00000                                   00000000                    ");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			dt.CodigodoBanco.setValue(123l);
			System.out.println(dt.toLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
