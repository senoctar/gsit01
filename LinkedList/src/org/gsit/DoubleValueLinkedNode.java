package org.gsit;

public final class DoubleValueLinkedNode implements ILinkedNode<Double> {

    private final double value;
    private ILinkedNode<Double> next;

    public DoubleValueLinkedNode(double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public void setNext(ILinkedNode<Double> node) {
        next = node;
    }

    @Override
    public ILinkedNode<Double> getNext() {
        return next;
    }
}
