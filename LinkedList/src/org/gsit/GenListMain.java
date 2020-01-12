package org.gsit;

public class GenListMain {

    public static void main(String[] args) {
        listWithDoubles();
    }

    private static void listWithIntegers() {
        ILinkedNode<Integer> num1 = new DefaultLinkedNode<>(6);
        ILinkedNode<Integer> num2 = new DefaultLinkedNode<>(2);
        ILinkedNode<Integer> num3 = new DefaultLinkedNode<>(8);
        ILinkedNode<String> str1 = null;

        ILinkedList<Integer> numList = new DefaultLinkedList<>();
        numList.insert(num1);
        numList.insert(num2);
        numList.insert(num3);

        numList.println();
    }

    private static void listWithDoubles() {
        ILinkedNode<Double> num1 = new DoubleValueLinkedNode(6);
        ILinkedNode<Double> num2 = new DoubleValueLinkedNode(2);
        ILinkedNode<Double> num3 = DefaultLinkedNode.ofValue(8d);
        ILinkedNode<Double> num4 = new DefaultLinkedNode<>(7d);

        ILinkedList<Double> numList = new DefaultLinkedList<>();
        numList.insert(num1);
        numList.insert(num2);
        numList.insert(num3);
        numList.insert(num4);

        numList.println();
    }
}
