package linkedList;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/7/10-22:45
 * 双链表设计,这里链表初始化还是只有一个head
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 */
public class leetCode707_2 {
    @Test
    public void Test(){
        MyLinkedList linkedList=new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(5);

    }
    class Node{
        int data;
        Node prev;
        Node next;
        Node(){}
        Node(int data){this.data=data;}
        Node(int data,Node prev,Node next){this.data=data;this.prev=prev;this.next=next;}

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
            if(index<0 || index>=length) return -1;
            Node cur=head.next;
            for(int i=index;i>0;i--){
                cur=cur.next;
            }
            return cur.data;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node newNode=new Node(val);
            if(length==0){
                newNode.prev=head;
                head.next=newNode;
                length++;
            }else {
                newNode.prev=head;
                newNode.next=head.next;
                head.next.prev=newNode;
                head.next=newNode;
                length++;
            }

        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node newNode=new Node(val);
            Node cur=head.next;
            if(cur!=null){
                while(cur.next!=null){
                    cur=cur.next;
                }

                cur.next=newNode;   //尾插就两步
                newNode.prev=cur;
            }else {
                newNode.prev=head;
                head.next=newNode;
            }
            length++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index>length) return;
            else if(index<=0) addAtHead(val);
            else if(index==length) addAtTail(val);
            else {
                Node newNode=new Node(val);
                Node cur=head.next;
                for(int i=index;i>0;i--){
                    cur=cur.next;
                }
                newNode.prev=cur.prev;
                newNode.next=cur;
                cur.prev.next=newNode;
                cur.prev=newNode;

                length++;
            }

        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
//            if(length==0) return;
            if(index<0 ||index>=length) return;
            Node cur=head.next;
            for(int i=index;i>0;i--){
                cur=cur.next;
            }
            if(cur.next==null){  //说明是删除末尾的
                cur.prev.next=null;
                
            }else {                 //删中间
                cur.prev.next=cur.next;
                cur.next.prev=cur.prev;
            }
            length--;
        }
    }
}
