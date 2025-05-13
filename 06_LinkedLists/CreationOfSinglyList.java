public class CreationOfSinglyList{

    protected static Node head = null;
    protected static Node tail = null;

    static class Node{
        protected int data;
        protected Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
 
    public static void add(int data){

        //1. created new node
        Node newNode = new Node(data);

        if(head == null) { // Edge case (Empty List)

            //2. point head and tail at same
            head = tail = newNode;
            return;

        }else{

            //2. Connect tail node to newNode
            tail.next = newNode;
            //3. Update new tail
            tail =  newNode;
            return;

        }
    }

    public static void addAt(int position ,int data){

        int length = getLength(head);

        if(position < 1 || position > length+1){ // Edge case (Invalid position)
            System.out.println("Enter correct position");
            return;
        }

        //* Case 1: Empty List
        if(head == null) { 

            Node newNode = new Node(data);
            head = tail = newNode;
            return;

        }

        //* Case 2: Insert at head
        else if(position == 1){

            //1. Create new Node
            Node newNode = new Node(data);
            //2. Connect this node to head
            newNode.next = head;
            //3. Update new head
            head =  newNode;
            return;

        }
        
        //* Case 3: Insert at tail
        else if(position == length+1){

            add(data);
            return;

        }
        
        //* Case 4: Insert between head & tail
        else{

            Node newNode = new Node(data); // Create node
            Node pre = null;            // Create previous node
            Node curr = head;           // Current node

            //1. Traversing at give position
            while (position > 1) {
                pre = curr;
                curr = curr.next;
                position--;
            }

            //2. Connect pre node with new node
            pre.next = newNode;

            //3. Connect new node with curr node
            newNode.next = curr;
            return;
        }
    }

    public static void remove(){
    
        if(head == null) { // Edge case (Empty List)

            System.out.println("Empty List");
            return;

        }

        //* Case1: Single element
        if(head == tail){

            // Nullify head & tail
            head = tail = null;
            return;
        }

        //* Case2: Delete at tail
        else{

            Node curr = head;           // Current node

            //1. Traverse until current node pointing to tail
            while (curr.next != tail) {
                curr = curr.next;
            }

            //2. Nullify Current node
            curr.next = null;

            //3. Update tail
            tail = curr;
            return;

        }
    }

    public static void removeAt(int position){

        int length = getLength(head);

        if(position < 1 || position > length){ // Edge case (Invalid position)
            System.out.println("Enter correct position");
            return;
        }

        //* Case 1: Empty List
        if(head == null) { 

            System.out.println("Empty List");
            return;

        }

        //* Case 2: Single Element
        else if(head == tail && position ==1) { 

            //Nullify head & tail
            head = tail = null;
            return;

        }

        //* Case 3: delete at head
        else if(position == 1){

            //1. Create new node and set to head
            Node tempNode = head;

            //2. Update head postion
            head = head.next;

            //3. delete 1st node
            tempNode.next = null;
            return;

        }
        
        //* Case 4: delete at tail
        else if(position == length){

            remove();
            return;

        }
        
        //* Case 5: delete between head & tail
        else{

            Node pre = null;            // Create previous node
            Node curr = head;           // Current node

            //1. Traverse at give postion
            while (position > 1) {
                pre = curr;
                curr = curr.next;
                position--;
            }

            //2. Connect pre node to current next node
            pre.next = curr.next;

            //3. Nullify the current node
            curr.next = null;
            return;

        }
    }
    

    public static void printList(Node head){
        // *! Always use temp node for traverse the node, don't touch original node
        Node temp = head;

        if(temp == null){
            System.out.println("List is empty");
            return;
        }else{

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
            return;
        }
        
    }

    public static int getLength(Node head){
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

        add(20);
        add(30);
        add(40);
        printList(head); // Output: 20 30 40

        addAt(1, 10);
        printList(head); // Output: 10 20 30 40

        addAt(3, 25);
        printList(head); // Output: 10 20 25 30 40

        removeAt(1);
        printList(head); // Output: 20 25 30 40

        removeAt(4);
        printList(head); // Output: 20 25 30

        removeAt(2);
        printList(head); // Output: 20 30

        remove();
        printList(head); // Output: 20

    }

}