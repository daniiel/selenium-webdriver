package com.searchmodule.tests;

import com.search.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"value"})
    public void search(String value) {
        SearchPage page = new SearchPage(driver);
        page.goTo();
        page.doSearch(value);
        page.goToVideos();
        int actualSize = page.getResult();
        Assert.assertTrue(actualSize > 0);
    }

}

