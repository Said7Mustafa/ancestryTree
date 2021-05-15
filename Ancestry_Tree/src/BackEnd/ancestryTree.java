package BackEnd;

import java.io.Serializable;



public class ancestryTree implements Serializable{
	private static final long serialVersionUID = 123L;
	private person root;


	public ancestryTree(person root) {
		this.root = root;
	}
	
	public ancestryTree() {
		this.root = null;
	}
	
	

	private boolean isEmpty() {
		return root == null;
	}
	

	
	//inserts as a root if empty otherwise inserts as a child if the parent is not null
	public void insert(String date_of_birth, String date_of_death, String fName, String mName, String lName,
		String titles, person parent,String motherFName,String motherLName,String childPassword,String parentPassword) {
	
//			person childTemp = new person(date_of_birth, date_of_death, fName, mName,
//					lName, titles, parent,motherFName ,motherLName, childPassword);
//			if (isEmpty())  
//				root = childTemp;
//			else {
//				if (parent == null) 
//					System.err.println("*" + fName+ " "+ lName + " is not added");            /********************************/
//				else 
//					parent.setChildren(childTemp); 
//				             
//			} 

	
			if ((date_of_birth.equalsIgnoreCase("") || regexDate(date_of_birth)) 
					&& (date_of_death.equalsIgnoreCase("") || regexDate(date_of_death))) {
				
				person childTemp = new person(date_of_birth, date_of_death, fName, mName,
						lName, titles, parent,motherFName ,motherLName, childPassword);
				if (isEmpty())  
					root = childTemp;
				else {
					if (passwordChecker(parent, parentPassword)) {
						if (parent == null) 
							System.err.println("*" + fName+ " "+ lName + " is not added");            /********************************/
						else 
							parent.setChildren(childTemp); 
					}
					else
						System.err.println("*Father's Password is incorrect");                 /********************************/
				} 
			}
			else
				System.err.println("*for " + fName+ " "+ lName +", leave date of birth and date of death empty");          /********************************/
	
			
	}
	
	
	
	private boolean regexDate(String date) {
		String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
		return date.matches(regex);
	}
	 
	
	
	private boolean passwordChecker(person parent, String password) {
		return parent.getPassword().equals(password);
	}
	
	
	
	//gives the height/distance from root or in this case the generation of the node from root
	private int generation(person person) {
		int generation = 0;
		while (person.getParent() != null) {
			person = person.getParent();
			generation++;
		}
		return generation;
	}
	
	//algorithm to design and print the tree which is used in output()
	private void printAlgorithm(person person, int flag) {
		String dash = "";
		for (int i = 0; i <= generation(person); i++) {
			if (flag == 0) 
				System.out.print("--");
			else
				dash = dash + "--";
		}
		if (flag == 0) 
			System.out.println(person.getfName()+ " " + person.getlName());
		else
			treeToString(dash,person.getfName(),person.getlName());
		
		for (int i = 0; i < person.getChildren().size(); i++) {
			if (person.getChildren().size() != 0) 
				printAlgorithm(person.getChildren().get(i),flag); 
			else
				break;
		}	
	}
	
	//called and uses print algorithm 
	public void output() {
		person temp = root;
		if (temp == null) {
			System.err.println("*Tree is empty, please enter an element");           /********************************/
		}
		else {
			printAlgorithm(temp,0);
		}
	}

	
	
	//this node stores the ancestor found temporary and returns it in searchfor method
	private person personFoundTemp;
	
	// gives back either to use signle or double  to search 
	private int x = 0;
	
	// method looks for the data using parent in each node and stores it in ancestorFound variable 
	private void searchSingleAlgorithm(person person,String fname, String lname) {
		if (person.getfName().equalsIgnoreCase(fname) && person.getlName().equalsIgnoreCase(lname)) {
			personFoundTemp = person;
			x = x + 1;
		}
		for (int i = 0; i < person.getChildren().size(); i++) {
			if (person.getChildren().size() == 0) 
				break;
			searchSingleAlgorithm(person.getChildren().get(i),fname,lname);
		}
	}
	
	// method looks for the data using parent and Gparent in each node and stores it in ancestorFound variable 
	private void searchDoubleAlgorithm(person person,String fname, String lname,String parentfname, String parentlname) {
		if (person.getfName().equalsIgnoreCase(fname) && person.getlName().equalsIgnoreCase(lname)) 
			if (person.getParent() == null || (person.getParent().getfName().equalsIgnoreCase(parentfname) &&
					person.getParent().getlName().equalsIgnoreCase(parentlname)))
				personFoundTemp = person;
			
		for (int i = 0; i < person.getChildren().size(); i++) {
			if (person.getChildren().size() == 0) 
				break;
			searchDoubleAlgorithm(person.getChildren().get(i),fname,lname,parentfname,parentlname);
		}
	}
	
	
	
	//uses searchalgorithm to find the person and returns it,parentfname,parentlname
	public person personFinder(String fname,String lname,String parentfname, String parentlname) {
			person temp = root;
			searchSingleAlgorithm(temp, fname ,lname);
			if (x == 1) {
				x=0;
				if (personFoundTemp.getfName().equalsIgnoreCase(fname) &&
						personFoundTemp.getlName().equalsIgnoreCase(lname))
					return personFoundTemp;
				else
					return null;
			} 
			else {
				x=0;
				if (( parentfname == null || parentfname.equalsIgnoreCase("") )|| (parentlname.equalsIgnoreCase("") || parentlname == null) ) {
					System.err.println("*GrandParent name needed because more than one parent with the same name");  /********************************/
					return null;
				} else {					
					searchDoubleAlgorithm(temp, fname ,lname,parentfname,parentlname);
					if (personFoundTemp.getfName().equalsIgnoreCase(fname) &&
							personFoundTemp.getlName().equalsIgnoreCase(lname))
						return personFoundTemp;
					else
						return null;

				}
			}
	}
	
	
	
	//deleting a node
	public void deleteNode(String fname,String lname,String parentfname, String parentlname, String parentPassword) {
		person temp = root;
		searchDoubleAlgorithm(temp, fname ,lname,parentfname,parentlname);
		if (personFoundTemp == root) {
			root = null;
		} else {
			if (parentPassword.equalsIgnoreCase(personFoundTemp.getParent().getPassword())) {
				if (personFoundTemp.getfName().equalsIgnoreCase(fname) && personFoundTemp.getlName().equalsIgnoreCase(lname)) {
					if (personFoundTemp.getParent() == null || (personFoundTemp.getParent().getfName().equalsIgnoreCase(parentfname) && 
							personFoundTemp.getParent().getlName().equalsIgnoreCase(parentlname))) {
						personFoundTemp.getParent().getChildren().remove(
								personFoundTemp.getParent().getChildren().indexOf(
										personFoundTemp));
					}
				}
				else {
					System.err.println("*Person Not found");                               /********************************/
				}
				
			} else {
				System.err.println("*Parent Password is incorrect, child not deleted");      /********************************/
			}
		}
	}
	
	
	
	// tree stored as a string in treestring
	private String treeString = "";
	
	//creates and turns tree to string
	private void treeToString(String dash, String fname, String lname) {
		treeString = treeString +  dash + fname+ " "+ lname + "\n";
	}
	
	//return the string of the tree
	public String outputAsString() {
		person temp = root;
		if (temp == null) {
			return "*Tree is empty, please enter an element";                    /********************************/
		}
		else {
			printAlgorithm(temp,1);
			return treeString;
		}
	}
	
}
