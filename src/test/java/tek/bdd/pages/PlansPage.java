package tek.bdd.pages;

import org.openqa.selenium.By;

public class PlansPage {

    public final static By plansLink = By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[2]");



    public final static By plansTableRows = By.xpath("//table/tbody/tr");

    public final static By dateCreatedColumn = By.xpath("//tbody/tr/td[4]");



    public final static By dateExpireColumn = By.xpath("//tbody/tr/td[5]");



}
