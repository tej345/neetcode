class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carry = 0;
        while(l1!=null || l2!=null){
            int sum = carry;
            if(l1!=null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum = sum + l2.val;
                l2 = l2.next;
            }

            carry = sum/10;
            sum = sum%10;
            ListNode re = new ListNode(sum);
            curr.next = re;
            curr = curr.next;
        }
        if(carry == 1){
            ListNode ex = new ListNode(carry);
            curr.next = ex;
        }
        return res.next;
    }
}
