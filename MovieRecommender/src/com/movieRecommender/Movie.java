package com.movieRecommender;

import java.util.ArrayList;
import java.util.List;

public class Movie{
	
	@Override
	public String toString() {
		return "Movie [name=" + name + ", year=" + year + ", genre=" + genre.get(0)
				+ "]";
	}
	private String name;
	private int year;
	private List<Ratings> ratingList;
	private List<Integer> genre=new ArrayList<Integer>();
	
	public Movie(String str){
		String tkn[]=ParseString(str);
		name=tkn[0];
		year=Integer.parseInt(tkn[1]);
		genre.add(Integer.parseInt(tkn[2]));
		genre.add(Integer.parseInt(tkn[3]));
		genre.add(Integer.parseInt(tkn[4]));
	}
	
	public String[] ParseString(String str) {
		
		String arr[]= {"Silence","1989","5","4","7"};
		return arr;
	}
	
	protected String getName() {
		return name;
	}
	
	protected int getYear() {
		return year;
	}
	
	protected List<Ratings> getRatingList() {
		return ratingList;
	}
	protected void setRatingList(List<Ratings> ratingList) {
		this.ratingList = ratingList;
	}
	
	
	
}
