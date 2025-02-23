package cheetsheet;

import java.util.BitSet;

public class BitSetEx {

	public static void main(String[] args) {
        // BitSet の宣言
        BitSet bs = new BitSet();
        // 指定したインデックスのビットをセット（trueにする）
        bs.set(0); // 0番目のビットをセット
        bs.set(2); // 2番目のビットをセット
        System.out.println("BitSet: " + bs);
        // 2番目のビットがセットされているか確認
        boolean isSet = bs.get(2);
        System.out.println("Bit at position 2 is set: " + isSet);
        // 0番目のビットをクリア（falseにする）
        bs.clear(0);
        System.out.println("After clearing index 0: " + bs);
	}
}
