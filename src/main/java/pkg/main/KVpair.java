package pkg.main;
public class KVpair<Key, E> {
    private Key k;
    private E e;

    //Constructors
    KVpair() {
        k = null;
        e = null;
    }

    // Overriding toString() method of String class
    @Override
    public String toString() {
        return ("< " + e.toString() + " >");
    }

    //If values of variables are given as argument, we instantiate, otherwise they are null
    KVpair(Key kval, E eval) {
        k = kval; e = eval;
    }

    /** Data member access functions */
    public Key getKey() {
        return k;
    }

    public E getValue() {
        //System.out.println("The value: " + e + "\n\n");
        return e;
    }

}
