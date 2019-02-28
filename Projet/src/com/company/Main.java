
package com.company;

import java.io.*;
import java.util.*;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream("./file/a_example.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = null;
        try {
            line = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        
		while(line != null){
   			sb.append(line).append("\n");
            try {
                line = buf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        String file = sb.toString();
        String[] ligne = file.split("\n");

        Parser p = new Parser();
        ArrayList<Photo> A = p.parse(file);

        Collections.sort(A, new Comparator<Photo>(){
        	public int compare(Photo p1, Photo p2){
        		return (p1.getNtag() > p2.getNtag()) ? 1 : 0;
        	}
        } );
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
}
