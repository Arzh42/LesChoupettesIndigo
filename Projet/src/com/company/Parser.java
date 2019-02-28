package com.company;

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
}
