package br.com.pw.antares.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;


public abstract class Tools  {
	
	public static class ComprovanteGen {
		
		public static String generate(){
			return GetBase36(10);
		}
		
	    private static char[] _base62chars = 
	        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
	        .toCharArray();
	    private static Random _random = new Random();

	    @SuppressWarnings("unused")
		private static String GetBase62(int length){
	    	StringBuilder sb = new StringBuilder(length);
	        for (int i=0; i<length; i++) 
	            sb.append(_base62chars[_random.nextInt(62)]);
	        return sb.toString();
	    }       

	    private static String GetBase36(int length){
	    	StringBuilder sb = new StringBuilder(length);
	        for (int i=0; i<length; i++) 
	            sb.append(_base62chars[_random.nextInt(36)]);
	        return sb.toString();
	    }
	}

	public static String getStack(Exception ex){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		return sw.toString();
	}

	
	public static String stringToDateFormat(String str, String inputFormat, String outputFormat) throws ParseException{
		if(str.length()!= inputFormat.length())
			throw new ParseException("The str param must have the same length of the inputFormat param.", 0);
				
		return DateTimeFormat.forPattern(inputFormat).parseDateTime(str).toString(outputFormat);
	}


	public static DateTime stringToDate(String str, String inputFormat) throws ParseException{
		return DateTimeFormat.forPattern(inputFormat).parseDateTime(str);
	}

	public static DateTime stringToDate(String str) throws ParseException{
		return stringToDate(str,"dd/MM/yyyy");		
	}

	public static String intArrayToString(int[] array, char separator){
		String retur = "";
		for(int i = 0; i < array.length; i++){
			retur = retur+array[i]+String.valueOf(separator);
		}
		return retur;
	}

	public static String stringArrayToString(String[] array, char separator) {
		String retur = "";
		for(int i = 0; i < array.length; i++){
			retur = retur+array[i]+String.valueOf(separator);
		}
		return retur;
	}


	public static Double doubleFormat(double d) {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(d).replace(",", "."));
	}

	public static Double doubleFormat(String d) {
		if(d == null || d.length() == 0){
			return 0.00;
		}
		double dou = Double.parseDouble(d.replace(",", "."));
		return doubleFormat(dou);
	}


	public static String getAsMoney(Number obj){
		NumberFormat f = NumberFormat.getNumberInstance();  
		f.setMinimumFractionDigits(2);
		f.setMaximumFractionDigits(2);
		return f.format(obj);
	}


	public static BigInteger toMD5(String s){
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(s.getBytes(),0,s.length());
			return new BigInteger(1,m.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int getRamdom(){
		return getRamdom(Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public static int getRamdom(int max, int min){
		Random rn = new Random();
		int range = max - min + 1;
		return rn.nextInt(range) + min;

	}

	public static Integer intPrimo(){
		Integer r;
		while(true){

			r = (Tools.getRamdom(10000000, 100000));
			int cont = 0;
			for (int i=1;i<=r;i++ ){
				if(r%i == 0){
					cont=cont+1;
				}
			}

			if(cont == 2){
				break;
			}
		}

		return r;

	}
	public static DateTime now(){
		return DateTime.now(DateTimeZone.forID("America/Sao_Paulo"));
	}

	public static int modulo10(String string){
		return modulo10(string.toCharArray());
	}

	public static int modulo10(char[] digitos){
		int flag = 2;
		Integer soma = 0;
		Integer num;
		for(int i = digitos.length-1; i >=0; i--){
			num = Integer.parseInt(String.valueOf(digitos[i]))*flag;
			soma+= num > 9 ? (num - 9) : num;
			flag = flag == 2 ? 1 : 2;
		}
		return soma%10 == 0 ? 0 : 10 - (soma%10);
	}



}
