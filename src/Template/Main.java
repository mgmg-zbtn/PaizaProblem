package Template;
import Test.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 提出の際
 * 
 * 1.下記を削除する
 * package Hoge;
 * import Test.Test;
 * 
 * 2.BufferedReaderをテストから本番に切り替える必要がある.
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Test.stream("src\\Template\\testcase\\case1.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	}
}
