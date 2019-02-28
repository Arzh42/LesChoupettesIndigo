import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

package com.company;

public class Main {

    public static void main(String[] args) {
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
        ArrayList<Photo> A = p.parse(file);

        Collections.sort(A, new Comparator<Photo>(){
        	public int compare(Photo p1, Photo p2){
        		return p1.getNtag() > p2.getNtag();
        	}
        } );
    }
}
