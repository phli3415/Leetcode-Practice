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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        PriorityQueue <ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode node: lists){
            if(node!= null){
                queue.add(node);
            }
            
        }
        while (!queue.isEmpty()){
            ListNode smallest= queue.poll();
            if(smallest.next != null){
                queue.add(smallest.next);
            }
            cur.next = smallest;
            cur = cur.next;
        
        }
        return dummy.next;
    }
}