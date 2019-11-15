package org.elevenst.SampleRT;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class Reg_PCTest {
	
	String id = "nike";
	
	@Test
	public void PC_loginTest() throws Exception
	{ 
		Reg_PC app = new Reg_PC();
		app.ChromeSet();
		Reg_PC.PCLogin();

	}
	
	@Test
	public void PC_Search() throws Exception
	{ 	//주석추
//		String id = "나이키";
		Reg_PC app = new Reg_PC();
		app.ChromeSet();
		Reg_PC.PCSearch(id);
		

	}
	@Test
	public void PC_GnbTest() throws Exception
	{ 
//		String id = "나이키";
		Reg_PC app = new Reg_PC();
		app.ChromeSet();
		Reg_PC.PCGnb();	


	}
	     
}
