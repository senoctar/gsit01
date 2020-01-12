package org.gsit;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class MainFunctional {

    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("a", "b", "c");
//        String result = strings.stream()
//                .filter(s -> s.compareTo("b") >= 0)
//                .map(s -> "u" + s.toUpperCase())
//                .collect(Collectors.joining(", "));

        List<String> words = Arrays.asList(
                "drum", "building", "bodacious", "transient");
        System.out.println(firstLetterWithExplicitBuilder(words));
        System.out.println(firstLetterWithCollector(words));

        removeOdd(words);
        printMap(words);

        groupWordsByLength(words);
        groupWordsByLengthToMap(words);
        groupWordsByLengthWithComma(words);
    }

    private static void groupWordsByLength(List<String> words) {
        Map<Integer, List<String>> wordsByLength =
                words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(wordsByLength);
    }

    private static void groupWordsByLengthWithComma(List<String> words) {
        Map<Integer, String> wordsByLength = words.stream().collect(Collectors
                        .groupingBy(String::length, Collectors.joining(", ")));
        System.out.println(wordsByLength);
    }

    private static void groupWordsByLengthToMap(List<String> words) {
        Map<Integer, String> wordsByLength = words.stream()
                .collect(Collectors.toMap(
                        String::length, identity(), (v1, v2) -> v1 + ", " + v2));
        System.out.println(wordsByLength);
    }

    private static void removeOdd(List<String> words) {
        ArrayList<String> w1 = new ArrayList<>(words);
        removeOddIterative(w1);
        System.out.println(w1);

        ArrayList<String> w2 = new ArrayList<>(words);
        removeOddStream(w2);
        System.out.println(w2);

        ArrayList<String> w3 = new ArrayList<>(words);
        removeOddCollection(w3);
        System.out.println(w3);
    }

    private static void printMap(List<String> words) {
        Map<String, Integer> map = words.stream()
                .collect(Collectors.toMap(identity(), String::length));
        System.out.println(map);

        String mapString = map.entrySet().stream()
                .map(e -> String.format("%15s %d", e.getKey(), e.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(mapString);
    }

    private static void removeOddStream(ArrayList<String> words) {
        List<String> oddWords = words.stream()
                .filter(s -> s.length() % 2 == 1)
                .collect(Collectors.toList());
        words.removeAll(oddWords);
    }

    private static void removeOddIterative(List<String> words) {
        for (ListIterator<String> iterator = words.listIterator(); iterator.hasNext(); ) {
            String w = iterator.next();
            if (w.length() % 2 == 1) {
                iterator.remove();
            }
        }
    }

    private static void removeOddCollection(List<String> words) {
        words.removeIf(w -> w.length() % 2 == 1);
    }

    private static String firstLetterWithExplicitBuilder(List<String> words) {
        StringBuilder sb = new StringBuilder();
        words.stream()
                .map(s -> s.charAt(0))
                .forEach(sb::append);
        return sb.toString();
    }

    private static String firstLetterWithCollector(List<String> words) {
        return words.stream()
                .map(s -> s.substring(0, 1))
                .collect(Collectors.joining());
    }
}
