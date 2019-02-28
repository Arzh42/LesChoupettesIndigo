
package com.company;

import java.io.*;
import java.util.*;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //soluce_a();
        soluce_b();
        //soluce_c();
        //soluce_d();
        //soluce_e();
    }
    public static void soluce_a() {
        Parser p = new Parser();
        String file = p.loadFile("a_example.txt");
        String[] ligne = file.split("\n");
        ByBloc b = new ByBloc();
        ArrayList<Photo> photos = p.parse(file);
        ArrayList<Slide> slides = toSlide(photos);
        ArrayList<Slide> soluce = b.build(slides);
        Slideshow show = new Slideshow();
        for (Slide s:soluce) {
            show.addSlide(s);
        }
        printSoluce(show.generateOutput(),"soluce_a.txt");
    }

    public static void soluce_b() {
        Parser p = new Parser();
        String file = p.loadFile("b_lovely_landscapes.txt");
        String[] ligne = file.split("\n");
        ByBloc b = new ByBloc();
        ArrayList<Photo> photos = p.parse(file);
        ArrayList<Slide> slides = toSlide(photos);
        ArrayList<Slide> soluce = b.build(slides);
        Slideshow show = new Slideshow();
        for (Slide s:soluce) {
            show.addSlide(s);
        }
        printSoluce(show.generateOutput(),"soluce_b.txt");
    }
    public static void soluce_c() {
        Parser p = new Parser();
        String file = p.loadFile("c_memorable_moments.txt");
        String[] ligne = file.split("\n");
        ByBloc b = new ByBloc();
        ArrayList<Photo> photos = p.parse(file);
        ArrayList<Slide> slides = toSlide(photos);
        ArrayList<Slide> soluce = b.build(slides);
        Slideshow show = new Slideshow();
        for (Slide s:soluce) {
            show.addSlide(s);
        }
        printSoluce(show.generateOutput(),"soluce_c.txt");
    }
    public static void soluce_d() {
        Parser p = new Parser();
        String file = p.loadFile("d_pet_pictures.txt");
        String[] ligne = file.split("\n");
        ByBloc b = new ByBloc();
        ArrayList<Photo> photos = p.parse(file);
        ArrayList<Slide> slides = toSlide(photos);
        ArrayList<Slide> soluce = b.build(slides);
        Slideshow show = new Slideshow();
        for (Slide s:soluce) {
            show.addSlide(s);
        }
        printSoluce(show.generateOutput(),"soluce_d.txt");
    }
    public static void soluce_e() {
        Parser p = new Parser();
        String file = p.loadFile("e_shiny_selfies.txt");
        String[] ligne = file.split("\n");
        ByBloc b = new ByBloc();
        ArrayList<Photo> photos = p.parse(file);
        ArrayList<Slide> slides = toSlide(photos);
        ArrayList<Slide> soluce = b.build(slides);
        Slideshow show = new Slideshow();
        for (Slide s:soluce) {
            show.addSlide(s);
        }
        printSoluce(show.generateOutput(),"soluce_e.txt");
    }

    public static void printSoluce(String s,String name) {
        PrintWriter out = null;
        try {
            out = new PrintWriter("file/"+name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println(s);
        out.close();
    }
    public static String stupid(ArrayList<Photo> photos) {
        int i = 0;
        Photo lastVertical = null;
        Slideshow show = new Slideshow();
        for (i=0;i<photos.size();i++) {
            Photo photo = photos.get(i);
            if (photo.isHorizontal()) {
                Slide s = new Slide(photo);
                show.addSlide(s);
            }
            else {
                if (lastVertical==null) {
                    lastVertical = photo;
                }
                else {
                    Slide s = new Slide(lastVertical,photo);
                    lastVertical = null;
                    show.addSlide(s);
                }
            }
        }
        return show.generateOutput();
    }
    public static ArrayList<Slide> toSlide(ArrayList<Photo> photos) {
        int i = 0;
        Photo lastVertical = null;
        ArrayList<Slide> a = new ArrayList<>();
        for (i=0;i<photos.size();i++) {
            Photo photo = photos.get(i);
            if (photo.isHorizontal()) {
                Slide s = new Slide(photo);
                a.add(s);
            }
            else {
                if (lastVertical==null) {
                    lastVertical = photo;
                }
                else {
                    Slide s = new Slide(lastVertical,photo);
                    lastVertical = null;
                    a.add(s);
                }
            }
        }
        return a;
    }
}
