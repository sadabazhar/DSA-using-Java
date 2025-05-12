public class CreationOfDoublyList {
    
    static Node head = null;
    static Node tail = null;

    static class Node{
        private int data;
        private Node pre;
        private Node next;

        Node(int data){
            this.data = data;
            this.pre = null;
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

            tail.next = newNode;        //2. Connect tail next to newNode
            
            newNode.pre = tail;         //3. Connect newNode pre to tail
            
            tail =  newNode;            //4. Update new tail
            return;

        }
    }

    public static void addAt(int position ,int data){

        int length = getLength();

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

            Node newNode = new Node(data);  //1. Create new Node
            
            newNode.next = head;            //2. Connect newNode next to head
            
            head.pre = newNode;             //3. Connect head pre to newNode
            
            head =  newNode;                //4. Update new head
            return;

        }
        
        //* Case 3: Insert at tail
        else if(position == length+1){

            add(data);
            return;

        }
        
        //* Case 4: Insert between head & tail
        else{

            Node newNode = new Node(data);  // Create node
            Node pre = null;                // Create previous node
            Node curr = head;               // Current node

            //1. Traversing at give position
            while (position > 1) {
                pre = curr;
                curr = curr.next;
                position--;
            }

            //2. Connect pre next to new node
            pre.next = newNode;
            //3. Connect newNode pre to pre node
            newNode.pre = pre;

            //4. Connect newNode next to curr node
            newNode.next = curr;
            //5. Connect curr pre to newNode
            curr.pre = newNode;
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

            //2. Disconnect curr next
            curr.next = null;
            //3. Disconnect tail pre
            tail.pre = null;

            //4. Update tail
            tail = curr;
            return;

        }
    }

    public static void removeAt(int position){

        int length = getLength();

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

            //2. Update head
            head = head.next;

            //3. Disconnect the 1st node
            tempNode.next = null;
            head.pre = null;
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

            //2. Connect pre next to current next node
            pre.next = curr.next;

            //2. Connect curr next pre to current pre node
            curr.next.pre = curr.pre;

            //3. Nullify the current node
            curr.pre = null;
            curr.next = null;
            return;

        }
    }
    

    public static void printList(){
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

        add(20);
        add(30);
        add(40);
        printList(); // Output: 20 30 40

        addAt(1, 10);
        printList(); // Output: 10 20 30 40

        addAt(3, 25);
        printList(); // Output: 10 20 25 30 40

        removeAt(1);
        printList(); // Output: 20 25 30 40

        removeAt(4);
        printList(); // Output: 20 25 30

        removeAt(2);
        printList(); // Output: 20 30

        remove();
        printList(); // Output: 20

    }
}
