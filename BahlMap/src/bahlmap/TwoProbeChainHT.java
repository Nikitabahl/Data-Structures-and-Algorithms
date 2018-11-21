package bahlmap;

import java.util.LinkedList;
import java.util.Queue;

public class TwoProbeChainHT<Key, Value> implements SymbolTable<Key, Value>
{
    private class Entry
    {
        private Key key;
        private Value val;
        
        public Entry(Key k, Value v)
        {
            this.key = k;
            this.val = v;
        }
    }
    
    private int M; 
    private int N;
    private LinkedList<Entry>[] entries;
    
    public TwoProbeChainHT()
    {
        this(997);
    }
    
    public TwoProbeChainHT(int M)
    {
        this.M = M;
        this.N = 0;
        entries = new LinkedList[M];
        for (int i = 0; i < M; i++)
        {
            entries[i] = new LinkedList<>();
        }
    }
    
    private int hash (Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    private int hash2 (Key key)
    {
        return (((key.hashCode() & 0x7ffffff) % M) * 31) % M;
    }
    
    @Override
    public void put(Key key, Value val)
    {
        int index1 = hash(key);
        int index2 = hash2(key);
        
        for (Entry e : entries[index1])
            {
                if (key.hashCode() == e.key.hashCode()) 
                {
                    e.val = val;
                    //System.out.println(e.val);
                    return;
                }
            }
        
        for (Entry e : entries[index2])
            {
                if (key.hashCode() == e.key.hashCode()) 
                {
                    e.val = val;
                    //System.out.println(e.val);
                    return;
                }
            }
        
        if (entries[index1].size() < entries[index2].size())
        {
            Entry temp = new Entry(key, val);
            entries[index1].addLast(temp);
            //System.out.println(temp.val);
            this.N++;
        }
        else
        {
            Entry temp = new Entry(key, val);
            this.N++;
            entries[index2].addLast(temp);
            //System.out.println(temp.val);
        }   
    }
    
    @Override
    public Value get(Key key)
    {
        int index1 = hash(key);
        int index2 = hash2(key);
        
        for (Entry e : entries[index1])
        {
            if (key.hashCode() == e.key.hashCode()) 
            {
                //System.out.println(e.val);
                return e.val;
            }
        }
        
        for (Entry e : entries[index2])
        {
            if (key.hashCode() == e.key.hashCode()) 
            {
                //System.out.println(e.val);
                return e.val;
            }
        }
        return null;
    }
    
    @Override
    public void delete(Key key)
    {
        if (key == null) throw new UnsupportedOperationException();
        
        int index1 = hash(key);
        int index2 = hash2(key);
        
        for (Entry e : entries[index1])
        {
            if (key.hashCode() == e.key.hashCode()) 
            {
                entries[index1].removeFirstOccurrence(e);
                this.N--;
                //System.out.println(e.val);
                return;
            }
        }
        
        for (Entry e : entries[index2])
        {
            if (key.hashCode() == e.key.hashCode()) 
            {
                entries[index2].removeFirstOccurrence(e);
                this.N--;
                //System.out.println(e.val);
                return;
            }
        }
        
    }
    
    @Override
    public boolean contains(Key key)
    {
        if (key == null)
            throw new UnsupportedOperationException("Not supported yet.");
        return get(key)!=null;
    }
    
    @Override
    public boolean isEmpty()
    {
        return (size() == 0);
    }
    
    @Override
    public int size()
    {
        return N;
    }
    
    @Override
    public Iterable<Key> keys()
    {
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) 
        {
            for (Entry e : entries[i])
            {            
                queue.add((Key) e.key );
            }
        }
        return queue;
    }
}
