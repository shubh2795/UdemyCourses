package hashTables;

public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable(10);

        //Birthday date and name
        table.put(27,"Shubham");
        table.put(17,"Priyanka");//expect collision
        table.put(3,"Rekha");
        table.put(12,"Anil");
        table.put(3,"Kratika");//expect collision
        table.put(12,"Princy");//expect collision
        table.put(14,"Shubham Airan");
        table.put(8,"Shravan");
        System.out.println();
        System.out.println("Testing get method "+table.get(3));
        System.out.println("Testing get method "+table.get(17));
        System.out.println();
        table.printHashTable();

    }
}
