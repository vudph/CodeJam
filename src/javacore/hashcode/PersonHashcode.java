package javacore.hashcode;

public class PersonHashcode {
	private String name;
	public PersonHashcode(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PersonHashcode)) {
			return false;
		}
		PersonHashcode p = (PersonHashcode) obj;
		if (this.name.equals(p.name)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
//		System.out.println(name.hashCode());
		return 2783;
	}
}
