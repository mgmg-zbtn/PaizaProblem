package make;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Exportせずにプロジェクト内で直接実行する
 * 
 * @author mgmg-zbtn
 */
public class Make {

	public static void main(String[] args) throws IOException {

		ParseTestCase ptc = new ParseTestCase();
		
		String problem = ptc.title;
		
		File dir = new File("src\\" + problem.charAt(0) + "000\\" + problem + "\\testcase");
		if (dir.exists()) return;
		dir.mkdirs();
		
		// [i] 0 2 4 6..
		// list.get(i)   -> case
		// list.get(i+1) -> ans
		// 
		// case[k].txt
		//  ans[k].txt
		//  log[k].txt
		for (int i = 0, k = 1; i < ptc.testCaseList.size() - 1; i += 2, k++) {
			File caseFile = new File(dir.getAbsolutePath() + "\\" + "case" + k + ".txt");
			caseFile.createNewFile();

			File ansFile = new File(dir.getAbsolutePath() + "\\" + "ans" + k + ".txt");
			ansFile.createNewFile();
			
			File logFile = new File(dir.getAbsolutePath() + "\\" + "log" + k + ".txt");
			logFile.createNewFile();

			Files.writeString(
					Paths.get(dir.getAbsolutePath(),
					"case" + k + ".txt"),
					ptc.testCaseList.get(i),
					Charset.forName("UTF-8"),
					StandardOpenOption.WRITE);
			
			Files.writeString(
					Paths.get(dir.getAbsolutePath(),
					"ans" + k + ".txt"),
					ptc.testCaseList.get(i + 1),
					Charset.forName("UTF-8"),
					StandardOpenOption.WRITE);
		}
		
		
		File mainFile = new File(dir.getParent() + "\\Main.java");
		mainFile.createNewFile();
		
		Path basePath = Paths.get("src\\Template\\Main.java");
		String temp = Files.readString(basePath);
		
		// replace [Template]
		String packageName = problem.charAt(0) + "000." + problem;
		temp = temp.replace("Template", packageName);
		
		// replace [TESTCASE]
		String testCase = dir.getPath() + "\\case1.txt";
		testCase = testCase.replace("\\", "\\\\");
		temp = temp.replace("TESTCASE", testCase);
		
		Path wp = Paths.get(mainFile.toURI());
		Files.write(wp, temp.getBytes(), StandardOpenOption.WRITE);
	}
}
