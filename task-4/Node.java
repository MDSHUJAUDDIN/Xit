class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Node {
    public static ListNode moveZerosToEnd(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode tail = head;

        while (current != null) {
            if (current.val != 0) {
                tail.val = current.val;
                tail = tail.next;
            }
            current = current.next;
        }

        // Append zeros to the end
        while (tail != null) {
            tail.val = 0;
            tail = tail.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        head = moveZerosToEnd(head);

        System.out.println("After moving zeros to end:");
        printLinkedList(head);
    }
}

