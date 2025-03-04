package cheetsheet;

import java.util.HashSet;

public class HashSet_ {
    public static void main(String[] args) {
    	
    	// 重複しない要素を管理するためのコレクション
        // 内部的にはハッシュテーブルを利用
    	// 要素の追加、検索、削除などの操作が高速に行える
    	
    	// HashSet の宣言（String型）
        HashSet<String> hashSet = new HashSet<>();
        
        // 要素の追加
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Blue");

        // 削除
        hashSet.remove("Red");
        
        boolean exists = hashSet.contains("Green");
        System.out.println("要素の存在確認 'Green'? " + exists);
        
        System.out.println("セットのサイズ: " + hashSet.size());
        
        System.out.println(hashSet);
        
        // 全削除
        hashSet.clear();
    }
}
