public class CreationOfLL{

    static Node head = null;
    static Node tail = null;

    static class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
 

    public static void addAtHead(int data){

        //1. created new node
        Node temp = new Node(data);

        if(head == null) { // Edge case (Empty List)

            //2. point head and tail at same
            head = tail = temp;

        }else{

            //2. Connect this node to head
            temp.next = head;
            //3. Update new head
            head =  temp;

        }
    }


    public static void addAtTail(int data){

        //1. created new node
        Node temp = new Node(data);

        if(head == null) { // Edge case (Empty List)

            //2. point head and tail at same
            head = tail = temp;

        }else{

            //2. Connect tail node to temp
            tail.next = temp;
            //3. Update new tail
            tail =  temp;

        }
    }

    public static void addAtAny(int position ,int data){

        int length = getLength();

        if(position < 1 || position > length+1){ // Edge case (Invalid position)
            System.out.println("Enter correct position");
            return;
        }

        //* Case 1: Empty List
        if(head == null) { 

            Node temp = new Node(data);
            head = tail = temp;

        }

        //* Case 2: Insert at head
        else if(position == 1){

            addAtHead(data);

        }
        
        //* Case 3: Insert at tail
        else if(position == length+1){

            addAtTail(data);

        }
        
        //* Case 4: Insert between head & tail
        else{

            Node temp = new Node(data); // Create node
            Node pre = null;            // Create previous node
            Node curr = head;           // Current node

            while (position > 1) {
                pre = curr;
                curr = curr.next;
                position--;
            }

            //Connect temp node with correct position
            pre.next = temp;
            temp.next = curr;

        }
    }
    

    public static void printList(){
        // *! Always use temp node for traverse the node, don't touch original node
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int getLength(){
        // *! Always use temp node to traverse the node, don't touch original node
        Node temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }
    
    public static void main(String[] args) {

        

        // Adding new node (defult)
        addAtTail( 20);
        addAtTail( 30);
        addAtTail( 40);
        addAtTail( 60);
        printList();

        //After adding new node at head
        addAtHead(10);
        printList();

        //After adding new node at Any position
        addAtAny(-1, 12);
        printList();
    }

}