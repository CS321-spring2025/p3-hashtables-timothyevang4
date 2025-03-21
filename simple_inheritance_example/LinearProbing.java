package simple_inheritance_example;

public class LinearProbing extends Hashtable {
    public LinearProbing(int min, int max) {
        super(min, max);
        // TODO Auto-generated constructor stub
    }

    public int hash(Object obj, int k) {
        return k % m;
    }

}

