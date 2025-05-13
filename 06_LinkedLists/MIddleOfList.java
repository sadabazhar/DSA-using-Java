/*
 * I/P: [10 20 30 40 50]   O/P: 30
 * I/P: [10 20 30 40 50 60]   O/P: 40
 */

public class MIddleOfList extends CreationOfSinglyList {
    public static Node middleNode(){

        int length = getLength(head);
        int mid = (length/2);       // Indicates middle of the node

        Node temp = head;           // For traversing

        // Move temp pointer until we reach middle of list
        while (mid>0) {
            temp = temp.next;
            mid--;
        }

        return temp;
    }

    // Tortoise and Hare Algorithm
    public static Node middleNode(Node head){

        Node fast = head;   //Move 2
        Node slow = head;   //Move 1

        //slow pointer moves one step only when the fast pointer is able to move two steps.
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow stand at middle of the list
        return slow;
    }

    public static void main(String[] args) {
        add(10);
        add(20);
        add(30);
        add(40);
        add(50);
        // add(60);

        printList(head);

        Node middNode = middleNode(head);
        System.out.println("Middle Node: " + middNode.data);
    }
}
