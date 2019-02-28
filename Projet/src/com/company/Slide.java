package com.company;

import java.util.ArrayList;

public class Slide {
    private boolean horizontal;
    private Photo photo1;
    private Photo photo2;
    private ArrayList<String> tag;
    public Slide(Photo photo) {
        this.horizontal = true;
        this.photo1 = photo;
        this.tag = photo.getTag();
    }

    public Slide(Photo photo1,Photo photo2) {
        this.horizontal = false;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.tag = photo1.getTag();

        this.tag.addAll(photo2.getTag());
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public Photo getPhoto1() {
        return photo1;
    }

    public void setPhoto1(Photo photo1) {
        this.photo1 = photo1;
    }
    public String toString() {

        String s;
        if (horizontal) {
            s = String.valueOf(this.photo1.getNumero());
        }
        else {
            s = String.valueOf(this.photo1.getNumero()) +" "+String.valueOf(this.photo2.getNumero());
        }
        return s;

    }

    public Photo getPhoto2() {
        return photo2;
    }

    public void setPhoto2(Photo photo2) {
        this.photo2 = photo2;
    }
    public ArrayList<String> getTag() {
        return this.tag;
    }
    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }
}
