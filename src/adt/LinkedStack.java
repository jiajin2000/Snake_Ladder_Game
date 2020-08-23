package adt;

public class LinkedStack<T> implements LinkedStackInterface<T> {

    private class Node<T> {

        T item;
        Node<T> next;

        private Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        private Node() {
            item = null;
            next = null;
        }
    }
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(T element) {
        Node<T> newNode = new Node(element, top);
        this.top = newNode;
        size++;
    }

    public T pop() {
        if (this.top == null) {
            System.out.print("Stack is empty");
        }
        T returnElement = this.top.item;
        this.top = top.next;
        size--;
        return returnElement;
    }

    public T peek() {
        if (this.top == null) {
            System.out.print("Stack is empty");
        }
        T returnElement = this.top.item;
        return returnElement;
    }

    public int size() {
        return this.size;
    }

}
