package cheetsheet;

import java.util.HashMap;

public class HashMapEx {
    public static void main(String[] args) {
    	// HashMap の宣言（キー: String, 値: Integer）
    	HashMap<String, Integer> map = new HashMap<>();
    	// 要素の追加
    	map.put("apple", 100);
    	map.put("banana", 150);
    	System.out.println("HashMap: " + map);
    	// キーによる値の取得
    	int price = map.get("apple");
    	System.out.println("Price of apple: " + price);
    }
}
