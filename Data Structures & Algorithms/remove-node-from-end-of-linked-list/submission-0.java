class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode six = new ListNode(0);
        six.next=head;

        ListNode slow = six;
        ListNode fast = six;

        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return six.next;

    }
}
