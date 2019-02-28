package com.company;

import java.util.ArrayList;

public class Photo {
    private ArrayList<String> tag;
    private boolean horizontal;
    public Photo(ArrayList<String> tag,boolean horizontal) {
        this.tag = tag;
        this.horizontal = horizontal;
    }
    public Photo(String[] data) {
        this.tag = new ArrayList<>();
        if (data[0].equals("H")) {
            this.horizontal = true;
        }
        else {
            this.horizontal = false;
        }
        for (int i=1;i<data.length;i++) {
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
}
