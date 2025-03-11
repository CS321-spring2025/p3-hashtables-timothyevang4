package simple_inheritance_example;


import java.util.Hashtable;

public class DoubleHashing extends Hashtable {
    public DoubleHashing(int min, int max) {
        super(min, max);
        // TODO Auto-generated constructor stub
    }
    public int hash(Object obj, int k) {
        return k % m;
    }
    public int hash2(int k) {
        return 1 + (k % m * (m - 2)) % m;
    }
}

