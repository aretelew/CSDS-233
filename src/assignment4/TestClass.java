package assignment4;

public class TestClass {
    public static void main(String[] args) {
        System.out.println("TESTING assignment4.HashTable");
        HashTable hashTable = new HashTable(10);
        System.out.println("LINEAR PROBING INSERTING 10, 3, 17, 14, 18, 3, 8, 1, 18, 11");
        hashTable.linearProbingInsert(10);
        hashTable.linearProbingInsert(3);
        hashTable.linearProbingInsert(17);
        hashTable.linearProbingInsert(14);
        hashTable.linearProbingInsert(18);
        hashTable.linearProbingInsert(3);
        hashTable.linearProbingInsert(8);
        hashTable.linearProbingInsert(1);
        hashTable.linearProbingInsert(18);
        hashTable.linearProbingInsert(11);
        System.out.println("=====================================");
        System.out.println("DOUBLE HASHING INSERTING 7, 17, 27, 37, 47, 57, 67, 77, 87, 97, with PRIME 7");
        HashTable hashTable2 = new HashTable(10);
        hashTable2.doubleHashingInsert(7, 7);
        hashTable2.doubleHashingInsert(17, 7);
        hashTable2.doubleHashingInsert(27, 7);
        hashTable2.doubleHashingInsert(37, 7);
        hashTable2.doubleHashingInsert(47, 7);
        hashTable2.doubleHashingInsert(57, 7);
        hashTable2.doubleHashingInsert(67, 7);
        hashTable2.doubleHashingInsert(77, 7);
        hashTable2.doubleHashingInsert(87, 7);
        hashTable2.doubleHashingInsert(97, 7);
    }
}
