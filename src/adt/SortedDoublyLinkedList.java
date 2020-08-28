package adt;

import java.util.Iterator;

public class SortedDoublyLinkedList<T extends Comparable<T>> implements SortedDoublyLinkedListInterface<T> {

    private Node firstNode;

    public SortedDoublyLinkedList() {
        this.firstNode = null;
    }

    @Override
    //sorting the list by decending order
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        Node previousNode = firstNode;
        Node currentNode = firstNode;

        while (currentNode != null && newEntry.compareTo(currentNode.data) < 0) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        //if the list is empty
        if (firstNode == null) {
            firstNode = newNode;
            firstNode.next = null;
            firstNode.previous = null;
        } //if the node is added in the front of the list
        else if (currentNode == firstNode) {
            newNode.next = firstNode;
            newNode.previous = null;
            firstNode.previous = newNode;
            firstNode = newNode;
        } //add the node at the behind of the list
        else if (firstNode != null && currentNode == null) {
            newNode.previous = previousNode;
            newNode.next = null;
            previousNode.next = newNode;
        } //add the node in the middle of the list
        else {
            newNode.next = currentNode;
            newNode.previous = currentNode.previous;
            currentNode.previous.next = newNode;
            currentNode.previous = newNode;
        }

        return true;

    }

    @Override
    public boolean remove(T currentEntry) {
        Node currentNode = firstNode;
        //first, check if the list contain the currentEntry
        if (!isEmpty() && contains(currentEntry)) {
            //find that particular entry within the list
            while (!currentEntry.equals(currentNode.data) && currentNode.next != null) {
                currentNode = currentNode.next;
            }
            //remove if it is the firstNode
            if (currentNode == firstNode) {
                firstNode = firstNode.next;
                firstNode.previous = null;
            } //remove if it is the lastNode
            else if (currentNode.next == null) {
                currentNode.previous.next = null;
            } //remove if the node is in the middle of the list
            else {
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
            }
            return true;
        } //else, return remove unsuccessfully
        else {
            return false;
        }
    }

    @Override
    public boolean contains(T anEntry) {
        return search(firstNode, anEntry);
    }

    @Override
    public void clear() {
        firstNode = null;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    //using recursive method to search the particular node.
    private boolean search(Node currentNode, T anEntry) {

        if (currentNode == null) {
            return false;
        } else if (anEntry.equals(currentNode.data)) {
            return true;
        } else {
            return search(currentNode.next, anEntry);
        }
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public T getNth(int position) {
        Node currentNode = firstNode;
        int count = 0;

        while (!isEmpty() || currentNode.next != null) {
            if (count == position) {
                return currentNode.data;
            }
            count++;
            currentNode = currentNode.next;
        }
        assert (false);
        return null;
    }

    public String toString() {
        String output = "";
        int rank = 1;
        Node currentNode = firstNode;
        while (currentNode != null) {
            output += String.format("%d    %s", rank, currentNode.data);

            currentNode = currentNode.next;
            rank++;
        }
        return output;
    }

    @Override
    public Iterator<T> getIterator() {
        return new SortedLListIterator();
    }

    private class SortedLListIterator implements Iterator<T> {

        Node currentNode = firstNode;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T currentEntry = null;
            if (hasNext()) {
                currentEntry = currentNode.data;
                currentNode = currentNode.next;
            }
            return currentEntry;
        }
    }

    private class Node {

        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

}
