package com.company;

import java.io.*;
import java.util.ArrayList;

public class Parser {
    public ArrayList<Photo> parse(String file) {

        String[] ligne = file.split("\n");
        ArrayList<Photo> photos = new ArrayList<>();
        int i;
        for (i=1;i<ligne.length;i++) {

            photos.add(this.createPhoto(i-1,ligne[i]));
        }
        return photos;
    }
    public Photo createPhoto(int num,String ligne) {
        String[] value = ligne.split(" ");
        Photo p = new Photo(num,value);
        return p;
    }
    public static String loadFile(String path) {
        InputStream is = null;
        try {
            is = new FileInputStream("./file/"+path);
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

        return file;
    }
}
