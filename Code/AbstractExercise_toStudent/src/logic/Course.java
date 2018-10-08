package logic;

public abstract class Course implements Cloneable {

	  private String name;

	  public Course(String name){      // ... with constructor
	    this.name = name;
	  }

	  public abstract boolean isPassed();
	  
	  public abstract String toString();
	  
	 // public boolean equals (Object o) // TO DO: QUESTION 4
	  public boolean equals(Object o) {
		  if(this == o) return true;
		  if(o == null) return false;
		  if(this.getClass() != o.getClass()) return false;
		  if(this.name != ((Course) o).name) return false;
		  return true;
	  }
		  
		
		  
	 //  protected Object clone() // TO DO: QUESTION 4
	  public Object clone() {
		  try {
			  Course newC = (Course) super.clone();
			  return newC;
		  }catch(CloneNotSupportedException e) {
			  throw new InternalError(e.toString());
		  }
		  
		  
	  }
		  

	  public String getName() {
		  return name;
	  }

	  public void setName(String name) {
		  this.name = name;
	  }
	  
	  
	}
	

