package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/11-14:57
 * 双链表，一个伪头一个伪尾
 */
public class leetCode707_3 {
    class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }
    class MyLinkedList {
        int size;
        Node head;
        Node tail;

        /** Initialize your data structure here. */
        public MyLinkedList(){
            this.size=0;
            this.head=new Node(0);
            this.tail=new Node(0);
            this.head.next=this.tail;
            this.tail.prev=this.head;
        }


        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index<0||index>=size) return -1;
            Node cur=null;
            if(index+1<size-index){    //near head
                cur=head;
                for(int i=0;i<index+1;i++){
                    cur= cur.next;
                }
            }else {                   //near tail
                cur=tail;
                for(int i=0;i<size-index;i++){
                    cur=cur.prev;
                }
            }
            return cur.data;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node newNode=new Node(val);
            Node pred=head;
            Node succ=head.next;

            newNode.next=succ;
            newNode.prev=pred;
            pred.next=newNode;
            succ.prev=newNode;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node newNode=new Node(val);
            Node pred=tail.prev;
            Node succ=tail;

            newNode.next=succ;
            newNode.prev=pred;
            pred.next=newNode;
            succ.prev=newNode;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index>size) return;
            else if(index<0) {
                addAtHead(val);
                return;
            }else {
                Node cur=null;
                Node newNode=new Node(val);
                if(index+1<size-index){   //near head
                    cur=head;
                    for(int i=0;i<index+1;i++){
                        cur=cur.next;
                    }
                }else {                  //near tail
                    cur=tail;
                    for(int i=0;i<size-index;i++){
                        cur=cur.prev;
                    }
                }
                //在cur之前插入
                Node pred=cur.prev;
                Node succ=cur;
                newNode.prev=pred;
                newNode.next=succ;
                pred.next=newNode;
                succ.prev=newNode;
                size++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index<0 || index>=size) return;
            Node cur=null;
            if(index+1<size-index){   //near head
                cur=head;
                for(int i=0;i<index+1;i++){
                    cur=cur.next;
                }
            }else {                  //near tail
                cur=tail;
                for(int i=0;i<size-index;i++){
                    cur=cur.prev;
                }
            }
            //delete cur

            cur.prev.next=cur.next;
            cur.next.prev=cur.prev;
            size--;

        }
    }
}
