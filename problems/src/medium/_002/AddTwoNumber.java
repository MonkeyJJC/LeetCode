package medium._002;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overFlow = 0;
        ListNode rs = new ListNode(0);
        ListNode pre = rs;
        while (l1 != null || l2 != null || overFlow != 0) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + overFlow;
            overFlow = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum%10 : sum;
            ListNode temp = new ListNode(sum);
            pre.next = temp;
            pre = pre.next;
        }
        return rs.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        ListNode result = new AddTwoNumber().addTwoNumbers(l1, l4);
        do {
            System.out.println(result.val);
            result = result.next;
        } while (null != result);
    }
}
