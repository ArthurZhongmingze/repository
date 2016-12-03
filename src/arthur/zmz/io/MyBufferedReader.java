package arthur.zmz.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * 模拟BufferedReader
 * 
 * 分析：
 * 缓冲区无非就是封装了一个数组
 * 并对外提供了更多的方法对数组进行访问
 * 
 * 缓冲原理
 * 其实就是从源中获取一批数据装进缓冲区
 * 再从缓冲区取出一个一个数据
 * 
 * 在此次取完后，再从源中继续取一批数据进缓冲区
 * 当源中的数据取光时，用-1作为标记结束
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author
 * @date 2016-12-1 下午6:49:13
 */

public class MyBufferedReader {
	
	private FileReader fr;
	
	//定义一个数组作为缓冲区
	private char[] buf = new char[1024];
	//定义一个指针操作这个数组元素的元素。当操作到最后一个元素后，指针归零
	private int pos = 0;
	
	//定义一个计数器用于记录缓冲区中的数据个数,但该数据减到0，就从源中继续获取缓冲区
	private int count = 0;
	
	MyBufferedReader(FileReader fr) {
		this.fr = fr;
	}
	
	public int myRead() throws IOException {
		// 1、从源中获取一批数据到缓冲区中。需要先判断，只有计数器为0时，才需要从源中获取数据
//		if(count == 0) {
//			count = fr.read(buf); 
//			if(count < 0) 
//				return -1;
//			
//			//每次获取数据到缓冲区后，角标归零
//			pos = 0;
//			char ch = buf[pos];
//			pos++;
//			count--;
//			
//			return ch;
//		} else {
//			char ch = buf[pos];
//			pos++;
//			count--;
//			
//			return ch;
//		}
		
		if(count == 0) {
			count = fr.read(buf);
			pos = 0;
		}
		
		if(count < 0)
			return -1;
		
		char ch = buf[pos];
		pos++;
		count--;
		
		return ch;
		
	}
	
	public String MyReadLine() throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		 
		int ch = 0;
		while((ch = myRead())!= -1) {
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return stringBuilder.toString();
			stringBuilder.append((char)ch);
			
		}
		
		if(stringBuilder.length() != 0)
			return stringBuilder.toString();
		return null;
	}
	
	public void myclose() throws IOException {
		fr.close();
	}
}
