# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1 = 0
        l2 = 0
        
        temp1 = headA
        temp2 = headB

        while temp1:
            l1 += 1
            temp1 = temp1.next
        while temp2:
            l2 += 1
            temp2 = temp2.next
        
        difference = abs(l1 - l2)
        
        temp1 = headA
        temp2 = headB

        if l1 > l2:
            for _ in range(difference):
                temp1 = temp1.next
        else:
            for _ in range(difference):
                temp2 = temp2.next
        
        while temp1 is not None and temp2 is not None:
            if temp1 == temp2:
                return temp1
            temp1 = temp1.next
            temp2 = temp2.next
        
        return None