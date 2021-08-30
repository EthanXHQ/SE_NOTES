package cn.edu.nju.software.lcy.engine;

public class ResultString {

	private int startIndex;
	private int endIndex;
	
	private String matchString;
	
	public ResultString() {
		
	}
	
	public ResultString(int start, int end, String match) {
		this.setStartIndex(start);
		this.setEndIndex(end);
		this.setMatchString(match);
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public String getMatchString() {
		return matchString;
	}

	public void setMatchString(String matchString) {
		this.matchString = matchString;
	}
	
	public void printResult() {
		System.out.println("StartIndex: " + this.startIndex + ", EndIndex: " + this.endIndex + ", String:" + this.matchString);
	}
}
