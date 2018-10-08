package logic;

public class Movie {
	private String name;
	private int length;
	public Movie(String name, int length) {
		if(name.equals("")) name = "No Name";
		if(length < 1) length = 1;
		setName(name);
		setLength(length);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
