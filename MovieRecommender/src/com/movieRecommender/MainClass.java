/**
 * @author shubham
 * 
 */
package com.movieRecommender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Step 1. Create the classes of nouns i.e. Ratings, Movie, User.
 * Step 2. Parse the files.
 * Step 3. Create objects of all the nouns by inserting appropriate value from parsed data.
 * Step 4. 
 * 
 */

public class MainClass {
		
	private static List<Movie> movieList = new ArrayList<Movie>();
	public static void main(String[] args) {
		CreateMovieList("movie.data");
		CreateRatingListInMovie("ratings.data");
		int i=0;
		//try{
		while(i<1682){
			//System.out.println(movieList.get(i).toString());
			i++;
		}
		//}catch(IndexOutOfBoundsException ex){System.out.println("not found.");}
		System.out.println(i);
	}
	
	
	
	private static void CreateRatingListInMovie(String str) {
		FileInputStream fin = null;
		BufferedReader br = null;
		String str1="";
		try {
			fin=new FileInputStream(str);
			br=new BufferedReader(new InputStreamReader(fin));
			while((str1=br.readLine())!=null){
				String token[] = str1.split("	");
				
				Ratings ratingObject=new Ratings(Integer.valueOf(token[0]), Integer.valueOf(token[2]));
				System.out.println(ratingObject.toString());
				
				System.out.println(movieList.get((Integer.valueOf(token[1]))-1).toString());
				
			}
		} catch (Exception e) {
			
		}
		
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
