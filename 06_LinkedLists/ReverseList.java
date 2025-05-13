public class ReverseList extends CreationOfSinglyList {

    public static Node reverseList(Node head){

        // Traversing nodes
        Node pre = null;
        Node curr = head;
        
        while (curr != null) {
            //1. for track record
            Node next = curr.next;

            //2. set curr next to pre
            curr.next = pre;
            
            //3. Move forward
            pre = curr;
            curr = next;
        }

        // Now, pre is stand at head
        head = pre;
        return head;
    }

    public static void main(String[] args) {

        add(10);
        add(20);
        add(30);
        add(40);
        printList();
        head = reverseList(head);
        printList();
    }
}
