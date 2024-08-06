"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        # create a clone list with next pointers
        temp = head
        dummy = ListNode(0)
        curr = dummy

        while temp is not None:
            curr.next = ListNode(temp.val)
            curr = curr.next
            temp = temp.next
        
        # set random pointers using distance
        temp = head
        curr = dummy.next

        while temp is not None:
            if temp.random is None:
                curr.random = None
            else:
                temp_curr = head
                curr_rand = dummy.next
                count = 0
                
                while temp_curr is not None and temp_curr != temp.random:
                    temp_curr = temp_curr.next
                    count += 1
                
                for _ in range(count):
                    curr_rand = curr_rand.next
                
                curr.random = curr_rand

            temp = temp.next
            curr = curr.next
        
        return dummy.next