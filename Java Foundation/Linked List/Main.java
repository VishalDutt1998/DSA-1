class Main {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode curr = null;
        ListNode ctail = null;
        ListNode prev = null;
        ListNode ptail = null;
        int csize = 0;
        int psize = 0;

        while (size > 0) {
            if (size > k) {
                for (int i = 0; i < k; i++) {
                    ListNode node = removeFirst(head, size);
                    addFirst(curr, node, csize, ctail);
                }

            } else {
                while (size-- > 0) {
                    ListNode node = removeFirst(head, size);
                    addLast(prev, node, psize, ptail);
                }
            }
            if (prev == null) {
                prev = curr;
                psize = csize;
                curr = null;
                csize = 0;
            } else {
                ptail.next = curr;
                ptail = ctail;
                psize = psize + csize;
            }
        }
        head = curr;
        return head;
    }

    public void addFirst(ListNode head, ListNode node, int csize, ListNode ctail) {
        if (csize == 0) {
            node.next = null;
            head = ctail = node;
            csize++;
        } else {
            node.next = head;
            head = node;
            csize++;
        }
    }

    public ListNode removeFirst(ListNode head, int size) {
        if (size == 1) {
            ListNode temp = head;
            // head.next = null;
            size--;
            return temp;
        }
        ListNode node = head;
        head = head.next;
        size--;
        return node;
    }

    public void addLast(ListNode head, ListNode node, int psize, ListNode ptail) {
        // if (psize == 0) {
        // node.next = null;
        // head = node;
        // psize++;
        // }
        // else
        ptail.next = node;
        ptail = node;
        node.next = null;
        psize++;
    }
}