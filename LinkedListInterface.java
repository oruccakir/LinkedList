public interface LinkedListInterface  <T> extends PubliclyCloneable{

    public void print();

    public void add(T data);

    public void add(int index, T data);

    public T get(int index);

    public void set(int index, T data);

    public void remove();

    public void remove(int index);

    public boolean contains(T data);

    public void clear();

    public Object[] toArray();

    public T[] toArray(T []array);

    public int indexOf(T data);

}

interface PubliclyCloneable extends Cloneable{
    public Object clone();
}

