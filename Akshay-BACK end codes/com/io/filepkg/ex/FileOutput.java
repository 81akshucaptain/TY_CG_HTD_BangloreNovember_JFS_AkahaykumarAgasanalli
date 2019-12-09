package com.io.filepkg.ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
public static void main(String[] args) {
	try {
		FileOutputStream f1=new FileOutputStream("anu.txt");
		String s1="mowneshwari p";
		byte b[]=s1.getBytes();
			f1.write(b);
			System.out.println("success.....!");
		//IT WILL TAKE THE BYTE AS INPUT HENCE COVERT STRING TO BYTES
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
