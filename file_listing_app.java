package javaproject_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class file_listing_app {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);           // user input
		System.out.println("enter your path");     
		String file =sc.nextLine();
		
		//File file = new File("C:\\Users\\RISHIKA\\eclipse-workspace\\javaproject_1\\src\\javaproject_1\\abc.txt");
		                                   
		
		
		 FileInputStream in=null;
		 
		 try {
			 in=new FileInputStream(file);
			 
			 int a;
			 String path="", path1="";
			 while((a=in.read())!=10) {
				 path=path+(char)a;
			 }
			 
			 System.out.println();
			 System.out.println(path);
			 Listf(path.substring(0,path.length()-1));
			
			while((a=in.read())!=-1) {
				 path1=path1+(char)a;
			 }
			 System.out.println(path1);
			 Listf(path1.substring(1,path1.length()-1));
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
	
				 
			
		 
		 public static void Listf(String Directory) throws IOException {
			 
			 String path1=new String();
			 File fout =new File(path1);
			 ArrayList<File> List=new ArrayList<File>();
			 BufferedWriter b= null;
			  FileOutputStream fileout = new FileOutputStream(path1, true);
			   b= new BufferedWriter(new OutputStreamWriter(fileout));
			  
			 File file1 =new File(Directory); 
			 
			 File[] flist=file1.listFiles();
			 
			 for(int i=0;i<flist.length;i++) {
				 File files= flist[i];
				 if(files.isFile()) {
					 List.add(files);
					// System.out.println("file name:-"+files.getName()+"//// file path:-"+files.getAbsolutePath());
					 
				 }
				 else if(files.isDirectory()) {
					 Listf(files.getAbsolutePath());
				 }
			 }
			 try 
			 {
			 Iterator<File> itr= List.iterator();
			 while(itr.hasNext()) {
				 File f =itr.next();
				 b.write("file name:-"+ f.getName());
				 b.write(",");
				 b.write("path:-"+ f.getAbsolutePath());
				 b.newLine();
			 }
			 }
			 catch(Exception e) {
				 System.out.println(e + "Error happened");
			 }
			 finally {
				 if(b!=null) {
					 b.close();
				 }
			 }
			 }
			 
		 }
	
		
		 

	 




	