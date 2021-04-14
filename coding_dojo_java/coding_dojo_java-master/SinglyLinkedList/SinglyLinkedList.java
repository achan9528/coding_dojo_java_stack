public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        // your code here
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }    

    public void remove(){
        Node currentNode = head;
        while (currentNode.next.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = null;
    }

    public void printValues(){
        Node currentNode = head;
        while (currentNode.next != null){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.value);
    }
}