package com.labor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    /***
     * Da wir vielen mal den Noten Array als Argument verwenden, es ist besser eine Methode bauen, die Ausnahme
     * werfen
     * @param Noten das Noten Array
     * * @throw IllegalArgumentException ob da Noten gibt, die kleiner als 0 oder grosser als 100 sind
     */
    static void throwException(int[] Noten){
        for (int note : Noten)
            if (note < 0 || note > 100)
                throw new IllegalArgumentException();
    }

    /***
     *<h1>Aufgabe 1.1</h1>
     * Nicht ausreichend meint, dass die Note muss weniger als 40 sein
     * Wir werden nur eine for-Schleife verwenden
     * @param Noten das Noten Array
     */
    static void nichtAusreichendeNoten(int[] Noten){
        throwException(Noten);

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
