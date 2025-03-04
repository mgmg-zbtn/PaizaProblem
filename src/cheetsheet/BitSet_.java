package cheetsheet;

import java.util.BitSet;

public class BitSet_ {

	public static void main(String[] args) {
		 // BitSetの作成
        BitSet bitSet = new BitSet();

        // ビットの設定
        bitSet.set(2);
        bitSet.set(4, true);
        bitSet.set(5, 10); // 5~9をtrueに

        int length = bitSet.length();           // ビットの長さ
        int cardinality = bitSet.cardinality(); // true になっているビットの数
        int flip = length - cardinality;        // false
        System.out.println(length + ":" + cardinality + ":" + flip);
        
        // ビットの取得
        boolean isSet = bitSet.get(2);

        // ビットのクリア
        bitSet.clear(2);
        bitSet.clear(); // 全ビットクリア

        // ビットの反転
        bitSet.flip(2);
        bitSet.flip(3, 6); // 3~5を反転

        // ビットの論理演算
        BitSet another = new BitSet();
        another.set(3);
        another.set(5);

        bitSet.and(another);  // AND演算
        bitSet.or(another);   // OR演算
        bitSet.xor(another);  // XOR演算
	}
}
