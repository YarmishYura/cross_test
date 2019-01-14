package ua.org.autotest;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class OpenPageTest extends BaseTest {
    @Test
    public void openpage(){
        driver.get("https://testmatick.com");
        String titleActual = driver.getTitle();
        String titleExcpected = "TestMatick – Quality is Never too Much";
        Assert.assertEquals(titleActual, titleExcpected);
    }
}