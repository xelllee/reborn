package com.xelllee.test;


import com.xelllee.code.leetcode.btree.TreeNode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.TimeZone;

public class SimpleTest {

    public static void main(String[] args) {


    }


    public static String roundToMin(String s) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = simpleDateFormat.parse(s);
            return simpleDateFormat2.format(date);
        } catch (ParseException e) {
            return "";
        }


    }


    public static void printTree(Stack<TreeNode> stack){


        Stack<TreeNode> stacknew = new Stack<TreeNode>();

        while(!stack.isEmpty())  {

            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.left != null){
                stacknew.push(node.left);
            }
            if(node.right != null){
                stacknew.push(node.right);
            }
        }
        if(!stacknew.isEmpty())    {
            printTree(stacknew);
        }

    }



}
