package cn.edu.util;

public class Variable {//变量信息
	public String type;
	public String name;
	public int row;
	public int column;
	public Variable(String type, String name,int row,int column) {//
		super();
		this.type = type;
		this.name = name;
		this.row = row;
		this.column = column;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String toString(){
		return "("+this.type+"\t"+this.name+"\t"+this.row+"\t"+this.column+")";
	}
	
}
