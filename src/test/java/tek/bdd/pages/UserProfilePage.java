package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class UserProfilePage {

    public final static By loginButton = By.linkText("Login");

    public final static By logoutButton = By.xpath("//button[contains(text(),'Logout')]");

    public final static By homePageElement = By.xpath("//h2[contains(text(),'Lets get you started')]");
    public final static By usernameField = By.id("username");

    public final static By passwordField = By.id("password");

    public final static By profileButton = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/button[1]");

    public final static By profileHeader = By.xpath("//header");
    public final static By profileStatus = By.xpath("//span[contains(text(),'Active')]");
    public final static By profileUserType = By.xpath("//p[contains(text(),'CSR')]");
    public final static By profileName = By.xpath("//p[contains(text(),'Supervisor')]");

    public final static By profileUsername = By.xpath("//p[contains(text(),'supervisor')]");

    public static final By profileAuthorities = By.xpath("//li[contains(text(),'admin')]");
}