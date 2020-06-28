package com.company.node;

public class ListNode implements LinkList{

    Node head = new Node();
    Node tail;
    int size;

    public ListNode() {
        tail = head;
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public boolean check(int index){
        if (index < 0 || index > size){
            return false;
        }
        return true;
    }

    @Override
    public void add(int e) {
        Node node = new Node(e);
        tail.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public void insert(int e, int index) {
        if (!check(index)){
            return;
        }
        Node currntHead = head.next;
        for (int i = 0;i<index;i++){
            currntHead = currntHead.next;
        }
        Node node = new Node(e);
        if (index == 0){
            head.next = null;
            node.next = currntHead;
            head.next = node;
        }else {
            Node pre = head.next;
            for (int i = 0;i<index -1;i++){
                pre = pre.next;
            }
            pre.next = null;
            pre.next = node;
            node.next = currntHead;
        }
        size++;
    }

    @Override
    public void delete(int index) {
        if (!check(index)){
            return;
        }
        Node currentNode = head.next;
        for (int i = 0;i<index;i++){
            currentNode = currentNode.next;
        }
        if (index == 0){
            head.next = null;
            head.next = currentNode.next;
            currentNode.next = null;
        }else {
            Node pre = head.next;
            for (int i = 0;i<index -1;i++){
                pre = pre.next;
            }
            pre.next = null;
            pre.next = currentNode.next;
            currentNode.next = null;
        }
        size--;
    }

    @Override
    public int get(int index) {
        if (!check(index)){
            return 0;
        }
        Node currentNode = head.next;
        for (int i = 0;i<index;i++){
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public int getSize() {
        return size;
    }
}
