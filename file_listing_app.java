import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class test {
	
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);           // user input
		System.out.println("enter your path");     
		String filepath =sc.nextLine();
		
		//File file = new File("C:\\Users\\RISHIKA\\eclipse-workspace\\javaproject_1\\src\\javaproject_1\\abc.txt");
		                                   
		File file = new File(filepath);
		 
		 FileInputStream in=null;
		 
		 try {
			 in=new FileInputStream(file);
			 int newline_count = 0;
			 int a;
			 String b = "" ;
			 String c = "";
			 String path="", path1="";
			 while((a=in.read())!=-1) {
				 if(a==10)
				 {
					 newline_count++;
				 }
				 if(newline_count == 0)
				 {
					 b = b + (char)a;
					 path = b.substring(0, b.length()-1); 
				 }
				 if(newline_count == 1)
				 {
					 c = c + (char)a;	 
				 }                 				    		
			 }
				path1 = c.substring(1, c.length()-1);

			 File path2 = new File(path);            // The Path is fetched from the file
			 
			 File files[] = path2.listFiles();  
			 
			 Listf(files , path , path1);	
			 System.out.println(path);
			 System.out.println(path1);
		 }
		 finally {
			 if(in!=null) {
				 in.close();
			 }
		 }
	}
	
				
		 public static void Listf(File files1[] , String path , String path1) throws IOException {
			 			 
			 ArrayList<File> List=new ArrayList<File>();
			 Iterator<File> itr = null;
			 BufferedWriter b= null;
			 FileOutputStream fileout = null;
			   
			 for(int i=0;i<files1.length;i++) {
				 if(files1[i].isFile()) {
					 List.add(files1[i]);
					// System.out.println("file name:-"+files.getName()+"//// file path:-"+files.getAbsolutePath());
					 
				 }
				 else if(files1[i].isDirectory()) 
				 {
					 File files2[] = files1[i].listFiles();
					 Listf(files2 , path , path1);
				 }
			 }
			 try 
			 {
			   fileout =  new FileOutputStream(path1, true);
			   b= new BufferedWriter(new OutputStreamWriter(fileout));
				 	 
			 itr= List.iterator();
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
	
		
		 

	 




	
