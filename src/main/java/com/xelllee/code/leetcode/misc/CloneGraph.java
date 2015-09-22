package com.xelllee.code.leetcode.misc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    /*
    *
     *  Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


        OJ's undirected graph serialization:
        Nodes are labeled uniquely.

        We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
        As an example, consider the serialized graph {0,1,2#1,2#2,2}.

        The graph has a total of three nodes, and therefore contains three parts as separated by #.

        First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
        Second node is labeled as 1. Connect node 1 to node 2.
        Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
        Visually, the graph looks like the following:

               1
              / \
             /   \
            0 --- 2
                 / \
                 \_/
    *
    * */

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }


    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        UndirectedGraphNode node = new UndirectedGraphNode(0);
        node.neighbors.add(node);
        node.neighbors.add(node);


        UndirectedGraphNode clone = cloneGraph(node);

    }


    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return cloneNode(node, map);
    }


    public static UndirectedGraphNode cloneNode(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {

        if (!map.containsKey(node.label)) {
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            map.put(clone.label, clone);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                clone.neighbors.add(cloneNode(neighbor, map));
            }

            return clone;
        } else return map.get(node.label);
    }


}
