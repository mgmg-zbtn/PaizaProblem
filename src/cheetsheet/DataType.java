package cheetsheet;

public class DataType {
	
	// 整数型 (byte) 範囲: -128 ～ 127
	byte minByte = Byte.MIN_VALUE;
	byte maxByte = Byte.MAX_VALUE;

	// 整数型 (short) 範囲: -32768 ～ 32767
	short minShort = Short.MIN_VALUE;
	short maxShort = Short.MAX_VALUE;

	// 整数型 (int) 範囲: -2147483648 ～ 2147483647
	int minInt = Integer.MIN_VALUE;
	int maxInt = Integer.MAX_VALUE;

	// 整数型 (long) 範囲: -9223372036854775808 ～ 9223372036854775807
	long minLong = Long.MIN_VALUE;
	long maxLong = Long.MAX_VALUE;

	// 浮動小数点型 (float) 範囲: -Float.MAX_VALUE ～ Float.MAX_VALUE
	// ※Float.MIN_VALUE は 0 に限りなく近い正の値
	float minFloat = -Float.MAX_VALUE;
	float maxFloat = Float.MAX_VALUE;

	// 浮動小数点型 (double) 範囲: -Double.MAX_VALUE ～ Double.MAX_VALUE
	// ※Double.MIN_VALUE は 0 に限りなく近い正の値
	double minDouble = -Double.MAX_VALUE;
	double maxDouble = Double.MAX_VALUE;

	// 文字型 (char) 範囲: 0 ～ 65535
	char minChar = Character.MIN_VALUE;
	char maxChar = Character.MAX_VALUE;

	// 論理型 (boolean): true または false
	// ※数値的な範囲は存在しない
	boolean trueValue = true;
	boolean falseValue = false;

}
