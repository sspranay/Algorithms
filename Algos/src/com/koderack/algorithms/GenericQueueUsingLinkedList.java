package com.koderack.algorithms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * This overrides and makes private the remove<node> method of LinkedList calls
 * and provides remove method
 *
 * @author pranay
 */
public class GenericQueueUsingLinkedList<T> {

    MyLinkedList<T> queue;
    
    public GenericQueueUsingLinkedList(){
        queue = new MyLinkedList<>();
    }
    public LLNode<T> dequeue() {
        if (queue.head == null) { // no elements
            System.out.println("Queue is empty");
            return null;
        } 
        else if(queue.head.next == null){ // only head present
            LLNode<T> tail = queue.head;
            System.out.println("returning tail node " + tail.item.toString());
            queue.head = null;
            return tail;
        }
        else {
            LLNode<T> node = queue.head;
            LLNode<T> previousToNode = queue.head;
            while(node.next != null){
                previousToNode = node;
                node = node.next;
            }
            LLNode<T> tail = node;
            System.out.println("returning tail node " + tail.item.toString());
            previousToNode.next = null; //freeing node
            return node;
        }
    }
    
    public void enqueue(LLNode<T> node){
        queue.add(node);
    }
}
class DemoQueueUsingLL {

    public static void main(String[] args) {
        GenericQueueUsingLinkedList<Student> queueLL = new GenericQueueUsingLinkedList<>();
        queueLL.dequeue();
        queueLL.enqueue(new LLNode(new Student("Billu1", 001)));
        queueLL.enqueue(new LLNode(new Student("Billu2", 002)));
        queueLL.enqueue(new LLNode(new Student("Billu3", 003)));
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.dequeue();
    }
}