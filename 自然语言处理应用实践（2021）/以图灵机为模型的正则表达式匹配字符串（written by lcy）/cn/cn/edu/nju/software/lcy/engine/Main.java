package cn.edu.nju.software.lcy.engine;

public class Main {

	public static void main(String[] args) {
		//定义待检索的文本
		String testText = "aabdcaabadcadaabad";
		
		//新建引擎对象，并开始检索，检索过程中会将结果保存到列表中
		SearchEngine searchEngine = new SearchEngine(testText);
		searchEngine.startSearch();
		
		//遍历结果列表，打印每一个结果
		for(ResultString result : searchEngine.matches) {
			result.printResult();
		}
	}
}
