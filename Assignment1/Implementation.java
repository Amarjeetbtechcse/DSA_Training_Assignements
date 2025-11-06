// Program 1: Count the Number of Digits in a Number using Recursion
public class CountDigits {
    static int countDigits(int n) {
        n = Math.abs(n); 
        if (n < 10) 
            return 1;
        return 1 + countDigits(n / 10);
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Number of digits in " + n + " = " + countDigits(n));
    }
}






// Program 2: Find Maximum Element in an Array using Recursion
public class MaxInArray {
    static int findMax(int[] arr, int n) {
        if (n == 1) 
            return arr[0];
        int maxInRest = findMax(arr, n - 1); 
        return Math.max(arr[n - 1], maxInRest);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 3};
        System.out.println("Maximum element: " + findMax(arr, arr.length));
    }
}






// Program 3: Check if Array is Sorted using Recursion
public class CheckSorted {
    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) 
            return true;
        if (arr[index] >= arr[index + 1]) 
            return false;
        return isSorted(arr, index + 1); 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array is sorted: " + isSorted(arr, 0));
    }
}








// Program 4: Check if String contains only digits using Recursion
public class OnlyDigits {
    static boolean isAllDigits(String s, int index) {
        if (index == s.length()) 
            return true;
        if (!Character.isDigit(s.charAt(index))) 
            return false;
        return isAllDigits(s, index + 1); 
    }

    public static void main(String[] args) {
        String str = "12345";
        System.out.println("String contains only digits: " + isAllDigits(str, 0));
    }
}









// Program 5: Count the Number of Zeros in a Number using Recursion
public class CountZeros {
    static int countZeros(int n) {
        n = Math.abs(n); 
        if (n == 0) return 1; 
        if (n < 10) return (n == 0) ? 1 : 0;
        return ((n % 10) == 0 ? 1 : 0) + countZeros(n / 10); 
    }

    public static void main(String[] args) {
        int n = 102030;
        System.out.println("Number of zeros in " + n + " = " + countZeros(n));
    }
}








// Program 6: Convert Decimal to Binary using Recursion
public class DecimalToBinary {
    static String toBinary(int n) {
        if (n == 0) return "0"; 
        if (n == 1) return "1"; 
        return toBinary(n / 2) + (n % 2); 

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Binary of " + n + " = " + toBinary(n));
    }
}







// Program 7: Reverse Digits of a Number using Recursion
public class ReverseNumber {
    static int reverseHelper(int n, int rev) {
        if (n == 0) return rev; 
        return reverseHelper(n / 10, rev * 10 + n % 10); 
    }

    static int reverse(int n) {
        return reverseHelper(Math.abs(n), 0); 
    }

    public static void main(String[] args) {
        int n = 1234;
        System.out.println("Reversed number: " + reverse(n));
    }
}









// Program 8: Reverse a Linked List using Recursion
class Node {
    int data;
    Node next;
    Node(int data) {
         this.data = data; 
    }
}

public class ReverseLinkedList {
    static Node reverse(Node head) {
        if (head == null || head.next == null) 
            return head;
        Node newHead = reverse(head.next); 
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static void printList(Node head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        printList(head.next);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.print("Original List: ");
        printList(head);

        head = reverse(head);

        System.out.print("\nReversed List: ");
        printList(head);
    }
}










// Program 9: Reverse an Array using Recursion
public class ReverseArray {
    static void reverse(int[] arr, int start, int end) {
        if (start >= end) return; 
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr, 0, arr.length - 1);
        System.out.print("Reversed Array: ");
        for (int num : arr)
            System.out.print(num + " ");
    }
}








// Program 10: Merge Two Sorted Linked Lists using Recursion
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeSortedLists {
    static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2; 
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    static void printList(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        printList(head.next);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode merged = merge(l1, l2);

        System.out.print("Merged Sorted List: ");
        printList(merged);
    }
}