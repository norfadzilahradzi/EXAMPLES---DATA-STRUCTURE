/**
 * Interface that describes the operations of a bag of objects.
 */
package OnlineShopping;

public interface BagInterface<T> {
    
    /**
     * Get the current number of entries in this bag.
     * @return Number of entries currently in the bag.
     */
    public int getCurrentSize();
    
    /**
     * Check whether the bag is empty.
     * @return True if the bag is empty, false if not.
     */
    public boolean isEmpty();
    
    /**
     * Add a new entry to this bag.
     * @param newEntry The object to be added as a new entry.
     * @return  True if successful, false if not.
     */
    public boolean add (T newEntry);
    
    /**
     * Remove one unspecified entry from this bag, if possible.
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove();
    
    /**
     * Remove one occurence of a given entry from this bag.
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove (T anEntry);
    
    /**
     * Remove all entries from this bag.
     */
    public void clear();
    
    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted.
     * @return Number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry);
    
    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains (T anEntry);
    
    /**
     * Retrieve all entries that are in the bag.
     * @return A newly allocated array of all the entries in the bag.
     * Note : If the bag is empty, the returned array is empty.
     */
    public T[] toArray();
}
