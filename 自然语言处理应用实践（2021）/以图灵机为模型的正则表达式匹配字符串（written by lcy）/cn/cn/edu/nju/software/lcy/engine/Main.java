package cn.edu.nju.software.lcy.engine;

public class Main {

	public static void main(String[] args) {
		//������������ı�
		String testText = "aabdcaabadcadaabad";
		
		//�½�������󣬲���ʼ���������������лὫ������浽�б���
		SearchEngine searchEngine = new SearchEngine(testText);
		searchEngine.startSearch();
		
		//��������б���ӡÿһ�����
		for(ResultString result : searchEngine.matches) {
			result.printResult();
		}
	}
}
