/*****************************************************************************/
//  HashTable.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 5 Question 3
//  This class creates a dynamically resizable hash table to store SSNs and
//  peoples names. It uses extraction, division, and double hashing to insert
//  and resolve collisions with a load factor of 0.8 and intial size of 31
/*****************************************************************************/

package question3;
import jsjf.exceptions.*;
@SuppressWarnings("unused")

public class HashTable
{
    /**
     * Reperesents the key value pair that will be inserted into HashTable
     */
    private static class HashPair
    {
        // social security number (SSN)
        protected String key;

        // the name of the person
        protected String value;

        // indicates if this HashPair is deleted at respective index
        protected boolean flag;

        /**
         * Default HashPair contstrucotr
         * @param sin the SSN of the peson
         * @param name the name of the person
         */
        public HashPair(String sin, String name)
        {
            key = sin;
            value = name;
        }

        /**
         * Accessor method for key 
         * @return the key (SIN number)
         */
        public String getKey()
        { 
            return key; 
        }

        /**
         * Accessor method for the value
         * @return the value (name)
         */
        public String getValue()
        {
            return value;
        }
    }

    // default intial size
    private static int INITIAL_SIZE = 31;
    
    // default load factor 
    private static double LOAD_FACTOR = 0.8;
    
    /**
     * The class attributes which represent the:
     * entries, threshold for resizing, and count (number of keys)
     */
    private HashPair[] hashTable;
    private int threshold;
    private int count; 
    
    /**
     * Default constructor with initial size of 31 and
     * load factor equal to 0.8
     */
    public HashTable()
    {
        hashTable = new HashPair[INITIAL_SIZE];
        threshold = (int)(INITIAL_SIZE*LOAD_FACTOR);
    }

    /**
     * Creates HashTable of specified size
     * @param size the initial size
     */
    public HashTable(int size)
    {
        hashTable = new HashPair[size];
        threshold = (int)(size*LOAD_FACTOR);
    }

    /**
     * Clears hashTable so that it contains no keys
     */
    public void clear()
    {
        for (int i = 0; i < hashTable.length; i++)
            hashTable[i] = null;
    }

    /**
     * Increases the capacity and internallly reorganizes this HashTable
     */
    public void rehash()
    {
        // create new hashTable with twice the length
        HashPair[] oldTable = hashTable;
        hashTable = new HashPair[oldTable.length*2];

        // copy each HashPair from old table into new table
        for (int i = 0; i < oldTable.length; i ++)
        {
            // if not null and not deleted
            if (oldTable[i] != null && !oldTable[i].flag)
            {
                String key = oldTable[i].getKey();
                int newIndex = hashIndex(key);
                hashTable[newIndex] = oldTable[i];
            }
        }

        // increase threshold value
        threshold = (int)(oldTable.length*2*LOAD_FACTOR);
    }

    /**
     * Maps the specified HashPair (key and value) to this HashTable.
     * Validates key (SSN) which is formatted ###-##-####
     * @param key
     * @param value
     */
    public void put(String key, String value)
    {
        // SSN must follow format ###-##-####
        if (!key.matches("\\d{3}-\\d{2}-\\d{4}"))
            throw new IllegalArgumentException("SSN is not valid");

        // find key index and place in table
        int index = hashIndex(key);
        hashTable[index] = new HashPair(key, value);
        count++;

        // if count exceeds threshold, rehash
        if (count >= threshold)
            rehash();
    }

    /**
     * Removes the key from this hashTable (marks as deleted by flagging)
     * @param key the key to be removed
     * @return the corresponding value of the key
     */
    public String remove(String key)
    {
        // if this table does not contain key
        if (this.contains(key) == false)
            throw new ElementNotFoundException("HashTable");
        
        //mark as deleted
        int index = findIndex(key);
        hashTable[index].flag = true;
        count--;
        return hashTable[index].value;
    }

    /**
     * Determines if specified key exists in this table
     * @param key the key to be found
     * @return true if found, false otherwise
     */
    public boolean contains(String key)
    {
        return (findIndex(key) != -1);
    }

    /**
     * Finds the index containing the specified key.
     * Returns -1 if key is not found
     * @param key the key to find the index for
     * @return the index where the key is found
     */
    private int findIndex(String key)
    {
        // SSN must follow format ###-##-####
        if (!key.matches("\\d{3}-\\d{2}-\\d{4}"))
            throw new IllegalArgumentException("SSN is not valid (");

        int index = firstHash(key);
        int i = 2; // counter for double hashing

        // index at firstHash is null
        if (hashTable[index] == null)  
            return -1;

        // index at firstHash is not null and not deleted
        else if (hashTable[index].key.equals(key) && !hashTable[index].flag)
            return index;

        // use double hashing until the value is found
        index = (firstHash(key) + secondHash(key)) % hashTable.length;

        while (hashTable[index] != null)
        {
            // key at index is equivalent and not deleted
            if (hashTable[index].key.equals(key) && !hashTable[index].flag)
                return index;
            
            // continue double hasing unitl index element is found
            index = (firstHash(key) + i*secondHash(key)) % hashTable.length;
            i++;
        }

        // double hashing did not find key
        return -1;
    }

    /**
     * Calculates index for key using hashCode and doubleHashCode if necessary.
     * Uses double hashing if primary hash code does not find available spot.
     * (firstHash(key) + i*secondHash(key)) % hashTable.length
     * @param key the key to be hashed and indexed
     * @return the final index for this key
     */
    private int hashIndex(String key)
    {
        // primary hash key
        int index = firstHash(key);
        int i = 2; // counter for double hash

        // double hash if first hash does not find
        if (hashTable[index] != null && !hashTable[index].flag)
            index = (firstHash(key) + secondHash(key)) % hashTable.length;

        // continue double hashing to find available spot
        while (hashTable[index] != null && !hashTable[index].flag)
        {
            index = (firstHash(key) + i*secondHash(key)) % hashTable.length;
            i++;
        }

        return index;
    }

    /**
     * Returns the primary hash code which uses extraction on the last 4 digits
     * on the SSN of the person
     * @param key the SSN to perform a modulo on
     * @return the hash code for this key
     */
    private int firstHash(String key)
    {
        int keyIndex = Integer.parseInt(key.substring(7));
        return keyIndex % hashTable.length;
    }

    /**
     * Returns the double hash code using extraction on the first 3 digits of 
     * the SSN
     * @param key the SSN to perform a modulo on
     * @return the double hash code for this key
     */
    private int secondHash(String key)
    {
        int keyIndex = Integer.parseInt(key.substring(0, 3));
        return keyIndex % hashTable.length;
    }

    /**
     * Accessor method to get number of elements in this hashTable
     * @return the number of elements
     */
    public int size()
    {
        return count;
    }

    /**
     * Prints this hashTable's elements
     */
    public String toString()
    {
        String result = "";
        //result = "[";
        for (int i = 0; i < hashTable.length; i++)
        {   
            // not null and not delted
            if (hashTable[i] != null && !hashTable[i].flag)
                result += ("(" + hashTable[i].key + "," + hashTable[i].value + ")\n");
        }
        //result += "]";
        return result;
    }
}