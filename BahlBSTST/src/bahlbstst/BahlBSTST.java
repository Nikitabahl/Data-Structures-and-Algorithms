package bahlbstst;
/**
 * A binary search tree based implementation of a symbol table.
 * 
 * @author Nikita Bahl, Sedgewick and Wayne, Acuna
 * @version 11/10/2017
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
        
public class BahlBSTST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private Node root;

    private class Node
    {
        private final Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key; this.val = val; this.N = N;
        }
    }
    
    @Override
    public int size() {
        return size(root);
    }
    
    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }
    
    @Override
    public Value get(Key key) {
        return get(root, key);
    }
    
//    private Value get(Node x, Key key) {
//        // Return value associated with key in the subtree rooted at x;
//        // return null if key not present in subtree rooted at x.
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0) return get(x.left, key);
//        else if (cmp > 0) return get(x.right, key);
//        else return x.val;
//    }
    
    private Value get(Node x, Key key) {
        // Return value associated with key in the subtree rooted at x;
        // return null if key not present in subtree rooted at x.
        for (Node t = root; t!= null ; x = x.left)
        {
            if (key.equals(x.key))
                return x.val;
        }
        for (Node t = root; t!= null ; x = x.right)
        {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }
      
    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }
    
        private Node put(Node x, Key key, Value val) {
        // Change key’s value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
        
    
//    private Node put(Node x, Key key, Value val) 
//    {
//        Node z = new Node(key, val, 1);
//        z.N = z.N+1;
//        if (x == null) 
//        {
//            root = z;
//            return z;
//        }
//        Node parent = null, y = x;
//        while (y != null) 
//        {
//            parent = y;
//            int res = key.compareTo(y.key);
//            if      (res < 0) y = y.left;
//            else if (res > 0) y = y.right;
//            else 
//            {
//                y.val = val;
//                //return y;
//            }  
//            return y;
//        }
//        int res = key.compareTo(parent.key);
//        if (res < 0) { parent.left  = z; return z;}
//        else         { parent.right = z; return z;}
//    }
//        
    @Override
    public Key min() 
    {
      return min(root).key;
    }
    
    private Node min(Node x) 
    {
        if (x.left == null)
            return x;
        return min(x.left);
    }
    
    @Override
    public Key max() 
    {
      return max(root).key;
    }
    
    private Node max(Node x) 
    {
        if (x.right == null) return x;
        return max(x.right);
    }
    
    @Override
    public Key floor(Key key) 
    {
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }
    
    private Node floor(Node x, Key key) 
    {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }
    
    @Override
    public Key select(int k) {
        return select(root, k).key;
    }
    
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else return x;
    }
    
    @Override
    public int rank(Key key) {
        return rank(key, root);
    }
    
    private int rank(Key key, Node x) {
        // Return number of keys less than x.key in the subtree rooted at x.
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }
    
    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }
    
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }
    
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else
        {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
    
    @Override
    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }
    
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
    {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
    
    @Override
    public boolean contains(Key key) {
        if (key == null)
            throw new UnsupportedOperationException("Not supported yet.");
        return get(key)!=null;
    }

    @Override
    public boolean isEmpty() {
        if (root == null)
            throw new UnsupportedOperationException("Not supported yet.");
        return size() == 0;         
    }

    @Override
    public Key ceiling(Key key) {
        if (key == null)
            throw new UnsupportedOperationException("Not supported yet.");
        Node x = ceiling(root, key);
        if (x == null)
            return null;
        return x.key;
    }
    
    private Node ceiling(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.right, key);
        Node t = floor(x.left, key);
        if (t != null) return t;
        else return x;
    }
    
    @Override
    public void deleteMax() {
        root = deleteMax(root);
        if(isEmpty() || root == null)
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    @Override
    public int size(Key lo, Key hi) 
    {    
        if (lo == null || hi == null)
            throw new UnsupportedOperationException("Not supported yet.");
        if (hi.compareTo(lo) <0)
            return 0;
        else if (contains(hi))
            return rank(hi)-rank(lo)+1;
        else
            return rank(hi)-rank(lo);
    }
    
    public void balance() 
    {
        if(isEmpty())
            throw new UnsupportedOperationException("Not supported yet.");
        ArrayList<Node> Data = new ArrayList<Node>();
        bstToList(root, Data);
        this.root = listToTree(Data, 0, size()-1);
    }
   
    void bstToList(Node root, ArrayList<Node> Data) 
    {
        if (root == null)
            return;
 
        bstToList(root.left, Data);
        Data.add(root);
        bstToList(root.right,Data);
    }
 
    Node listToTree(ArrayList<Node> Data, int start, int end) 
    {
        if (start > end)
            return null;
 
        int mid = ((start + end+1) / 2);
        Node node = Data.get(mid);
        
        node.left = listToTree(Data, start, mid - 1);
        node.right = listToTree(Data, mid +1, end);
        return node;
    }
    
    public void printLevel(Key key) 
    {
        Node current=root;  
            //finding place of key
            if (key.compareTo(root.key) < 0)
            {
                while (current!=null)
                {
                    if (current.key == key)
                    {
                        print(current);
                        break;
                    } 
                    else
                        current=current.left;
                }
            }
            else
            {   
                while (current!= null)
                {
                    if (current.key == key)
                    {
                        print(current);
                        break;
                    }
                    else
                        current=current.right;
                }
            }  
    }
    
    //helper method to print subtree for a given node
    private void print(Node x)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(x);
        while (!queue.isEmpty())
        {
            Node temp = queue.poll();
            System.out.println(temp.val);
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }
    }
    
    /**
     * entry point for testing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BahlBSTST<Integer, String> bst = new BahlBSTST();
        
        bst.put(10, "TEN");
        bst.put(3, "THREE");
        bst.put(1, "ONE");
        bst.put(5, "FIVE");
        bst.put(2, "TWO");
        bst.put(7, "SEVEN");
        
        System.out.println("Before balance:");
        bst.printLevel(10); //root
        System.out.println("After balance:");
        bst.balance();
        bst.printLevel(5); //root
    }
}