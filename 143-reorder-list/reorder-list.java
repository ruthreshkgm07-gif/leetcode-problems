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

    public void reorderList(ListNode head) {

        //find mid
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode curr = slow.next;

        slow.next = null; //adding null to left part end

        ListNode prev = null;
        ListNode next = null;

        //reverse right part
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //zigzag merge
        ListNode lh = head;
        ListNode rh = prev;
        ListNode nxtL, nxtR;

        while (lh != null && rh != null) {
            //zigzag
            nxtL = lh.next;
            lh.next = rh;

            nxtR = rh.next;
            rh.next = nxtL;

            //update
            rh = nxtR;
            lh = nxtL;
        }
    }
}