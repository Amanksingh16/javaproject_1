package javaproject_1;

import java.io.*;
import java.io.File;

public class javaproject_1 {
	
	public static void main(String[] args) throws IOException {
		
		 File file = new File("C:\\Users\\RISHIKA\\eclipse-workspace\\javaproject_1\\src\\javaproject_1\\abc.txt");
		 
		 FileReader in=null;
		 try {
			 in=new FileReader(file);
			 
			 int a;
			 String path="";
			 while((a=in.read())!=10) {
				 path=path+(char)a;
			 }
			 
			 //while((a=in.read())!=-1) {
					//System.out.print((char)a); 
			// }
			 System.out.println();
			 System.out.println(path);
			 Listf(path);
			 
		 }
		 catch(Exception e) {
			 System.out.println("Error has occured");
		 }
		 finally {
			 if(in!=null) {
				 in.close();
			 }
		 }
	}
	
				 
			
		 
		 public static void Listf(String Directory) {
			 
			 File file1 =new File(Directory); 
			 
			 File[] flist=file1.listFiles();
			 
			 for(int i=0;i<flist.length;i++) {
				 File files= flist[i];
				 if(files.isFile()) {
					 
					 System.out.println("file name"+files.getName()+" file path"+files.getAbsolutePath());
					 
				 }
				 else if(files.isDirectory()) {
					 Listf(files.getAbsolutePath());
				 }
			 }
			 
		 }
	
		
		 

}	 




	