package BackEnd;



import java.io.IOException;

import Additional_methods.FileSystem;

public class test {
	public static void main(String[] args) throws IOException{
		ancestryTree ll = new ancestryTree();
		

		
		
		ll.insert("", "", "ROOT", "", "ROOT", 
				"", null,"","", "ROOT", null);
		
		ll.insert("12/12/1202", "30/12/5222", "f00", "", "l00", 
				"", ll.personFinder("ROOT", "ROOT","",""),"","", "00", "ROOT");
		ll.insert("12/12/1212", "23/11/1111", "f01", "", "l01", 
				"", ll.personFinder("ROOT", "ROOT","",""),"","", "01", "ROOT");
		
				
//		FileSystem x = new FileSystem();
//		x.serializeTree(ll);
//		ll.output();
		
		
//		testt();
	}

	private static void testt() {
		// TODO Auto-generated method stub
		
	}
}
