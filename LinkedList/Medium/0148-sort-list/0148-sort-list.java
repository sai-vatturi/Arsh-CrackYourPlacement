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
    public ListNode sortList(ListNode head) {
        int count=0;
		ListNode temp=head;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		int arr[]=new int[count];
		temp=head;
		int pos=0;
		while(temp!=null) {
			arr[pos++]=temp.val;
			temp=temp.next;
		}
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		temp=head;
		pos=0;
		while(temp!=null) {
			temp.val=arr[pos];
			pos++;
			temp=temp.next;
		}
		return head;
    }
}