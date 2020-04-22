package com.techproed.tests;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryDropdownTest {
    GlbHomePage obj= new GlbHomePage();
    @Test
    public void hasCategory() {
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        Select options = new Select(obj.glbTraderHomePageDropDown);
        //System.out.println(options.getOptions());

        boolean flag=false;
        for (WebElement option : options.getOptions()) {
            if (option.getText().equals("Furniture")) {
                System.out.println("dropdown has furniture");
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);

        Assert.assertTrue(options.getOptions().stream().map(t->t.getText()).anyMatch(t->t.equals("Furniture")));

    }
}
