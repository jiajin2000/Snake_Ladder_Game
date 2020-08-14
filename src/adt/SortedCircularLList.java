/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author User
 */
public class SortedCircularLList<T extends Comparable<T>> implements SortedCircularLListInterface<T> {
    private Node lastNode;

    public SortedCircularLList() {
        this.lastNode = null;
    }
    
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        
        Node currentNode = lastNode;
        
        //check if the newEntry already existed in the list.
        if(contains(newEntry)){
            remove(newEntry);
        }
        
        do{
            currentNode = currentNode.next;
        }while(currentNode != null && newEntry.compareTo(currentNode.data) > 0);
        
        if(isEmpty()){
            lastNode = newNode;
            lastNode.next = lastNode;
        }else{
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        
        return true;
    }

    @Override
    public boolean remove(T currentEntry) {
        Node currentNode = lastNode;
        Node firstNode = lastNode.next;
        //chech if the entire list contains that particular currentEntry
        if(contains(currentEntry)){
            //find the target Node
            while(currentEntry.compareTo(currentNode.data)!= 0){
                currentNode = currentNode.next;
            }
            //after get the target Node, we check is that the last Node of the list
            if(currentNode == lastNode){
                Node tempNode = lastNode;
                while(tempNode.next!=lastNode){
                    tempNode = tempNode.next;
                }
                if(tempNode.next == tempNode){
                    lastNode = null;
                }
                tempNode.next = lastNode.next;
                lastNode = tempNode;
            }
            //check if the target Node is the first Node
            else if(currentNode == firstNode){
                lastNode.next = currentNode.next;
            }
            //else remove the middle node of the list
            else{
                if(currentNode == firstNode.next){
                    firstNode.next = currentNode.next;
                }else{
                    firstNode.next.next = currentNode.next;    
                }
                lastNode.next = firstNode;
            }
        }
        return false;
    }
    
    @Override
    public boolean contains(T anEntry){
        Node currentNode = null;
        return search(currentNode,anEntry);
    }

    @Override
    public void clear() {
        lastNode = null;
    }

    @Override
    public boolean isEmpty() {
        return lastNode == null;
    }
    
    //Using recursive method to search.
    public boolean search(Node currentNode,T anEntry){
        currentNode = lastNode;
        
        if(currentNode.next != lastNode ){
            if(anEntry.compareTo(currentNode.data)==0){
                return true;
            }
            else{
            search(currentNode.next,anEntry);
            }
        }
        
            return false;
    }

    @Override
    public Iterator<T> getIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class Node{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
        
        
    }
    
}
