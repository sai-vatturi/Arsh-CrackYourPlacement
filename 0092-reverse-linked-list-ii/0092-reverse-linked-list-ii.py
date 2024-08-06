# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def reverseBetween(self, head, left, right):
        """
        :type head: ListNode
        :type left: int
        :type right: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head

        orgHead = dummy
        subHead = head

        for _ in range(left - 1):
            orgHead = orgHead.next
            subHead = subHead.next
        
        current = subHead
        prev = None
        next = None

        for _ in range(right - left + 1):
            next = current.next
            current.next = prev
            prev = current
            current = next
        
        orgHead.next = prev
        subHead.next = current

        return dummy.next