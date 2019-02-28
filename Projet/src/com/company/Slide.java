package com.company;

public class Slide {
    private boolean horizontal;
    private Photo photo1;
    private Photo photo2;
    public Slide(Photo photo) {
        this.horizontal = true;
        this.photo1 = photo;
    }

    public Slide(Photo photo1,Photo photo2) {
        this.horizontal = false;
        this.photo1 = photo1;
        this.photo2 = photo2;
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
}
