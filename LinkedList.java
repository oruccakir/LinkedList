import java.util.Arrays;

public class LinkedList <T extends PubliclyCloneable> implements LinkedListInterface<T>{

    private ListNode head;

    private int length = 0;

    public LinkedList(){

        this.head = null;

    }

    public Object clone(){

        LinkedList <T> newList = new LinkedList<>();

        newList.head = (ListNode) this.head.clone();

        ListNode tempThis = this.head;

        while(tempThis != null){

            newList.add((T) tempThis.data.clone());
            tempThis = tempThis.link;

        }

        return newList;
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


    public void recursivePrint(ListNode head){

        if(head == this.head)
           System.out.print("[ ");

        if(head == null){
            System.out.println("]");
            return;
        } 

        System.out.print(head.data+" ");
        
        recursivePrint(head.link);

    }

    public void reverseRecursivePrint(ListNode head){

        if(head == null) return;

        reverseRecursivePrint(head.link);

        System.out.print(head.data+" ");

    }

    public int recursiveSearch(ListNode head,T data){

        if(head == null) return -1;

        if(head.data.equals(data)) return 0;

        int result = recursiveSearch(head.link,data);

        return (result == -1 ) ? -1 : result+1;

    }

    public void reverseTheList(){

        if(this.head == null || this.head.link == null) 
           return;

        ListNode temp = null, prev = null, curr = this.head;

        while(curr != null){

            temp = curr.link;

            curr.link = prev;

            prev = curr;

            curr = temp;

        }

        this.head = prev;

    }


    public Integer convertIntegerNumber(ListNode head,Integer mult){

        if(head.link == null){

             Object intData = head.data;

             return (Integer)(intData);

        }

        Object intData = head.data;


        return (Integer) intData*mult + convertIntegerNumber(head.link, mult/10);

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

                while(temp != null && currentIndex!=index){

                    temp = temp.link;
                    currentIndex++;

                }

                if(temp == null){
                    this.add(data);
                    this.length--;
                }
                    

                else{
                    newNode.setLink(temp.link);
                    temp.link=newNode;
                }

            }

        }


        length++;

    }

    public T get(int index){

        ListNode temp = this.head;

        int currIndex = 0;

        while(currIndex!=index && temp!=null){
            currIndex++;
            temp = temp.link;
        }

        return temp.data;

    }


    public void set(int index, T data){

        ListNode temp = this.head;

        int currIndex = 0;

        while(currIndex!=index && temp!=null){
            currIndex++;
            temp = temp.link;
        }

        temp.data=data;
        
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
    
    public boolean equals(LinkedList <T>list) {

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

    public int indexOf(T data){

            ListNode temp = this.head;

            int index = 0;

            while(temp!=null){

                if(temp.data.equals(data)) return index;

                temp = temp.link;
                index++;
                
            }

        return -1;
    }


    public class ListNode implements PubliclyCloneable{

        private T data;
        private ListNode link;

        public ListNode(){

            this.data = null;
            this.link = null;

        }

        public ListNode(T data,ListNode link){

            this.data = data;
            this.link = link;

        }

        public ListNode(ListNode link){
            this.data = (T) data.clone();
            this.link = null;
        }

        public Object clone(){ return new ListNode(this);}



        public String toString(){

            return data.toString();

        }

        public ListNode getLink() {
            return link;
        }

        public void setLink(ListNode link) {
            this.link = link;
        }

    
    }


    /**
     * @param args
     */
    public static void main(String args[]){

        
    LinkedList<Temp > linkedList = new LinkedList<>();

    Temp temp = new Temp(122,15);
    Temp temp1= new Temp(122,15);

    linkedList.add(new Temp(12,15));
    linkedList.add(new Temp(1,15));
    linkedList.add(new Temp(2,15));
    linkedList.add(new Temp(122,15));
    linkedList.add(new Temp(162,15));

    linkedList.recursivePrint(linkedList.head);

    int res = linkedList.recursiveSearch(linkedList.head, temp);
    int res1 = linkedList.indexOf(temp);
    
    System.out.println(res);

    System.out.println(temp.equals(temp1));


    LinkedList<> linkedList2 = new LinkedList<>();

    }


}

class Temp implements PubliclyCloneable{

    private int x, y ;

    public Temp (int x, int y)  {
        this.x = x;
        this.y = y;
    }

    public Temp (Temp other){

        this.x = other.x;
        this.y = other.y;
    }

    public Object clone(){
        return new Temp(this);
    }

    public String toString(){
        return ""+x+" "+y;
    }

    public boolean equals(Object other){

        if(other == null) return false;

        if(this.getClass() != other.getClass()) return false;

        Temp temp = (Temp)other;

        return this.x == temp.x && this.y == temp.y;

    }

    public boolean equals(Temp temp){

        if(temp == null) return false;

        System.out.println(" fmfmfm");

        return this.x == temp.x && this.y == temp.y;

    }



}