import java.io.*;
import java.util.*;

class linkedlist {
    private class Node {
        private int data;
        private Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Reference
    private Node head;
    private Node tail;
    private int size;

    public linkedlist() {
        this.head = this.tail = null;
        this.size = 0;
    }

    private void handleAddWhenSize0(int val) {
        Node temp = new Node(val);
        this.head = temp;
        this.tail = temp;
        this.size++;
    }

    public void addFirst(int val) {
        // Node temp = new Node(val);
        // if(this.size == 0){
        // head = temp;
        // tail = temp;
        // }
        if (size == 0) {
            handleAddWhenSize0(val);
        } else {
            Node temp = new Node(val);
            temp.next = head;
            this.head = temp;
            this.size++;
        }
    }

    public void addLast(int val) {
        // Node temp = new Node(val);
        // if(this.size == 0){
        // head = temp;
        // tail = temp;
        // }
        if (this.size == 0) {
            handleAddWhenSize0(val);
        } else {
            Node temp = new Node(val);
            this.tail.next = temp;
            this.tail = temp;
            this.size++;
        }
    }

    // Return the node at ith index position
    private Node getNthNode(int pos) {
        Node temp = this.head;
        while (pos > 0) {
            temp = temp.next;
            pos--;
        }
        return temp;
    }

    public void addAt(int val, int idx) {
        if (idx < 0 || idx >= this.size) {
            System.out.println("Invalid Position");
            return;
        } else if (idx == 0) {
            addFirst(val);
        } else if (idx == this.size) {
            addLast(val);
        } else {
            Node nm1 = getNthNode(idx - 1);
            Node temp = new Node(val);
            temp.next = nm1.next;
            nm1.next = temp;
            this.size++;
        }
    }

    public int getFirst(int val) {
        if (this.size == 0) {
            return -1;
        }
        return this.head.data;
    }

    public int getLast(int val) {
        if (this.size == 0) {
            return -1;
        }
        return this.tail.data;
    }

    public int getAt(int idx) {
        if (idx < 0 || idx > this.size) {
            return -1;
        }
        Node n = getNthNode(idx);
        return n.data;
    }

    private int handleremove() {
        int val = this.head.data;
        this.head = this.tail = null;
        return val;
    }

    public int removeFirst() {
        if (this.size == 0) {
            return -1;
        } else if (this.size == 1) {
            return handleremove();
        } else {
            int val = this.head.data;
            this.head = this.head.next;
            this.size--;
            return val;
        }
    }

    public int removeLast() {
        if (this.size == 0) {
            return -1;
        } else if (this.size == 1) {
            return handleremove();
        } else {
            Node temp = getNthNode(this.size - 2);
            int val = this.tail.data;
            temp.next = null;
            this.tail = temp;
            this.size--;
            return val;
        }
    }

    public int removeAt(int idx) {
        if (idx < 0 || idx >= this.size) {
            return -1;
        } else if (idx == 0) {
            return removeFirst();
        } else if (idx == this.size - 1) {
            return removeLast();
        } else {
            Node nm1 = getNthNode(idx - 1);
            int val = nm1.next.data;
            nm1.next = nm1.next.next;
            this.size--;
            return val;
        }
    }

    public int size() {
        return this.size;
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int mid2() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int mid1() {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int mid() {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static linkedlist mergeTwoSortedLists(linkedlist l1, linkedlist l2) {
        // write your code hered
        Node one = l1.head;
        Node two = l2.head;
        linkedlist ans = new linkedlist();
        while (one != null && two != null) {
            if (one.data < two.data) {
                ans.addLast(one.data);
                one = one.next;
            } else {
                ans.addLast(two.data);
                two = two.next;
            }
        }

        while (one != null) {
            ans.addLast(one.data);
            one = one.next;
        }

        while (two != null) {
            ans.addLast(two.data);
            two = two.next;
        }

        return ans;
    }

    public void removeDuplicates() {
        linkedlist res = new linkedlist();
        while (this.size() > 0) {
            int val = this.getFirst();
            this.removeFirst();
            if (res.size() == 0 || val != res.tail.data) {
                res.addLast(val);
            }
        }
        this.head = res.head;
        this.tail = res.tail;
        this.size = res.size;
    }

    public void removeDuplicates2() {
        Node temp = this.head;
        Node itr = temp.next;
        while (itr != null) {
            if (temp.data == itr.data) {
                itr = itr.next;
            } else {
                temp.next = itr;
                temp = temp.next;
                itr = itr.next;
            }
        }
        temp.next = itr;
    }

    public void oddEven() {
        linkedlist odd = new linkedlist();
        linkedlist even = new linkedlist();
        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();
            if (val % 2 == 0) {
                even.addLast(val);
            } else {
                odd.addLast(val);
            }
        }

        if (odd.size > 0 && even.size > 0) {
            odd.tail.next = even.head;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        } else if (odd.size > 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        } else {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }
    }

    public void oddEven2() {
        Node ehead = new Node();
        Node temp1 = ehead;
        Node ohead = new Node();
        Node temp2 = ohead;
        Node itr = this.head;
        while (itr != null) {
            if (itr.data % 2 == 0) {
                temp1.next = itr;
                temp1 = temp1.next;
            } else {
                temp2.next = itr;
                temp2 = temp2.next;
            }
            itr = itr.next;
        }
        temp2.next = ehead.next;
        temp1.next = null;

        this.head = ohead.next;
        this.tail = temp2.next == null ? temp2 : temp1;
    }

    private void displayReverseHelper(Node node) {
        if (node == null) {
            return;
        }
        displayReverseHelper(node.next);
        System.out.print(node.data + " ");
    }

    private void reversePRHelper(Node node) {
        if (node == null) {
            return;
        }
        reversePRHelper(node.next);
        if (node == tail) {

        } else {
            node.next.next = node;
        }
    }

    public void reversePR() {
        reversePRHelper(head);
        head.next = null;
        Node temp = head;
        head = tail;
        tail = temp;
    }

    private void reversePRHelper2(Node node) {
        // write your code here
        if (node.next == null) {
            this.head = node;
            return;
        }
        reversePRHelper2(node.next);
        node.next.next = node;
    }

    public void reversePR2() {
        // write your code here
        Node temp = this.head;
        reversePRHelper(temp);
        temp.next = null;
        this.tail = temp;
    }

    // Check if LinkedList is pallindrome or not O(n^2)
    private Node getNthNode(int pos) {
        Node temp = this.head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean IsPalindrome() {
        // write your code here
        int left = 0;
        int right = size - 1;
        while (left < right) {
            Node lnode = getNthNode(left);
            Node rnode = getNthNode(right);
            if (lnode.data != rnode.data) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Check if LinkedList is pallindrome or not O(n) and O(1) Space
    private Node getMidNode(Node node) {
        Node slow = node;
        Node fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node reversePointer(Node node) {
        Node prev = null;
        Node curr = node;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean IsPalindrome2() {
        Node head1 = this.head;

        Node mid = getMidNode(head1);
        Node head2 = mid.next;
        mid.next = null;

        head2 = reversePointer(head2);

        Node t1 = head1;
        Node t2 = head2;
        boolean res = true;

        while (t1 != null && t2 != null) {
            if (t1.data != t2.data) {
                res = false;
                break;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        head2 = reversePointer(head2);
        mid.next = head2;
        return res;
    }

    // Fold a Linked List

    public void fold() {
        if (this.head == null)
            return;

        Node head1 = this.head;
        Node mid = getMidNode(head1);
        Node head2 = mid.next;
        mid.next = null;
        head2 = reversePointer(head2);
        Node t1 = head1;
        Node t2 = head2;
        while (t1 != null && t2 != null) {
            Node n1 = t1.next;
            Node n2 = t2.next;

            t1.next = t2;
            t1 = n1;
            t2.next = n1;
            t2 = n2;
        }
        t1 = head1;
        while (t1.next != null) {
            t1 = t1.next;
        }
        this.head = head1;
        this.tail = t1;
    }

    public void fold2() {
        if (this.head == null || this.head.next == null || this.head.next.next == null) {
            return;
        }

        Node head1 = this.head;
        Node mid = getMidNode(head1);
        Node head2 = mid.next;
        mid.next = null;
        head2 = reversePointer(head2);
        Node t1 = head1;
        Node t2 = head2;

        Node prev = head1;

        while (t1 != null && t2 != null) {
            Node n1 = t1.next;
            Node n2 = t2.next;

            t1.next = t2;
            t1 = n1;
            prev = t1 == null ? prev : t1;

            t2.next = n1;
            t2 = n2;
            prev = t2 == null ? prev : t2;
        }
        // t1 = head1;
        // while(t1.next!=null){
        // t1 = t1.next;
        // }
        this.head = head1;
        this.tail = prev;
    }

    // Fold Linked List recursively
    private void foldHelper(Node right, int floor) {
        if (right == null) {
            return;
        }
        foldHelper(right.next, floor + 1);

        if (floor > size / 2) {
            Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }
        if (floor == size / 2) {
            tail = right;
            tail.next = null;
        }
    }

    Node left;

    public void fold3() {
        left = head;
        foldHelper(head, 0);
    }

    // Reverse the linked List Recursively
    private void reverseDRHelper(Node right, int floor) {
        // write your code here
        if (right == null) {
            return;
        }
        reverseDRHelper(right.next, floor + 1);
        if (floor >= size / 2) {
            int temp = right.data;
            right.data = left.data;
            left.data = temp;
            left = left.next;
        }
    }

    Node left;

    public void reverseDR() {
        left = head;
        reverseDRHelper(head, 0);
    }

    // Addition of two linked List
    // private static Node reversePointer(Node head) {
    // Node prev = null;
    // Node curr = head;
    // while (curr != null) {
    // Node next = curr.next;
    // curr.next = prev;
    // prev = curr;
    // curr = next;
    // }
    // return prev;
    // }

    // Addd two linked List iterative

    public static linkedlist addTwoLists(linkedlist one, linkedlist two) {
        Node head1 = one.head;
        Node head2 = two.head;
        head1 = reversePointer(head1);
        head2 = reversePointer(head2);

        Node i = head1;
        Node j = head2;
        linkedlist res = new linkedlist();
        int carry = 0;
        while (i != null || j != null || carry != 0) {
            int ival = i == null ? 0 : i.data;
            i = i == null ? null : i.next;
            int jval = j == null ? 0 : j.data;
            j = j == null ? null : j.next;

            int sum = ival + jval + carry;
            int val = sum % 10;
            carry = sum / 10;
            res.addFirst(val);
        }

        head1 = reversePointer(head1);
        head2 = reversePointer(head2);
        return res;
    }

    // Addiion of two linked List using recursive
    private static int additionHelper(Node one, int i1, Node two, int i2, linkedlist res) {
        if (one == null && two == null) {
            return 0;
        }
        int d1 = one.data;
        int d2 = two.data;
        int sum = 0;
        if (i1 > i2) {
            int carry = additionHelper(one.next, i1 - 1, two, i2, res);
            sum = d1 + carry;
        } else if (i1 < i2) {
            int carry = additionHelper(one, i1, two.next, i2 - 1, res);
            sum = d2 + carry;
        } else {
            int carry = additionHelper(one.next, i1 - 1, two.next, i2 - 1, res);
            sum = d1 + d2 + carry;
        }
        res.addFirst(sum % 10);
        return sum / 10;
    }

    public static linkedlist addTwoLists2(linkedlist one, linkedlist two) {
        linkedlist res = new linkedlist();
        int carry = additionHelper(one.head, one.size, two.head, two.size, res);
        if (carry > 0) {
            res.addFirst(carry);
        }
        return res;
    }

    // InterSection Point of two linked List
    public static int findIntersection(LinkedList one, LinkedList two) {
        Node t1 = one.head;
        Node t2 = two.head;

        int s1 = one.size();
        int s2 = two.size();

        if (s1 > s2) {
            int diff = s1 - s2;
            for (int i = 0; i < diff; i++)
                t1 = t1.next;
        } else {
            int diff = s2 - s1;
            for (int i = 0; i < diff; i++)
                t2 = t2.next;
        }

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1.data;
    }

    // copyt linked list with random pointer
    public static ListNode copyRandomList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode t1 = dummy;
        ListNode t2 = head;

        // 1. Clone without pointer
        while (t2 != null) {
            ListNode nn = new ListNode(t2.val);
            t1.next = nn;
            // t1 = nn;
            t1 = t1.next;
            t2 = t2.next;
        }

        ListNode head2 = dummy.next;
        // 2. Connect in Zig zag order
        t1 = head;
        t2 = head2;
        while (t1 != null && t2 != null) {
            ListNode n1 = t1.next;
            ListNode n2 = t2.next;

            t1.next = t2;
            t2.next = n1;
            t1 = n1;
            t2 = n2;
        }

        // 3. Set Random Pointer
        t1 = head;
        while (t1 != null) {
            t1.next.random = t1.random == null ? null : t1.random.next;
            t1 = t1.next.next;
        }

        // 4. Rearrange original list
        ListNode d1 = new ListNode(-1);
        t1 = d1;
        ListNode d2 = new ListNode(-1);
        t2 = d2;
        ListNode temp = head;
        while (temp != null) {
            t1.next = temp;
            t2.next = temp.next;

            t1 = t1.next;
            t2 = t2.next;
            temp = temp.next.next;
        }
        t1.next = null;
        t2.next = null;
        // 5. Return Cloned LinkedList head
        return d2.next;
    }
}

public class LL {
    public static void demo() {
        linkedlist list = new linkedlist();
        // list.addFirst(10);
        // list.addFirst(10);
        // list.addFirst(20);
        // list.addFirst(30);
        // list.addLast(40);
        // list.addLast(50);
        // list.addLast(60);

        list.addLast(10);
        list.addLast(20);
        list.display();
        list.addLast(30);
        list.addFirst(9);
        list.display();
        list.addFirst(7);
        list.addLast(40);
        list.display();
        System.out.println(list.size());

        System.out.println(list.removeFirst());
        list.addAt(40, 2);
        list.display();

        System.out.println(list.removeAt(3));
        System.out.println(list.getAt(3));
        list.addLast(90);
        list.addLast(85);
        list.addLast(40);
        list.addLast(70);
        list.addLast(60);

        list.display();

        System.out.println(list.size());
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeAt(3);
        list.display();

        list.removeLast();
        list.removeLast();
        list.display();
    }

    public static void main(String[] args) {
        demo();
    }
}