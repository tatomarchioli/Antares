package br.com.pw.antares.febraban.lotes;

import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.febraban.segmentos.Header;
import br.com.pw.antares.febraban.segmentos.SegmentoB;
import br.com.pw.antares.febraban.segmentos.SegmentoJ;
import br.com.pw.antares.febraban.segmentos.SegmentoJ52;
import br.com.pw.antares.febraban.segmentos.SegmentoZ;
import br.com.pw.antares.febraban.segmentos.Trailer;

public class TitulosBancarios extends AntaresLineBatch{

	protected TitulosBancarios(boolean include, int sequence) {
		super(1, "Titulos Bancários", sequence, include);
	}

	private Header header = new Header(true, this);
	private SegmentoJ segmentoJ = new SegmentoJ(true, this);
	private SegmentoJ52 segmentoJ52 = new SegmentoJ52(false, this);
	private SegmentoB segmentoB = new SegmentoB(true, this);
	private SegmentoZ segmentoZ = new SegmentoZ(false, this);
	private Trailer trailer = new Trailer(true, this);

}
