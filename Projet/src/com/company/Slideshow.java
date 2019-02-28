package com.company;

import java.util.ArrayList;

public class Slideshow {
    ArrayList<Slide> slides = new ArrayList<>();
    public Slideshow() {

    }
    public void addSlide(Slide s) {
        slides.add(s);
    }
    public String generateOutput() {
        String s = String.valueOf(slides.size());
        for (int i=0;i<slides.size();i++) {
            s = s + "\n" + slides.get(i).toString();
        }
        return s;
    }

}
