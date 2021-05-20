package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

public class person implements Serializable{
	private static final long serialVersionUID = 123L;
	private String date_of_birth;
	private String date_of_death;
	private String fName;
	private String mName;
	private String lName;
	private String motherFName;
	private String motherLName;
	private String moreInformation;
	private ArrayList<person> children = new ArrayList<>();
	private person parent;
	private String password;

	
	public person(String date_of_birth, String date_of_death, String fName, String mName, String lName,
			String moreInformation, person parent,String motherFName,String motherLName, String password) {
		super();
		this.date_of_birth = date_of_birth;
		this.date_of_death = date_of_death;
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.moreInformation = moreInformation;
		this.parent = parent;
		this.motherFName = motherFName;
		this.motherLName = motherLName;
		this.password = password;

	}

	public person() {
		super();
		this.date_of_birth = null;
		this.date_of_death = null;
		this.fName = null;
		this.mName = null;
		this.lName = null;
		this.parent = null;
		this.password = null;

	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getDate_of_death() {
		return date_of_death;
	}

	public void setDate_of_death(String date_of_death) {
		this.date_of_death = date_of_death;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public ArrayList<person> getChildren() {
		return children;
	}

	public void setChildren(person child) {
		this.children.add(child);
	}

	public person getParent() {
		return parent;
	}

	public void setParent(person parent) {
		this.parent = parent;
	}
	
	public String getMotherFName() {
		return motherFName;
	}

	public void setMotherFName(String motherFName) {
		this.motherFName = motherFName;
	}

	public String getMotherLName() {
		return motherLName;
	}

	public void setMotherLName(String motherLName) {
		this.motherLName = motherLName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
}
