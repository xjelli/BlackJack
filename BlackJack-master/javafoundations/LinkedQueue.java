//********************************************************************
//  LinkedQueue.java       Java Foundations
//
//  Represents a linked implementation of a queue.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class LinkedQueue<T> implements Queue<T>
{
    private int count;
    private LinearNode<T> front, rear;

    //-----------------------------------------------------------------
    //  Creates an empty queue.
    //-----------------------------------------------------------------
    public LinkedQueue()
    {
        count = 0;
        front = rear = null;
    }

    //-----------------------------------------------------------------
    //  Adds the specified element to the rear of this queue.
    //-----------------------------------------------------------------
    public void enqueue (T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);

        if (count == 0)
            front = node;
        else
            rear.setNext(node);

        rear = node;
        count++;
    }

    //-----------------------------------------------------------------
    //  The following methods are left as Programming Projects.
    //-----------------------------------------------------------------

    public T dequeue () throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("DeQ failed. Q is empty.");
        } else {
            T temp = front.getElement();
            front = front.getNext();
            count--;
            return temp;
        }
    }

    public T first () throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("Cannot get first. Q is empty.");
        } else {
            return front.getElement();
        }   
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        String result = "Beginning of Q:\n";
        LinearNode<T> pointer = front;
        for(int i = 0; i < count; i++) {
            result += pointer.getElement().toString() + " ";
            pointer = pointer.getNext();
        }
        result += "\nEnd of Q";
        return result;
    }
}