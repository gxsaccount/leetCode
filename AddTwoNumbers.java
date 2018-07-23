//https://leetcode.com/problems/add-two-numbers/description/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1),p1=l1, p2= l2,p=head;
        int carry=0;
        while(p1!=null||p2!=null||carry!=0){
            int sum=0;
            if(p1!=null){
                sum+=p1.val;
                p1=p1.next;
            }
            if(p2!=null){
                sum+=p2.val;
                p2=p2.next;
            }
            sum+=carry;
            if(sum>=10){
                carry=1;
                sum-=10;
            }
            else{
                carry=0;
            }
            p.next=new ListNode(sum);
            p=p.next;
        }
        return head.next;
    }
}
