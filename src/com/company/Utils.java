package com.company;

import com.company.node.Node;

import java.util.*;

public class Utils {

    /**
     * 判断两个字符串是否是字母异位词
     */
    public static boolean isEccentric(String s, String t) {
        int[] s1 = new int[26];
        for (char c : s.toCharArray()) {
            s1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            s1[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (s1[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 链表翻转
     *
     * @param head
     * @return
     */
    public static Node flipLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 链表的k个字节翻转
     *
     * @param head
     * @param k
     * @return
     */
    public static Node nodereverseKGroup(Node head, int k) {
        if (head == null) {
            return head;
        }
        Node tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return tail;
            }
            tail = tail.next;
        }
        Node newHead = reverse(head, tail);
        head.next = nodereverseKGroup(tail, k);
        return newHead;
    }

    private static Node reverse(Node head, Node tail) {
        Node pre = null;
        Node next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 判断字符串是否是有效的括号
     *
     * @return
     */
    public static boolean isValidString(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                stack.push(chars[i]);
            } else {
                if (isRightBrackets(stack.peek(), chars[i])) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    private static boolean isRightBrackets(char left, char right) {
        if ((left == '{' && right == '}') || (left == '[' && right == ']')) {
            return true;
        }
        return false;
    }

    /**
     * 气温升高天数计算
     */
    public static int[] getDaysTemperature(int[] emp) {
        int[] emps = new int[emp.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < emp.length; i++) {
            if (i == 0) {
                stack.push(i);
            } else {
                while (!stack.empty() && emp[i] > emp[stack.peek()]) {
                    int pre = stack.pop();
                    emps[pre] = i - pre;
                }
                stack.push(i);
            }
        }
        return emps;
    }

    /**
     * 窗口滑动最大值
     *
     * @param wins
     * @param k
     * @return
     */
    public static List<Integer> maxSlidingWindow(int[] wins, int k) {
        List<Integer> s = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && wins[i] > wins[queue.getLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        s.add(wins[queue.getFirst()]);
        for (int j = k; j < wins.length; j++) {
            if (!queue.isEmpty() && queue.getFirst() <= j - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && wins[j] > wins[queue.getLast()]) {
                queue.pollLast();
            }
            queue.addLast(j);
            s.add(wins[queue.getFirst()]);
        }
        return s;
    }

    /**
     * 取出前k个出现频率最高的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] nums, int k) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        for (String n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return count.get(o1) - count.get(o2);
            }
        });
        for (String n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        return list;
    }

    /**
     * 冒泡排序
     *
     * @param nums
     * @return
     */
    public static int[] maopao(int[] nums) {
        for (int j = 0; j < nums.length - 1; j++) {
            for (int i = 0; i < nums.length - 1 - j; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 插入排序
     *
     * @return
     */
    public static int[] insert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i; j > 0; j--) {
                if (temp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 对链表进行插入排序
     *
     * @return
     */
    public static Node insertLinked(Node head) {
        Node pre = new Node(-1);
        pre.next = head;
        Node lat;
        while (head != null) {
            lat = head.next;
            if (lat != null && lat.data < head.data) {
                while (pre.next != null && pre.next.data < lat.data) {
                    pre = pre.next;
                }
                Node temp = pre.next;
                pre.next = lat;
                head.next = lat.next;
                lat.next = temp;
            } else {
                head = lat;
            }
        }
        return pre.next;
    }

    public static void guibing() {
        int[] nums = new int[]{1,2,5,3,4,6,8};
        chaifen(nums, 0, nums.length - 1 );
    }

    private static void chaifen(int[] nums, int start, int end){
        int mid = (end + start)/2;
        if (start<end){
            chaifen(nums, start, mid);
            chaifen(nums, mid + 1, end);
            guibing(nums, start, mid, end);
        }
    }

    private static void guibing(int[] arr, int start, int mid, int end){
        int start1 = start;
        int start2 = mid + 1;
        int index = 0;
        int[] temp = new int[end - start + 1];
        while (start1 <= mid && start2 <= end){
            if (arr[start1] < arr[start2]){
                temp[index] = arr[start1];
                start1++;
                index++;
            }else {
                temp[index] = arr[start2];
                start2++;
                index++;
            }
        }
        while (start1 <= mid){
            temp[index] = arr[start1];
            start1++;
            index++;
        }
        while (start2 <= end){
            temp[index] = arr[start2];
            start2++;
            index++;
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i+start] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @return
     */
    public static int[] selectSort(int[] arr){
        int n = arr.length;
        int min;
        for (int i = 0; i < n; i++){
            min = arr[i];
            for (int j = i + 1; j < n;j++){
                if (arr[j] < min){
                    int temp = arr[j];
                    arr[j] = min;
                    arr[i] = temp;
                    min = arr[i];
                }
            }
        }
        return arr;
    }


    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     */
    public static void quitSort(int[] arr, int start, int end){
        if (start < end){
            int index = quitIndex(arr, start, end);
            quitSort(arr, start, index -1);
            quitSort(arr, index + 1, end);
        }
    }

    private static int quitIndex(int[] arr, int start, int end){
        int i = start;
        int j = end;
        int result = arr[i];
        while (i<j){
            while (i<j && arr[j] > result){
                j--;
            }
            if (arr[j] < result){
                arr[i] = arr[j];
                i++;
            }
            while (i<j && arr[i] < result){
                i++;
            }
            if (arr[i] > result){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = result;
        return i;
    }
}
