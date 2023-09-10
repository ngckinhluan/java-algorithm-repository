/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 * This is some of my codes contributing to the subject CSD201 practice
 * exercises.
 *
 * @author nkluan
 */
public class SinglyLinkedList {

    /**
     * @param args the command line arguments
     */
    private ListNode head; //We just need head in singly linked list because
    //the tail of this list will point to null.

    public SinglyLinkedList() {
        head = null;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public static class ListNode {

        private int data;       //This attributes are set private because it hides internal details of
        //a class and only expose only the necessary information - Encapsulation.
        private ListNode next;

        //Constructor to get parameteres which are passed by test cases.
        public ListNode(int data) {
            this.data = data;
            this.next = null; //Point to null because the last reference of singly linked list 
            //will point to null to indicate the end of list.
        }

    }

    /**
     * Inserts a new node with the given value at the beginning of the list.
     *
     * @param value
     */
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Inserts a new node after the given node.
     *
     * @param position
     * @param value
     */
    public void insertAfter(int position, int value) {

        //Create a new node
        ListNode node = new ListNode(value);
        //Position cannot be negative
        if (position < 1) {
            System.err.println("Invalid Position!!!");
            return;
        }

        //If position is 1 then the new node is set in front of head node.
        //Thus, we have to change the head node forward 1 position.
        if (position == 1) {
            node.next = head;
            head = node;
            return;
        }

        ListNode previous = head;
        for (int i = 1; previous != null && i < position - 1; i++) {
            previous = previous.next;

        }

        //Check if it out of bounds
        if (previous != null || previous.next == null) {
            System.err.println("Out of bounds!!!");
            return;
        }

        node.next = previous.next;
        previous.next = node;

    }

    /**
     * Delete a node at a given position.
     *
     * @param position
     */
    public void delete(int position) {
        //Position is valid and starting from 1
        //3 -> 4 -> 7 -> 8 -> 9 -> null

        //Check if the list is empty
        if (head == null) {
            System.err.println("The list is empty. Nothing to print out!!!"); // I use System.err instead because it will print the red messages in the output
            // which I think it would be cool!!!.
            return;
        }

        //Special case: If the position is 1 (first node)
        if (position == 1) {
            head = head.next;
            return;
        }
        ListNode previous = head; //Create a temporary previous node in order to keep track of the list

        // Traverse the list to find the node just before the one to be deleted.  
        for (int i = 1; previous != null && i < position - 1; i++) {
            previous = previous.next;
        }

        //Check if it is out of bounds.
        if (previous == null || previous.next == null) {
            System.err.println("Out of bound!!!");
            return;
        }

        previous.next = previous.next.next;
    }

    public void insertLast(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            return;
        }
        ListNode current = head;
        //Traverse to the end of the list to find the last node
        while (current.next != null) {
            current = current.next;
        }
        //Set the last node of the list to the new node.
        current.next = node;
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(" null");
        System.out.println();
    }

    /**
     * Traverse a list
     */
    public void traverse() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); //Print a newline to separate output from the program
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        head = head.next;
        return head;

    }

    public ListNode deleteLast() {
        //Check if the list is empty
        if (head == null) {
            return null;
        }

        //Check if the list contains only 1 node
        if (head.next == null) {
            return null;
        }

        ListNode secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        return head;

    }

    /**
     * Delete the first node whose info is equal to x
     *
     * @param x
     */
    public void deleteFirstNode(int x) {
        //Check if the list is empty
        if (head == null) {
            return;
        }

        if (head.data == x) {
            head = head.next;
            return;
        }
    }

    /**
     * Search and return the reference to the first node having info x
     *
     * @param x
     * @return
     */
    public ListNode search(int x) {
        ListNode current = head;
        while (current != null) {
            if (current.data == x) {
                return current; // Return the reference to the first node with data x
            }
            current = current.next;
        }
        return null; // Node with data x not found
    }

    /**
     * Count the number of nodes in list.
     *
     * @return
     */
    public int count() {
        if (head == null) {
            return 0; //If the list is empty, return 0 indicates there is not list
        }
        ListNode current = head;
        int count = 0; //Count = 0 because we want to assume that there is no node intially, then count up to 1, 2,3..
        //If we count from 1, we assume there is 1 node already so it's wrong
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void delete2(int x) {
        //Position is valid and starting from 1
        //3 -> 4 -> 7 -> 8 -> 9 -> null

        //Check if the list is empty
        if (head == null) {
            System.err.println("The list is empty. Nothing to print out!!!"); // I use System.err instead because it will print the red messages in the output
            // which I think it would be cool!!!.
            return;
        }

        //Special case: If the position is 1 (first node)
        if (x == 1) {
            head = head.next;
            return;
        }
        ListNode previous = head; //Create a temporary previous node in order to keep track of the list

        // Traverse the list to find the node just before the one to be deleted.  
        for (int i = 1; previous != null && i < x - 1; i++) {
            previous = previous.next;
        }

        //Check if it is out of bounds.
        if (previous == null || previous.next == null) {
            System.err.println("Out of bound!!!");
            return;
        }

        previous.next = previous.next.next;
    }

    public void remove(ListNode p) {
        if (head == null || p == null) {
            System.err.println("Nothing to remove!");
            return;
        }

        //Special case: If Node p is in the first node, shift it toward 1 node, and delete the node before.
        if (head == p) {
            head = head.next;
            return;

        }

        ListNode current = head;
        while (current != null && current != p) {
            current = current.next;
        }

        if (current == null) {
            System.err.println("Not found!");
            return;
        }

        current.next = current.next.next;
    }

    /**
     * Sort the list by ascending order of info.
     */
    public void sort() {
        // Node current will point to head, index will point to the next position of current
        ListNode current = head, index = null;
        int temp;
        // If the list is empty or has only one element, it is already sorted.
        if (head == null || head.next == null) {
            return;
        } else {
            // Node index will point to node next to
            // current
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList myLinkedList = new SinglyLinkedList();

        myLinkedList.insertLast(11);
        myLinkedList.insertLast(8);
        myLinkedList.insertLast(1);
        myLinkedList.insertLast(2);

        myLinkedList.display();

    }

}
