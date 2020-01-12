package org.gsit;

public class DefaultLinkedList<E> implements ILinkedList<E> {

    private ILinkedNode<E> first;
    private ILinkedNode<E> last;

    @Override
    public void insert(ILinkedNode<E> node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
    }

    @Override
    public void println() {
        ILinkedNode it = first;
        while (it != null) {
            System.out.println(it.getValue());
            it = it.getNext();
        }
    }
}
