package com.shopeasy.tests;

import com.shopeasy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"}, description = "Đăng nhập thành công")
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(
            driver.getCurrentUrl().contains("inventory"),
            "Phải chuyển đến trang inventory"
        );
    }

    @Test(groups = {"smoke"}, description = "Đăng nhập sai mật khẩu")
    public void testLoginWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(
            loginPage.getErrorMessage().contains("Username and password do not match")
        );
    }

    @Test(groups = {"smoke"}, description = "Đăng nhập để trống")
    public void testLoginEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        Assert.assertTrue(
            loginPage.getErrorMessage().contains("Username is required")
        );
    }
    
    @Test(groups = {"smoke"}, description = "Test fail cố ý để demo CI")
    public void testIntentionalFail() {
        // Assert sai để pipeline báo đỏ
        Assert.assertEquals("actual_value", "expected_value",
            "Test này fail cố ý để demo CI pipeline");
    }

}
