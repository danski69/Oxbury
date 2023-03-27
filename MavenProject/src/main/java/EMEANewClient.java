import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EMEANewClient {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\browserdrivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		@SuppressWarnings("unused")
		ChromeDriver driver = new ChromeDriver(options);

		options.addArguments(new String[]{"--incognito"});
		ChromeDriver chromeDriver = new ChromeDriver(options);
		chromeDriver.get("https://ir35v2-uat.people20.com/#/");

		chromeDriver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait((WebDriver) chromeDriver,
				Duration.ofSeconds(10));

		wait.until((Function) ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html[1]/body[1]/app-root[1]/app-home-container[1]/div[1]/div[1]/div[1]/div[1]/app-log-in[1]/div[1]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[1]/formly-wrapper-form-field[1]/div[1]/input[1]")));
		System.out.println("IC Verify Log In page load Successful");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home-container[1]/div[1]/div[1]/div[1]/div[1]/app-log-in[1]/div[1]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[1]/formly-wrapper-form-field[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"dan.skinner@brookson.co.uk"});

		wait.until((Function) ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html[1]/body[1]/app-root[1]/app-home-container[1]/div[1]/div[1]/div[1]/div[1]/app-log-in[1]/div[1]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[2]/formly-wrapper-form-field[1]/div[1]/input[1]")));
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home-container[1]/div[1]/div[1]/div[1]/div[1]/app-log-in[1]/div[1]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[2]/formly-wrapper-form-field[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"Bluebell999*"});

		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home-container[1]/div[1]/div[1]/div[1]/div[1]/app-log-in[1]/div[1]/form[1]/div[2]/input[1]"))
				.click();
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("IC verify Logged in Successful");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"//body/app-root[1]/app-dashboard-container[1]/div[1]/div[2]/div[1]/app-clients-container[1]/app-data-container[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[1]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"XYXY TEST COMPANY"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[2]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"Test Address 1"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[3]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"Test Address 2"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[4]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"Test Address Town"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[5]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"Test Address County"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[6]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"TE5 7ER"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[7]/formly-wrapper-form-field[1]/div[1]/select[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html/body/ngb-modal-window/div/div/app-client-details-container/div[2]/div/div/app-client-account/div/form/div[1]/formly-form/formly-field/formly-group/formly-field[7]/formly-wrapper-form-field/div/select/option[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[9]/formly-wrapper-form-field[1]/div[1]/select[1]"))
				.click();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[9]/formly-wrapper-form-field[1]/div[1]/select[1]/option[1]"))
				.click();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-client-account[1]/div[1]/form[1]/div[2]/input[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until((Function) ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h4[contains(text(),'XYXY TEST COMPANY')]")));
		System.out.println("New Client Created Successfully");
		driver.findElement(By.xpath(
				"/html/body/ngb-modal-window/div/div/app-client-details-container/div[2]/ul/li[2]/a"))
				.click();
		driver.findElement(By.xpath("//button[contains(text(),'New user')]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-user-account[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[1]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"xyxy@test.com"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-user-account[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[2]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"TEST"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-user-account[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[3]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"USER"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-user-account[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[4]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"01234 56789"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-user-account[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[5]/formly-wrapper-form-field[1]/div[1]/select[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-user-account[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[5]/formly-wrapper-form-field[1]/div[1]/select[1]/option[2]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-user-account[1]/div[2]/form[1]/div[1]/input[1]"))
				.click();
		wait.until((Function) ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h4[contains(text(),'XYXY TEST COMPANY')]")));
		System.out.println("New USER Created Successfully");
		driver.findElement(By.xpath(
				"//body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/ul[1]/li[3]/a[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(),'New role')]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[1]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"TEST ROLE"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[2]/formly-wrapper-text-wrapper[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"TEST AGENCY"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[5]/formly-wrapper-form-field[1]/div[1]/select[1]"))
				.click();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[5]/formly-wrapper-form-field[1]/div[1]/select[1]/option[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[10]/formly-card-wrapper[1]/div[1]/div[2]/formly-repeat-section[1]/div[2]/button[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[10]/formly-card-wrapper[1]/div[1]/div[2]/formly-repeat-section[1]/div[1]/formly-field[1]/formly-group[1]/formly-field[1]/formly-wrapper-form-field[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"Fred the Ted"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Add a Daily rate
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[10]/formly-card-wrapper[1]/div[1]/div[2]/formly-repeat-section[1]/div[1]/formly-field[1]/formly-group[1]/formly-field[2]/formly-wrapper-form-field[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"250.00"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[10]/formly-card-wrapper[1]/div[1]/div[2]/formly-repeat-section[1]/div[1]/formly-field[1]/formly-group[1]/formly-field[3]/formly-wrapper-form-field[1]/div[1]/div[2]/input[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Add Contract Length
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[10]/formly-card-wrapper[1]/div[1]/div[2]/formly-repeat-section[1]/div[1]/formly-field[1]/formly-group[1]/formly-field[4]/formly-wrapper-form-field[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"12"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Add the project name
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/formly-form[1]/formly-field[1]/formly-group[1]/formly-field[10]/formly-card-wrapper[1]/div[1]/div[2]/formly-repeat-section[1]/div[1]/formly-field[1]/formly-group[1]/formly-field[5]/formly-wrapper-form-field[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"TEST PROJECT"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[2]/div[1]/div[1]/app-role-detail[1]/div[2]/form[1]/div[1]/input[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until((Function) ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h4[contains(text(),'XYXY TEST COMPANY')]")));
		System.out.println("New ROLE with CONTRACTOR Created Successfully");
		driver.findElement(By.xpath(
				"//body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/ul[1]/li[4]/a[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement TxtBoxContent = chromeDriver.findElement(By.xpath(
				"/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[2]/div[1]/div[1]/app-status-container[1]/div[1]/div[1]/app-status-count[1]/table[1]/tbody[1]/tr[1]/td[2]"));
		System.out.println("STATUS Page, Contractors Total Number    - "
				+ TxtBoxContent.getAttribute("value"));
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"//html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-client-details-container[1]/div[1]/button[1]/span[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"//html[1]/body[1]/app-root[1]/app-dashboard-container[1]/div[1]/div[2]/div[1]/app-clients-container[1]/app-data-container[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(new CharSequence[]{"XYXY"});
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-dashboard-container[1]/div[1]/div[2]/div[1]/app-clients-container[1]/app-data-container[1]/form[1]/div[1]/div[1]/div[1]/div[1]/ngb-typeahead-window[1]/button[1]/ngb-highlight[1]"))
				.click();
		// Delete the test customer
		driver.findElement(By.xpath("//tbody/tr[1]/td[6]/fa-icon[1]/*[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]"))
				.click();
		System.out.println("The Test Customer Has Been Deleted");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("//header/div[1]/div[1]/div[1]/fa-icon[1]/*[1]"))
				.click();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[contains(text(),'Log off')]")).click();
		System.out.println("You have logged out of the IR35 App");
		driver.quit();
		System.out.println("Chrome has been Closed");
	}
}
