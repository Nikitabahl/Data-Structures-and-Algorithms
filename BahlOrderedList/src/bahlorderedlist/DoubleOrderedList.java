/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bahlorderedlist;

/**
 *
 * @author Nikita Bahl
 */
public class DoubleOrderedList<T> extends DoubleList<T> implements OrderedListADT<T> {
    
    public DoubleList<T> orderedListElement;
    
    public DoubleOrderedList()
    {
        orderedListElement = new DoubleList();
    }
    
    @Override
    public void add(T element)
    {
        if (count == 0)
        {
            //list is empty, so add first element
            //orderedListElement.head.setElement(element);
            DoubleNode<T> temp = new DoubleNode(element);
            temp.setNext(head);
            head = temp;
            count++;
            //System.out.println(head.getElement());
        }
        else
        {
            
            if (element.toString().compareTo(head.getElement().toString()) <= 0 )
            //if (element.toString().equals(head.getElement().toString()) <=0)
            {
            // insert before head, make new head
            DoubleNode<T> newNode = new DoubleNode();
            head.setPrev(newNode);
            head = newNode;
            count++;
            System.out.println(head.getElement());
            }
            else
            {
                //add in middle of list
                DoubleNode current = head.getNext();
                while (current != null)
                {
                    if (element.toString().compareTo(head.getElement().toString()) > 0 )
                    {
//                        DoubleNode newNode = new DoubleNode(element);
//                        newNode.getPrev().setNext(newNode);
//                        current.setPrev(newNode);
//                        count++;
//                        System.out.println(head.getElement());
                        DoubleNode newNode = new DoubleNode(element);
                //DoubleNode lastElement = new DoubleNode();
                //lastElement.setNext(newNode);
                head.setNext(newNode);
                count++;
                System.out.println(head.getElement());
                        
                    }
                    current = current.getNext();
                }

                // add to end of list
//                DoubleNode newNode = new DoubleNode(element);
//                DoubleNode lastElement = new DoubleNode();
//                lastElement.setNext(newNode);
//                count++;
//                System.out.println(head.getElement());
        }
        }
        
    }
    
}
