package arthur.zmz.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterAndFileReader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("fw.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);	
		bw.write("write a file by FileWriter!");
		
		FileReader fr = new FileReader("fw.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = null;
		while ((line = br.readLine())!=null) {
			System.out.println(line);
			bw.newLine();
			bw.write("read a file by FileReader!");
			
		}
		
		bw.flush();
		
//		int i = 0;
//		while ((i = fr.read()) != -1){
//			System.out.print((char)i);
//		}
		
//		char[] ch = new char[1024];
//		int len = 0;
//		while ((len = fr.read(ch)) != -1){
//			System.out.println(new String(ch, 0, len));
//		}
		
		
		
		
		br.close();
		bw.close();

	}

}
