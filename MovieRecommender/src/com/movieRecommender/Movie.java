package com.movieRecommender;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	@Override
	public String toString() {
		return "Movie [name=" + name + ", year=" + year + ", genre="+ PrintGenre() + "]";
		}

	private String name;
	private int year;
	private List<Ratings> ratingList;
	private List<Integer> genre = new ArrayList<Integer>();
	public int ratingListLength=0;

	public Movie(String str) {
		String st[]=str.split("[|()]+");
		List<String> tkn= ParseString(st);
		try{
			name = tkn.get(1);
			year = Integer.parseInt(tkn.get(2));
			int i=3;
		
			while(i<tkn.size()){
				genre.add(Integer.parseInt(tkn.get(i)));
				i++;
			}
		}catch(Exception ex){}
	}

	public float GetAverageRating(){
		int sum=0;
		int count=0;
		//try{
		if(ratingListLength!=0){
		while(count<ratingListLength){
			sum=sum+ratingList.get(count).getRateValue();
			count++;
		}
		return (float)sum/count;}//}catch(Exception ex){}
		return 0;
	}
	
	public List<String> ParseString(String[] tkn) {

		List<String> list=new ArrayList<String>();
		 
		 
		 list.add(tkn[0]);
		 list.add(tkn[1]);
		 list.add(tkn[2]);
		 
		 
		 for(int i=6;i<tkn.length;i++){
			 if(tkn[i].equals("1"))
				 list.add(String.valueOf(i-6));
		 }
		 
		 return list;
	}

	
	private String PrintGenre(){
		int i=0;
		String st="";
		try{
			for(i=0;i <=genre.size()-1;i++){
				st=st+Integer.toString(genre.get(i))+", ";
			}
		
			st=st+Integer.toString(genre.get(i+1));
			
		}catch(Exception ex){}
		return st;
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

	public void setRating(Ratings rating) {
		ratingList.add(rating);
		ratingListLength++;
	}
	protected float avgRating(){
		if(ratingList.size() == 0)
			return 0;
		int sum=0;
		int count=0;
		while( count < ratingList.size() ) {
			sum=sum+ratingList.get(count).getRateValue();
			count++;
		}
		count=count+1;
		return (float)sum/count;
		
	}

}
