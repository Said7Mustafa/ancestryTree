package BackEnd;



import java.io.IOException;

import Additional_methods.FileSystem;

public class test {
	public static void main(String[] args) throws IOException{
		ancestryTree ll = new ancestryTree();
		
		ll.insert("28/12/2012", "25/12/1212", "root", "", "root", 
				"", null,"","", "0", null);
		
		
//		ll.insert("12/12/1202", "30/12/5222", "f00", "", "l00", 
//				"", ll.personFinder("f0", "l0","",""),"","", "21", "Said");
//		ll.insert("12/12/1212", "23/11/1111", "f01", "", "l01", 
//				"", ll.personFinder("f0", "l0","",""),"","", "", "Said");
//		
				
		FileSystem x = new FileSystem();
		x.serializeTree(ll);
//		ll.output();
		
		
//		testt();
	}

	private static void testt() {
		// TODO Auto-generated method stub
		
	}
}
