package com.screwfix.data;

import org.testng.annotations.DataProvider;

public class MainPageData {
    @DataProvider(name = "main page elements")
    public static Object[][] mainPageElements(){
        return new Object[][] {
                {"Your account link", "header_link_sign_in"},
                {"","search_submit_button"},
                {"","branding-logo"},
                {"","firstLevelCat_0"}
        };
    }
}
