import java.util.Arrays;

public class LinkedList <T> implements LinkedListInterface<T>{

    private ListNode head;

    private int length = 0;

    public LinkedList(){

        this.head = null;

    }




    @Override
    public void print() {

        ListNode temp = this.head;

        System.out.print("[ ");

        while(temp != null){

            System.out.print(temp.data+" ");
            temp = temp.link;

        }

        System.out.print("]"+"\n");

    }

    @Override
    public void add(T data) {

        ListNode newNode = new ListNode(data,null);

        if(length == 0){
            this.head = newNode;
        }
        else{

            ListNode position = this.head;

            while (position.getLink() != null){

                position=position.getLink();
            }

            position.setLink(newNode);

        }

       length++;

    }

    @Override
    public void add(int index, T data) {

        if(index > length) return;

        ListNode newNode = new ListNode(data,null);

        if(length == 0 && index == 0){
            this.head = newNode;
        }

        else{

            if(index == 0){
                newNode.setLink(this.head);
                this.head = newNode;
            }
            else{

                int currentIndex = 0;

                ListNode temp = this.head;

                while(temp != null && currentIndex+1<index){

                    temp = temp.link;
                    currentIndex++;

                }

                newNode.setLink(temp.link);
                temp.link=newNode;

            }

        }


        length++;

    }

    @Override
    public void remove() {

        if (length == 0) return;

        if(length == 1) this.head = null;

        else{

            ListNode temp = this.head;

            while (temp.getLink().getLink()!=null) temp = temp.link;

            temp.setLink(null);

        }

        length--;

    }

    @Override
    public void remove(int index) {

        if(index >length-1) return;

        if (length == 0 && index == 0) return;

        int currentIndex = 0;

        ListNode temp = this.head;

        if(index == 0){
            this.head=this.head.link;
        }
        else if(index == length-1){
            remove();
            length++;
        }
        else{

            int currIndex = 0;
            ListNode current = this.head;
            while (currIndex != index-1){
                current = current.link;
                currIndex++;
            }

            current.setLink(current.getLink().getLink());

        }

        length--;

    }

    @Override
    public boolean contains(T data) {

        ListNode temp = this.head;

        while (temp != null){

            if(temp.data.equals(data)) return true;

            temp = temp.link;

        }

        return false;
    }

    @Override
    public boolean equals(LinkedList list) {

        ListNode thisTemp = head;
        ListNode otherTemp = list.head;

        if(thisTemp == null && otherTemp == null) return true;

        if(list.length != this.length) return false;

        while (thisTemp !=null && otherTemp !=null){

            if(!thisTemp.data.equals(otherTemp.data)) return false;

            thisTemp = thisTemp.link;
            otherTemp = otherTemp.link;

        }

        return true;
    }

    @Override
    public void clear() {this.head = null; length=0;}

    @Override
    public Object[] toArray() {

        Object [] obj = new Object[length];

        int index = 0;

        ListNode temp = this.head;

        while(temp!=null){

            obj[index] =  temp.data;
            temp = temp.getLink();
            index++;
        }

        return obj;
    }

    @Override
    public T[] toArray(T[] array) {

        int index = 0;

        ListNode temp = this.head;

        while (temp !=null){

            array[index] = temp.data;
            index++;
            temp = temp.link;

        }

        return array;

    }





    private class ListNode{

        private T data;
        private ListNode link;

        public ListNode(){

            this.data = null;
            this.link = null;

        }

        public ListNode (T data, ListNode link){

            this.data = data;
            this.link = link;

        }

        public String toString(){

            return data.toString();

        }


        public T getData() {
            return data;
        }

        public ListNode getLink() {
            return link;
        }

        public void setLink(ListNode link) {
            this.link = link;
        }

        public void setData(T data) {
            this.data = data;
        }
    }


    public static void main(String []args){


        LinkedList<String> list = new LinkedList<>();

        list.add(0,"oruç");
        list.add("bebe");
        list.add(1,"çakır");
        list.add(3,"zehracıkk");
        list.add(0,"tobb");
        list.add(3,"cece");
        list.remove(2);
        list.remove();
        list.remove(0);
        list.remove(1);
        list.remove(1);
        list.remove();
        list.clear();
        list.add(0,"bebebe");

        list.print();
        System.out.print(list.length);





    }


}
