package org.gsit;

public class DefaultLinkedNode<T> implements ILinkedNode<T> {

    private final T value;
    private ILinkedNode<T> next;

    public DefaultLinkedNode(T value) {
        this.value = value;
    }

    public static <FT> ILinkedNode<FT> ofValue(FT value) {
        if (value instanceof Double) {
            @SuppressWarnings("unchecked")
            ILinkedNode<FT> result = (ILinkedNode<FT>) new DoubleValueLinkedNode((Double) value);
            return result;
        }
        return new DefaultLinkedNode<>(value);
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public void setNext(ILinkedNode<T> node) {
        next = node;
    }

    @Override
    public ILinkedNode<T> getNext() {
        return next;
    }
}
