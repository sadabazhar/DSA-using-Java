/*
 * I/P [10 20 30 20 10]   O/P true
 * I/P [10 20 30 30 20 20]   O/P false
*/

/*
 * Approach:
    1. Break the list into 2 halfs 
    2. reverse the 2nd half         (Create head2 of 2nd half)
    3. Compare both list from heads till end
*/


public class CheckPalindrome extends CreationOfSinglyList {
    
    public static Node breakList(){
        
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //Slow's next pointing to the head2
        Node head2 = slow.next;

        //Break the list
        slow.next = null;

        //Return new list
        return head2;
    }

    public static Node reverse(Node head){

        Node pre = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }

        return pre;
    }

    public static boolean compareList(Node head1, Node head2){

        while (head2 != null) {
            if (head1.data == head2.data) {
                head1 = head1.next;
                head2 = head2.next;
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        add(10);
        add(20);
        add(30);
        add(20);
        add(10);

        //Break the list
        Node head2 = breakList();
        System.out.println(head2.data);

        //Reverse 2nd half
        head2 = reverse(head2);
        printList(head2);

        //Compare both list
        System.out.println(compareList(head2, head2));
    }
}