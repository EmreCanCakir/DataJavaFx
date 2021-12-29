package com.company.model;

public class BaseDataSet {
    Element head; //head of list
    Element tail; //tail of list
    public int size;

    //Constructor
    public BaseDataSet() {
        head = null;
        tail = null;
        size = 0;
    }

    //Check list is empty or not
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    //This function first builds new element with the given data
    public void insert(double value) {
        //Write your codes here
        Element element = new Element(value);
        if (isEmpty() == true) {
            head = element;
            tail = element;
        } else {            /** If user wants to insert element to tail */
            tail.next = element;
            element.previous = tail.next;
            tail = element;
        }
        size++;
    }

    public void insertStart(double value) {
        Element element = new Element(value);
        if (head == null) {
            head = element;
            tail = head;
        } else {
            head.previous = element;
            element.next = head;
            head = element;
        }
        size++;
    }

    // overload this method as new nodes are added to given position (int pos)
    public void insert(double value, int pos) {
        Element element = new Element(value);

        Element pointer = head;

        if (pos == 0) {
            insertStart(value);
            return;
        } else {
            for (int i = 1; i <= size; i++) {
                if (i == pos) {
                    Element temp = pointer.next;
                    pointer.next = element;
                    element.previous = pointer;
                    element.next = temp;
                    temp.previous = element;
                }
                pointer = pointer.next;
            }
            size++;
        }
    }

    //This method finds how many elements are exist in LinkedList
    public int size() {
        return size;
    }


    // This functions delete a node in the LinkedList by a given position
    public Element deleteByPosition(int pos) {
        Element element = head;
        if (pos == 0) {      /** If user wants to delete the first element, this if is run */
            head = head.next;
            head.previous = null;
            size--;
            return element;
        } else if (pos == size) {   /** If user wants to delete the last element, this if is run */
            Element previous = tail.previous;
            if (previous != null) {
                previous.next = null;
            }
            tail.previous = null;
            tail = previous;
            size--;
            return previous;
        } else {       /** If user wants to delete another element, this if is run */
            for (int i = 0; i < size; i++) {
                if (i == pos) {
                    Element previous = element.previous;
                    Element next = element.next;
                    previous.next = next;
                    next.previous = previous;
                    size--;
                    break;
                }
                element = element.next;

            }
            return element;
        }
    }

    //This function get the node in the given index
    public Element getByPosition(int pos) {
        if (this.isEmpty())
            return new Element(0);
        Element current = this.head;
        int index = 0;

        while (current != null) {
            if (index++ == pos)
                break;
            current = current.next;
        }

        if (current == null)
            return new Element(0);

        return current;
    }

    // This function prints  the LinkedList
    public void print() {

        if (this.isEmpty())
            return;
        Element element = this.head;  // make a copy of head
        int index = 1;

        // never operate on "head", otherwise you will lost the linkedlist
        //unless you want to change "head"
        while (element != null) {
            System.out.println(index++ + ". " + element.getValue());

            element = element.next;  // iterate to next node
        }

    }
    //This methot provide to find max element
    public void findMaximum(){
        Element current = this.head;
        double maximum = 0;
        while(current.next!=null){
            if(current.getValue()>maximum){
                maximum=current.getValue();
            }
            current=current.next;
        }
        System.out.println(maximum);
    }

}