package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class CommonPage extends SeleniumUtility {

    public static By getLinkLocator(String linkText) {
        return By.partialLinkText(linkText);
    }
}
