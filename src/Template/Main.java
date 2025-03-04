package Template;
import Test.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Test.stream("TESTCASE")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String[] lines = br.readLine().split(" ");
		int N = Integer.parseInt(lines[0]);
		int K = Integer.parseInt(lines[1]);
		int X = Integer.parseInt(lines[2]);
		
		
		for (int n = 0; n < N; n++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
		}
	}
}
