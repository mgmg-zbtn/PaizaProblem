package Template;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Make {

	public static void main(String[] args) throws IOException {

		String problem = "P991";
		
		File dir = new File("src\\" + problem.charAt(0) + "000\\" + problem + "\\testcase");
		dir.mkdirs();
		
		String[] list = {
				"ans1.txt",
				"ans2.txt",
				"ans3.txt",
				"case1.txt",
				"case2.txt",
				"case3.txt",
				};
		
		for (String s : list) {
			File f = new File(dir.getAbsolutePath() + "\\" + s);
			f.createNewFile();
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
