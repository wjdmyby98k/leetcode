package linkedList;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/7/10-19:43
 * 单链表设计
 */
public class leetCode707 {
    @Test
    public void Test(){
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.length);
    }
    //先定义结点node
    class Node {
        int data;
        Node next;
        Node(){}
        Node(int data){this.data=data;}
        Node(int data,Node next){this.data=data;this.next=next;}
    }
    class MyLinkedList {
        Node head;
        int length;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            this.head=new Node(-1);
            this.length=0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(length==0) return -1;
            if(index>=length||index<0) return -1;
            Node cur=head.next;
            while(index>0){
                cur=cur.next;
                index--;
            }
            return cur.data;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node newNode =new Node(val);
            newNode.next=head.next;
            head.next=newNode;
            length++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node cur=head.next;
            if(cur!=null){
                while (cur.next!=null) {
                    cur=cur.next;
                }
                Node newNode=new Node(val);
                cur.next=newNode;
                length++;
            }else{
                Node newNode=new Node(val);
                head.next=newNode;
                length++;
            }

        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index>length) return;
            if(index<0) addAtHead(val);
            if(index==length) addAtTail(val);
            else {
                Node newNode=new Node(val);
                Node cur =head;
                while(index>0){
                    cur=cur.next;
                    index--;
                }
                newNode.next=cur.next;
                cur.next=newNode;
                length++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index<0 || index>=length) return;
            Node cur=head;
            while(index>0){
                cur=cur.next;
                index--;
            }
            cur.next=cur.next.next;
            length--;
        }
    }
}
