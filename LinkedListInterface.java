public interface LinkedListInterface  <T> extends Cloneable{


    public void print();

    public void add(T data);

    public void add(int index, T data);

    public void remove();

    public void remove(int index);

    public boolean contains(T data);

    public boolean equals(LinkedList list);

    public void clear();

    public Object[] toArray();

    public T[] toArray(T []array);

}
