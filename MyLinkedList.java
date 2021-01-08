public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
   start = null;
   end = null;
 }
 public int size() {
   return size;
 }
 public boolean add(String value) {
   if (size == 0) {
     start.setData(value);
     end.setData(value);
     start.setNext(end);
     end.setPrev(start);
   }
   else if (size == 1) {
     end.setData(value);
     start.setNext(end);
     end.setPrev(start);
   }
   else {
     Node current = new Node(value);
     end.setNext(current);
     current.setPrev(end);
     end = current;
   }
   size += 1;
   return (true);
 }
 public boolean add (int index, String value) {
   if (index>= size) {
     throw new IndexOutOfBoundsException("Index is too large for your LinkedList!");
   }
   Node newNode = new Node (value);
   if (index ==0) {
     start.setPrev(newNode);
     newNode.setNext(start);
     start = newNode;
   }
   else if (index == size -1) {
     end.setNext(newNode);
     newNode.setPrev(end);
     end = newNode;
   }
   else {
     findThisNode(index).setPrev(newNode);
     newNode.setNext(findThisNode(index));
   }
   size+=1;
   return (true);
 }
 public String get(int index) {
   if (index>= size) {
     throw new IndexOutOfBoundsException("Index is too large for your LinkedList!");
   }
   return (findThisNode(index).getData());
 }
 public String set(int index, String value){
   if (index>= size) {
     throw new IndexOutOfBoundsException("Index is too large for your LinkedList!");
   }
   String old = findThisNode(index).setData(value);
   return (old);
 }
 public String toString() {
   if (size ==0) {
     return ("[]");
   }
   String newList = "[";
   for (int i=0; i<size-1;i++) {
     newList = newList + findThisNode(i);
     newList = newList + ",";
   }
   newList = newList + findThisNode(size-1);
   newList = newList + "]";
   return (newList);
 }
 private Node findThisNode(int index) {
   Node x = new Node("");
   for (int i=0; i<index;i++) {
     if (i ==0) {
       x = start.getNext();
     }
     else {
       x = x.getNext();
     }
   }
   return (x);
 }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
