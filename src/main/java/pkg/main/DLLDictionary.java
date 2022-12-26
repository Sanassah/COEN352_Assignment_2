package pkg.main;

import java.util.ArrayList;
import java.util.List;


public class DLLDictionary<Key, E> implements ADTDictionary<Key, E> {
    private final DLList<KVpair<Key, E>> list;  // To store dictionary

    // Overriding toString() method of String class
    @Override
    public String toString() {
        return this.list.toString();
    }

    //Constructors
    public DLLDictionary() {
        list = new DLList<>();
    }


    //Reinitialize

    public void clear() {
        list.clear();
    }


    //Insert an element: append to list
    public void insert(Key k, E e) {
        //todo
        KVpair<Key, E> temp = new KVpair<Key, E>(k, e);
        list.append(temp);
    }


    //Use sequential search to find the element to remove
    public E remove(Key k) {
        E temp = find(k);
        if (temp != null)
            list.remove();
        return temp;
    }


    //Remove the last element
    public E removeAny() {
        if (size() != 0) {
            KVpair<Key, E> e = list.remove();
            return e.getValue();
        } else
            return null;
    }

    /**
     * Find k using sequential search
     *
     * @return Record with key value k
     */
    public E find(Key k) {
        this.list.moveToStart();
        for (int i = 0; i < this.list.length(); i++) {
            KVpair<Key, E> temp = this.list.getValue();
            if (k.equals(temp.getKey())) {
                return temp.getValue();
            }
            this.list.next();
        }
        return null; // "k" does not appear in dictionary
    }

    /**
     * @return List size
     */
    public int size() {
        return list.length();
    }

    public DLList<KVpair<Key,E>> getList() {
        return list;
    }
}

