package search;

public class Three implements One, Two {
  @Override
  public void print() {
    One.super.print();
  }
}
