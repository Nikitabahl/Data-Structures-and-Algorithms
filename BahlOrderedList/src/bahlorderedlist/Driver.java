/**
 * DoubleOrderedList testing area.
 * 
 * @author Nikita Bahl, Acuna
 * @version 09/12/2017
 **/
package bahlorderedlist;

public class Driver {
    public static void main(String [] args) {
        DoubleOrderedList<Integer> list = new DoubleOrderedList<>();
        DoubleOrderedList<String> listString = new DoubleOrderedList<>();
        
        //RA: These are _extremely_ simple tests - do not use them when doing
        //    your writeup.
        
        //to test removal if list is empty
        //list.remove(100);
        
        list.add(23);
       
        list.add(24);	
        list.add(16);
        list.add(3);	
        list.add(7);
        list.add(17);	
        list.add(9);	
        list.add(13);	
        list.add(14);	
        list.add(1);
        
        //Test the list size function
        //System.out.println(list.size());
        
        //Test first element of list
        //System.out.println(list.first());
        
        //Test last element of list
        //System.out.println(list.last());
        
        System.out.println(list);
        
        listString.add("Hello");
        listString.add("World");
        listString.add("Test");
        
        System.out.println(listString);
        list.remove(7);
//        list.removeFirst();
//        list.remove(17);
//        list.removeLast();
//        list.remove(14);
//        list.removeLast();

        //to test exceptions
//        list.remove(100);
//        
        System.out.println(list);
        
        /* Test Results:
            1 3 7 9 13 14 16 17 23 24 
            3 9 13 16 
        */
    }
}
