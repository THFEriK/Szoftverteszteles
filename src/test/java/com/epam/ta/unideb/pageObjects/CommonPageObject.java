package com.epam.ta.unideb.pageObjects;

import com.epam.ta.unideb.factory.WebDriverFactory;
import org.openqa.selenium.support.PageFactory;

public class CommonPageObject {

    public CommonPageObject(final WebDriverFactory factory) {
        PageFactory.initElements(WebDriverFactory.getInstance(), this);
    }
}
