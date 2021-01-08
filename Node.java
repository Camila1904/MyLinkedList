public class Node {
  private String data;
  private Node next,prev;
  public Node (String value) {
    data = value;
    next = null;
    prev = null;
  }

  public String getData() {
    return data;
  }
  public String setData(String value) {
    String old = data;
    data = value;
    return old;
  }
  public Node getNext() {
    return next;
    }
  public void setNext(Node newNext) {
    next = newNext;
  }
  public Node getPrev() {
    return prev;
  }
  public void setPrev(Node newPrev) {
    prev = newPrev;
  }
}
