package javaproject_1;

import java.io.*;
import java.util.*;

public class javaproject_1 {

	public static void main (String[] args) throws IOException {
		
		File file = new File("C:\\Users\\RISHIKA\\eclipse-workspace\\javaproject_1\\src\\javaproject_1\\abc.txt");
		
	 
		FileReader in = null;
		try {
			in = new FileReader(file);             //reading file
	int a;
		while((a=in.read())!=-1) {
			System.out.print((char)a);                      //printing the file of given path
		}
		
		Scanner sc = new Scanner(file);
		          String path = sc.nextLine();
		                 File files= new File(path);              //user will input path
		
		File file1[]=files.listFiles();
		
		int count=0;                                    //to store the no. of files present
		System.out.println();
		System.out.println("files in the directory are:-");	
			for(int i=0;i<file1.length;i++) {
				if(file1[i].isFile())
				 {
					 count++;                                           //count the total numbers of files
					 
				 	 System.out.println(count+"."+"path and file name:- "+file1[i].getAbsolutePath());     //files of directory will print
				 }
				 
			
			 }
			 
			 check(file1 , path);        
		
		
			
		}
		catch (Exception e){
            System.out.print("error has occured");			
		}
	
    finally {
			if(in!=null)
			{
			in.close(); 
			}
			else {
				
			}
			}
	}

	public static void check(File file2[] , String path)            
	
	
	                                                      /* will check if there will be any other directory present in the given directory
	                                                       * if there then will print all the file of that second or whatever directory 
	                                                       * or else print the file.
	                                                       */

{
                                 int count = 0;
             for(int i=0 ; i<file2.length; i++)   
                    { 
                                  if(file2[i].isDirectory())            //is there any other directory in the given directory
                {
                        File files2[] = file2[i].listFiles();
                                        System.out.println();
                                               System.out.println("folder name - "+file2[i].getName() + " // Folder Path - "+file2[i].getAbsolutePath());

                      check(files2 , path);                 
                               }
                    else
                                {
                         if(file2[i].isFile())
                               {
                              count++;                    
                                       }
                        
                         System.out.println(count+ "."+"path and file name:-"+file2[i].getAbsolutePath());			 
		 				 
                    }
                    }
}
	}

	
		
				
				
			
		
		
		


