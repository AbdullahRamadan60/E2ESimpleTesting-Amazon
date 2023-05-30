package E2EScenario;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllVideoGamesPage;
import pages.ProductPage;


public class E2ETest extends BaseTests
{
    @Test
    public void testTheSuccessfulPurchaseScenario()
    {
        SoftAssert softAssert = new SoftAssert();

        /*LoginPage loginPage = homePage.clickLoginToolTipButton();
        loginPage.setEmail("test@test.com");
        loginPage.setPassword("P@ssw0rd");
        loginPage.clickSignInButton();*/

        //softAssert.assertTrue(getWindowManager().getCurrentWindowTitle().contains("Your Souq is now Amazon.eg | Welcome to Amazon.eg in Egypt."));

        homePage.clickNavBarHamburgerMenu();
        homePage.clickHamburgerMenuSeeAll();
        homePage.clickHamburgerMenuVideoGames();
        AllVideoGamesPage allVideoGamesPage = homePage.clickHamburgerMenuAllVideoGames();

        softAssert.assertEquals(allVideoGamesPage.getPageHeader() , "Video Games");

        allVideoGamesPage.clickFreeShippingCheckBox();
        try {Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        allVideoGamesPage.scrollToNewConditionFilter();
        try {Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        allVideoGamesPage.clickNewConditionFilter();
        try {Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        allVideoGamesPage.scrollToSortMenu();
        try {Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        allVideoGamesPage.sortBy("Price: High to Low");
        try {Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}

        ProductPage productPage = allVideoGamesPage.openInNewTabsProducts(AllVideoGamesPage.ComparisonOperator.lessThan , 15000);
        //getWindowManager().openLoginPageInANewWindow();
        try {Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        productPage.addAllRequiredProductsToCart();
        try {Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}

        gotoHomepage();
        try {Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}

        softAssert.assertEquals(homePage.getNavCartCount() , allVideoGamesPage.getNumOfRequiredProducts());
    }
}
