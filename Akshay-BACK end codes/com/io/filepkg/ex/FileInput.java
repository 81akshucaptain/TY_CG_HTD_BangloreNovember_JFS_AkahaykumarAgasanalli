package com.io.filepkg.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInput {
	public static void main(String[] args) {
		try {
			FileInputStream f1=new FileInputStream("anu.txt");
			int j=0;
			while ((j=f1.read())!=-1) {
				System.out.print((char)j);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
