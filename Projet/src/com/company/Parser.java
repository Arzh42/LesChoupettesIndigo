package com.company;

import java.util.ArrayList;

public class Parser {
    public ArrayList<Photo> parse(String file) {

        String[] ligne = file.split("\n");
        ArrayList<Photo> photos = new ArrayList<>();
        int i;
        for (i=1;i<ligne.length;i++) {
            photos.add(this.createPhoto(ligne[i]));
        }
        return photos;
    }
    public Photo createPhoto(String ligne) {
        String[] value = ligne.split(" ");
        Photo p = new Photo(value);
        return p;
    }
}
