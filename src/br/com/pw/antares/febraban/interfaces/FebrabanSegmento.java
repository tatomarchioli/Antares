package br.com.pw.antares.febraban.interfaces;

import br.com.pw.antares.febraban.enums.TipoRegistro;
import br.com.pw.antares.febraban.enums.TipoSegmento;

/**
 * Define dois metodos, um que retorna o tipo do registro e o outro que retorna o tipo de segmento.*/

public interface FebrabanSegmento{
	
	public TipoRegistro getTipoRegistro();
	
	public TipoSegmento getTipoSegmento();
}
