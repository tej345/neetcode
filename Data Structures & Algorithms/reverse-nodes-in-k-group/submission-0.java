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
        if(head == null || k == 1) return head;

        ListNode check = head;

        for(int i = 0; i < k; i++){
            if(check == null) return head;
            check = check.next;
        }

        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        while(count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(head != null){
            head.next = reverseKGroup(next,k);
        }

        return prev;
    }
}
