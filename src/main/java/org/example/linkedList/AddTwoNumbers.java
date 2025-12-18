package org.example.linkedList;

public class AddTwoNumbers {
    int carry=0;

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode cur = start;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode data = getNode(sum);
            cur.next = data;
            cur = data;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            ListNode data = getNode(sum);
            cur.next = data;
            cur = data;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            ListNode data = getNode(sum);
            cur.next = data;
            cur = data;
            l2 = l2.next;
        }

        if (carry > 0) {
            ListNode data = new ListNode(carry);
            cur.next = data;
        }
        return start.next;
    }

    private ListNode getNode(int sum) {
        ListNode data;
        if (sum > 9) {
            carry = 1;
            data = new ListNode(sum % 10);
        } else {
            carry = 0;
            data = new ListNode(sum);
        }
        return data;
    }

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode l1 = obj.new ListNode(2);
        l1.next = obj.new ListNode(4);
        l1.next.next = obj.new ListNode(3);

        ListNode l2 = obj.new ListNode(5);
        l2.next = obj.new ListNode(6);
        l2.next.next = obj.new ListNode(4);

        ListNode result = obj.addTwoNumbers(l1,l2);
        System.out.println(result);
    }
}
