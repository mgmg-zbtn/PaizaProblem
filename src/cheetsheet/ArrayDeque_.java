package cheetsheet;

import java.util.ArrayDeque;

public class ArrayDeque_ {

	public static void main(String[] args) {
        // ArrayDeque の宣言（Integer型）
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // キューとして要素を追加
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println("Deque: " + deque);
        // 先頭の要素を取り出す
        int first = deque.poll();
        System.out.println("Removed element: " + first);
        System.out.println("Deque after removal: " + deque);
	}
}
