package com.all4tic.kioqs.utilities;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.all4tic.kioqs.dao.LecteurDao;
public class Utility {
	@Autowired
	private LecteurDao lecteurDao;
	 public static int generateRandomDigits(int n) {
	        int m = (int) Math.pow(10, n - 1);
	        return m + new Random().nextInt(9 * m);
	    }
	 public static String generateCodeBq() {
	String code=	 "B"+Utility.generateRandomDigits(4)+""+LocalDate.now().getDayOfYear();
	if(code.length()==6) {
		code +="00";
	}else if(code.length()==7) {
		code+="0";
	 }
	 return code ;
	 }
	 public static String generateCodeFile() {
			String code=	 "F"+Utility.generateRandomDigits(6)+""+LocalDate.now().getDayOfYear();
			if(code.length()==7) {
				code +="00";
			}else if(code.length()==8) {
				code+="0";
			 }
			 return code ;
			 }
	 public static String generateCodeCategorie() {
			String code=	 "C"+Utility.generateRandomDigits(1)+""+LocalDate.now().getDayOfYear();
			if(code.length()==4) {
				code +=""+Utility.generateRandomDigits(2);
			}else if(code.length()==5) {
				code+=""+Utility.generateRandomDigits(1);
			 }
			 return code ;
			 }
	 public static String generateCodeProduits() {
			String code=	 "P"+Utility.generateRandomDigits(7)+""+LocalDate.now().getDayOfYear();
			if(code.length()==10) {
				code +=""+Utility.generateRandomDigits(2);
			}else if(code.length()==11) {
				code+=""+Utility.generateRandomDigits(1);
			 }
			 return code ;
			 }
	 public static String generateCodeLecteur() {
		 String code = "L"+Utility.generateRandomDigits(7)+""+LocalDate.now().getDayOfYear();
		 return code ;
	 }
}
