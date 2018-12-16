package javafoundations;
/********************************************************************
 *  ArrayStack.java       Java Foundations
 *
 *  Represents an array implementation of a stack. The bottom of
 *  the stack is kept at array index 0.
********************************************************************/
import java.util.*;
public class ArrayStack<T> implements Stack<T> {
  private final int DEFAULT_CAPACITY = 10;
  private int count;
  private T[] array;
  
  /**
   *    Creates an empty stack using the default capacity.
   */
  public ArrayStack() {
    count = 0;
    array = (T[])(new Object[DEFAULT_CAPACITY]); 
  }
  
  /**
   *  Adds the specified element to the top of this stack, expanding
   *  the capacity of the stack array if necessary.
   */
  public void push (T element) {
    if (count == array.length)
      expandCapacity();
    
    array[count] = element;
    count++;
  }
  
  /**
   *  Returns a string representation of this stack.
   */
  public String toString() {
    //String result = "<top of stack>\n";
    String result ="";
    for (int index=count-1; index >= 0; index--)
      result += array[index] + " \n";
    //result += "<bottom of stack>\n";
    return result;
  }
  
  /**
   *  Helper method. 
   *  Creates a new array to store the contents of this stack with
   *  twice the capacity of the old one.
   */
  private void expandCapacity() {
    T[] larger = (T[])(new Object[array.length*2]);
    
    for (int index=0; index < array.length; index++)
      larger[index] = array[index];
    
    array = larger;
  }
  
  /**
   *  Removes the element at the top of this stack and returns a
   *  reference to it. Throws an EmptyCollectionException if the
   *  stack contains no elements.
   */
  public T pop () throws EmptyStackException {
    if(count == 0)
      throw new EmptyStackException();
    
    T temp = array[count - 1];
    count--;
    return temp;
  }
  
 //implement the rest of the methods as needed.
  public T peek() throws EmptyStackException {
      if(count == 0) {
          throw new EmptyStackException();
        }
        return array[count-1];
    }
  public boolean isEmpty() {
      if (count ==0) {
          return true;
      } return false;
  }
  public int size() {
      return count;
    }
 
  public static void main(String[] args) {
    //System.out.println("hello");
    ArrayStack<String> a = new ArrayStack<String>();
    a.push("cs230");
    a.push("is");
    a.push("so");
    a.push("awesome");
    System.out.println("The stack: \n" + a);
    System.out.println("poping from the stack:");
    while (!a.isEmpty()) {
       System.out.println(a.pop());
    }

  }
}