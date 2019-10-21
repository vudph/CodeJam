package javacore.hashcode;

public class PersonNoHashcode {
	private String name;
	public PersonNoHashcode(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PersonNoHashcode)) {
			return false;
		}
		PersonNoHashcode p = (PersonNoHashcode) obj;
		if (this.name.equals(p.name)) {
			return true;
		}
		return false;
	}
}
