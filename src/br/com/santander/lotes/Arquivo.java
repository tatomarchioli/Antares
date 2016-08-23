package br.com.santander.lotes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.febraban.segmentos.HeaderArquivo;
import br.com.pw.antares.febraban.segmentos.TrailerArquivo;
import br.com.pw.antares.util.Tools;
import br.com.pw.antares.interfaces.FebrabanLote;

public class Arquivo{
	private int id;
	private String url;
	private HeaderArquivo header;
	private TrailerArquivo trailer;
	private List<FebrabanLote> lotes = new ArrayList<>();

	public HeaderArquivo getHeader() {
		return header;
	}
	public void setHeader(HeaderArquivo header) {
		this.header = header;
	}
	public TrailerArquivo getTrailer() {
		return trailer;
	}
	public void setTrailer(TrailerArquivo trailer) {
		this.trailer = trailer;
	}
	public List<FebrabanLote> getLotes() {
		return lotes;
	}
	public void addLote(FebrabanLote lote) throws Exception {
		if(!lote.validate()){
			throw new Exception("Lote inválido: "+lote);
		}
		this.lotes.add(lote);
	}
	public void addLotes(List<FebrabanLote> lotes) {
		this.lotes.addAll(lotes);
	}

	public List<String> gerarLinhas() throws Exception {
		List<String> list = new ArrayList<>();
		list.add(header.toLinha());
		for(FebrabanLote lote : lotes){
			list.addAll(lote.getLinhas());
		}
		list.add(trailer.toLinha());
		return list;
	}

	public int getQuantidadeRegistros(){
		int i = 2;
		for(FebrabanLote l : lotes){
			i+= l.contadorRegistros();
		}
		return i;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * Retorna um Arquivo proveniente da leitura de um arquivo de texto.
	 * @throws Exception 
	 * @throws NumberFormatException */
	public static Arquivo ler(InputStream inputStream) throws NumberFormatException, Exception{
		Scanner scan = new Scanner(inputStream);
		Arquivo arq = new Arquivo();

		FebrabanLote.TipoLote tipoHolder = null;
		List<String> holder = null;

		while(scan.hasNext()){
			String line = scan.nextLine();
			FebrabanSegmento.TipoRegistro tipoLinha = 
					FebrabanSegmento.TipoRegistro.getByValue(Integer.parseInt(line.substring(7,8)));


			switch (tipoLinha) {
			case HEADER_ARQUIVO: {
				arq.setHeader(new HeaderArquivo().fromLinha(line));
				break;
			}
			case TRAILER_ARQUIVO: {
				arq.setTrailer(new TrailerArquivo().fromLinha(line));
				break;
			}
			case HEADER:{
				holder = new ArrayList<>();
				holder.add(line);
				tipoHolder = FebrabanLote.TipoLote.getByValue(Integer.parseInt(line.substring(9, 11)));
				break;
			}
			case SEGMENTO:{
				holder.add(line);
				break;
			}
			case TRAILER:{
				holder.add(line);
				switch (tipoHolder) {
				case PAGAMENTO_FORNECEDOR:
					arq.addLote(new TitulosBancarios().setLinhas(holder));
					holder = null;
					tipoHolder = null;
					break;
				}
				break;
			}
			}

		}
		scan.close();
		return arq;
	}


	public static Arquivo criar(int mId, List<Boleto> boletos) {
		DateTime data = Tools.now();
		try {
			Arquivo arq = new Arquivo();
			arq.setId(mId);
			
			HeaderArquivo h = new HeaderArquivo();
			h.NomedaEmpresa.setValue("Banco Digital Maré");
			h.DatadaGeracaodoArquivo.setValue(data);
			h.HoradaGeracaodoArquivo.setValue(data);
			h.NumeroSequencialdoArquivo.setValue(mId);
			arq.setHeader(h);

			for(int i = 0; i < boletos.size(); i++){
				TitulosBancarios titulos = TitulosBancarios.criarLote(boletos.get(i), i+1);
				arq.addLote(titulos);
			}

			TrailerArquivo t = new TrailerArquivo();
			t.Quantidadederegistrosnoarquivo.setValue(arq.getQuantidadeRegistros());
			t.Quantidadedelotesdoarquivo.setValue(arq.getLotes().size());
			arq.setTrailer(t);

			return arq;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	public File write() throws Exception {
		BufferedWriter bufferedWriter = null;
		DateTime hoje = Tools.now();
		String filename = "REM_"+hoje.toString("ddMMyyyy");
		try {            
			File file = new File(System.getProperty("java.io.tmpdir"),filename+".txt");
			bufferedWriter = new BufferedWriter(new FileWriter(file));            
			for(String line : this.gerarLinhas()){
				if(file.exists())
					bufferedWriter.append(line);
				bufferedWriter.newLine();
			}
//			path = file.getPath();
//			System.out.println(file.getAbsolutePath());
			return file;
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString() {
		return "Arquivo [id=" + id + ", url=" + url + ", header=" + header + ", trailer=" + trailer + ", lotes=" + lotes
				+ "]";
	}

	
	

}
