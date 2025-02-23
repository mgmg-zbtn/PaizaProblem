package cheetsheet;

import java.util.LinkedList;

public class LinkedListEx {

	public static void main(String[] args) {
        // LinkedList の宣言（String型）
        LinkedList<String> list = new LinkedList<>();
        // 要素の追加
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");
        System.out.println("LinkedList: " + list);
        // 最初の要素の削除
        list.removeFirst();
        System.out.println("After removing first: " + list);
	}
}
