# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        prevNode = dummy
        temp = head
        
        while temp:
            kth = self.kthNode(temp, k)
            if kth is None:
                break
            nextNode = kth.next
            kth.next = None
            reversedHead, reversedTail = self.reverse(temp)
            prevNode.next = reversedHead
            reversedTail.next = nextNode
            prevNode = reversedTail
            temp = nextNode

        return dummy.next

    def kthNode(self, head, k):
        curr = head
        while k > 1 and curr:
            curr = curr.next
            k -= 1
        return curr

    def reverse(self, head):
        prev = None
        curr = head
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev, head  