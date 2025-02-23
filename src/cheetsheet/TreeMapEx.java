package cheetsheet;

import java.util.TreeMap;

public class TreeMapEx {

	public static void main(String[] args) {
		
		// キーがソートされた状態で保持される
		// データの順序性が重要な場合に有用
		
		// 内部的にはRed-Black Tree（自己平衡二分探索木）
		// ↑よって検索・挿入・削除はO(log n)
		// HashMapの方が平均的には高速

		// nullキーを許容しません
		// 
		// 
		
    	// TreeMap の宣言（キー: Integer, 値: String）
    	TreeMap<Integer, String> map = new TreeMap<>();
    	
    	// 要素の追加（キーは自動的にソートされる）
    	map.put(3, "C");
    	map.put(1, "A");
    	map.put(2, "B");
    	
    	// キー1のエントリを削除し、その値を返す
    	String removedValue = map.remove(1);
    	System.out.println("removedValue: " + removedValue);
    	
    	// キーが存在しない場合、get は null を返す
    	System.out.println(map.get(1));
    	
    	for (Integer key : map.keySet()) {
    	    System.out.println(key + " : " + map.get(key));
    	}
    	System.out.println("TreeMap: " + map);

    	// 最小のキーのエントリーを取得
    	System.out.println("First entry: " + map.firstEntry());
	}
}
