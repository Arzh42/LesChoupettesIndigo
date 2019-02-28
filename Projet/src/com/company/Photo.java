package com.company;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Photo {
    private int numero;
    private ArrayList<String> tag;
    private boolean horizontal;
    private int ntag;
    public Photo(ArrayList<String> tag,boolean horizontal) {
        this.tag = tag;
        this.horizontal = horizontal;
    }
    public Photo(int numero,String[] data) {
        this.numero = numero;
        this.tag = new ArrayList<>();
        if (data[0].equals("H")) {
            this.horizontal = true;
        }
        else {
            this.horizontal = false;
        }
        this.ntag = parseInt(data[1]);
        for (int i=2;i<data.length;i++) {
            tag.add(data[i]);
        }
    }

    public String toString() {
        String s;
        if (horizontal) {
            s = "H";
        }
        else {
            s = "V";
        }
        for (int i=0;i<this.tag.size();i++) {
            s = s + " " + this.tag.get(i);
        }
        s = s + "\n";
        return s;

    }
    public ArrayList<String> getTag() {
        return tag;
    }

    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNtag() {
        return ntag;
    }

    public void setNtag(int ntag) {
        this.ntag = ntag;
    }
}
