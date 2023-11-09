package tek.bdd.pages;

import org.openqa.selenium.By;

public class CreateAccountPage {

    public final static By createPrimaryAccountBtn = By.linkText("Create Primary Account");
    public final static By primaryAccountFormText = By.xpath("//h2[contains(text(),'Create Primary Account Holder')]");
    public final static By emailAddressField = By.id("email");
    public final static By titleField = By.id("title");
    public final static By firstNameField = By.id("firstName");
    public final static By lastNameField = By.id("lastName");
    public final static By genderField = By.id("gender");
    public final static By maritalStatusField = By.id("maritalStatus");
    public final static By employmentStatusField = By.id("employmentStatus");
    public final static By dateOfBirth = By.id("dateOfBirth");
    public final static By clickOnPrimaryAccountBtn = By.xpath("//button[@type='submit']");
    public final static By signUpAccountForm = By.xpath("//h2[contains(text(),'Sign up your account')]");
    public final static By emailAddressDisplayed = By.xpath("//h2[@class='chakra-heading css-18j379d'][2]");
    public final static By errorBanner = By.xpath("//div[contains(text(), 'ERROR')]");


}
