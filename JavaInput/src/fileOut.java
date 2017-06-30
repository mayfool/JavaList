import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class fileOut {
	public static void writeFile1(String str) throws IOException {
        File fout = new File("d:/rank.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write(str);
        bw.close();
    }
	public static void writeFile2() throws IOException {
        FileWriter fw = new FileWriter("d:/out.txt");
        for (int i = 0; i < 10; i++) {
            fw.write("love");
        }
        fw.close();
    }
}
