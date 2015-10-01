package com.xelllee.code.leetcode.btree;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by xiao on 9/30/15.
 */
public class BinaryTree {

    public static Node prev = null;

    //recursively traverse the tree with
    //a stack of nodes (LIFO)
    public static void depthFirstSearch(Stack stack) {

        if (stack.isEmpty()) return;

        Node node = (Node) stack.pop();

        System.out.println("popping node: " + node);


        if (node.left != null) stack.push(node.left);
        if (node.right != null) stack.push(node.right);

        depthFirstSearch(stack);
    }

    //Recursively traverse the tree with
    //a queue of nodes (FIFO)
    public static void breadthFirstSearch(Queue queue) {

        if (queue.isEmpty()) return;

        Node node = (Node) queue.poll();

        System.out.println("polling node: " + node);


        if (node.left != null) queue.offer(node.left);

        if (node.right != null) queue.offer(node.right);
        breadthFirstSearch(queue);
    }


    public static void DFS(Stack<Node> stack) {

        if (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.println(n);

            if (n.left != null) {
                stack.push(n.left);
            }
            if (n.right != null) {
                stack.push(n.right);
            }
            DFS(stack);
        }

    }

    public static void BFS(Queue<Node> queue) {

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.println(n);
            if (n.left != null) queue.offer(n.left);
            if (n.right != null) queue.offer(n.right);
        }


    }


    public static void inOrder(Node node) {

        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.println(node);

        if (node.right != null) {
            inOrder(node.right);
        }

    }


    public static void main(String args[]) {

        //nodeA needs to be final to be accessed by
        //the anonymous inner classes below

        final Node nodeA = new Node("A");

        Node nodeB = new Node("B");

        Node nodeC = new Node("C");

        Node nodeD = new Node("D");

        Node nodeE = new Node("E");

        Node nodeF = new Node("F");

        Node nodeG = new Node("G");

        //build the tree

        nodeD.left = nodeE;

        nodeB.left = nodeC;

        nodeB.right = nodeD;

        nodeF.right = nodeG;

        nodeA.left = nodeB;

        nodeA.right = nodeF;


        //Do breadth first search

        System.out.println("***  Breadth First search *** ");

        Queue queue =
                new java.util.LinkedList() {{
                    offer(nodeA);
                }};

        breadthFirstSearch(queue);
//        BFS(queue);

        //Do depth first search

        System.out.println("***  Depth First search *** ");

        Stack stack = new Stack() {{
            push(nodeA);
        }};

        depthFirstSearch(stack);
//        DFS(stack);
    }

}

class Node {

    Node(String value) {
        this.value = value;
    }

    Node right;

    Node left;

    String value;

    public String toString() {
        return value;
    }
}
