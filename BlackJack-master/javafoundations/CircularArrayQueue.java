//********************************************************************
//  CircularArrayQueue.java       Java Foundations
//
//  Represents an array implementation of a queue in which neither
//  end of the queue is fixed in the array. The variables storing the
//  indexes of the front and rear of the queue continually increment
//  as elements are removed and added, cycling back to 0 when they
//  reach the end of the array.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class CircularArrayQueue<T> implements Queue<T>
{
    private final int DEFAULT_CAPACITY = 3;
    private int front, rear, count;
    private T[] queue;

    //-----------------------------------------------------------------
    //  Creates an empty queue using the default capacity.
    //-----------------------------------------------------------------
    public CircularArrayQueue()
    {
        front = rear = count = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    //-----------------------------------------------------------------
    //  Adds the specified element to the rear of this queue, expanding
    //  the capacity of the queue array if necessary.
    //-----------------------------------------------------------------
    public void enqueue (T element)
    {
        if (count == queue.length)
            expandCapacity();

        queue[rear] = element;
        rear = (rear+1) % queue.length;
        count++;
    }

    //-----------------------------------------------------------------
    //  Creates a new array to store the contents of this queue with
    //  twice the capacity of the old one.
    //-----------------------------------------------------------------
    public void expandCapacity()
    {
        T[] larger = (T[])(new Object[queue.length*2]);

        for (int index=0; index < count; index++)
            larger[index] = queue[(front+index) % queue.length];

        front = 0;
        rear = count;
        queue = larger;
    }

    //-----------------------------------------------------------------
    //  The following methods are left as Programming Projects.
    //-----------------------------------------------------------------
    public T dequeue () throws EmptyCollectionException {
        if(count == 0) {
            throw new EmptyCollectionException("DeQ failed. Q is empty.");
        }
        T temp = queue[front];
        front++;
        count--;
        return temp;
    }

    public T first () throws EmptyCollectionException {
        if(count == 0) {
            throw new EmptyCollectionException("Cannot get first. Q is empty.");
        }
        return queue[front];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        String result = "Beginning of Q:\n";
        for(int i = front; i < front+count; i++) {
            result += queue[i] + " ";
        }
        result += "\nEnd of Q";
        return result;
    }

  
}
