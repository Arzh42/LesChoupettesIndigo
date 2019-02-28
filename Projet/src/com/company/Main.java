package com.company;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

import java.util.ArrayList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	ArrayList<Slide> S = new ArrayList<Slide>() ;

    	InputStream is = new FileInputStream("a_example.txt");
    	BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();
        
		while(line != null){
   			sb.append(line).append("\n");
   			line = buf.readLine();
		}



        String file = sb.toString();
        String[] ligne = file.split("\n");

        Parser p = new Parser();
        ArrayList<Photo> B = p.parse(file);

        ArrayList<Slide> A = this.transfo(B);

        Collections.sort(A, new Comparator<Photo>(){
        	public int compare(Photo p1, Photo p2){
        		return p1.getNtag() > p2.getNtag();
        	}
        } );

        S[0] = A[0] ;
        int tmp = this.test(A);
        int i = 0 ;
        while(A.length >1){
        	S[i+1] = A[tmp] ;
        	A.remove(0);
        	A.add(0,A[tmp-1]);
        	A.remove(tmp);
        	tmp = this.test(A);
        }


        Slide s1 = new Slide(photos.get(0));
        Slide s2 = new Slide(photos.get(3));
        Slide s3 = new Slide(photos.get(1),photos.get(2));
        Slideshow show = new Slideshow();
        show.addSlide(s1);
        show.addSlide(s2);
        show.addSlide(s3);
        System.out.println(show.generateOutput());
        ArrayList<Photo> photos = p.parse(file);
        Slide s1 = new Slide(photos.get(0));
        Slide s2 = new Slide(photos.get(3));
        Slide s3 = new Slide(photos.get(1),photos.get(2));
        Slideshow show = new Slideshow();
        show.addSlide(s1);
        show.addSlide(s2);
        show.addSlide(s3);
        System.out.println(show.generateOutput());
    }

    public int test(ArrayList<Slide> A){
   		Iterator<Slide> it = new Iterator<Slide>();
   		Slide p1 = it;
   		int tmp;
   		int cur = 1;
   		int p2 = 1;
   		int tagc = this.commun(it, it.next());
   		it = it.next();

    	while(it.getNtag()>tagc){
    		tmp = this.commun(p1, it);
    		if(tmp>tagc){
    			tagc = tmp;
    			p2 = cur;
    		}
    		cur ++;
    		it = it.next();
    	}

    	return p2;
    }

    public int commun(Slide p1, Slide p2){
    	ArrayList<String> tag1 = p1.getTag();
    	ArrayList<String> tag2 = p2.getTag();

    	int t1len = tag1.length;
    	int t2len = tag2.length;
    	int commun = 0;

    	for(int i = 0; i<t1len; i++){
    		for(int j = 0 ; j<t2len; j++){
    			if(tag1[i] == tag2[j]){
    				commun++;
    			}
    		}
    	}

    	return commun;
    }

    public ArrayList<Slide> transfo(ArrayList<Photo> A){
    	ArrayList<Slide> P = new ArrayList<Slide>();
    	Photo tmp = null;
    	for(int i = 0; i<A.length; i++){
    		if(A[i].isHorizontal()){
    			P[i] = new Slide(A[i]);
    		} else {
    			if (tmp == null){
    				tmp = A[i];
    			} else {
    				P[i] = new Slide(tmp, A[i]);
    				tmp = null;
    			}
    		}
    	}
    }
}
