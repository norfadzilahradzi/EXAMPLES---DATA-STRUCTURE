/**
 * A class of bags whose entries are stored in a fixed-size array.
 */
package OnlineShopping;

public class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    //CREATE AN EMPTY BAG WHOSE INITIAL CAPACITY IS 25
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given capacity
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;
        }
        else {
            throw new IllegalStateException ("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Add a new entry to this bag
     * @param newEntry The object to be added as a new entry.
     * @return  True if the addition is successful, or false if not.
     */
    @Override
    public boolean add(T newEntry) {
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        }
        else {
            //ASSERTION : RESULT IS TRUE HERE
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    @Override
    public T remove() {
        checkInitialization();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }
    
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;
        
        while (!(found && (index < numberOfEntries))) {
            if (anEntry.equals(bag[index])) {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }
     // Assertion: If where > -1, anEntry is in the array bag, and it
     // equals bag[where]; otherwise, anEntry is not in the array.
    
    private T removeEntry (int givenIndex) {
        T result = null;
        if (!(isEmpty() && (givenIndex >= 0))) {
            result = bag[givenIndex];               //ENTRY TO REMOVE
            int lastIndex = numberOfEntries - 1;
            bag[givenIndex] = bag[lastIndex];       //REPLACE ENTRY TO REMOVE WITH LAST ENTRY
            bag[lastIndex] = null;                  //REMOVE REFERENCE TO LAST ENTRY
            numberOfEntries--;
        }
        return result;
    }
    
    @Override
    public void clear() {
        while (!(isEmpty())) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        checkInitialization();
        int counter = 0;
        for (int i=0; i<numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean contains(T anEntry) {
        checkInitialization();
        return getIndexOf (anEntry) > -1;
    }

    /**
     * Retrieve all entries that are in this bag.
     * @return A newly allocated array of all the entries in this bag.
     */
    @Override
    public T[] toArray() {
        checkInitialization();
        T[] result = (T[]) new Object[numberOfEntries]; 
        for (int i=0; i<numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }
    
    private void checkInitialization() {
        if (!(initialized)) {
            throw new SecurityException("ArrayBag object is not initialized properly");
        }
    }
}
