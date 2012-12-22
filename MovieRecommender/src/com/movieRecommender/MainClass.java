/**
 * @author shubham
 * 
 */
package com.movieRecommender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Step 1. Parse the files.
 * Step 2. Create the structure of Data
 * 
 */

public class MainClass {
		
	private static List<Movie> movieList = new ArrayList<Movie>();
	public static void main(String[] args) {
		
		try{
		CreateMovieList("movie.data");
		System.out.println(movieList.get(0).toString());
		}catch(IndexOutOfBoundsException ex){}
	}
	
	
	
	public static void CreateMovieList(String fileName){
		String str="";
		FileInputStream fin = null;
		BufferedReader br=null;
		
		try{
			fin = new FileInputStream(fileName);
			br=new BufferedReader(new InputStreamReader(fin));
			while((str=br.readLine())!=null){	
			movieList.add(new Movie(str));
			}
			fin.close();
			br.close();
		}catch(IOException ioEx){}
		
	}
	
	
	
}
