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

    /***
     *<h1>Aufgabe 1.2</h1>
     * In eine for Schleife werden wir die Noten addieren
     * @param Noten das Noten Array
     */
    static void durchschnittWert(int[] Noten){
        throwException(Noten);

        for (int note : Noten)
            if (note < 0 || note > 100)
                throw new IllegalArgumentException();

        double summe = 0;
        for (int note : Noten)
            summe += note;

        System.out.println("Das Durchschnittswert ist " + String.format("%.2f", summe / Noten.length)); //2 Dezimale
    }

    /***
     * <h1>Aufgabe 1.3</h1>
     * Es werdet matematisch gelöst, durch substraktion mit 5, so dass wir die letzte Ziffern finden.
     * @param Noten das Noten Array
     * @return ArrayList<Integer> die abgerundete Noten aus den Noten Array
     */
    static ArrayList<Integer> abgerundeteNoten(int[] Noten){
        throwException(Noten);

        ArrayList<Integer> abNoten = new ArrayList<Integer>();

        for (int note : Noten) {
            int result = note % 10 - 5;     // die letzte Ziffern - 5

            if (result < 0) {
                if (result == -2)   // die letzte Ziffer ist 3
                    abNoten.add(note + 2);
                if (result == -1)   // die letzte Ziffer ist 4
                    abNoten.add(note + 1);
            }

            if (result > 0) {
                if (result == 3)   // die letzte Ziffer ist 8
                    abNoten.add(note + 2);
                if (result == 4)   // die letzte Ziffer ist 9
                    abNoten.add(note + 1);
            }
        }
        return  abNoten;
    }

    /***
     * <h1>Aufgabe 1.4</h1>
     * Es werdet die max Methode aus Collections verwendet
     * @param Noten das Noten Array
     * @return Integer die grosste Note aus den abgerundete Noten Array
     */
    static Integer maxAbNote(int[] Noten){
        throwException(Noten);return Collections.max(abgerundeteNoten(Noten));
    }

    /***
     * <h1>Aufgabe 2.1</h1>
     * Max Methode aus Array stream
     * Vielleicht gibt es einfacher Lösungen
     * @param Noten das Noten Array
     * @return Integer die max Note
     */
    static Integer maxNote(int[] Noten) {throwException(Noten);return Arrays.stream(Noten).max().getAsInt();}

    /***
     * <h1>Aufgabe 2.2</h1>
     * Min Methode aus Array stream
     * @param Noten das Noten Array
     * @return Integer die kleinste Note aus die Noten Array
     */
     static Integer minNote(int[] Noten) {throwException(Noten);return Arrays.stream(Noten).min().getAsInt();}

    /***
     * <h1>Aufgabe 2.3</h1>
     * Wir sorten den Array dann so dass wir alle Noten ohne die erste (kleinste) summieren konnen
     * @param Noten das Noten Array
     * @return Integer die maximale Summe der n-1 Noten
     */
    static Integer maxSumme(int[] Noten) {
        throwException(Noten);
        int[] sortedNoten = Noten;
        Arrays.sort(sortedNoten);

        int sum = 0;
        for (int i = sortedNoten.length - 1; i > 0; i--)
            sum += sortedNoten[i];

        return sum;
    }

    public static void main(String args[]) {
        int[] Noten = {4, 8, 3, 10, 17, 60};
        nichtAusreichendeNoten(Noten);
        durchschnittWert(Noten);
        abgerundeteNoten(Noten);
        System.out.println("Die abgerundete Noten sind: " + abgerundeteNoten(Noten).toString());
        System.out.println(maxAbNote(Noten).toString());
        System.out.println("Die hochste Note ist: " + maxNote(Noten));
        System.out.println("Die kleinste Note ist: " + minNote(Noten));
        System.out.println("Die maximum Summe der n-1 Zahlen ist " + maxSumme(Noten));
    }

}
