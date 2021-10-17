package com.labor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import org.apache.commons.lang3.ArrayUtils;  -> cannot import it, should download it first

public class Main {
    /***
     * Da wir vielen mal den Noten Array als Argument verwenden, es ist besser eine Methode bauen, die Ausnahme
     * werfen
     * @param Noten das Noten Array
     * * @throw IllegalArgumentException ob da Noten gibt, die kleiner als 0 oder grosser als 100 sind
     */
    static void throwException(int[] Noten) {
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
    static void nichtAusreichendeNoten(int[] Noten) {
        throwException(Noten);

        ArrayList<Integer> nANoten = new ArrayList<Integer>();

        for (int note : Noten)
            if (note < 40) nANoten.add(note);

        System.out.println(nANoten.toString());
    }

    /***
     *<h1>Aufgabe 1.2</h1>
     * In eine for Schleife werden wir die Noten addieren
     * @param Noten das Noten Array
     */
    static void durchschnittWert(int[] Noten) {
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
    static ArrayList<Integer> abgerundeteNoten(int[] Noten) {
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
        return abNoten;
    }

    /***
     * <h1>Aufgabe 1.4</h1>
     * Es werdet die max Methode aus Collections verwendet
     * @param Noten das Noten Array
     * @return Integer die grosste Note aus den abgerundete Noten Array
     */
    static Integer maxAbNote(int[] Noten) {
        throwException(Noten);
        return Collections.max(abgerundeteNoten(Noten));
    }

    /***
     * <h1>Aufgabe 2.1</h1>
     * Max Methode aus Array stream
     * Vielleicht gibt es einfacher Lösungen
     * @param Noten das Noten Array
     * @return Integer die max Note
     */
    static Integer maxNote(int[] Noten) {
        throwException(Noten);
        return Arrays.stream(Noten).max().getAsInt();
    }

    /***
     * <h1>Aufgabe 2.2</h1>
     * Min Methode aus Array stream
     * @param Noten das Noten Array
     * @return Integer die kleinste Note aus die Noten Array
     */
    static Integer minNote(int[] Noten) {
        throwException(Noten);
        return Arrays.stream(Noten).min().getAsInt();
    }

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

    /***
     * <h1>Aufgabe 2.4</h1>
     * Es ist die Gleiche wie Aufgabe 2.3, nur die for Schleife ist verschieden
     * @param Noten
     * @return Integer die kleinste Summe der n-1 Noten
     */
    static Integer minSumme(int[] Noten) {
        throwException(Noten);
        int[] sortedNoten = Noten;
        Arrays.sort(sortedNoten);

        int sum = 0;
        for (int i = 0; i < sortedNoten.length - 1; i++)
            sum += sortedNoten[i];

        return sum;
    }

    /***
     * <h1>Aufgabe 3.1</h1>
     * Der Algorithmus wandelt von Array in Integer um, macht die Operation(Summe, Differenz, Multiplikation, Division)
     * als Integer, wandelt dann das Ergebnis als Array um und gibt es zurück
     * @param Array1 die erste Nummer
     * @param Array2 die zweite Nummer
     * @return Summe die Summe als int Array
     */
    static int[] ArraySumme(int[] Array1, int[] Array2) {
        int kleinsteAnzahlNull = 0, aux1 = 0, aux2 = 0;

        //wir finden die erste Null in beiden arrays
        for (int i = 0; i < Array1.length; i++)
            if (Array1[Array1.length - i - 1] == 0)
                aux1++;
            else break;

        for (int i = 0; i < Array2.length; i++)
            if (Array2[Array2.length - i - 1] == 0)
                aux2++;
            else break;

        //wir brauchen die kleinste Nummer
        kleinsteAnzahlNull = Math.min(aux1, aux2);

        //von Array to int
        int nummer1 = 0, nummer2 = 0;

        for (int i = 0; i < Array1.length-kleinsteAnzahlNull; i++) {
            nummer1 *= 10;
            nummer1 += Array1[i];
        }

        for (int i = 0; i < Array2.length-kleinsteAnzahlNull; i++) {
            nummer2 *= 10;
            nummer2 += Array2[i];
        }

        // die beiden Nummern addieren
        int nummer3 = nummer1 + nummer2;


        //wir brauchen einen neuen Array, die unserer summe enthalt
        //erstmal finden wir die Anzahl von Ziffern der Summe
        int anzahlZiffern = (int) Math.log10(nummer3) + 1;

        //das neue Array hat anzahlZiffern + kleinsteAnzahlNull grosse
        int[] Summe = new int[anzahlZiffern + kleinsteAnzahlNull];

        //von int to array
        //erstmal alle null
        for (int i = 0; i < Summe.length; i++)
            Summe[i] = 0;

        //jetzt stellen wir nur nummer3 ein, von hinter nach vorne
        int power = (int) Math.pow(10, anzahlZiffern-1);

        for (int i = 0; i < anzahlZiffern; i++) {
            Summe[i] = nummer3 / power;
            nummer3 %= power;
            power /= 10;
        }

        //fertig
        return Summe;
    }

    /***
     * <h1>Aufgabe 3.2</h1>
     * Der Algorithmus wandelt von Array in Integer um, macht die Operation(Summe, Differenz, Multiplikation, Division)
     * als Integer, wandelt dann das Ergebnis als Array um und gibt es zurück
     * @param Array1 die erste Nummer
     * @param Array2 die zweite Nummer
     * @return Diff die Differenz als int Array
     */
    static int[] ArrayDifferenz(int[] Array1, int[] Array2) {
        int kleinsteAnzahlNull = 0, aux1 = 0, aux2 = 0;

        //wir finden die erste Null in beiden arrays
        for (int i = 0; i < Array1.length; i++)
            if (Array1[Array1.length - i - 1] == 0)
                aux1++;
            else break;

        for (int i = 0; i < Array2.length; i++)
            if (Array2[Array2.length - i - 1] == 0)
                aux2++;
            else break;

        //wir brauchen die kleinste Nummer
        kleinsteAnzahlNull = Math.min(aux1, aux2);

        //von Array to int
        int nummer1 = 0, nummer2 = 0;

        for (int i = 0; i < Array1.length-kleinsteAnzahlNull; i++) {
            nummer1 *= 10;
            nummer1 += Array1[i];
        }

        for (int i = 0; i < Array2.length-kleinsteAnzahlNull; i++) {
            nummer2 *= 10;
            nummer2 += Array2[i];
        }

        // die beiden Nummern subtrahieren. Abs weil wir wollen keine negative Nummer darstellen
        int nummer3 = Math.abs(nummer1 - nummer2);


        //wir brauchen einen neuen Array, die unserer summe enthalt
        //erstmal finden wir die Anzahl von Ziffern der Summe
        int anzahlZiffern = (int) Math.log10(nummer3) + 1;

        //das neue Array hat anzahlZiffern + kleinsteAnzahlNull grosse
        int[] Diff= new int[anzahlZiffern + kleinsteAnzahlNull];

        //von int to array
        //erstmal alle null
        for (int i = 0; i < Diff.length; i++)
            Diff[i] = 0;

        //jetzt stellen wir nur nummer3 ein, von hinter nach vorne
        int power = (int) Math.pow(10, anzahlZiffern-1);

        for (int i = 0; i < anzahlZiffern; i++) {
            Diff[i] = nummer3 / power;
            nummer3 %= power;
            power /= 10;
        }

        //fertig
        return Diff;
    }

    /***
     * <h1>Aufgabe 3.3</h1>
     * Es werdet array streams verwendet
     * @param Array1 die erste Nummer
     * @param Zahl die zweite Nummer
     * @return  die Multiplikation als int Array
     */
    static int[] ArrayMultiplikation(int[] Array1, int Zahl) {
        return Arrays.stream(Array1).map(i -> i*Zahl).toArray();
    }

    /***
     * <h1>Aufgabe 3.4</h1>
     * Es werdet array streams verwendet
     * @param Array1 die erste Nummer
     * @param Zahl die zweite Nummer
     * @return die Division als int Array
     */
    static int[] ArrayDivision(int[] Array1, int Zahl) {
        return Arrays.stream(Array1).map(i -> i/Zahl).toArray();
    }

    /***
     * <h1>Aufgabe 4.1</h1>
     * Es werdet array stream werwendet
     * @param Tastatur Tastatur Array
     * @return die billigste Tastatur
     */
    static int billigTastatur(int[] Tastatur){
        return Arrays.stream(Tastatur).min().getAsInt();
    }

    /***
     * <h1>Aufgabe 4.2</h1>
     * @param Tastatur Tastatur array
     * @param USB   USB array
     * @return  die teuresten Object aus dem beiden Arrays
     */
    static int teuersteObject(int[] Tastatur, int[] USB){
        int a =  Arrays.stream(Tastatur).max().getAsInt();
        int b =  Arrays.stream(USB).max().getAsInt();
        return Math.max(a, b);
    }

    /***
     * <h1>Aufgabe 4.3</h1>
     * @param USB USB  Array
     * @param budget Markus Budget
     * @return die teursten verfugbare USB
     * @exception IllegalArgumentException ob da keine usb gibt, die kleiner oder gleich als unserer budget sind
     */
    static int teuerUndVerfugbarUSB(int[] USB, int budget){
        Arrays.sort(USB);
        if (USB[0] > budget)
            throw new IllegalArgumentException("Nu se poate gasi usb la acest buget");

        for (int i = 0; i < USB.length; i++)
            if (USB[i] > budget)
                return USB[i-1];

        return -1;   //ansonstens intelijj wird error werfen
    }

    /***
     * <h1>Aufgabe 4.4</h1>
     * Wir sortieren die zwei Arrays in ungekehrte Reihenfolge, dann summieren die grosste mogliche Paaren
     * @param USB  usb array
     * @param Tastatur  tastatur array
     * @param budget    markus budget
     * @return  das grosste Paar, die in unserer budget gefindet
     */
    static int maxGeldbetrag(int[] USB, int[] Tastatur, int budget){

        //wir sortieren die Arrays in reverse order mit Hilfe von streams
        USB = Arrays.stream(USB).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        Tastatur = Arrays.stream(Tastatur).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        //inverse order summieren, so dass wir konnen die teursten pair finden
        //es ist wichtig, dass den ersten Array (oben for) soll die groste Zahlen enthalten
        if (Tastatur[0] > USB[0])
            for (int tastatur : Tastatur)
                for (int usb : USB)
                    if (tastatur + usb <= budget)
                        return tastatur + usb;

        //ansonstens
        for (int usb : USB)
            for (int tastatur : Tastatur)
                if (tastatur + usb <= budget)
                    return tastatur + usb;

        //ob wir keine pair gefunden habe
        return -1;
    }

    public static void main(String args[]) {
        int[] Noten = {4, 8, 3, 10, 17, 60};
        int[] Array1 = {3,4,2,1};
        int[] Array2 = {1,1,1,1};
        int[] Tastatur = {15,20,10,35};
        int[] USB = {20,15,40,15};
        int[] Preise = {15,45,20};
        int[] Array3;
        int[] tastaturen = {40,50,60};
        int[] laufwerke = {8,12};

        nichtAusreichendeNoten(Noten);
        durchschnittWert(Noten);
        abgerundeteNoten(Noten);
        System.out.println("Die abgerundete Noten sind: " + abgerundeteNoten(Noten).toString());
        System.out.println(maxAbNote(Noten).toString());
        System.out.println("Die hochste Note ist: " + maxNote(Noten));
        System.out.println("Die kleinste Note ist: " + minNote(Noten));
        System.out.println("Die maximum Summe der n-1 Zahlen ist " + maxSumme(Noten));
        System.out.println("Die maximum Summe der n-1 Zahlen ist " + minSumme(Noten));

        Array3 = ArraySumme(Array1, Array2);
        for (int zahl : Array3)
            System.out.println(zahl);

        System.out.println();
        Array3 = ArrayDifferenz(Array1, Array2);
        for (int zahl : Array3)
            System.out.println(zahl);

        System.out.println();
        Array3 = ArrayMultiplikation(Array1, 2);
        for (int zahl : Array3)
            System.out.println(zahl);

        System.out.println();
        Array3 = ArrayDivision(Array1, 2);
        for (int zahl : Array3)
            System.out.println(zahl);

        System.out.println();
        System.out.println(billigTastatur(Tastatur));
        System.out.println(teuersteObject(Tastatur,USB));
        System.out.println(teuerUndVerfugbarUSB(Preise,30));
        System.out.println(maxGeldbetrag(tastaturen,laufwerke,60));
    }
}
