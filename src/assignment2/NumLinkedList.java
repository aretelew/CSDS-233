package assignment2;

public class NumLinkedList {
    private IntegerNode head;

    public NumLinkedList() {
        head = null;
    }

    public int size() {
        int count = 0;
        IntegerNode current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void add(int value) {
        IntegerNode newNode = new IntegerNode(value);
        if (head == null) {
            head = newNode;
        } else {
            IntegerNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void add(NumLinkedList list) {
        IntegerNode current = list.head;
        while (current != null) {
            add(current.getValue());
            current = current.getNext();
        }
    }

    public boolean isSorted() {
        IntegerNode current = head;
        while (current != null && current.getNext() != null) {
            if (current.getValue() > current.getNext().getValue()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void reverse() {
        IntegerNode previous = null;
        IntegerNode current = head;
        IntegerNode next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public static NumLinkedList merge(NumLinkedList list1, NumLinkedList list2) {
        NumLinkedList mergedList = new NumLinkedList();
        IntegerNode current1 = list1.head;
        IntegerNode current2 = list2.head;
        if (list1.isSorted() && list2.isSorted()) {
            while (current1 != null && current2 != null) {
                if (current1.getValue() <= current2.getValue()) {
                    mergedList.add(current1.getValue());
                    current1 = current1.getNext();
                } else {
                    mergedList.add(current2.getValue());
                    current2 = current2.getNext();
                }
            }
            while (current1 != null) {
                mergedList.add(current1.getValue());
                current1 = current1.getNext();
            }
            while (current2 != null) {
                mergedList.add(current2.getValue());
                current2 = current2.getNext();
            }
            return mergedList;
        } else {
            mergedList.add(list1);
            mergedList.add(list2);
        }
        return mergedList;
    }

    public static NumLinkedList duplicate(NumLinkedList list) {
        NumLinkedList duplicateList = new NumLinkedList();
        duplicateList.add(list);
        return duplicateList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntegerNode current = head;
        while (current != null) {
            sb.append(current.getValue());
            if (current.getNext() != null) {
                sb.append(" <- ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}
