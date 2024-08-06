# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        length = self.findLength(head)

        if length == n:
            return head.next

        temp = head
        for i in range(length - n - 1):
            temp = temp.next
        
        temp.next = temp.next.next
        return head



    def findLength(self, head: Optional[ListNode]) -> int:
        count = 0
        temp = head
        while temp:
            count += 1
            temp = temp.next
        return count
        