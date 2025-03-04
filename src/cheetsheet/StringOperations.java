package cheetsheet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperations {

    public static void main(String[] args) {
        String str = "  Hello, World!  ";
        
        // 空白の除去（trim）
        str = str.trim();
        
        // 文字列の長さ取得
        str.length();
        
        // 特定位置の文字取得
        // System.out.println(str.charAt(1));
        // System.out.println(str.charAt(2));
        
        // 部分文字列の抽出
        String substr = str.substring(7);
        System.out.println(substr); // "World!"部分
        substr = str.substring(0, 5);
        System.out.println(substr); // "Hello"
        
        // 2. 文字列の検索と比較
        // 0123456789 10 11 12
        // Hello, Wor  l  d  !
        System.out.println("indexOf(\"World\"): " + str.indexOf("World"));
        System.out.println("lastIndexOf(\"l\"): " + str.lastIndexOf("l"));
        
        // equals, equalsIgnoreCase, compareTo
        String s1 = "Java";
        String s2 = "java";
        // 大文字・小文字の区別: 区別する（完全に一致するか）
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // false
        // 大文字・小文字の区別: 区別しない
        System.out.println("s1.equalsIgnoreCase(s2): " + s1.equalsIgnoreCase(s2)); // true
        // 文字列を辞書順（辞典の並び順）で比較
        // 大文字・小文字の区別: 区別する
        // 0 : 等しい
        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2)); // -32
        
        // 3. 文字列の変換と置換
        // HELLO, WORLD!
        System.out.println("toUpperCase(): " + str.toUpperCase());
        // hello, world!
        System.out.println("toLowerCase(): " + str.toLowerCase());
        
        // 文字列の置換
        // Hi, World!
        System.out.println("replace(\"Hello\", \"Hi\"): " + str.replace("Hello", "Hi"));

        // 正規表現による置換
        // H*ll*, W*rld!
        System.out.println("replaceAll(\"[aeiouAEIOU]\", \"*\"): " + str.replaceAll("[aeiouAEIOU]", "*"));
        
        
        // 4. 分割・連結・フォーマット
        // 分割 (split)
        String csv = "apple,banana,cherry";
        
        String[] fruits = csv.split(",");

        for (String fruit : fruits) {
            System.out.println("::" + fruit);
        }

        // 連結 (String.join)
        // apple|banana|cherry
        String joined = String.join("|", fruits);
        System.out.println("String.join(): " + joined);
        
        // フォーマット (String.format)
        // 255(10) = ff(16)
        String formatted = String.format("数値 %d の16進数表現は %x", 255, 255);
        System.out.println("String.format(): " + formatted);
        
        // 5. 数値や他の型から文字列への変換
        String numStr = String.valueOf(12345);
        System.out.println("String.valueOf(12345): " + numStr);
        
        
        // 6. 正規表現の利用
        String regexExample = "The quick brown fox jumps over the lazy dog.";
        
        // 4文字の単語を抽出するパターン
        Pattern pattern = Pattern.compile("\\b\\w{4}\\b");
        Matcher matcher = pattern.matcher(regexExample);
        while (matcher.find()) {
            System.out.println("[match] " + matcher.group());
        }
        
        // 7. 可変文字列の操作
        // StringBuilder (シングルスレッド環境向け、高速)
        StringBuilder sb = new StringBuilder();
        sb.append("aaa");
        sb.append("bbb");
        System.out.println("[StringBuilder] " + sb.toString());
        
        // StringBuffer (スレッドセーフ)
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("ccc");
        sBuffer.append("ddd");
        System.out.println("[StringBuffer] " + sBuffer.toString());
    }
}
