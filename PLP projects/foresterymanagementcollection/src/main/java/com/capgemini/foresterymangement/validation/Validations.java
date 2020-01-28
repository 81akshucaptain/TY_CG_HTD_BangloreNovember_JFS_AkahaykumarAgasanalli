package com.capgemini.foresterymangement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.ValidationException;

import com.capgemini.foresterymanagement.exception.VallidationExceptionFMS;

public class Validations {
	public static boolean fullNameValidation(String fullName)  {
		String nameregex = "^[A-Za-z _?A-Za-z A-Za-z]*";
		Pattern namepattern = Pattern.compile(nameregex);
		Matcher namematcher = namepattern.matcher(fullName);
		if( namematcher.matches()) { 
			return true;
		}else {
			throw new VallidationExceptionFMS("please Enter the VALID NAME..!");
		}
	}

	public static boolean alphabetsValidation(String alphabets) {
		String alphabetsgex = "^[A-Za-z]*";
		Pattern alphabetspattern = Pattern.compile(alphabetsgex);
		Matcher alphabetsmatcher = alphabetspattern.matcher(alphabets);
		if( alphabetsmatcher.matches()) {
			return true;
		}else {
			throw new VallidationExceptionFMS("please Enter the Valid Input, Must Be Alphabets..!");
		}
	}
	public static boolean emailValidation(String email)   {
		String emailregex = "^(.+)@(.+)\\.(.+)$";
		Pattern emailpattern = Pattern.compile(emailregex);
		Matcher emailmatcher = emailpattern.matcher((CharSequence)email);
		if( emailmatcher.matches()) {
			return true;
		}else{
			throw new VallidationExceptionFMS("Please Enter The Valid Email-Id");
		}
	}
	public static boolean numberValidation(String number) {
		String numberregex = "^[0-9]*";
		Pattern numberpattern = Pattern.compile(numberregex);
		Matcher numbermatcher = numberpattern.matcher(number);
		if( numbermatcher.matches()) {
			return true;
		}else {
			throw new VallidationExceptionFMS("Please Enter The Valid Input, Must be Number..!");
		}
	}
	public static boolean phoneNumberValidation(String phone) {
		String phoneregex = "^[6789][0-9]{9}";
		Pattern phonepattern = Pattern.compile(phoneregex);
		Matcher phonematcher = phonepattern.matcher(phone);
		if( phonematcher.matches()) {
			return true;
		}else {
			throw new VallidationExceptionFMS("Please Enter 10-Digit Valid Phone Number..!");
		}
	}
	public static boolean haulierIdVallidation(String haulier) {
		String haulierregex = "^[A-Z]{2}-[0-9]{2}-[A-Z]{2}-[0-9]{4}$";
		Pattern haulierpattern = Pattern.compile(haulierregex);
		Matcher hauliermatcher = haulierpattern.matcher(haulier);
		if( hauliermatcher.matches()) {
			return true;
		}else {
			throw new VallidationExceptionFMS("please Enter The Vallid HualuerId");
		}
	}
	public static boolean dateValidation(String date) {
		String regex = "^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]"
				+ "|[12][0-9]|0[1-9])$"; 
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher((CharSequence)date);
		if(matcher.matches()) {
			return true;	
		}else {
			return false;
		}
	}
	public static boolean postalValidation(String number) {
		String numberregex = "^[0-9]*";
		Pattern numberpattern = Pattern.compile(numberregex);
		Matcher numbermatcher = numberpattern.matcher(number);
		if( numbermatcher.matches()) {
			return true;
		}else {
			throw new VallidationExceptionFMS("Please Enter The Valid Input, Must be Number..!");
		}
	}
	
	public static boolean passwordValidation(String password) {
		String passwordregex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^+=!*()@%&]).{8,20}$";
		Pattern passwordpattern = Pattern.compile(passwordregex);
		Matcher passwordmatcher = passwordpattern.matcher(password);
		if( passwordmatcher.matches()) {
			return true;
		}else {
			throw new VallidationExceptionFMS("Please Enter The Valid Password \n Minimum one(lower and upper case,special symbol,digit) And characters..!");
		}
	}
	
}









