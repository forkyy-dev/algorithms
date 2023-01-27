package leetcode.easy;

import java.util.ArrayList;
import java.util.List;


public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return false;
        }

        ListNode temp = head;

        while (temp.next != null) {
            list.add(temp);
            if (list.contains(temp.next)) {
                return true;
            }
            temp = temp.next;
        }
        return false;

//        다른 유저의 풀이
//        ListNode slowPointer = head;
//        ListNode fastPointer = head;
//        while (fastPointer != null && fastPointer.next != null) {
//            slowPointer = slowPointer.next;
//            fastPointer = fastPointer.next.next;
//            if (slowPointer == fastPointer) {
//                return true;
//            }
//        }
//        return false;
    }
}