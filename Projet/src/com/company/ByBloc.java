package com.company;

import java.util.ArrayList;

public class ByBloc {
    private int nbTry = 60;
    public ArrayList<Slide> build(ArrayList<Slide> slides) {
        int i = 0;
        ArrayList<Slide> arrayList = new ArrayList<>();
        while ((i+1)*this.nbTry<slides.size()) {
            ArrayList<Slide> sub = new ArrayList<Slide>(slides.subList(i*this.nbTry,(i+1)*this.nbTry));
            arrayList.addAll(this.buildBloc(sub));
            i ++;
        }
        ArrayList<Slide> sub = new ArrayList<Slide>(slides.subList(i*this.nbTry,slides.size()));
        arrayList.addAll(this.buildBloc(sub));
        return arrayList;
    }
    public ArrayList<Slide> buildBloc(ArrayList<Slide> array) {
        ArrayList<Slide> result = new ArrayList<Slide>();
        Slide s = array.get(0);
        array.remove(0);
        while(array.size()>0) {
            Slide find = findBestSlide(s,array);
            array.remove(find);
            result.add(s);
            s = find;
        }
        result.add(s);
        return result;
    }
    public Slide findBestSlide(Slide slide,ArrayList<Slide> array) {
        Slide best = array.get(0);
        int maxNbTag = 0;
        int nbTag = 0;
        for (int i=0;i<array.size();i++) {
            nbTag = slide.countTagEqual(array.get(i));
            if (maxNbTag<nbTag) {
                best = array.get(i);
                maxNbTag = nbTag;
            }
        }

        return best;
    }

}
