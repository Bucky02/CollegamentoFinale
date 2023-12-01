package com.example.collegamentofinale;

public class PunteggioManager {
    private static int punt1 = 0;
    private static int punt2 = 0;

    public static int getPunt1() {
        return punt1;
    }

    public static int getPunt2() {
        return punt2;
    }

    public static void setPunt1( int i) {
        punt1 = i;
    }

    public static void setPunt2(int i) {
        punt2 = i;
    }

    public static void incrementPunt1() {
        punt1++;
    }

    public static void incrementPunt2() {
        punt2++;
    }
}

