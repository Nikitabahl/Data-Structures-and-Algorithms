/**
 * Linear Probing Hash Table
 * 
 * @author Nikita Bahl, Acuna
 * @version 11/21/2017
 */

package bahlmap;

import java.util.LinkedList;
//import java.util.Queue;

public class LinearProbingHT<Key, Value> implements SymbolTable<Key, Value>
{
    public class Entry<Key, Value>
    {
        public Key key;
        public Value val;
        
        public Entry(Key k, Value v)
        {
            this.key = k;
            this.val = v;
        }
    }
    
    private int M; 
    private int N;
    protected Entry entries[];
    
    public LinearProbingHT()
    {
        this(997);
    }
    
    public LinearProbingHT(int M)
    {
        this.M = M;
        this.N = 0;
        entries = new Entry[M];
    }
    
    protected int hash (Key key, int i)
    {
        return (((key.hashCode() &0x7fffffff) + i) % M);
    }
    
    @Override
    public void put(Key key, Value val)
    {
        int probe = 0;
        Entry<Key,Value> temp = new Entry(key, val);
        int hashValue = hash(key, probe);
        probe = hashValue;
        
        if (entries[hashValue] == null)
        {
            entries[hashValue] = temp;
            //System.out.println(entries[hashValue].val);
            this.N++;
        }
        else
        {
            probe = probeOffset(probe);

            while (probe != hashValue && probe<M)
            {
                if (entries[probe] == null)
                {
                   entries[probe] = temp;
                   this.N++;
                   //System.out.println(entries[probe].val);
                   return;
                }
                else
                {
                    probe = probeOffset(probe);
                }
            }
        }
    }
    
    protected int probeOffset(int i)
    {
        if (i == (entries.length -1) )
                  i = 0;
               else
                  i++;
        
        return i;
    }
    
    @Override
    public Value get(Key key)
    {       
        int probe =0;
        int hashValue = hash(key, probe);
        probe = hashValue;
        
        if (entries[hashValue] == null)
           return null;
        else if (entries[hashValue].key.equals(key))
        {
           //System.out.println((Value)entries[hashValue].val);
           return (Value)entries[hashValue].val;
        }
        else
        {
          probe = probeOffset(probe);

          while ((probe != hashValue))
          {
              if (entries[probe] == null)
                  return null;
              else if (entries[probe].key.equals(key))
              {
                  //System.out.println((Value)entries[hashValue].val);
                  return (Value)entries[probe].val;
              }
              else
              {
                  probe = probeOffset(probe);
              }
          }
       }
        return null;
    }
    
    @Override
    public void delete(Key key)
    {        
        int probe=0;
        int hashValue = hash(key,probe);

        if (entries[hashValue] == null)
        {
            //System.out.println("Nothing to delete!");
            return;
        }
        else if (entries[hashValue].key.equals(key))
        {
           entries[hashValue].key = null;
           entries[hashValue].val = null;
           //System.out.println((Value)entries[hashValue].val);
           return;
        }
        else
        {
            probeOffset(probe);

            while ((probe != -1) && (probe != hashValue))
            {
                if (entries[probe] == null)
                {
                   //System.out.println("null");
                   return;
                }
                else if (entries[probe].key.equals(key))
                {
                    entries[hashValue].key = null;
                    entries[hashValue].val = null;
                    //System.out.println((Value)entries[hashValue].val);
                    return;
                }
                else
                {
                   probeOffset(probe);
                }
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
        LinkedList<Key> keyArrayList = new LinkedList<>();
        for (int i = 0; i < M; i++) 
        {       
            if (entries[i] != null)
            {
                keyArrayList.add((Key) entries[i].key);
            }
        }
        return keyArrayList;        
    }
}
