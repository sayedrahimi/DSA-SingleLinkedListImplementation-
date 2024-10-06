package LinkedListPractice;

public class LinkedList {

    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedList(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        size = 1;
        head = node;
        tail = node;

        return head;
    }

    public void insertionIntoLinkedList(int nodeValue, int location){
        Node node = new Node();
        node.value = nodeValue;
        if(head == null){
            createSingleLinkedList(nodeValue);
        }else if(location == 0){
            node.next = head;
            head = node;
        }else if(location >= size){
            node.next = null;
            tail.next = node;
            tail = node;
        }else{
            Node tempNode = head;
            int index = 0;
            while (index < location-1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    public void traversalSingleLinkedList(){
        if (head == null) {
            System.out.println("There is no node for show !");
        }else{
            Node tempNode = head;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size-1) {
                    System.out.print(" => ");
                }
                tempNode = tempNode.next;
            }
        }
    }

    public boolean searchInSingleLinkedList(int nodeValue){
        Node tempNode = head;
        
        if (head != null) {
            for(int i = 0; i < size; i++){
                if (tempNode.value == nodeValue) {
                    System.out.println("your node find at index " + i);
                    return true;
                }
                tempNode = tempNode.next;
                
            }
        }
        System.out.println("Your node is not found");
        
        return false;
    }

    public void deleteNode(int location){
        if (head != null) {
         System.out.println("There is no node for deletion");
         return;   
        }else if(location == 0){
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
        }else if(location >= size){
            Node tempNode = head;
            for(int i = 0; i < size-1; i++){
                tempNode = tempNode.next;
            }
            if (head == tempNode) {
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        }else{
            Node tempNode = head;
            for(int i = 0; i < location-1; i++ ){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteSLL(){
        head = null;
        tail = null;
        System.out.println("\nLinked List is successfully deleted!");
    }
}
