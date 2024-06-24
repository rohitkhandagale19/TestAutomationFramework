package com.framework.tests;


import com.epam.framework.pages.AccountPage;
import com.epam.framework.pages.LoginPage;
import com.epam.framework.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactTest extends BaseTest {

    @DataProvider(name = "contactData")
    public Iterator<Object[]> contactDataProvider() {
        String filePath = "TestData.xlsx"; // Provide the actual path
        String sheetName = "Sheet1";
        List<String[]> data = ExcelReader.readExcelData(filePath, sheetName);

        List<Object[]> dataProvider = new ArrayList<>();
        for (String[] row : data) {
            dataProvider.add(row);
        }
        return dataProvider.iterator();
    }

    @Test(dataProvider = "contactData")
    public void fillContactTest(String firstName, String lastName, String emailAddress) {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        loginPage.loginToApplication();
        accountPage.goToContact();

        accountPage.enterContactDetails(firstName, lastName, emailAddress);

    }
}
