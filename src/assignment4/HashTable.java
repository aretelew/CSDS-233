package assignment4;

public class HashTable {
    private final int size;
    private final Integer[] table;

    public HashTable(int size) {
        this.size = size;
        table = new Integer[size];
    }

    public void linearProbingInsert(int key) {
        int index = key % size;
        while (table[index] != null) {
            index = (index + 1) % size;
        }
        table[index] = key;
        printTable();
    }

    public void doubleHashingInsert(int key, int prime) {
        int index = key % size;
        int step = prime - (key % prime);
        while (table[index] != null) {
            index = (index + step) % size;
        }
        table[index] = key;
        printTable();
    }

    public void printTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                sb.append(table[i]);
            } else {
                sb.append("null");
            }
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
