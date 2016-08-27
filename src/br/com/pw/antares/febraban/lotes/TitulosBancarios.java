package br.com.pw.antares.febraban.lotes;

import java.util.List;

import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.febraban.enums.TipoRegistro;
import br.com.pw.antares.febraban.enums.TipoSegmento;
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

	@Override
	public void fromLines(List<String> linhas) throws Exception {

		for(String line : linhas){
			TipoRegistro tipoLinha = TipoRegistro.getByValue(Integer.parseInt(line.substring(7,8)));
			switch (tipoLinha) {
			case HEADER:{
				header.fromLinha(line);
				break;
			}
			case SEGMENTO:{
				TipoSegmento tipoSegmento = TipoSegmento.getByValue(line.substring(13,14));

				switch (tipoSegmento) {
				case J:{
					segmentoJ.fromLinha(line);
					segmentoJ.setInclude(true);
					break;
				}
				case J52:{
					segmentoJ52.fromLinha(line);
					segmentoJ52.setInclude(true);
					break;
				}
				case B:{
					segmentoB.fromLinha(line);
					segmentoB.setInclude(true);
					break;
				}
				case Z:{
					segmentoZ.fromLinha(line);
					segmentoZ.setInclude(true);
					break;
				}
				default: break;

				}
				break;
			}
			case TRAILER:{
				trailer.fromLinha(line);
				break;
			}
			default: break;
			}
		}
	}
}
