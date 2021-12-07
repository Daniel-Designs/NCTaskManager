package mx.edu.j2se.morales.tasks;

public class LinkedTaskList {
    public class Node{
        Task taskInNode;
        Node next;

        public Node() {
            super();
        }

        public Node(Task taskInNode) {
            this.taskInNode = taskInNode;
            next = null;
        }

    }

    Node head;

    public LinkedTaskList() {
        this.head = null;
    }

    public LinkedTaskList(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add (Task task) throws IllegalArgumentException{
        if (task == null)
            throw new IllegalArgumentException("Parameter shoul not be null ");
        Node newNode = new Node (task);

        if(getHead() == null){
            setHead(newNode);
        }else{
            Node aux = getHead();

            while(aux.next != null)
                aux = aux.next;

            aux.next = newNode ;
        }
        //System.out.println("added at the end");
    }

    public boolean remove (Task task)throws IllegalArgumentException {
        if (task == null)
            throw new IllegalArgumentException("Parameter shuold not be null");

        boolean flag = false;
        Node current = getHead();
        Node prev = getHead();

            while (current != null){
                if(current.taskInNode.equals(task)){
                    if(current.taskInNode.equals(getHead().taskInNode)){
                        setHead(getHead().next);
                    } else{
                      prev.next = current.next;
                    }
                    flag = true;
                }
                prev = current;
                current = prev.next;
            }
        return flag;
    }

    public int size (){
        int count = 0;
        Node aux = getHead();

        if(getHead() != null){
        count++;
        while (aux.next != null){
            count++;
            aux = aux.next;
            }
        }


        return count;
    }

   public Task getTask(int index) throws IndexOutOfBoundsException{
        if(index >= size())
            throw new IndexOutOfBoundsException(Integer.toString(index)+":  exced the bounds");

       Node aux = getHead();

       if(getHead() != null){
          for(int i=0;i<index;i++){
              aux = aux.next;
          }
       }
       return aux.taskInNode;
    }

    public void toPrint(){
        Node aux = getHead();
        while (aux != null){
            System.out.println(aux.taskInNode.getTitle());
            aux = aux.next;
        }
        }
    public LinkedTaskList incoming (int from,int to){

        if(from < 0 || to < 0 || from > to)
            throw new IllegalArgumentException("Parameter for calculation should not be negative");

        LinkedTaskList newLinkedTaskList = new LinkedTaskList(null);
        Node aux = getHead();

        if(getHead() != null){

            while (aux.next != null){

                if(aux.taskInNode.nextTimeAfter(from) != -1 && aux.taskInNode.nextTimeAfter(from) < to )
                    newLinkedTaskList.add(aux.taskInNode);

                aux = aux.next;
            }
        }
     return newLinkedTaskList;
    }
}
