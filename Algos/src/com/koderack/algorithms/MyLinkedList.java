package com.koderack.algorithms;


import java.util.Objects;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author pranay
 */
public class MyLinkedList<T> {
    LLNode<T> head;
    
    public MyLinkedList(LLNode<T> head){
        this.head = head;
    }
    
    public MyLinkedList(){
        head = null;
    }
    
    public boolean add(LLNode<T> node){
        if(head == null){
            head = node;
            return true;
        }
        else{
            node.next = head;
            head = node;
            return true;
        }
    }
    
    public boolean remove(LLNode<T> node){
        if(head == null){
            System.out.println("The list is empty...removal of false node requested");
            return false;
        }
        if(head.equals(node)){
            System.out.println("removing head..." + head.item.toString());
            head = head.next;
            return true;
        }
        else{
            LLNode<T> previousNode,currentNode;
            previousNode = currentNode = head;
            
            while(currentNode != null && !currentNode.equals(node)){
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            if(currentNode == null){
                System.out.println("Node requested not found...");
                return false; // couldn't find the node
            }
            else{
                System.out.println("removing node..." + node.item.toString());
                previousNode.next = currentNode.next;
             return true;   
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder list;
        list = new StringBuilder();
        
        if(head != null){
            LLNode<T> node = head;
            while(node != null){
                list.append(" ").append(node.item.toString());
                node = node.next;
            }
        }
        return list.toString();
    }
}
class LLNode<T> {
    T item;
    LLNode<T> next;
    
    public LLNode() {
        item = null;
        next = null;
    }
    
    public LLNode(T item){
        this.item = item;
        next = null;
    }
    
    @Override
    public boolean equals(Object o){
        boolean result = false;
        if(o instanceof LLNode){
            LLNode node = (LLNode)o;
            result = this.item.equals(node.item);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.item);
        hash = 29 * hash + Objects.hashCode(this.next);
        return hash;
    }
}

class DemoMyLinkedList{
    public static void main(String[] args){
        MyLinkedList<Student> list = new MyLinkedList<>();
        // try to delete from an empty list
        list.remove(new LLNode<>(new Student("Golu", 2)));
        
        list.add(new LLNode<>(new Student("Juhi", 3)));
        list.add(new LLNode<>(new Student("Ashu", 1)));
        list.add(new LLNode<>(new Student("Golu", 2)));
        
        //list.remove(new LLNode<>(new Student("Golu", 2)));
        //list.remove(new LLNode<>(new Student("Juhi", 3)));
        
        //try removing a non-existent node
        list.remove(new LLNode<>(new Student("Ashu", 4)));
        list.remove(new LLNode<>(new Student("Ashu", 1)));
        
        System.out.println(list.toString());
    }
}
