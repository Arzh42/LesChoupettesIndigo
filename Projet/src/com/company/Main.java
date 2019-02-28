package com.company;

public class Main {

    public static void main(String[] args) {
        String file = "4\n" +
        "H 3 cat beach sun\n" +
        "V 2 selfie smile\n" +
        "V 2 garden selfie\n" +
        "H 2 garden cat";
        String[] ligne = file.split("\n");

        Parser p = new Parser();
        p.parse(file);
    }
}
