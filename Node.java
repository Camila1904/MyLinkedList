public class Node {
  private String data;
  private Node next,prev;

  public String getData() {
    return data;
  }
  public void setData(String value) {
    data = value;
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
