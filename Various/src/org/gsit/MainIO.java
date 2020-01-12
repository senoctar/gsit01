package org.gsit;

import sun.applet.Main;

import java.io.*;

public class MainIO {

    public static void main(String[] args) throws IOException {
        String line;
        int width = 4;
        int height = 2;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(MainIO.class.getResourceAsStream("/input.txt")))) {
            while ((line = r.readLine()) != null) {
                printFixedHeight(line, width, 0);
                printVariableHeight(line, width, height, 3);
                printFixedHeight(line, width, 3);
                printVariableHeight(line, width, height, 6);
                printFixedHeight(line, width, 6);
            }
        }
    }

    private static void printFixedHeight(String line, int width, int i) {
        for (char ch : line.toCharArray()) {
            String number = getNumber(ch);
            System.out.print(number.charAt(i));
            printTimes(number.charAt(i + 1), width);
            System.out.print(number.charAt(i + 2));
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void printVariableHeight(String line, int width, int height, int index1) {
        for (int i = 0; i < height; i++) {
            for (char ch : line.toCharArray()) {
                String number = getNumber(ch);
                System.out.print(number.charAt(index1));
                printTimes(' ', width);
                System.out.print(number.charAt(index1 + 2));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void printTimes(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
        }
    }

    private static String getNumber(int ch) {
        switch (ch) {
            case '1':
                return "     |  |";
            case '2':
                return " _  _||_ ";
            default:
                throw new IllegalArgumentException("Unknown character: " + ch);
        }
    }
}
