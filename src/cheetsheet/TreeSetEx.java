package cheetsheet;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetEx {

	public static void main(String[] args) {
		
		// 要素を自動的にソートして管理するための集合クラス
		// 要素は自然順序（例: 数値は小さい順、文字列は辞書順）
		
		// 内部的にはRed-Black Tree（平衡二分探索木）
		// SortedSetおよびNavigableSetインターフェースを実装

		// 部分集合や範囲検索といった操作が効率的
		// 基本的な操作（追加、削除、検索）の時間計算量は O(log n)
		// ソート機能のためにHashSetよりも操作速度は若干劣る場合がある
		
		// null要素は許容されない。追加しようとするとNullPointerException
		
        TreeSet<String> set = new TreeSet<>();
        
        // 要素の追加
        set.add("Banana");
        set.add("Apple");
        set.add("Orange");
        set.add("Peach");
        
        // 重複する要素は追加されない
        boolean added = set.add("Apple"); // 既に存在するのでfalseが返る
        
        // ソートされた順序で出力
        System.out.println("TreeSetの要素:");
        for (String fruit : set) {
            System.out.println(fruit);
        }
        
        // 要素の検索
        if (set.contains("Banana")) {
            System.out.println("Bananaはセットに含まれています");
        }
        
        // 最小値と最大値の取得
        System.out.println("最小値: " + set.first());
        System.out.println("最大値: " + set.last());
        
        // 部分集合の取得（例："Apple"から"Orange"まで）
        System.out.println("部分集合 (Apple ～ Orange): " + set.subSet("Apple", "Orange"));

        ////////////////////////////////////////////////////////////////////////////////////
        // 指定した要素より小さいすべての要素を含む部分集合
        // "Orange"より小さい要素（"Orange"は含まれない）
        // [Apple, Banana]
        SortedSet<String> headSet = set.headSet("Orange");
        System.out.println("headSet(\"Orange\") : " + headSet);
        
        // 第2引数：NavigableSetのオーバーロード（"Orange"も含む）
        // [Apple, Banana, Orange]
        SortedSet<String> headSetInclusive = set.headSet("Orange", true);
        System.out.println("headSet(\"Orange\", true) : " + headSetInclusive);
        
        ////////////////////////////////////////////////////////////////////////////////////
        // 指定した要素以上のすべての要素を含む部分集合
        // "Banana"以上の要素（"Banana"は含まれる）
        // [Banana, Orange, Peach]
        SortedSet<String> tailSet = set.tailSet("Banana");
        System.out.println("tailSet(\"Banana\") : " + tailSet);
        
        // 第2引数：NavigableSetのオーバーロード（"Banana"を除外）
        // [Orange, Peach]
        SortedSet<String> tailSetExclusive = set.tailSet("Banana", false);
        System.out.println("tailSet(\"Banana\", false) : " + tailSetExclusive);
        
        ////////////////////////////////////////////////////////////////////////////////////
        // 要素の削除
        set.remove("Banana");
        System.out.println("Banana削除後のセット: " + set);
	}
}
