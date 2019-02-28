package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String file = "4\n" +
        "H 3 cat beach sun\n" +
        "V 2 selfie smile\n" +
        "V 2 garden selfie\n" +
        "H 2 garden cat";
        String[] ligne = file.split("\n");

        Parser p = new Parser();
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
