package repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.ActionsHelper;
import enums.Direction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;

public class HomeScreen {
	
	ActionsHelper actionsHelper;
	
	public HomeScreen(AndroidDriver androidDriver){
		Allure.step("home screen intinialtion is starated...");
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		this.actionsHelper = new ActionsHelper(androidDriver);
	}

    //* Header
    private static final String smartDigiBook_Icon = "com.app.smartdigibook:id/imgLogo";
    private static final String wallet_Btn = "com.app.smartdigibook:id/rvWallet";
    private static final String notification_Btn = "com.app.smartdigibook:id/flNotification";
    private static final String cart_Btn = "com.app.smartdigibook:id/flNotificationCartlist";
    private static final String profile_Img = "com.app.smartdigibook:id/imgProfile";
    private static final String profile_Btn = "com.app.smartdigibook:id/constraintProfileInitial";
    private static final String banner_Img = "com.app.smartdigibook:id/imageViewPage";

    //* My Library
    private static final String myLibrary_Txt = "com.app.smartdigibook:id/titles";
    private static final String category_Sec = "com.app.smartdigibook:id/llCategory";
    private static final String categoryAll_Btn = "com.app.smartdigibook:id/txtCategoryAll";
    private static final String search_TxtFd = "com.app.smartdigibook:id/search_src_text";

    //* My Books Section
    private static final String booksBanner_Img = "com.app.smartdigibook:id/rvmain";
    private static final String myBooks_Txt = "com.app.smartdigibook:id/txtMybooks";
    private static final String redeemAccessCode_Btn = "com.app.smartdigibook:id/imgRedeemAccessCode";
    private static final String bookProgressBar_Img = "com.app.smartdigibook:id/progressbarBook";
    private static final String bookCover_Img = "com.app.smartdigibook:id/imgBookImage";
    private static final String bookFeedback_Btn = "com.app.smartdigibook:id/ivFeedback";
    private static final String bookName_Txt = "com.app.smartdigibook:id/txtBookName";
    private static final String bookPremium_Icon = "com.app.smartdigibook:id/premiumLayout";

    //* Recent Activities
    private static final String recentActivities_Txt = "com.app.smartdigibook:id/txtRecentNote";
    private static final String recentActivitiesViewAll_Lnk = "com.app.smartdigibook:id/txtSeeAll";
    private static final String recentActivity_Img = "com.app.smartdigibook:id/ivEdit";
    private static final String recentActivityBookTitle_Txt = "com.app.smartdigibook:id/txtContent";
    private static final String recentActivityBook_Img = "com.app.smartdigibook:id/ivBook";
    private static final String recentActivityDesc_Txt = "com.app.smartdigibook:id/tvDesc";
    private static final String recentActivityPageNo_Txt = "com.app.smartdigibook:id/tvPageNo";
    private static final String recentActivityArrow_Img = "com.app.smartdigibook:id/imgArrow";

    //* Recent Activities View All Screen
    private static final String recentActivitiesTitle_Txt = "//android.widget.TextView[@text='Recent Activities']";
    private static final String digitalResources_Btn = "//android.widget.LinearLayout[@content-desc='Digital Resources']";
    private static final String highlights_Btn = "//android.widget.LinearLayout[@content-desc='Highlights']";
    private static final String bookmarks_Btn = "//android.widget.LinearLayout[@content-desc='Bookmarks']";
    private static final String stickyNotes_Btn = "//android.widget.LinearLayout[@content-desc='Sticky notes']";
    private static final String digitalPen_Btn = "//android.widget.LinearLayout[@content-desc='Digital Pen']";
    private static final String recentSearch_TxtFd = "com.app.smartdigibook:id/searchView";
    private static final String noDataFound_Txt = "com.app.smartdigibook:id/tvNoDataFound";
    private static final String activitySerialNum_Txt = "com.app.smartdigibook:id/txtPageNumber";
    private static final String activityBookCover_Img = "com.app.smartdigibook:id/bookPic";
    private static final String activityBookName_Txt = "com.app.smartdigibook:id/txtContent";
    private static final String activityPageNo_Txt = "com.app.smartdigibook:id/tvChapter";
    private static final String activityPageDigitNumber_Txt = "com.app.smartdigibook:id/tvChapterNo";
    private static final String activityType_Img = "com.app.smartdigibook:id/ivType";
    private static final String activityNavigationArrow_Img = "com.app.smartdigibook:id/imgArrow";

    //* The Smart Store
    private static final String theSmartStore_Txt = "com.app.smartdigibook:id/txtRecommendBook";
    private static final String smartStoreViewAll_Lnk = "com.app.smartdigibook:id/recommendBookViewAll";
    private static final String smartStoreBook_Img = "//android.widget.GridView[@resource-id='com.app.smartdigibook:id/rvRecommendBook'] //*[@resource-id='com.app.smartdigibook:id/imgBookImage']";
    private static final String smartStoreBookName_Txt = "//android.widget.GridView[@resource-id='com.app.smartdigibook:id/rvRecommendBook'] //*[@resource-id='com.app.smartdigibook:id/txtBookName']";
    private static final String smartStoreBookAmount_Txt = "com.app.smartdigibook:id/afterDiscountAmount";
    private static final String smartStoreBookFavourite_Img = "com.app.smartdigibook:id/addToFavorite";
    private static final String smartStoreBookPremium_Txt = "//android.widget.TextView[@text='Premium DigiBook']";
    private static final String smartStoreUpdagrade_Btn = "com.app.smartdigibook:id/btnUpgrade";
    private static final String smartStoreAddToCart_Btn = "com.app.smartdigibook:id/btnAddToCart";
    private static final String smartStoreCartOrUpgrade_Btn = "//android.widget.LinearLayout[@resource-id='com.app.smartdigibook:id/premiumLayout']//following-sibling::android.widget.Button";

    //* Promotional Books
    private static final String promotionalBooks_Txt = "com.app.smartdigibook:id/txtPromoBook";
    private static final String promotionalBook_Img = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.app.smartdigibook:id/rvPromoBook']//child::android.widget.ImageView";
    private static final String promotionalBookName_Txt = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.app.smartdigibook:id/rvPromoBook']//child::android.widget.TextView";

    //* Search
    private static final String searchClear_Icon = "com.app.smartdigibook:id/searchclosebtn";
    private static final String noBooksFound_Img = "//android.widget.LinearLayout[@resource-id='com.app.smartdigibook:id/noBookFoundLayout']//child::android.widget.ImageView";
    private static final String noBookFound_Txt = "//android.widget.TextView[@text='No books found!']";
    private static final String weCouldNotFound_Txt = "com.app.smartdigibook:id/notfoundline1";
    private static final String matchesYourSearch_Txt = "com.app.smartdigibook:id/notfoundline2";

    //* Recent Viewed Books
    private static final String recentlyViewed_Txt = "com.app.smartdigibook:id/txtRecentBook";
    private static final String recentlyViewedBook_Img = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.app.smartdigibook:id/rvRecentBook']//child::android.widget.ImageView[@resource-id='com.app.smartdigibook:id/imgBookImage']";
    private static final String recentlyViewedBookRatting_Btn = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.app.smartdigibook:id/rvRecentBook']//child::android.widget.ImageView[@resource-id='com.app.smartdigibook:id/ivFeedback']";
    private static final String recentlyViewedBookName_Txt = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.app.smartdigibook:id/rvRecentBook']//child::android.widget.TextView";

    //* Bottom Navigation Bar
    private static final String home_Sec = "com.app.smartdigibook:id/rvhomeBg";
    private static final String home_Img = "com.app.smartdigibook:id/imgHome";
    private static final String home_Txt = "com.app.smartdigibook:id/txtTab";
    private static final String theSmartStore_Sec = "com.app.smartdigibook:id/rvSmartStoreBg";
    private static final String theSmartStore_Img = "com.app.smartdigibook:id/imgSmartStore";
    private static final String navigationTheSmartStore_Txt = "com.app.smartdigibook:id/txtSmartStore";
    private static final String nsp_Sec = "com.app.smartdigibook:id/rvNspBg";
    private static final String nsp_Img = "com.app.smartdigibook:id/imgNsp";
    private static final String nsp_Txt = "com.app.smartdigibook:id/txtNsp";
    private static final String rewards_Sec = "com.app.smartdigibook:id/rvRewardsBg";
    private static final String rewards_Img = "com.app.smartdigibook:id/imgRewards";
    private static final String rewards_Txt = "com.app.smartdigibook:id/txtRewards";
    private static final String loadingMessage_Txt = "com.app.smartdigibook:id/loading_msg";
    private static final String loader_Icon = "com.app.smartdigibook:id/loader";
    private static final String back_Btn = "com.app.smartdigibook:id/backMenu";

    //* 1.Header
    @AndroidFindBy(id = smartDigiBook_Icon)
    private WebElement smartDigiBookIcon;

    @AndroidFindBy(id = wallet_Btn)
    private WebElement walletBtn;

    @AndroidFindBy(id = notification_Btn)
    private WebElement notificationBtn;

    @AndroidFindBy(id = cart_Btn)
    private WebElement cartBtn;

    @AndroidFindBy(id  = profile_Img)
    private WebElement profileImg;

    @AndroidFindBy(id = profile_Btn)
    private WebElement profileBtn;

    @AndroidFindBy(id = banner_Img)
    private WebElement bannerImg ;

    //* 2.My Library
    @AndroidFindBy(id = myLibrary_Txt)
    private WebElement myLibraryTxt;

    @AndroidFindBy(id = category_Sec)
    private WebElement categorySec;

    @AndroidFindBy(id = categoryAll_Btn)
    private WebElement categoryAllBtn;

    @AndroidFindBy(id = search_TxtFd)
    private WebElement searchTxtFd;

    //* 3.My Books
    @AndroidFindBy(id = booksBanner_Img)
    private WebElement booksBannerImg;

    @AndroidFindBy(id = myBooks_Txt)
    private WebElement myBooksTxt;

    @AndroidFindBy(id = redeemAccessCode_Btn)
    private WebElement redeemAccessCodeBtn;

    @AndroidFindBy(id = bookProgressBar_Img)
    private WebElement bookProgressBarImg;

    @AndroidFindBy(id = bookCover_Img)
    private WebElement bookCoverImg;

    @AndroidFindBy(id = bookFeedback_Btn)
    private WebElement bookFeedbackBtn;

    @AndroidFindBy(id = bookName_Txt)
    private WebElement bookNameTxt;

    @AndroidFindBy(id = bookPremium_Icon)
    private WebElement bookPremiumIcon;

    //* 4.Recent Activities
    @AndroidFindBy(id = recentActivities_Txt)
    private WebElement recentActivitiesTxt;

    @AndroidFindBy(id = recentActivitiesViewAll_Lnk)
    private WebElement recentActivitiesViewAllLnk;

    @AndroidFindBy(id = recentActivity_Img)
    private WebElement recentActivityImg;

    @AndroidFindBy(id = recentActivityBookTitle_Txt)
    private WebElement recentActivityBookTitleTxt;

    @AndroidFindBy(id = recentActivityBook_Img)
    private WebElement recentActivityBookImg;

    @AndroidBy(id = recentActivityDesc_Txt)
    private WebElement recentActivityDescTxt;

    @AndroidFindBy(id = recentActivityPageNo_Txt)
    private WebElement recentActivityPageNoTxt;

    @AndroidFindBy(id = recentActivityArrow_Img)
    private WebElement recentActivityArrowImg;

    //* 5.The SMART Store
    @AndroidFindBy(id = theSmartStore_Txt)
    private WebElement theSmartStoreTxt;

    @AndroidFindBy(id = smartStoreViewAll_Lnk)
    private WebElement smartStoreViewAllLnk;

    @AndroidFindBy(xpath = smartStoreBook_Img)
    private WebElement smartStoreBookImg;

    @AndroidFindBy(xpath = smartStoreBookName_Txt)
    private WebElement smartStoreBookNameTxt;

    @AndroidFindBy(id = smartStoreBookAmount_Txt)
    private WebElement smartStoreBookAmountTxt;

    @AndroidFindBy(id = smartStoreBookFavourite_Img)
    private WebElement smartStoreBookFavouriteImg;

    @AndroidFindBy(xpath = smartStoreBookPremium_Txt)
    private WebElement smartStoreBookPremiumTxt;

    @AndroidFindBy(id = smartStoreUpdagrade_Btn)
    private WebElement smartStoreUpdagradeBtn;

    @AndroidFindBy(id = smartStoreAddToCart_Btn)
    private WebElement smartStoreAddToCartBtn;

    @AndroidFindBy(xpath = smartStoreCartOrUpgrade_Btn)
    private List<WebElement> smartStoreCartOrUpgradeBtn;

    //* 6.PROMOTIONAL Books
    @AndroidFindBy(id = promotionalBooks_Txt)
    private WebElement promotionalBooksTxt;

    @AndroidFindBy(xpath = promotionalBook_Img)
    private WebElement promotionalBookImg;

    @AndroidFindBy(xpath = promotionalBookName_Txt)
    private WebElement promotionalBookNameTxt;

    //* 7.Search
    @AndroidFindBy(id = searchClear_Icon)
    private WebElement searchClearIcon;

    @AndroidFindBy(xpath = noBooksFound_Img)
    private WebElement noBooksFoundImg;

    @AndroidFindBy(xpath = noBookFound_Txt)
    private WebElement noBookFoundTxt;

    @AndroidFindBy(id = weCouldNotFound_Txt)
    private WebElement weCouldNotFountTxt;

    @AndroidFindBy(id = matchesYourSearch_Txt)
    private WebElement matchesYourSearchTxt;

    //* 7.Recent Viewed Books
    @AndroidFindBy(id = recentlyViewed_Txt)
    private WebElement recentlyViewedTxt;

    @AndroidFindBy(xpath = recentlyViewedBook_Img)
    private WebElement recentlyViewedBookImg;

    @AndroidFindBy(xpath = recentlyViewedBookRatting_Btn)
    private WebElement recentlyViewedBookRattingBtn;

    @AndroidFindBy(xpath = recentlyViewedBookName_Txt)
    private WebElement recentlyViewedBookNameTxt;

    //* Bottom Navigation Bar
    @AndroidFindBy(id = home_Sec)
    private WebElement homeSec;

    @AndroidFindBy(id = home_Img)
    private WebElement homeImg;

    @AndroidFindBy(id = home_Txt)
    private WebElement homeTxt;

    @AndroidFindBy(id = theSmartStore_Sec)
    private WebElement theSmartStoreSec;

    @AndroidFindBy(id = theSmartStore_Img)
    private WebElement theSmartStoreImg;

    @AndroidFindBy(id = navigationTheSmartStore_Txt)
    private WebElement navigationTheSmartStoreTxt;

    @AndroidFindBy(id = nsp_Sec)
    private WebElement nspSec;

    @AndroidFindBy(id = nsp_Img)
    private WebElement nspImg;

    @AndroidFindBy(id = nsp_Txt)
    private WebElement nspTxt;

    @AndroidFindBy(id = rewards_Sec)
    private WebElement rewardsSec;

    @AndroidFindBy(id = rewards_Img)
    private WebElement rewardsImg;

    @AndroidFindBy(id = rewards_Txt)
    private WebElement rewardsTxt;

    @AndroidFindBy(id = loadingMessage_Txt)
    private WebElement loadingMessageTxt;

    @AndroidFindBy(id = loader_Icon)
    private WebElement loaderIcon;

    @AndroidFindBy(id = back_Btn)
    private WebElement backBtn;

    //* Recent Activities View All
    @AndroidFindBy(xpath = recentActivitiesTitle_Txt)
    private WebElement recentActivitiesTitleTxt;

    @AndroidFindBy(xpath = digitalResources_Btn)
    private WebElement digitalResourcesBtn;

    @AndroidFindBy(xpath = highlights_Btn)
    private WebElement highlightsBtn;

    @AndroidFindBy(xpath = bookmarks_Btn)
    private WebElement bookmarksBtn;

    @AndroidFindBy(xpath = stickyNotes_Btn)
    private WebElement stickyNotesBtn;

    @AndroidFindBy(xpath = digitalPen_Btn)
    private WebElement digitalPenBtn;

    @AndroidFindBy(id = recentSearch_TxtFd)
    private WebElement recentSearchTxtFd;

    @AndroidFindBy(id = noDataFound_Txt)
    private WebElement noDataFoundTxt;

    @AndroidFindBy(id = activitySerialNum_Txt)
    private WebElement activitySerialNumTxt;

    @AndroidFindBy(id = activityBookCover_Img)
    private WebElement activityBookCoverImg;

    @AndroidFindBy(id = activityBookName_Txt)
    private WebElement activityBookNameTxt;

    @AndroidFindBy(id = activityPageNo_Txt)
    private WebElement activityPageNoTxt;

    @AndroidFindBy(id = activityPageDigitNumber_Txt)
    private WebElement activityPageDigitNumberTxt;

    @AndroidFindBy(id = activityType_Img)
    private WebElement activityTypeImg;

    @AndroidFindBy(id = activityNavigationArrow_Img)
    private WebElement activityNavigationArrowImg;

    /**
     * This method is used to verify the heard of application.
     */
    public void verifyHeader(){
        actionsHelper.isDisplayed(smartDigiBookIcon);
        actionsHelper.isDisplayed(walletBtn);
        actionsHelper.isDisplayed(notificationBtn);
        actionsHelper.isDisplayed(cartBtn);
        actionsHelper.isDisplayed(profileImg);
        actionsHelper.isDisplayed(profileBtn);
        actionsHelper.isDisplayed(bannerImg);
    }

    /**
     * This section is used to verify my library section.
     */
    public void verifyMyLibrarySection(){
        actionsHelper.isDisplayed(myLibraryTxt);
        actionsHelper.isDisplayed(categorySec);
        actionsHelper.isDisplayed(categoryAllBtn);
        actionsHelper.isDisplayed(searchClearIcon);
    }

    /**
     * This method is used to verify my books section and get first book name.
     * @return bookName <code>String</code>
    */
    public String verifyMyBookSection(){
        actionsHelper.isDisplayed(booksBannerImg);
        actionsHelper.isDisplayed(myBooksTxt);
        actionsHelper.isDisplayed(redeemAccessCodeBtn);
        actionsHelper.isDisplayed(bookProgressBarImg);
        actionsHelper.isDisplayed(bookCoverImg);
        actionsHelper.isDisplayed(bookFeedbackBtn);
        actionsHelper.isDisplayed(bookNameTxt);
        actionsHelper.isDisplayed(bookPremiumIcon);
        return actionsHelper.getTextOfElement(bookNameTxt);
    }

    
    /**
     * This method is used to verify recent activities and get recent activity book name.
     * @return bookName <code>String</code>
     */
    public String VerifyRecentActivities(){
    	actionsHelper.swipeUpOrDownTillElement(By.id(recentActivities_Txt), Direction.UP, 15);
    	actionsHelper.swipeElementToTopOfScreen(recentActivitiesTxt);
        actionsHelper.isDisplayed(recentActivitiesTxt);
        actionsHelper.isDisplayed(recentActivitiesViewAllLnk);
        actionsHelper.isDisplayed(recentActivityImg);
        actionsHelper.isDisplayed(recentActivityBookTitleTxt);
        actionsHelper.isDisplayed(recentActivityBookImg);
        actionsHelper.isDisplayed(recentActivityDescTxt);
        actionsHelper.isDisplayed(recentActivityPageNoTxt);
        actionsHelper.isDisplayed(recentActivityArrowImg);
        return actionsHelper.getTextOfElement(recentActivityBookTitleTxt);
    }

    /**
     *This method is used to verify recent activity view.
     */
    public void verifyRecentActivitiesViewAll(){
        actionsHelper.swipeUpOrDownTillElement(By.id(recentActivities_Txt), Direction.UP, 15);
        actionsHelper.swipeElementToTopOfScreen(recentActivitiesTxt);
        actionsHelper.click(recentActivitiesViewAllLnk);
        actionsHelper.waitTillElementIsDisplayed(highlightsBtn, 5);
        actionsHelper.isDisplayed(digitalResourcesBtn);
        actionsHelper.isDisplayed(highlightsBtn);
        actionsHelper.isDisplayed(bookmarksBtn);
        actionsHelper.isDisplayed(stickyNotesBtn);
        actionsHelper.isDisplayed(digitalPenBtn);
        actionsHelper.isDisplayed(recentSearchTxtFd);
        for(int i = 1 ; i <= 5 ; i++){
            actionsHelper.swipeRightOrLeft(Direction.LEFT, 1);
            actionsHelper.isDisplayed(activitySerialNumTxt);
            actionsHelper.isDisplayed(activityBookCoverImg);
            actionsHelper.isDisplayed(activityBookNameTxt);
            actionsHelper.isDisplayed(activityPageNoTxt);
            actionsHelper.isDisplayed(activityPageDigitNumberTxt);
            actionsHelper.isDisplayed(activityTypeImg);
            actionsHelper.isDisplayed(activityNavigationArrowImg);
        }
        actionsHelper.navigateBack();
    }

    /**
     * This method is used to verify the the smart store section.
     */
    public void verifyTheSmartStore(){
        actionsHelper.swipeUpOrDownTillElement(By.id(theSmartStore_Txt), Direction.UP, 15);
        actionsHelper.swipeElementToTopOfScreen(theSmartStoreTxt);
        actionsHelper.isDisplayed(theSmartStoreTxt);
        actionsHelper.isDisplayed(smartStoreViewAllLnk);
        actionsHelper.isDisplayed(smartStoreBookImg);
        actionsHelper.isDisplayed(smartStoreBookNameTxt);
        actionsHelper.isDisplayed(smartStoreBookAmountTxt);
        actionsHelper.isDisplayed(smartStoreBookFavouriteImg);
        actionsHelper.isDisplayed(smartStoreBookPremiumTxt);
        actionsHelper.isDisplayed(smartStoreAddToCartBtn);
        for (WebElement element : smartStoreCartOrUpgradeBtn) {
            actionsHelper.isDisplayed(element);
        }
    }
}