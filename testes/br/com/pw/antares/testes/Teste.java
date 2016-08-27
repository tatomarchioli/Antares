package br.com.pw.antares.testes;

import br.com.pw.antares.febraban.segmentos.Header;

public class Teste {

	public static void main(String[] args) {
		Header dt = new Header();
		try {
			dt.fromLinha("03240201 0000000 2112740770001760033304400490259985303044 0000130039357                                                                                                     00000                                   00000000                    ");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println(dt.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
