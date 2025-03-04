package cheetsheet;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkedList_ {
    public static void main(String[] args) {
        // LinkedList の作成
        LinkedList<String> list = new LinkedList<>();

        // 追加 (Insertion)
        list.add("A");                 // 末尾に追加
        list.add(1, "B");              // 指定位置に追加
        list.addFirst("C");            // 先頭に追加
        list.addLast("D");             // 末尾に追加

        // ソート
        System.out.println(list.toString());
        Collections.sort(list);
        System.out.println(list.toString());
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list.toString());

        // 削除 (Deletion)
        list.remove(2);                // 指定位置の要素を削除
        list.remove("B");              // 指定値を削除 (最初に見つかったもの)
        list.removeFirst();            // 先頭の要素を削除
        list.removeLast();             // 末尾の要素を削除
        

        // 取得 (Access)
        String first = list.getFirst(); // 先頭の要素を取得
        String last = list.getLast();   // 末尾の要素を取得
        String element = list.get(0);   // 指定位置の要素を取得

        // 更新 (Modification)
        list.set(0, "E");              // 指定位置の要素を更新

        // 検索 (Search)
        int index = list.indexOf("E"); // 指定値の最初の出現位置を取得
        boolean contains = list.contains("E"); // 指定値が含まれているか確認

        // サイズ (Size)
        int size = list.size();        // 要素数を取得
        boolean isEmpty = list.isEmpty(); // リストが空か確認

        // イテレーション (Iteration)
        // 通常のイテレーター
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
        }

        // 逆方向のイテレーター
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            String item = listIterator.previous();
        }

        // 逆順のイテレーター
        Iterator<String> descendingIterator = list.descendingIterator();
        while (descendingIterator.hasNext()) {
            String item = descendingIterator.next();
        }

        // 全要素削除
        list.clear();
    }
}
