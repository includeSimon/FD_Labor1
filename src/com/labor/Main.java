package com.labor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    /***
     *<h1>Aufgabe 1.1</h1>
     * Nicht ausreichend meint, dass die Note muss weniger als 40 sein
     * Wir werden nur eine for-Schleife verwenden
     * @param Noten das Noten Array
     */
    static void nichtAusreichendeNoten(int[] Noten){
        ArrayList<Integer> nANoten = new ArrayList<Integer>();

        for (int note : Noten)
            if (note < 40)  nANoten.add(note);

        System.out.println(nANoten.toString());
    }

    public static void main(String args[]) {
        int[] Noten = {4, 8, 3, 10, 17, 60};
        nichtAusreichendeNoten(Noten);
    }

}
