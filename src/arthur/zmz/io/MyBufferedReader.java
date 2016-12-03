package arthur.zmz.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * ģ��BufferedReader
 * 
 * ������
 * �������޷Ǿ��Ƿ�װ��һ������
 * �������ṩ�˸���ķ�����������з���
 * 
 * ����ԭ��
 * ��ʵ���Ǵ�Դ�л�ȡһ������װ��������
 * �ٴӻ�����ȡ��һ��һ������
 * 
 * �ڴ˴�ȡ����ٴ�Դ�м���ȡһ�����ݽ�������
 * ��Դ�е�����ȡ��ʱ����-1��Ϊ��ǽ���
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author
 * @date 2016-12-1 ����6:49:13
 */

public class MyBufferedReader {
	
	private FileReader fr;
	
	//����һ��������Ϊ������
	private char[] buf = new char[1024];
	//����һ��ָ������������Ԫ�ص�Ԫ�ء������������һ��Ԫ�غ�ָ�����
	private int pos = 0;
	
	//����һ�����������ڼ�¼�������е����ݸ���,�������ݼ���0���ʹ�Դ�м�����ȡ������
	private int count = 0;
	
	MyBufferedReader(FileReader fr) {
		this.fr = fr;
	}
	
	public int myRead() throws IOException {
		// 1����Դ�л�ȡһ�����ݵ��������С���Ҫ���жϣ�ֻ�м�����Ϊ0ʱ������Ҫ��Դ�л�ȡ����
//		if(count == 0) {
//			count = fr.read(buf); 
//			if(count < 0) 
//				return -1;
//			
//			//ÿ�λ�ȡ���ݵ��������󣬽Ǳ����
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
