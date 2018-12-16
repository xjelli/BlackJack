package javafoundations;
//********************************************************************
//  ArrayQueue.java       Java Foundations
//
//  Represents an array implementation of a queue. The front of
//  the queue is kept at array index 0.
//********************************************************************

import javafoundations.exceptions.*;

public class ArrayQueue<T> implements Queue<T>
{
    private final int DEFAULT_CAPACITY = 10;
    private int count;
    private T[] queue;

    //-----------------------------------------------------------------
    //  Creates an empty queue using the default capacity.
    //-----------------------------------------------------------------
    public ArrayQueue()
    {
        count = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    //-----------------------------------------------------------------
    //  Removes the element at the front of this queue and returns a
    //  reference to it. Throws an EmptyCollectionException if the
    //  queue is empty.
    //-----------------------------------------------------------------
    public T dequeue() throws EmptyCollectionException
    {
        if (count == 0)
            throw new EmptyCollectionException ("Dequeue operation failed. "
                + "The queue is empty.");

        T result = queue[0];

        count--;

        // shift the elements to keep the front element at index 0
        for (int index=0; index < count; index++)
            queue[index] = queue[index+1];

        queue[count] = null;

        return result;
    }

    //-----------------------------------------------------------------
    //  The following methods are left as Programming Projects.
    //-----------------------------------------------------------------
    public void enqueue (T element) {
        if(count == queue.length) {
            expand();
        }
        queue[count] = element;
        count++;
    }

    public void expand() {
        T[] large = (T[])(new Object[count*2]);
        for(int i = 0; i < queue.length; i++) {
            large[i] = queue[i];
        }
        queue = large;
    }

    public T first () throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("Cannot get first. Q is empty.");
        } else {
            return queue[0];
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        String result = "Beginning of Q:\n";
        for(int i = 0; i < count; i++) {
            result += queue[i].toString() + " ";
        }
        result += "\nEnd of Q";
        return result;
    }
}