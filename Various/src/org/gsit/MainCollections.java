package org.gsit;

import java.util.*;

public class MainCollections {

    public static void main(String[] args) {
        System.out.println(pascalReplaceIterator(5));
    }

    private static List<Integer> pascalCopy(int n) {
        List<Integer> list = Collections.singletonList(1);

        for (int p=1; p<n; ++p) {
            List<Integer> next = new ArrayList<>(list.size() + 1);
            next.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                next.add(list.get(i) + list.get(i-1));
            }
            next.add(list.get(list.size()-1));
            list = next;
        }

        return list;
    }

    private static List<Integer> pascalReplaceIterator(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int p=1; p<n; ++p) {
            ListIterator<Integer> it = list.listIterator();
            Integer prev = it.next();
            while (it.hasNext()) {
                Integer el = it.next();
                it.set(el + prev);
                prev = el;
            }
            it.add(1);
        }

        return list;
    }

    private static List<Integer> pascalReplace(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int p=1; p<n; ++p) {
            Integer prev = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                int element = list.get(i) + prev;
                prev = list.set(i, element);
            }
            list.add(1);
        }

        return list;
    }

    private static void lerders() {
        List<Integer> integers =
                Arrays.asList(3, 8, 5, 15, 11, 17, 4, 18, 14, 12, 19, 1, 7);
        Collections.reverse(integers);

        Integer max = null;
        for (Integer i : integers) {
            if (max == null || i > max) {
                max = i;
                System.out.println("Leader: " + max);
            }
        }
    }
}
