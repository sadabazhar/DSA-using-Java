public class CircularDoublyList {

    static Node head = null;
    static Node tail = null;

    static class Node {
        int data;
        Node pre;
        Node next;

        Node(int data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }
    }

    // Add node at the end
    public static void add(int data) {
        Node newNode = new Node(data);

        if (head == null) { // Empty list
            head = tail = newNode;
            head.next = head;
            head.pre = head;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
            tail.next = head;
            head.pre = tail;
        }
    }

    // Add node at specific position
    public static void addAt(int position, int data) {
        int length = getLength();

        if (position < 1 || position > length + 1) {
            System.out.println("Enter correct position");
            return;
        }

        Node newNode = new Node(data);

        if (head == null) { // Empty list
            head = tail = newNode;
            head.next = head;
            head.pre = head;
        } else if (position == 1) { // Add at head
            newNode.next = head;
            newNode.pre = tail;
            head.pre = newNode;
            tail.next = newNode;
            head = newNode;
        } else if (position == length + 1) { // Add at tail
            add(data);
        } else { // Add in between
            Node temp = head;
            for (int i = 1; i < position - 1; i++)
                temp = temp.next;

            newNode.next = temp.next;
            newNode.pre = temp;
            temp.next.pre = newNode;
            temp.next = newNode;
        }
    }

    // Remove node from end
    public static void remove() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        if (head == tail) { // One node
            head = tail = null;
        } else {
            tail = tail.pre;
            tail.next = head;
            head.pre = tail;
        }
    }

    // Remove node from specific position
    public static void removeAt(int position) {
        int length = getLength();

        if (position < 1 || position > length) {
            System.out.println("Enter correct position");
            return;
        }

        if (head == null) {
            System.out.println("Empty List");
        } else if (head == tail && position == 1) { // One node
            head = tail = null;
        } else if (position == 1) { // Remove head
            head = head.next;
            head.pre = tail;
            tail.next = head;
        } else if (position == length) { // Remove tail
            remove();
        } else { // Remove in between
            Node temp = head;
            for (int i = 1; i < position; i++)
                temp = temp.next;

            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }
    }

    // Print the list
    public static void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Get number of nodes in the list
    public static int getLength() {
        if (head == null) return 0;

        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // Main method to test the list
    public static void main(String[] args) {
        add(20);
        add(30);
        add(40);
        printList(); // 20 30 40

        addAt(1, 10);
        printList(); // 10 20 30 40

        addAt(3, 25);
        printList(); // 10 20 25 30 40

        removeAt(1);
        printList(); // 20 25 30 40

        removeAt(4);
        printList(); // 20 25 30

        removeAt(2);
        printList(); // 20 30

        remove();
        printList(); // 20
    }
}
