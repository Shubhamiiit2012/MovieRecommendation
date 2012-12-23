/**
 * This class contains the method which parses genre.data and converts genre index to Actual genre values.
 */
package com.movieRecommender;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class Genre {

	protected static String getActualValue(String string) throws IOException {
		FileInputStream fin = null;
		BufferedReader br = null;
		String intStringToken[]=string.split("[ ]+");
		String toReturn="";
		int k=0;
		try {
			String str="";
			fin = new FileInputStream("genre.data");
			br=new BufferedReader(new InputStreamReader(fin));
			
			while((str = br.readLine())!=null){
				String token[]=str.split("[|]+");
				if(k<intStringToken.length && intStringToken[k].equals(token[1])){
					toReturn=toReturn + token[0]+" ";
					k++;
				}
			}
			
			
		} catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		} finally {
			br.close();
			fin.close();
		}
		return toReturn;
	}

}
