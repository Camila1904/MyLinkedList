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
   if (end == null) {
     start = new Node(value);
     end = start;
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
 public void add (int index, String value) {
   if (index>= size) {
     throw new IndexOutOfBoundsException("Index is too large for your LinkedList!");
   }
   Node newNode = new Node (value);
   if (index ==0) {
     start.setPrev(newNode);
     newNode.setNext(start);
     start = newNode;
     return;
   }
   else if (index == size -1) {
     add(value);
     return;
   }
   else {
     findThisNode(index).setPrev(newNode);
     newNode.setNext(findThisNode(index));
   }
   size+=1;
   return;
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
 public String toStringReversed() {
   if (size == 0) {
     return ("[]");
   }
   String newList = "[";
   for (int i=size-1;i<size-1;i--) {
     newList = newList +findThisNode(i);
     newList = newList +",";
   }
   newList = newList + findThisNode(0);
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
 public String remove(int index) {
   if (index>= size|| index<0) {
     throw new IndexOutOfBoundsException("Index is too large for or out of your LinkedList!");
   }
   Node newNode = start;
   while (index>0) {
     index--;
     newNode = newNode.getNext();
   }
   if (size == 1) {
     String newerNode = newNode.getData();
     start = null;
     end = null;
     size--;
     return newerNode;
   }
   if (newNode.getNext()==null) {
     String newerNode = newNode.getData();
     end = newNode.getPrev();
     end.setNext(null);
     size--;
     return newerNode;
   }
   if (newNode.getPrev() == null) {
     String newerNode = newNode.getData();
     start = newNode.getNext();
     start.setPrev(null);
     size--;
     return newerNode;
   }
   else {
     String newerNode = newNode.getData();
     newNode.getPrev().setNext(newNode.getNext());
     newNode.getNext().setPrev(newNode.getPrev());
     size--;
     return newerNode;
   }
 }
 public void extend (MyLinkedList other) {
   if (other.size()==0){
     return;
   }
   if (this.size == 0) {
     this.start = other.start;
     this.end = other.end;
     other.start = null;
     other.end = null;
     this.size = other.size;
     other.size = 0;
   }
   else {
     this.end.setNext(other.start);
     other.start.setPrev(this.end);
     this.end = other.end;
     this.size = this.size + other.size;
     other.start = null;
     other.end = null;
     other.size = 0;
   }
 }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
