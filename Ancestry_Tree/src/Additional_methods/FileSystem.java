package Additional_methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import BackEnd.ancestryTree;

public class FileSystem {
	// copy the path if tree.ser and paste it in path var 
	String path  = "S:\\Programming\\JavaWorkStation\\Ancestry_Tree\\src\\FileStorage\\tree.ser";
	
	public void serializeTree(ancestryTree e) {
		try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved ");
         } catch (IOException i) {
            i.printStackTrace();
         }
	}
	public ancestryTree DeserializeTree() throws IOException {
		ancestryTree tree = null;
	      try {
	         FileInputStream fileIn = new FileInputStream(path);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         tree = (ancestryTree) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         
	      }    
	      return tree;
	}
}
