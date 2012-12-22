/**
 * @author shubham
 * 
 */
package com.movieRecommender;

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
		CreateMovieList("ok");
		
		System.out.println(movieList.get(0).toString());
	}
	public static void CreateMovieList(String str){
		movieList.add(new Movie(str));
	}
	
}
