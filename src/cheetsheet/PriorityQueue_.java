package cheetsheet;

import java.util.PriorityQueue;

public class PriorityQueue_ {

	public static void main(String[] args) {
        // PriorityQueue の宣言（Integer型）
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 要素の追加
        pq.offer(4);
        pq.offer(1);
        pq.offer(3);
        System.out.println("PriorityQueue: " + pq);
        // 最小値（先頭要素）の取得と削除
        int smallest = pq.poll();
        System.out.println("Smallest element: " + smallest);
        System.out.println("PriorityQueue after removal: " + pq);
	}
}
