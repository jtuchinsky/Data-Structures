package com.intertuma.algorithms.leetcode.week2;

import org.junit.Test;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            System.out.println(slow.val + ", " + fast.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next != null)
            return slow.next;
        else
            return slow;
    }

    @Test
    public void middleNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(middleNode(head).val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

