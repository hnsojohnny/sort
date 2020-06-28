package com.company;

import com.company.node.Node;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        quitSort();
    }

    /**
     * 链表翻转
     */
    private static void flipLinkedList(){
        Node head = new Node();
        Node next;
        Node cur = null;
        for (int i = 1;i<10;i++){
            next = new Node(i);
            if (i == 1){
                head.next = next;
            }else {
                cur.next = next;
            }
            cur = next;
        }
        Node node = Utils.flipLinkedList(head);
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     * 部分链表翻转
     */
    private static void flipSectionLinkedList(){
        Node head = new Node();
        Node next;
        Node cur = null;
        for (int i = 1;i<9;i++){
            next = new Node(i);
            if (i == 1){
                head.next = next;
            }else {
                cur.next = next;
            }
            cur = next;
        }
        Node node = Utils.nodereverseKGroup(head, 2);
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static void isValidString(){
        String s = "{{}[]}";
        System.out.println(Utils.isValidString(s));
    }

    private static void getDaysTemperature(){
        int[] str = new int[]{23, 24, 25, 21, 19, 22, 26, 23};
        int[] emps = Utils.getDaysTemperature(str);
        for (int i = 0; i < emps.length; i++){
            System.out.println(emps[i]);
        }
    }

    private static void maxSlidingWindow(){
        int[] s = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> t = Utils.maxSlidingWindow(s, 3);
        for (int i = 0;i < t.size(); i++){
            System.out.println(t.get(i));
        }
    }

    private static void topKFrequent(){
        String[] name = new String[]{"1", "2", "2", "3", "4", "5", "5", "2", "3"};
        List<String> list = Utils.topKFrequent(name, 3);
        for (String s: list){
            System.out.println(s);
        }
    }

    private static void maopao(){
        int[] s = new int[]{8,6,3,5,3,2,9};
        Utils.maopao(s);
        for (int i = 0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }

    private static void insert(){
        int[] s = new int[]{8,6,5,3,2,9,4};
        Utils.insert(s);
        for (int i = 0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }

    private static void insertLinked(){
        Node head = new Node();
        Node next;
        Node cur = null;
        for (int i = 10;i>0;i--){
            next = new Node(i);
            if (i == 10){
                head.next = next;
            }else {
                cur.next = next;
            }
            cur = next;
        }
        Node node = Utils.insertLinked(head);
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static void guibing(){
        Utils.guibing();
    }

    private static void selectSort(){
        int[] s = new int[]{8,6,5,3,2,9,4};
        Utils.selectSort(s);
        System.out.println(Arrays.toString(s));
    }

    private static void quitSort(){
        int[] s = new int[]{8,6,5,3,2,9,4};
        Utils.quitSort(s, 0, s.length -1);
        System.out.println(Arrays.toString(s));
    }
}
