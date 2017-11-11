/**
 * 
 * Homework 03
 * 
 * Author Nikita Bahl
 * 
 * A piece of code to store the node values and provide a getter and setter for the same
 * 
 */

package bahlorderedlist;

public class DoubleNode<T> {
    private DoubleNode<T> next ;
    private DoubleNode<T> prev ;
    private T element ;
    
    public DoubleNode ( ) 
    {
        next = null ;
        prev = null;
        element = null ;
    }
    public DoubleNode (T elem ) 
    {
        next = null ;
        prev = null;
        element = elem ;
    }
    public DoubleNode<T> getNext ( ) 
    {
        return next ;
    }
    public DoubleNode<T> getPrev ( ) 
    {
        return prev ;
    }
    
    public void setNext ( DoubleNode<T> node ) 
    {
        next = node ;
    }
    
    public void setPrev ( DoubleNode<T> node ) 
    {
        prev = node ;
    }
    
    public T getElement ( ) 
    {
        return element ;
    }
    
    public void setElement (T elem ) 
    {
        element = elem ;
    }
}

