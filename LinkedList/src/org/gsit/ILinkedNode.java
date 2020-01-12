package org.gsit;

public interface ILinkedNode<E> {

    E getValue();
    boolean hasNext();
    void setNext(ILinkedNode<E> node);
    ILinkedNode<E> getNext();
}
