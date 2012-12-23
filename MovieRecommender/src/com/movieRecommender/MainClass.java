/**
 * @author shubham
 * 
 */
package com.movieRecommender;

import java.io.*;
import java.util.*;

/**
 * Step 1. Create the classes of nouns i.e. Ratings, Movie, User. 
 * Step 2. Parse
 * the files. 
 * Step 3. Create objects of all the nouns by inserting appropriate value from parsed data. 
 * Step 4.
 * 
 */

public class MainClass {

	private static List<Movie> movieList = new ArrayList<Movie>();
	private static Map<Integer, List<Ratings>> movieRatings = new HashMap<Integer, List<Ratings>>();
	private static int ratedMovieNum[] = new int[1682];
	private static int highestMovieRatedIndex = 0;
	private static int highestRate = 0;

	public static void main(String[] args) {

		new MainClass().CreateMovieList("movie.data");
		new MainClass().CreateRatingListInMovie("ratings.data");
		int i = 0;

		FindHighestRatedMovie("ratings.data");
	
	}

	private static void FindHighestRatedMovie(String string) {
		int i = 0;
		String str = "";
		while (i < 1682) {
			ratedMovieNum[i++] = 0;
		}
		try {
			FileInputStream fin = new FileInputStream(string);
			BufferedReader br = new BufferedReader(new InputStreamReader(fin));
			while ((str = br.readLine()) != null) {
				String token[] = str.split("[	]+");
				ratedMovieNum[Integer.valueOf(token[0])]++;
			}

			br.close();
			fin.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		int rate = 0;
		int index = 0;

		for (int it = 0; it < ratedMovieNum.length; it++) {

			if (ratedMovieNum[it] >= rate) {

				index = it;
				rate = ratedMovieNum[it];

			}
		}

		System.out.println("Highest Rated Movie is :");
		System.out.println(movieList.get(index).toString());
		System.out.println("Ratings = " + rate);

	}

	private static void CreateRatingListInMovie(String str) {
		FileInputStream fin = null;
		BufferedReader br = null;
		String str1 = "";
		try {
			fin = new FileInputStream(str);
			br = new BufferedReader(new InputStreamReader(fin));
			while ((str1 = br.readLine()) != null) {
				String token[] = str1.split("	");

				Ratings ratingObject = new Ratings(Integer.valueOf(token[0]),
						Integer.valueOf(token[2]));
				// System.out.println(ratingObject.toString()+Integer.valueOf(token[1]));
				int x = Integer.valueOf(token[1]) - 1;

				System.out.println(movieList.get((Integer.valueOf(token[1]))-1).toString());

			}
		} catch (Exception e) {

		}

	}

	public static void CreateMovieList(String fileName) {
		String str = "";
		FileInputStream fin = null;
		BufferedReader br = null;

		try {
			fin = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fin));
			while ((str = br.readLine()) != null) {
				movieList.add(new Movie(str));
			}
			fin.close();
			br.close();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

	}

}
