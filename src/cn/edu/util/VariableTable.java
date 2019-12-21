package cn.edu.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class VariableTable {//符号表
	public ArrayList<Variable>table;
	
	public static final int 	SUCCESS = 100;//成功
	public static final int Undefined =200;//变量未定义
	public static final int TYPEERROR=300;//类型错误
	public static final int Muldefined=400;//多次声明
	
	
	public VariableTable() {
		table = new ArrayList<Variable>();
	}
	public int addVariable(Variable variable){
		if(Judge(variable)!=Undefined ){
			return  1;
		}else{
			table.add(variable);
			return SUCCESS; 
		}
	}
	public Variable get(int index){
		return (Variable)table.get(index);
	}
	
	public 	int  assignmentJudge (String name){
		for(Iterator<Variable>iter = table.iterator();iter.hasNext();){
			Variable v = iter.next();
			if((v.name).equals(name)){
				return 	SUCCESS;
				}
			}
		System.out.println(name+"变量未定义");
		return Undefined;	
	}
	public void clear(){
		table.clear();
	}
	public void printVariableTable() throws FileNotFoundException {
		Iterator<Variable> itr = table.iterator();
		FileOutputStream output = null;
		output = new FileOutputStream("src/variabletable.txt");
		try {
			while (itr.hasNext()) {
				Variable tmp = (Variable) itr.next();
				output.write((tmp.toString()+"  \n").getBytes());
				//System.out.println(tmp.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int Judge(Variable variable){
		for(Iterator<Variable>iter = table.iterator();iter.hasNext();){
			Variable v = iter.next();
			if(v.name.equals(variable.name)){
				if(v.type.equals(variable.type)){
					System.out.println(variable.name+"变量多次声明 "+variable.row+"\t"+variable.column);
					return Muldefined;
				}
				System.out.println(variable.name+"类型错误 "+variable.row+"\t"+variable.column);
				return TYPEERROR;
			}
		}
		return Undefined;
	}

}
