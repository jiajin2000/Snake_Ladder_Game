/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Jimmy Ong Jun Ming
 */
public interface CircularArrQueueInterface<T> {
    
    public void enqueue(T newEntry);

    public T dequeue();
    
    public T getFront();

    public boolean isEmpty();
    
    public void clear();
    
}
