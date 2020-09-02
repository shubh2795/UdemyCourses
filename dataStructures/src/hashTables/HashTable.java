package hashTables;

public class HashTable {
    private final String[] hashTable;

    public HashTable(int capacity) {
        hashTable = new String [capacity];
    }

    private int hashFunction(int key) {
        return key % 10;
    }

    public void put(int key, String value) {
        int index = hashFunction(key);
        if (hashTable[index] == null)
            hashTable[index] = value;
        else
            System.out.println("HashTable at " + index + " Already occupied and the value" + value + "can not be added");

    }

    public String  get(int key) {
        return hashTable[hashFunction(key)];
    }

    public void printHashTable() {
        System.out.println("Printing hash Table");
        int i = 0;
        while ( i < hashTable.length ) {
            System.out.print(i+" -> "+ hashTable[i++] + " ,");
        }

        System.out.println();
    }

}
