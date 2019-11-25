package org.elevenst.SampleRT;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Reg_PC {
	
	
	//WebDriver
	public static WebDriver driver;
	public static WebElement element;
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";
	
    private static String base_url = "https://www.11st.co.kr";
    
	public static String PCUserID = "eyego994";
	public static String PCUserPWD = "1030Qkrwogml!";    
    
    public static void main( String[] args )
    {
        
    }
    
    
	public static void ChromeSet() {
		//주
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		driver = new ChromeDriver(options);
		
	}	
    
	public static void PCLogin () throws Exception {

			
			try 
			{
				driver.get(base_url);
				//System.out.println(base_url);
				
				//로그인 버튼 클릭
				element = driver.findElement(By.id("gnbLogin"));
				element.click();
				
				Thread.sleep(1000);
				
				//id, pw 입려
				element = driver.findElement(By.id("loginName"));
				element.sendKeys(PCUserID);
				
				element = driver.findElement(By.id("passWord"));
				element.sendKeys(PCUserPWD);			
				
				// 로그인 
				//element = driver.findElement(By.className("btn_Atype btn_a"));
				element = driver.findElement(By.cssSelector("input.btn_Atype.btn_a"));
				element.click();
				
				Thread.sleep(1000);
				System.out.println("[TR] =============== 로그인 성공 (id : "+PCUserID+") ================");
				String text = driver.findElement(By.id("gnbLogin")).getText();
				// text에 "로그아웃" 또는 "로그인" 문자열 들어감
				Assert.assertEquals("로그아웃", text);			
				// 로그인 되었는지 체크 (text가 '로그아웃'이면 로그인 상태, '로그인' 이면 로그아웃 상태) 
				//System.out.println(text);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				driver.close();
		}
	}
	
	public static void PCSearch (String id) throws Exception {
		
				try {
					driver.get(base_url);
										
					element = driver.findElement(By.id("tSearch"));
					element.click();
					Thread.sleep(1000);
					
					element = driver.findElement(By.id("AKCKwd"));
					element.sendKeys(id);
					
					driver.findElement(By.id("gnbTxtAd")).click();
					
					element = driver.findElement(By.xpath("//h3[@class='result_tit']/strong"));
					String text = element.getText();
	//				String text = "아디다스";
					Assert.assertEquals(id, text);		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					driver.close();
			}
				
	}
	
	public static void PCGnb () throws Exception {
		
		try {
			driver.get(base_url);	
			
			System.out.println("[TR] =============== 백화점 바로가기 ================");
			element = driver.findElement(By.xpath("//ul[@id='gnbThemeMenuArea']/li/a[contains(@class,'department')]"));
			element.click();
			Thread.sleep(1000);
			
			element = driver.findElement(By.xpath("//h1[text()='백화점 바로가기']"));
//			String text = element.getText();
//				String text = "아디다스";
			Assert.assertTrue(element.isDisplayed());
			
			System.out.println("[TR] =============== 마트 바로가기 ================");
			element = driver.findElement(By.xpath("//ul[@id='gnbThemeMenuArea']/li/a[contains(@class,'mart')]"));
			element.click();			
			Thread.sleep(1000);			
			element = driver.findElement(By.xpath("//h1[text()='전문관/브랜드 바로가기']"));			
			Assert.assertTrue(element.isDisplayed());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
	}
		
}
    
}
