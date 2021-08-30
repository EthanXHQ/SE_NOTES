package cn.edu.nju.software.lcy.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchEngine {

	//待检索文本
	private String text;
	
	//与状态机或者正则表达式相关的定义，如果后续扩张，可以通过解析状态机或者正则表达式获取。
	public Map<String, String> table;
	public Set<String> actionSet;
	//上面两个内容的初始化
	public void initializeTable() {
		this.table = new HashMap<String, String>();
		this.table.put("S-a", "1");
		this.table.put("S-b", "F");
		this.table.put("S-o", "F");
		this.table.put("1-a", "2");
		this.table.put("1-b", "1");
		this.table.put("1-o", "F");
		this.table.put("2-a", "2");
		this.table.put("2-b", "1");
		this.table.put("2-o", "E");
		this.table.put("E-a", "F");
		this.table.put("E-b", "F");
		this.table.put("E-o", "F");
	}
	
	public void initializeActionSet() {
		this.actionSet = new HashSet<String>();
		this.actionSet.add("a");
		this.actionSet.add("b");
	}
	
	
	//检索引擎本身的状态和下一步行为
	public String state;
	public String action;
	
	//结果列表
	public List<ResultString> matches;
	
	//引擎构造函数，输入文本就行。其他内容直接初始化
	public SearchEngine(String text) {
		this.text = text + "~";
		this.initializeState();
		this.initializeTable();
		this.initializeActionSet();
		this.action = "";
		
		this.matches = new ArrayList<ResultString>();
	}
	
	
	/**检索的核心函数：遍历输入文本，一个一个字符和状态机比对。
	*有三种情况：
	*（1）当前字符转到成功匹配的状态E-->记录匹配的结果，从当前字符继续处理；初始化引擎，开启下一轮匹配。
	*（2）当前字符转到匹配失败的状态F-->初始化引擎，从下一个字符开始，开启下一轮匹配。
	*（3）当前字符转到下一个可行的状态-->则记录被匹配的字符，继续处理下一个字符。
	**/
	public void startSearch() {
		String nextState = "";
		int tmpStartIndex = 0;
		int tmpEndIndex = 0;
		String tmpMatch = "";
		
		for(int i = 0; i < this.text.length(); i ++) {
			this.action = this.actionSet.contains(this.text.charAt(i) + "") ? this.text.charAt(i) + "" : "o";
			nextState = this.table.get(this.state + "-" + this.action);
			
			if(nextState == "E") {
				tmpEndIndex = i - 1;
				this.matches.add(new ResultString(tmpStartIndex, tmpEndIndex, tmpMatch));
				
				i --; //从当前不匹配的最后一个开始，再循环
				this.initializeState();
				tmpStartIndex = i + 1;
				tmpMatch = "";
			}else if(nextState == "F") {
//				if(this.state != "S") {
//					i --; //从当前不匹配的最后一个开始，再循环
//					tmpStartIndex = i + 1;
//				}else {
//					tmpStartIndex = i;
//				}
				tmpStartIndex = i;
				this.initializeState();
				tmpMatch = "";
			}else {
				tmpMatch = tmpMatch + this.action;
				this.state = nextState;
			}
		}
	}

	private void initializeState() {
		// TODO Auto-generated method stub
		this.state = "S";
	}
}
