package testProject1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Lists;

public class ConnectRegression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\browserdrivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://qa3-connect.brookson.co.uk/Login");

		driver.manage().window().maximize();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.navigate().refresh();

		// Confirm page loads correctly
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Brookson Connect - Online Portal"))
			System.out.println(
					"Brookson Connect - Online Portal Loaded Correctly");
		else
			System.out.println(
					"The Brookson Connect - Online Portal Page FAILED TO LOAD");
		// System.out.println(driver.getTitle());

		driver.findElement(By.id("userName")).sendKeys("270021");
		driver.findElement(By.name("submit")).click();

		// expected error text
		String exp = "Form invalid!";
		// identify actual error message
		WebElement m = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/ui-view/brookson-login-login/div/div/div/form/div[2]/div[3]"));
		String act = m.getText();
		System.out.println("Expected Error message is: " + exp);
		System.out.println("Actual Error message is: " + act);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.id("Password1")).sendKeys("Bluebell999*");
		driver.findElement(By.name("submit")).click();

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/div[1]/div[1]/ui-view/brookson-login-service-line/div/div/div/form/div[2]/div/select")))
				.click();
		driver.findElement(
				By.xpath("//option[contains(text(),'Mole Replacements')]"))
				.click();

		driver.findElement(By.xpath(
				"//body/div[1]/div[1]/ui-view[1]/brookson-login-service-line[1]/div[1]/div[1]/div[1]/form[1]/div[3]/input[1]"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='menuText ng-binding']")));
		System.out.println("Log In to Connect Live Successful");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[1]/a[1]")))
				.click();
		System.out.println("Dashboard Loaded");

		// Money Manager Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]")))
				.click();
		System.out.println("Money Manager Loaded");
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/brookson-money-manager[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]"))
				.click();
		System.out.println("Weekly Account History Sub-Page Loaded");

		driver.findElement(By.linkText("Profit & Loss")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//th[contains(text(),'Description')]")));
		System.out.println("Profit and Loss Sub-Page Loaded");

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// This page takes a long time to load - the reason the EXPLICIT WAIT is
		// set as
		// 70 seconds
		driver.findElement(By.linkText("Balance Sheet")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[contains(text(),'Fixed assets and investments')]")));
		System.out.println("Balance Sheet Sub-Page Loaded");

		// Expenses Page
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[3]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Personally Paid')]")));
		System.out.println("Expenses Page Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//a[contains(text(),'Business Paid')]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[contains(text(),'Select Assignment')]")));
		System.out.println("Business Paid Sub-Page Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Invoices
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[4]/a[1]")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/brookson-invoicing-ctrl[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")));
		System.out.println("Invoices 'All' Sub-Page Loaded");

		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/brookson-invoicing-ctrl[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]"))
				.click();
		System.out.println("Invoices 'Invoices' Sub-Page Loaded");

		driver.findElement(By.xpath("//a[contains(text(),'Payments')]"))
				.click();
		System.out.println("Invoices 'Payments' Sub-Page Loaded");

		// Open the Raise Invoice Help pop up.
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/brookson-invoicing-ctrl[1]/div[1]/div[1]/div[2]/a[1]"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Help Raising an Invoice pop up opened");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/ng-include[1]/div[1]/a[1]"))
				.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ArrayList<String> tabs2 = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Self Billing Video Tab Opened");

		driver.close();
		driver.switchTo().window(tabs2.get(0));
		System.out.println("Self Billing Video Tab Closed");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/ng-include[1]/div[1]/a[2]"))
				.click();
		System.out.println("Hours Invoice Video Tab Opened");

		ArrayList<String> tabs3 = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs3.get(1));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.switchTo().window(tabs3.get(1));
		driver.close();
		driver.switchTo().window(tabs3.get(0));
		System.out.println("Hours Invoice Video Tab Closed");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/a[1]/i[1]"))
				.click();
		System.out.println("Help Raising an Invoice pop up CLOSED");

		// Raise Invoice Help pop ups
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/brookson-invoicing-ctrl[1]/div[1]/div[1]/div[2]/button[1]"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/brookson-invoicing-raise-invoice[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/a[1]"))
				.click();
		System.out.println("Period End Date Help pop up opened");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/a[1]/i[1]"))
				.click();

		System.out.println("Period End Date Help pop up closed");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/brookson-invoicing-raise-invoice[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h3[1]/a[1]"))
				.click();
		System.out.println("Rate Help pop up opened");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/a[1]/i[1]"))
				.click();
		System.out.println("Rate Help pop up Closed");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/brookson-invoicing-raise-invoice[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/h3[1]/a[1]"))
				.click();
		System.out.println("Chargeable Expenses Help pop Up Opened");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/a[1]/i[1]"))
				.click();
		System.out.println("Chargeable Expenses Help pop Up CLOSED");

		// Assignments
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[5]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'View and Add Assignment')]")));
		System.out.println("View and Add Assignment Page Loaded");

		// Bank
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[6]/a[1]"))
				.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//thead/tr[1]/th[1]")));
		System.out.println("Banking Page Loaded");

		// Planner Page
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[7]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'Task Planner')]")));
		System.out.println("Task Planner Page Loaded");

		// Calendar Page
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[8]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]")));
		System.out.println("Calendar Page Loaded");

		// Documents
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[9]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'Document Storage')]")));
		System.out.println("Document Storage Page Loaded");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body[1]/div[1]/div[2]/div[2]/div[1]/brookson-document-storage[1]/div[1]/div[1]/div[2]/div[2]/div[1]/brookson-document-storage-recently-added-detailed[1]/div[1]/div[1]/div[1]/brookson-document-storage-detailed-table[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement TxtBoxContent10 = driver.findElement(By.xpath(
				"//body[1]/div[5]/div[1]/div[1]/div[2]/ng-pdf[1]/div[1]/div[1]/nav[1]/input[1]"));
		System.out.println("Document Page Number - "
				+ TxtBoxContent10.getAttribute("value"));
		System.out.println("Expected Text is '1'");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(
				By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/a[1]/i[1]"))
				.click();

		// Employment Status
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[10]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'IR35')]")));
		System.out.println("Employment Status Page Loaded");

		// Receipts Bank
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[11]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'Receipt Bank')]")));
		System.out.println("Receipt Bank Page Loaded");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Book a Call button
		String oldTab11 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"//html[1]/body[1]/div[1]/div[1]/brookson-shared-header[1]/header[1]/div[1]/ul[1]/li[2]/a[1]"))
				.click();

		ArrayList<String> newTab11 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab11.remove(oldTab11);

		driver.switchTo().window(newTab11.get(0));

		String actualGooglePageTitle7 = driver.getTitle();
		System.out.println("**BOOK A CALL LIMITED Calendly Opened - "
				+ actualGooglePageTitle7);

		// change focus back to old tab driver.close();
		driver.switchTo().window(oldTab11);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Refer A Friend Button String oldTab12 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/brookson-shared-header[1]/header[1]/div[1]/ul[1]/li[3]/a[1]"))
				.click();

		ArrayList<String> newTab12 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab12.remove(oldTab11);

		driver.switchTo().window(newTab12.get(0));

		String actualGooglePageTitle8 = driver.getTitle();
		System.out
				.println("**REFER A FRIEND Opened - " + actualGooglePageTitle8);

		// change focus back to old tab driver.close();
		driver.switchTo().window(oldTab11);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// SWITH TO UMBRELLA
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/span[1]"))
				.click();
		System.out.println("*** UMBRELLA NOW LOADED ***");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Raise Timesheet')]")));
		System.out.println("   Umbrella Dashboard Loaded");

		// PERSONAL TAX
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[7]/a[1]/span[1]"))
				.click();
		System.out.println("*** Personal Tax ***");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Personal Tax Planner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[7]/ul[1]/li[1]/a[1]")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h3[contains(text(),'Colour Key')]")));

		System.out.println("   Task Planner Page Loaded");

		// Personal Tax Tracker
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[2]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(text(),'Breakdown Of Income Received')]")));
		System.out.println("   Personal Tax Tracker Page Loaded");

		// Self Assessment Tax Pack
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[4]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'Self Assessment Tax Pack')]")));
		System.out.println("   Self Assessment Tax Pack Page Loaded");

		// Personal Tax Documents
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[5]/a[1]"))
				.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//thead/tr[1]/th[4]")));
		System.out.println("   Personal Tax Documents Page Loaded");

		// Financial Services Page
		driver.findElement(By.xpath(
				"//html[1]/body[1]/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[13]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/brookson-financial-services-fin-plan[1]/div[2]/p[1]")));
		System.out.println("*** The Financial Services Page Loaded***");

		// FinPlan Portal Login page
		String oldTab4 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"//a[contains(text(),'Login to Financial Services Portal')]"))
				.click();
		ArrayList<String> newTab4 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab4.remove(oldTab4);

		driver.switchTo().window(newTab4.get(0));
		System.out.println(driver.getTitle());

		String actualGooglePageTitle1 = driver.getTitle();
		System.out.println(
				"** Fin Plan Login Page Opened - " + actualGooglePageTitle1);

		// change focus back to old tab
		driver.close();
		driver.switchTo().window(oldTab4);

		// Pensions Calendly Page
		String oldTab5 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"//a[contains(text(),'Book time with Pensions and Investments services')]"))
				.click();

		ArrayList<String> newTab5 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab5.remove(oldTab5);

		driver.switchTo().window(newTab5.get(0));

		String actualGooglePageTitle2 = driver.getTitle();
		System.out.println(
				"** Pension Calendly Opened - " + actualGooglePageTitle2);

		// change focus back to old tab
		driver.close();
		driver.switchTo().window(oldTab5);

		// Mortgage Calendly Page
		String oldTab6 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"//a[contains(text(),'Book time with Mortgage services')]"))
				.click();

		ArrayList<String> newTab6 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab6.remove(oldTab6);

		driver.switchTo().window(newTab6.get(0));

		String actualGooglePageTitle3 = driver.getTitle();
		System.out.println(
				"** Mortgage Calendly Opened - " + actualGooglePageTitle3);
		// change focus back to old tab
		driver.close();
		driver.switchTo().window(oldTab6);

		// Initial Call Insurance Calendly Page
		String oldTab7 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"//a[contains(text(),'Book time with Protection services')]"))
				.click();

		ArrayList<String> newTab7 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab7.remove(oldTab7);

		driver.switchTo().window(newTab7.get(0));

		String actualGooglePageTitle4 = driver.getTitle();
		System.out.println("** Initial Insurance Calendly Opened - "
				+ actualGooglePageTitle4);

		// change focus back to old tab
		driver.close();
		driver.switchTo().window(oldTab7);

		// Financial Health Check Calendly Page
		String oldTab8 = driver.getWindowHandle();
		driver.findElement(
				By.xpath("//a[contains(text(),'Financial Health Check')]"))
				.click();

		ArrayList<String> newTab8 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab8.remove(oldTab8);

		driver.switchTo().window(newTab8.get(0));

		String actualGooglePageTitle5 = driver.getTitle();
		System.out.println("** Financial Health Check Calendly Opened - "
				+ actualGooglePageTitle5);

		// change focus back to old tab
		driver.close();
		driver.switchTo().window(oldTab8);

		// Jobs Board
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[13]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='container']")));
		System.out.println("*** Jobs Board Page Loaded***");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Knowledge Centre
		String oldTab9 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[15]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[15]/a[1]/span[1]")));
		System.out.println("*** Knowledge Centre Page Loaded***");

		ArrayList<String> newTab1 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab1.remove(oldTab9);

		driver.switchTo().window(newTab1.get(0));
		System.out.println(driver.getTitle());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();

		// change focus back to old tab
		driver.switchTo().window(oldTab9);

		// Umbrella
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Raise Timesheet')]")));
		System.out.println("*** UMBRELLA (ELLA) NOW LOADED ***");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[4]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body[1]/div[1]/div[2]/div[2]/div[1]/brookson-invoicing-ctrl[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")));
		System.out.println("**Timesheets Page Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Load Assignments Page
		driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[5]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/view-assignments[1]/div[1]/div[4]/div[1]/div[1]/a[1]")));
		System.out.println("**The Assignments Page Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Load UMB Doc Storage Page
		driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[9]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body[1]/div[1]/div[2]/div[2]/div[1]/brookson-document-storage[1]/div[1]/div[1]/div[2]/div[2]/div[1]/brookson-document-storage-recently-added-detailed[1]/div[1]/div[1]/div[1]/brookson-document-storage-detailed-table[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));
		System.out.println("***Umbrella Doc Storage Page Loaded");

		// Open First Doc in List
		driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/div[2]/div[1]/brookson-document-storage[1]/div[1]/div[1]/div[2]/div[2]/div[1]/brookson-document-storage-recently-added-detailed[1]/div[1]/div[1]/div[1]/brookson-document-storage-detailed-table[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Get Doc page Number and Print
		WebElement TxtBoxContent11 = driver.findElement(By.xpath(
				"//body[1]/div[5]/div[1]/div[1]/div[2]/ng-pdf[1]/div[1]/div[1]/nav[1]/input[1]"));
		System.out.println("Document Page Number - "
				+ TxtBoxContent11.getAttribute("value"));
		System.out.println("Expected Text is '1'");

		// Close Doc
		driver.findElement(
				By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/a[1]/i[1]"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Starter Zone
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[12]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[6]")));
		System.out.println("*** Starter Zone Loaded ***");

		// Understanding Umbrella
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h4[contains(text(),'Umbrella FAQ')]")));
		System.out.println("*** Starter Zone Understanding Umbrella Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Choose your Package
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[12]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[6]")));
		System.out.println("*** Starter Zone Loaded");
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[2]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//h4[contains(text(),'Do You Have An Existing Limited Company?')]")));
		System.out.println("*** Starter Zone Choose Your Package page Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Your Umbrella Benefits
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[12]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[6]")));
		System.out.println("*** Starter Zone Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Umbrella Benefits page

		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[3]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h4[contains(text(),'Brookson Rewards Scheme')]")));
		System.out
				.println("*** Starter Zone Your Umbrella Benefits page Loaded");
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// What To Expect On Payday
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[12]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[6]")));
		System.out.println("*** Starter Zone Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[4]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h4[contains(text(),'Further support')]")));
		System.out.println(
				"*** Starter Zone What To Expect On Payday page Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Personal InformationPage
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[12]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[6]")));
		System.out.println("*** Starter Zone Loaded");
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[5]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Edit details')]")));
		System.out.println("*** Starter Zone Personal Details page Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Questions and Support
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[12]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[6]")));
		System.out.println("*** Starter Zone Loaded");
		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[6]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"container\"]/div[2]/div/starter-zone-questions-and-support/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div/div")));
		System.out
				.println("*** Starter Zone Questions and Support page Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[1]/brookson-shared-navigation[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[12]/a[1]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[1]/starter-zone-section-list[1]/div[1]/div[1]/div[1]/a[6]")));
		System.out.println("*** Starter Zone Loaded");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]/div[1]"))
				.click();

		// New Tab Switch to - Switch Back
		List<String> browserTabs = Lists
				.newArrayList(driver.getWindowHandles());

		// Switch to second tab
		driver.switchTo().window(browserTabs.get(1));

		System.out.println(
				"*** The Umbrella Payslip Explained opened on a new tab");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Return to first tab
		driver.switchTo().window(browserTabs.get(0));

		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/a[1]/div[1]"))
				.click();

		// New Tab Switch to - Switch Back
		List<String> browserTabs1 = Lists
				.newArrayList(driver.getWindowHandles());

		// Switch to second tab
		driver.switchTo().window(browserTabs1.get(1));

		System.out.println(
				"*** The I've not been Paid. What Do I Do? page opened on a new tab");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Return to first tab
		driver.switchTo().window(browserTabs.get(0));

		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/a[1]/div[1]"))
				.click();

		// New Tab Switch to - Switch Back
		List<String> browserTabs2 = Lists
				.newArrayList(driver.getWindowHandles());

		// Switch to second tab
		driver.switchTo().window(browserTabs2.get(1));

		System.out.println("*** The Top 10 FAQ's page opened on a new tab");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Return to first tab
		driver.switchTo().window(browserTabs.get(0));

		driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/div[1]/starter-zone-main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/a[1]"))
				.click();

		// New Tab Switch to - Switch Back
		List<String> browserTabs3 = Lists
				.newArrayList(driver.getWindowHandles());

		// Switch to second tab
		driver.switchTo().window(browserTabs3.get(1));

		System.out.println("*** The Video Explainers tab opened");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Return to first tab
		driver.switchTo().window(browserTabs.get(0));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/brookson-shared-header/header/div/ul/li[3]/div/div"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/brookson-shared-header/header/div/ul/li[3]/ul/li[2]/p"))
				.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print First Name
		WebElement TxtBoxContent = driver
				.findElement(By.xpath("//input[@id='firstName_field']"));
		System.out
				.println("First Name - " + TxtBoxContent.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print Middle Name
		WebElement TxtBoxContent1 = driver
				.findElement(By.xpath("//input[@id='middleName_field']"));
		System.out.println(
				"Middle Name - " + TxtBoxContent1.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print Last name
		WebElement TxtBoxContent2 = driver
				.findElement(By.xpath("//input[@id='surname_field']"));
		System.out
				.println("Last Name - " + TxtBoxContent2.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print Nationality
		WebElement TxtBoxContent3 = driver
				.findElement(By.xpath("//select[@id='nationality_field']"));
		System.out.println(
				"Nationality - " + TxtBoxContent3.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print NI Number
		WebElement TxtBoxContent4 = driver
				.findElement(By.xpath("//input[@id='niNumber_field']"));
		System.out
				.println("NI Number - " + TxtBoxContent4.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print Address 1
		WebElement TxtBoxContent5 = driver
				.findElement(By.xpath("//input[@id='address1_field']"));
		System.out.println(
				"Address Line 1 - " + TxtBoxContent5.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print Address 2
		WebElement TxtBoxContent6 = driver
				.findElement(By.xpath("//input[@id='address2_field']"));
		System.out.println(
				"Address Line 2 " + TxtBoxContent6.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print Town
		WebElement TxtBoxContent7 = driver
				.findElement(By.xpath("//input[@id='city_field']"));
		System.out.println("Town - " + TxtBoxContent7.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print County
		WebElement TxtBoxContent8 = driver
				.findElement(By.xpath("//input[@id='county_field']"));
		System.out.println("County - " + TxtBoxContent8.getAttribute("value"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print Postcode
		WebElement TxtBoxContent9 = driver
				.findElement(By.xpath("//input[@id='postcode_field']"));
		System.out
				.println("Postcode - " + TxtBoxContent9.getAttribute("value"));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Book a Call button
		String oldTab10 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"//html[1]/body[1]/div[1]/div[1]/brookson-shared-header[1]/header[1]/div[1]/ul[1]/li[2]/a[1]"))
				.click();

		ArrayList<String> newTab10 = new ArrayList<String>(
				driver.getWindowHandles());
		newTab8.remove(oldTab10);

		driver.switchTo().window(newTab10.get(0));

		String actualGooglePageTitle6 = driver.getTitle();
		System.out.println("**BOOK A CALL Umbrella Calendly Opened - "
				+ actualGooglePageTitle6);

		// change focus back to old tab
		driver.switchTo().window(oldTab10);

		// Logout
		driver.findElement(By.xpath("//div[@class='profile-header-img']"))
				.click();
		driver.findElement(By.xpath("//a[@class='btn btn-danger pull-right']"))
				.click();

		if (driver.getPageSource().contains("/Login"))
			System.out.println(
					"Connect3 Has Logged Out WOOO-HOOO !!...I AM INVINCIBLE!!");
		else
			System.out.println(
					"Connect3 Has NOT logged out correctly - SLUG HEAD");

		driver.quit();
		System.out.println("The Browser window has now been closed");

	}

}
