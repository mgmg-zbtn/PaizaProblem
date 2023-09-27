# PaizaProblem

**問題ページをダウンロード（手動）して、テストケースなどを抽出し、自動生成する**  
**問題毎にパッケージ階層分けして管理する**  

|             |                 |  
| ----------- | --------------- |  
| case*.txt   | テストケース			|  
| ans*.txt    | テストケースの正答	|  
| log*.txt    | テストケースの出力	|  
| Main.java   | 実装用Mainファイル	|  


---

## [Make]自動生成について

1. Paizaの解きたい問題のページを[download]フォルダにDLして[index.html]にリネーム  
2. make.Make.javaを回すことでローカルテスト環境を自動生成する  

※実際に解答載せるのは規約違反ですわよ  

各ランク毎にまとめるための親ディレクトリを作っている  
問題用の子ディレクトリが2つ以上ないと  
EclipseのProjectExplorerでは表示が省略されるが生成は問題ないです  

問題番号などの抽出にjericho-html-3.4を使っているので別途用意が必要  
[jericho](http://jericho.htmlparser.net/docs/index.html)  

---

## 提出の際の注意

1. 下記を削除する（コメントアウトだけでも良い）  
package Hoge;  
import Test.Test;  
    
2. BufferedReaderをテストから本番に切り替える  

  
## 変更履歴

2023/09/27 : テストケースの自動生成に対応　　
2023/09/28 : log.txt出力追加　　
