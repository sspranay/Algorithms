package com.koderack.algorithms;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pranay pramod
 */
public class BST {

    private BSTNode root;
    
    static List<int[]> list = new LinkedList<>();

    public BST(BSTNode root) {
        this.root = root;
    }

    public BSTNode addNode(BSTNode root, BSTNode node) {
        if (root == null) {
            root = node;
        } else if(node.key < root.key){
            root.left = addNode(root.left, node);
        }
        else if(node.key > root.key){
            root.right = addNode(root.right, node);
        }
        return root;
    }
    
    public void levelOrder(BSTNode root){
        if(root == null)
            return;
        
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            BSTNode node = queue.remove();
            System.out.println(node.key);
            
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
    }
    
    public boolean isSymmetric(BSTNode root){
        if(root == null || (root.left == null && root.right == null))
            return true;
        else if( (root.left == null && root.right != null) || (root.left != null && root.right == null)){
           return false;
        }
        else //(root.left !=null && root.right !=null){
            return isSymmetric(root.left) && isSymmetric(root.right);
    }
    
    public BSTNode findLowestCommonAncestor(BSTNode root, BSTNode node1, BSTNode node2){
        if(node1.key < root.key && node2.key < root.key)
            return findLowestCommonAncestor(root.left, node1, node2);
        else if(node1.key > root.key && node2.key > root.key)
            return findLowestCommonAncestor(root.right, node1, node2);
        else if(node1.key < root.key && node2.key > root.key)
            return root;
        else 
            return null;
    }
    
    public int getHeight(BSTNode root){
        if(root == null)
            return -1;
        else{
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }
    
    public void prettyPrint(int[] arr, int len){
        int[] temp = new int[len];
        System.out.println();
        for (int i=0; i< len; i++){
            System.out.print(arr[i] + " ");
            temp[i] = arr[i];
        }
        list.add(arr);
    }
    
    public void printPaths(BSTNode root, int path[], int pathLength){
        if(root == null)
            return;
        //otherwise append to the path
        path[pathLength++] = root.key;
        
        // if leaf found, print path
        if(root.left == null && root.right == null){
            prettyPrint(path, pathLength);
        }
        else{
            printPaths(root.left, path, pathLength);
            printPaths(root.right, path, pathLength);
        }
    }
    
    public int nodesCount(BSTNode root){
        if(root == null)
            return 0;
        
        return 1 + nodesCount(root.left) + nodesCount(root.right);
    }
    
    public BSTNode min(BSTNode root){
        if(root == null)
            return null;
        else{
            while(root.left != null){
                root = root.left;
            }
            return root;
        }
    }
    
    public BSTNode successor(BSTNode root, BSTNode node){
        if(node.right != null)
            return min(node.right);
        else{// climb upto until successor found
            BSTNode successor = root;
            while(root != null){
                if(node.key < root.key){ //keep going left until hit with right turn
                    successor = root;
                    root = root.left;
                }
                else if(node.key > root.key){ // right turn and thus no need to update the successor
                    root = root.right;
                }
                else// node found
                    break;
                    
            }
            return successor;
        }
    }
    
    /**
     * Recursive traversal
     * @param root 
     */
    public void inorderRecurisve(BSTNode root){
        if(root == null)
            return;
        
        inorderRecurisve(root.left);
        System.out.print(" " + root.key);
        inorderRecurisve(root.right);
    }
    
    public void preOrderRecursive(BSTNode root){
        if(root == null)
            return;
        
        System.out.print(" " + root.key);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
    
    public void preOrderIterative(BSTNode root){
        Stack<BSTNode> stack = new Stack<>();
        BSTNode node = root;
        
        while(!stack.isEmpty() || node != null){
            if(node != null){
                System.out.print(" " + node.key);
                if(node.right != null)
                    stack.push(node.right);
                node = node.left;
            }
            else{
                node = stack.pop();
            }
        }
    }
    
    public void inorderIterative(BSTNode root){
        Stack<BSTNode> stack = new Stack<>();
        BSTNode node = root;
        
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                System.out.print(" " + node.key);
                node = node.right;
            }
        }
    }
    
    public void BFS(BSTNode root){
        if(root == null)
            return;
        else{
            Queue<BSTNode> queue = new LinkedList<>();
            queue.add(root);
            
            while(!queue.isEmpty()){
                BSTNode node = queue.remove();
                System.out.print(" " + node.key);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
    }
}
class BSTNode {

    int key;
    BSTNode left;
    BSTNode right;

    public BSTNode(int key) {
        this.key = key;
        left = right = null;
    }
}

class DemoBST {
    public static void main(String[] args){
        
        BSTNode root = new BSTNode(10);
        BST bst = new BST(root);
        
        bst.addNode(root, new BSTNode(5));
        bst.addNode(root, new BSTNode(15));
        bst.addNode(root, new BSTNode(2));
        bst.addNode(root, new BSTNode(7));
        bst.addNode(root, new BSTNode(12));
        bst.addNode(root, new BSTNode(20));
        //bst.addNode(root, new BSTNode(6));
        //bst.addNode(root, new BSTNode(9));
        //bst.addNode(root, new BSTNode(20));
        //bst.addNode(root, new BSTNode(18));
        //bst.addNode(root, new BSTNode(17));
        
        
        //bst.inorderRecurisve(root);
        //bst.inorderIterative(root);
        //bst.preOrderRecursive(root);
        //bst.preOrderIterative(root);
        //bst.BFS(root);
        
        //BSTNode minNode = bst.min(root);
        //System.out.println(minNode.key);
        
        //BSTNode successorNode = bst.successor(root, root.left.right.right);
        //System.out.println(successorNode.key);
        
        //System.out.println(bst.getHeight(root));
        //System.out.println(bst.nodesCount(root));
        
        //int[] path = new int[100];
        //bst.printPaths(root, path,0);
        
        //bst.levelOrder(root);
        System.out.println(bst.isSymmetric(root));
        System.out.println();
    }
}
