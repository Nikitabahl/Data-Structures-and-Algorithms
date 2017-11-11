/**
 * 
 * Homework 03
 * 
 * Author Nikita Bahl
 * 
 * A piece of code to make a doubly linked list and perform operations on it.
 * 
 */
package bahlorderedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class DoubleList<T> implements ListADT<T>, Iterable<T>
{
    protected int count;
    protected DoubleNode<T> head;
    
    /**
     * Creates an empty list.
     */
    public DoubleList()
    {
        count = 0;
        head = new DoubleNode();
    }    
    
    /**  
     * Removes and returns the first element from this list. 
     * 
     * @return the first element from this list
     */
    @Override
    public T removeFirst()
    {
       if (count == 0) 
       {
           throw new EmptyCollectionException("Double Ordered List");
       }
       else
       {
            DoubleNode<T> tmp = new DoubleNode(head);
            head.setNext(head.getNext());
            head.setPrev(null); 
            count--; 
            System.out.println(tmp.getElement());
            return tmp.getElement();
       }
    }

    /**  
     * Removes and returns the last element from this list. 
     *
     * @return the last element from this list
     */
    @Override
    public T removeLast()
    {
       if (count == 0) 
       {
           throw new EmptyCollectionException("Double Ordered List");
       } 
       
       else
       {
            DoubleNode<T> tmp = new DoubleNode(head);
            DoubleNode<T> last = new DoubleNode();
            while (tmp.getNext()!= null)
            {
                last = tmp;
                tmp = tmp.getNext();
            }
            
            last.getPrev().setNext(null);
       
            count--; 
            return last.getElement();
        }
    }

    /**  
     * Removes and returns the specified element from this list. 
     *
     * @param element the element to be removed from the list
     */
    
    @Override
    public T remove(T element)
    {
        if (count == 0) 
        {
           throw new EmptyCollectionException("Double Ordered List");
        } 
        else
        {      
            if ( contains(element) == true)
            {
                DoubleNode<T> tmp = new DoubleNode();
                    if (tmp.getPrev() == null)
                    {
                        //forst element in list which is being deleted
                        head = tmp.getNext();
                        
                    }
                    else if (tmp.getNext() == null)
                    {
                        //last element is being deleted from list
                        tmp.getPrev().setNext(null);
                    }
                    else
                    {
                        // element in middle of list
                        tmp.getPrev().setNext(tmp.getNext());
                        tmp.getNext().setPrev(tmp.getPrev());
                        
                    }
                count--;
                return tmp.getElement();
            }
            else
            {
                throw new ElementNotFoundException();
            }
        }
    }

    /**  
     * Returns a reference to the first element in this list. 
     *
     * @return a reference to the first element in this list
     */
    @Override
    public T first()
    {
        return head.getElement();
    }

    /**  
     * Returns a reference to the last element in this list. 
     *
     * @return a reference to the last element in this list
     */
    @Override
    public T last()
    {
        DoubleNode<T> tmp = new DoubleNode(head);
        DoubleNode<T> last = new DoubleNode();
            while (tmp.getNext()!= null)
            {
                last = tmp;
                tmp = tmp.getNext();
            }
        return tmp.getElement();
    }
    
    /**  
     * Returns true if this list contains the specified target element. 
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target)
    {
        boolean result = false;
        DoubleNode<T> tmp = new DoubleNode();
        for (tmp = head; tmp.getNext() != null; tmp = tmp.getNext()) 
            {
                if (tmp.getElement() == target)
                {
                    result = true;
                    break;
                }
                else
                {
                    result = false;
                }
            }
        return result;   
    }

    /**  
     * Returns true if this list contains no elements. 
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty()
    {
       if(head.getNext() == null && head.getPrev() == null)
       {
           return true;
       }
       else
       {
           return false;
       }
    }

    /**  
     * Returns the number of elements in this list. 
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size()
    {
        return count;
    }

    /**  
     * Returns an iterator for the elements in this list. 
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator()
    {
        return new DoubleIterator();
    }

    /**  
     * Returns a string representation of this list. 
     *
     * @return a string representation of this list
     */
    @Override
    public String toString()
    {
        DoubleNode<T> tmp = new DoubleNode();
        String result = "";
        for (tmp = head; tmp.getNext() != null; tmp = tmp.getNext()) 
            {
                result = result + tmp.getElement() + " ";
            }
        return result;
    }
    
//    @Override
//    public Iterator<T> iterator()
//    {
//        return new DoubleIterator();
//    }
    
    /**
	 * DoubleList represents an iterator for a linked list of linear nodes.
	 */
	private class DoubleIterator implements Iterator<T>
	{
		private int iteratorModCount;  // the number of elements in the collection
		private DoubleNode<T> current;  // the current position
		
		/**
		 * Sets up this iterator using the specified items.
		 *
		 * @param collection  the collection the iterator will move over
		 * @param size        the integer size of the collection
		 */
		public DoubleIterator()
		{
			current = head;
			iteratorModCount = size();
		}
		
		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		
                public boolean hasNext() throws ConcurrentModificationException
		{
			if (iteratorModCount != size()) 
				throw new ConcurrentModificationException();
			
			return (current != null);
		}
		
		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a EmptyCollectionException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws EmptyCollectionException if the iterator is empty
		 */
		
                public T next() throws ConcurrentModificationException
		{
			if (!hasNext())
				throw new EmptyCollectionException("Double Ordered List");
			
			T result = current.getElement();
			current = current.getNext();
			return result;
		}
		
		/**
		 * The remove operation is not supported.
		 * 
		 * @throws UnsupportedOperationException if the remove operation is called
		 */
		
                public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}
	
}


