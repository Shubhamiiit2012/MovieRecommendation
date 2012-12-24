/**
 * @author shubham
 * 
 */
package com.movieRecommender;

import java.io.*;
import java.util.*;

/**
 * Step 1. Create the classes of nouns i.e. Ratings, Movie, User. Step 2. Parse
 * the files. Step 3. Create objects of all the nouns by inserting appropriate
 * value from parsed data.
 * 
 */

public class MainClass {
	/*
	 * Global Variables
	 */
	private static List<Movie> movieList = new ArrayList<Movie>();
	private static int ratedMovieNum[] = new int[1682];
	private static HashMap<Integer, String> ratingRecord = new HashMap<Integer, String>();
	private static float[] avgRatingRecord = new float[1682];

	// private static Map<Integer, List<Ratings>> movieRatings = new
	// HashMap<Integer, List<Ratings>>();

	public static void main(String[] args) {

		CreateMovieList("movie.data");
		CreateMovieRateList("ratings.data");
		CreateRatingListInMovie("ratings.data");
		CalculateAvgRateOfMovie();
		FindMostWatchedMovie("ratings.data");
		FindHighestRatedMovie();

	}

	private static void FindHighestRatedMovie() {
		float maxRate = 0;
		int maxRateIndex = 0;
		for (int currentIndex = 0; currentIndex < 1682; currentIndex++)
			if (avgRatingRecord[currentIndex] > maxRate) {
				maxRate = avgRatingRecord[currentIndex];
				maxRateIndex = currentIndex;
			}
		System.out.println("\n\nHighest Rated Movie : \n" + "Movie ID = "
				+ (maxRateIndex + 1) + " Rating = " + maxRate + "\n"
				+ movieList.get(maxRateIndex).toString());

	}

	private static void CreateMovieRateList(String string) {
		FileInputStream fin = null;
		BufferedReader br = null;
		String str = "";

		try {
			fin = new FileInputStream(string);
			br = new BufferedReader(new InputStreamReader(fin));

			while ((str = br.readLine()) != null) {
				String token[] = str.split("[	]+");
				if (ratingRecord.isEmpty()) {
					ratingRecord.put(Integer.valueOf(token[1]),
							("1 " + token[2]));
				} else {
					if (ratingRecord.containsKey(Integer.valueOf(token[1]))) {
						String s = ratingRecord.get(Integer.valueOf(token[1]));
						String tkn[] = s.split("[ ]+");
						int x = Integer.valueOf(tkn[0]);
						int y = Integer.valueOf(tkn[1]);
						x++;
						y = y + Integer.valueOf(token[2]);
						s = x + " " + y;
						ratingRecord.put(Integer.valueOf(token[1]), s);
					} else {
						ratingRecord.put(Integer.valueOf(token[1]),
								("1 " + token[2]));
					}
				}
			}
		} catch (IOException ex) {
		}
	}

	private static void CalculateAvgRateOfMovie() {
		float avg = 0;
		try {
			for (int i = 0; i < 1682; i++) {
				if (ratingRecord.containsKey(i)) {
					String str = ratingRecord.get(i);
					String token[] = str.split("[ ]+");
					int x = Integer.valueOf(token[0]);
					int y = Integer.valueOf(token[1]);
					avg = (float) y / x;
					avgRatingRecord[i] = avg;
					System.out.println("Movie id = " + (i + 1) + " "
							+ movieList.get(i).toString());
					System.out.println("Average rating = " + " is "
							+ avgRatingRecord[i]);
				}
			}

		} catch (Exception ex) {
		}

	}

	// Prints Highest Rated Movie....
	private static void FindMostWatchedMovie(String string) {

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

		System.out.println("\n\n\nMost watched Movie is :");
		System.out.println(movieList.get(index).toString());
		System.out.println("Number of times Watched = " + rate + "\n\n");

	}

	// Not successfull.... :(
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
				/*
				 * System.out.println(ratingObject.toString()); int x =
				 * Integer.valueOf(token[1]) - 1;
				 * 
				 * System.out.println("Movie Id = " + (x + 1) + "  "+
				 * movieList.get(x).toString());
				 */

			}

		} catch (IOException e) {

		}

	}

	// Takes object by movie id, as index in list.
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
