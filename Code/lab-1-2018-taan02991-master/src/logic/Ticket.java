package logic;

public class Ticket {
	private int number,start,row,column;
	private String name;
	public Ticket(int number, String name, int start, int row, int column) {
		setNumber(number);
		setName(name);
		setStart(start);
		setRow(row);
		setColumn(column);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
