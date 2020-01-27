package dai.lucene;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.*;

public class StdAnalyzer {

	
	private static String strCh = "中华人民共和国简称中国，是一个有13亿人口的国家";
	private static String strEn = "Dogs can not achieve a place,eyes can reach.my email is daijinming@live.cn";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("StandardAnalyzer对中文分词");
		StdAnalyzer(strCh);
		
		System.out.println("StandardAnalyzer对英文分词");
		StdAnalyzer(strEn);
		
	}
	
	public static void StdAnalyzer(String str)
	{
		try {
			
			Analyzer analyzer  = null;
			analyzer = new StandardAnalyzer();
			StringReader reader = new StringReader(str);
			TokenStream toStream = analyzer.tokenStream(str, reader);
			toStream.reset();
			CharTermAttribute teAttribute = 
					toStream.getAttribute(CharTermAttribute.class);
			System.out.println("分词结果:");
			
			while(toStream.incrementToken())
			{
				
				System.out.print(teAttribute.toString() + "|");
				
			}
			System.out.println("\n");
			analyzer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
