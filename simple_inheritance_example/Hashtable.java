package simple_inheritance_example;

public abstract class Hashtable {
    HashObject[] table;
    int m;

    public abstract int hash(Object key, int i);

    public Hashtable(int min, int max){
        int size = TwinPrimeGenerator.generateTwinPrime(min, max);
        table = new HashObject[size];
        m = table.length;
    }

    /* Searches an element in the hash table */
    public int search(Object key) {
        int i = 0;
        int probe = 0;
        while(table[probe] != null && i < m) {
            probe = hash(key, i);
            if(table[probe].equals(key)) {
                return probe;
            }
            i++;
        }
        return -1;
    }

    public int insert(Object key) {
        int i = 0;
        int probe = 0;
        while(i != m) {
            return probe;
        }

        return 0;
    }
}

