/**
 * Quadratic Probing Hash Table
 * 
 * @author Nikita Bahl, Acuna
 * @version 11/21/2017
 */
package bahlmap;

public class QuadProbingHT<Key, Value> extends LinearProbingHT<Key, Value> implements SymbolTable<Key, Value>
{
    public QuadProbingHT()
    {
        super();
    }
    
    @Override
    protected int hash (Key key, int i)
    {
        return (((key.hashCode() &0x7fffffff) + i*i) % 997);
    }
    
    @Override
    protected int probeOffset(int i)
    {
        if (i == (entries.length -1) )
            i = 0;
        else
            i=i*i;
        return i;
    }
}
