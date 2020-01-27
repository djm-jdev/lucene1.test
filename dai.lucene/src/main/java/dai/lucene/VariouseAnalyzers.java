package dai.lucene;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.*;

public class VariouseAnalyzers {

	
	private static String str = "Better 中华人民共和国简称中国，是一个有13亿人口的国家";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Analyzer analyzer  = null;
		analyzer = new StandardAnalyzer();
		System.out.println("标准分词法:" + analyzer.getClass());
		printAnalyzer(analyzer);
		
		
		analyzer = new WhitespaceAnalyzer();
		System.out.println("空格分词法:" + analyzer.getClass());
		printAnalyzer(analyzer);
		
		
		analyzer = new SimpleAnalyzer();
		System.out.println("简单分词法:" + analyzer.getClass());
		printAnalyzer(analyzer);
		
		analyzer = new KeywordAnalyzer();
		System.out.println("关键字分词法:" + analyzer.getClass());
		
		printAnalyzer(analyzer);
		
		analyzer = new StopAnalyzer();
		System.out.println("停用词分词法:" + analyzer.getClass());
		
		printAnalyzer(analyzer);
		
		analyzer = new CJKAnalyzer();
		System.out.println("二分法分词法:" + analyzer.getClass());
		
		printAnalyzer(analyzer);
		
		analyzer = new SmartChineseAnalyzer();
		System.out.println("中文智能分词法:" + analyzer.getClass());
		
		printAnalyzer(analyzer);
		
		
		
	}
	
	
	public static void printAnalyzer(Analyzer analyzer)
	{
		try {
			StringReader reader = new StringReader(str);
			TokenStream toStream = analyzer.tokenStream(str, reader);
			toStream.reset();
			CharTermAttribute teAttribute = toStream.getAttribute(CharTermAttribute.class);
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
