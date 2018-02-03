package javaproject_1;

import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import  java.lang.NullPointerException;

public class javaproject_1 {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);           // user input
		System.out.println("enter your path");     
		String file =sc.nextLine();
		
		//File file = new File("C:\\Users\\RISHIKA\\eclipse-workspace\\javaproject_1\\src\\javaproject_1\\abc.txt");
		                                   
		
		
		 FileInputStream in=null;
		 try {
			 in=new FileInputStream(file);
			 
			 int a;
			 String path="";
			 while((a=in.read())!=10) {
				 path=path+(char)a;
			 }
			 
			 System.out.println();
			 System.out.println(path);
			 Listf(path.substring(0,path.length()-1));
			 
		 }
		 catch(Exception e) {
			 System.out.println(e + "Error has occured");
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
					 
					 System.out.println("file name:-"+files.getName()+"//// file path:-"+files.getAbsolutePath());
					 
				 }
				 else if(files.isDirectory()) {
					 Listf(files.getAbsolutePath());
				 }
			 }
			 
		 }
	
		
		 

}	 




	