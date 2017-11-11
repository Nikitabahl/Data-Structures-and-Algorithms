package bahlpqstack;

import java.util.NoSuchElementException;

/**
 * (description)
 * 
 * @author Nikita Bahl, Acuna
 * @verison 10/31/2017
 */
public class BahlPQStack<Item> implements Stack<Item> {
         
    
    public MaxPQ PriorityQueueStack;
    private int Counter;
    /**
     * Add an item.
     * @param item an item
     */
    
    public BahlPQStack()
    {
        PriorityQueueStack = new MaxPQ();
        Counter=0;
    }
    
    public void push(Item item)
    {
        PriorityQueueStack.insert((Comparable)item);
        Counter++;
    }
    
    /**
     * Remove the most recently added item.
     * @return an item
     */
    public Item pop() throws NoSuchElementException
    {
            Item x = (Item)PriorityQueueStack.delMax();
            Counter--;

            if (Counter == 1)
                return x;
            else
                return peek();
    }
    
    /**
     * Return, but do not remove, the most recently added item.
     * @return an item
     */
    public Item peek() throws NoSuchElementException
    {
        return (Item)PriorityQueueStack.max();
    }
    
    /**
     * Is the queue empty?
     * @return if empty
     */
    public boolean isEmpty()
    {
        return PriorityQueueStack.isEmpty();
    }
    
    /**
     * Number of items in the queue.
     * @return number of items
     */
    public int size()
    {
        return PriorityQueueStack.size();
    }
    
    /**
     * entry point for sample output..
     * @param args 
     */
    public static void main(String[] args) {
        Stack<Integer> S = new BahlPQStack<Integer>();
        
        S.push(new Integer(2));
        S.push(new Integer(7));
        Integer W = S.pop();
        S.push(new Integer(8));
        S.push(new Integer(5));
        Integer X = S.pop();
        Integer Y = S.peek();
        S.push(new Integer(3));
        Integer Z = S.pop();
        
        System.out.println("Testing: ");
        System.out.println(W);
        System.out.println(X);
        System.out.println(Y);
        System.out.println(Z);
        
    }
}