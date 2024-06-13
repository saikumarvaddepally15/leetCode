/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode knode=findkthNode(temp,k);
            if(knode==null){
                if(prev!=null){
                    prev.next=temp;
                }
                break;
            }
            ListNode nextNode=knode.next;
            knode.next=null;
            reverseLinkedList(temp);
            if(temp==head){
                head=knode;
            }else{
                prev.next=knode;
            }
            prev=temp;
            temp=nextNode;
        }
        return head;
    }
    static ListNode findkthNode(ListNode temp,int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    static ListNode reverseLinkedList(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}