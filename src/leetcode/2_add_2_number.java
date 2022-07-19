package leetcode;

//* Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        int l1_cnt = 1;
        int l2_cnt = 1;
        int l1_res = 0, l2_res = 0;
        while (l1 != null) {
            l1_res = l1_res + l1.val * l1_cnt;
            l1_cnt = l1_cnt * 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            l2_res = l2_res + l2.val * l2_cnt;
            l2_cnt = l2_cnt * 10;
            l2 = l2.next;
        }

        int res_int = l1_res + l2_res;
        String res_string = String.valueOf(res_int);
        String[] res_array = res_string.split("");
        ListNode currentNode = new ListNode();
        for (int i = res_array.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(Integer.parseInt(res_array[i]));
            if (i == res_array.length - 1) {
                res = node;
            } else {
                currentNode = node;
                res.next = node;

            }

        }
        return res;

    }
}
