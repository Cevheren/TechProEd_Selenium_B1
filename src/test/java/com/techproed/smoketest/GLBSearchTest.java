package com.techproed.smoketest;

import com.techproed.pages.GLBSearchPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GLBSearchTest {

    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        GLBSearchPage glbSearchPage = new GLBSearchPage();

        glbSearchPage.searchButton.click();
        boolean hasCamera = false;
        for (WebElement w : glbSearchPage.productsList) {
            System.out.println(w.getText());
            if (w.getText().contains("Camera")) {
                hasCamera = true;
                break;
            }
        }
        System.out.println("There are "+glbSearchPage.productsList.size()+" elements on the first page");
        //Asserting if the search result has Camera
        Assert.assertTrue(hasCamera);

        Assert.assertTrue(glbSearchPage.productsList.stream().map(t->t.getText()).anyMatch(t->t.contains("Camera")));



    }
}
