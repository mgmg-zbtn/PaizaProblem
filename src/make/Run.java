package make;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Run {

	public static void main(String[] args) {
		
		boolean PRINT_TO_CONSOLE = true;
		boolean WRITE_TO_FILE    = true;
		boolean IS_COMPARE       = true;
		
		// Test.stream の切り替え（コメントアウト）忘れずに
		// ..new InputStreamReader(System.in));
		String caseNum = "2";
		String problem = "B140";

		// src/N000/N999/testcase/
		String testcase = "src/"+ problem.charAt(0) +"000/"+ problem +"/testcase/";
		// "N000.N999.Main"
		String classPath = problem.charAt(0) + "000." + problem;
		
        try {
            ProcessBuilder pb = new ProcessBuilder("java","-cp", "bin", classPath + ".Main");
            
            // 出力ファイルの指定
            File outputFile = new File(testcase+"log"+caseNum+".txt");
            outputFile.getParentFile().mkdirs(); // 親ディレクトリがない場合は作成
            
            Process process = pb.start();

            // ファイルから標準入力を取得
            try (FileInputStream fis = new FileInputStream(testcase+"case"+caseNum+".txt");
                 OutputStream os = process.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, length);
                }
                os.flush(); // 入力が完了したことを通知
            }
            
         // 標準出力の取得 & ログファイルへの書き込み
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        		PrintWriter fileWriter = new PrintWriter(new FileWriter(outputFile, false))) { // 上書きモード
                String line;
                while ((line = reader.readLine()) != null) {
                    if (PRINT_TO_CONSOLE) {
                        System.out.println(line); // コンソールに出力
                    }
                    if (WRITE_TO_FILE) {
                    	fileWriter.println(line); // ファイルに出力
                    }
                }
            }
            
            process.waitFor();
            
            if (IS_COMPARE) {
            	ProcessBuilder pbCompare = new ProcessBuilder(
            			"java",
            			"-cp",
            			"bin",
            			"make.Compare",
            			testcase+"log"+caseNum+".txt",
            			testcase+"ans"+caseNum+".txt");
            	
            	// プロセスを開始
                Process procCompare = pbCompare.start();

                // 標準出力を取得
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(procCompare.getInputStream())
                );

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // プロセスの終了を待機
                int exitCode = procCompare.waitFor();
                System.out.println("プロセス終了コード: " + exitCode);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
