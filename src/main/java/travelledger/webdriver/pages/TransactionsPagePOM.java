package travelledger.webdriver.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.junit.Assert.assertTrue;

public class TransactionsPagePOM extends AbstractPage {

    By loginBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div/div[1]/main/div/form/button");

    By fileUploadsBtnInMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[2]/div/div/a[3]/span[1]");
    By uploadFileBtnInSubMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[1]/button[1]/span[1]");
    By dropFileBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div");
    By inputType = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div/input");
    By uploadBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[4]/div[2]/button");
    By importCheckBox = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[4]/label/span[1]/span[1]/input");
    By uploadBtnAgain = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[5]/div[2]/button");
    By alertMessageAfterUpload = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[4]/div/div");

    By bookingRefernceFilterFieldFromBuyer = By.xpath("//table[1]/thead/tr[2]/th[5]/div/div/input");
    By bookingRefernceFilterFieldAfterUpload = By.xpath("//table[1]/thead/tr[2]/th[10]/div/div/input");
    By checkBoxAfterUploadFromBuyer = By.xpath("//table[2]/tbody/tr/td[1]/span/span/input");
    By bookingRefernceFilterFieldFromSeller = By.xpath("//table[1]/thead/tr[2]/th[6]/div/div/input");

    By updatePartnerBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[3]/div[1]/div/span[2]/button/span[1]");
    //By partnerName = By.id("mui-66753");
    //*[@id="mui-67676"]

    By commercialLinkField = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div[2]/div/div/div");
    By prozendaTestAutomationCommercialLink = By.xpath("/html/body/div[5]/div[3]/ul/li");
    By commercialLinkSelectionOkBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div[2]/button");
    By commitBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[3]/div[1]/div/span[1]/button/span[1]");


    By bookingsBtnInMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[2]/div/div/a[1]");
    By resetFiltersBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div/div/div[1]/button[1]/span[1]");
    By logoutBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/ul[2]/div/div[2]/span");


    By quickViewDropDown = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div/div/div[1]/h6/div/label/div/div");
    By sellerAllDueOption = By.xpath("/html/body/div[4]/div[3]/ul/li[5]");
    By buyerAllDueOption = By.xpath("/html/body/div[4]/div[3]/ul/li[2]");

    By tableColumnReferenceSeller = By.xpath("//table[2]/tbody/tr/td[6]");
    By tableColumnReferenceBuyer = By.xpath("//table[2]/tbody/tr/td[5]");

    By txStatusDropDown = By.xpath("//table[2]/tbody/tr[1]/td[13]/div/div");
    By txStatusDropDownValues = By.xpath("//table[2]/tbody/tr[1]/td[13]/div/div[2]/div[3]/ul");
    By txAccepted = By.xpath("//table[2]/tbody/tr[1]/td[13]/div");
    By txRejected = By.xpath("//table[2]/tbody/tr[4]/td[11]/div/div[2]/div[3]/ul/li[3]");
    // Accepted: table[2]/tbody/tr[4]/td[11]/div/div[2]/div[3]/ul/li[1]
    // Rejected: table[2]/tbody/tr[4]/td[11]/div/div[2]/div[3]/ul/li[3]

    By reasonCodeCancelledBooking = By.xpath("//table[2]/tbody/tr[9]/td[12]/div/div[2]/div[3]/ul/li[5]");

    By currentAm = By.xpath("//table[2]/tbody/tr[1]/td[12]/div/div");

    WebDriverWait webDriverWait = new WebDriverWait(getDriverProvider().get(), Duration.ofSeconds(6));

    Actions action = new Actions(getDriverProvider().get());

    public TransactionsPagePOM(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open(String email, String pass) {
        findElement(By.id("email")).sendKeys(email);
        findElement(By.id("password")).sendKeys(pass);
        findElement(loginBtn).click();
    }

    public By getFileUploadsBtnInMenu() {
        return fileUploadsBtnInMenu;
    }

    public void navigateToFileUploadsPage() throws InterruptedException {
        findElement(fileUploadsBtnInMenu).click();
        Thread.sleep(1000);
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getCheckBoxBtnPath()));
    }

    public void checkParameterElementIsExist(String transactionNumber) throws InterruptedException {
        filterBookingReferenceFromSellerSide(transactionNumber);
        List<WebElement> col = findElements(tableColumnReferenceSeller);
        assertTrue(col.stream().anyMatch((element) -> element.getText().contains(transactionNumber)));
        System.out.println(transactionNumber + " transaction appear in Bookings page from Seller side!");
    }

    public void checkParameterElementIsExistFromBuyerSide(String transactionNumber) throws InterruptedException {
        filterBookingReference(transactionNumber);
        List<WebElement> col = findElements(tableColumnReferenceBuyer);
        assertTrue(col.stream().anyMatch((element) -> element.getText().contains(transactionNumber)));
        System.out.println(transactionNumber + " transaction appear in Bookings page from Buyer side!");
    }

    public void changeQuickViewToSellerAllDue() {
        findElement(quickViewDropDown).click();
        findElement(sellerAllDueOption).click();
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(sellerAllDueOption)).click();
    }

    public void changeQuickViewToBuyerAllDue() {
        findElement(quickViewDropDown).click();
        findElement(buyerAllDueOption).click();
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(sellerAllDueOption)).click();
    }

    //Method to upload file
    public void uploadTransactionFile() throws InterruptedException {
        String location = "/Users/borbelyistvan/Documents/Prozenda/Travelledger/Prozenda.txt";
        System.out.println("Click upload file in sub menu.");
        findElement(uploadFileBtnInSubMenu).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(dropFileBtn));
        System.out.println("Upload file button in sub menu clicked and drop file button loaded.");
        WebElement uploadElement = findElement(inputType);
        uploadElement.sendKeys(location);

        System.out.println("Transaction file selected lets click upload button.");
        Thread.sleep(3000);
        findElement(uploadBtn).click();
        System.out.println("Upload button clicked lets click check box.");
        Thread.sleep(3000);
        findElement(importCheckBox).click();
        Thread.sleep(3000);
        findElement(uploadBtnAgain).click();
        Thread.sleep(3000);
    }

    public void commitTransaction(String transactionNumber) throws InterruptedException {
        filterBookingReferenceAfterFileUpload(transactionNumber);
        System.out.println("Filter the transaction number.");
        Thread.sleep(2000);
        findElement(checkBoxAfterUploadFromBuyer).click();
        System.out.println("Checkbox selected after commetting transaction.");
        Thread.sleep(2000);
        findElement(updatePartnerBtn).click();
        System.out.println("Update button clicked.");
        Thread.sleep(15000);

        //TODO: manually step: type Prozenda2 into text box.

        //findElement(By.xpath("//*[contains(@id,'mui')]")).click();
        System.out.println("Partnername is Prozenda2 set by manually.");
        Thread.sleep(1000);
        findElement(commercialLinkField).click();
        Thread.sleep(1000);
        findElement(prozendaTestAutomationCommercialLink).click();
        System.out.println("Commercial link is Prozenda Test automation.");
        Thread.sleep(1000);
        findElement(commercialLinkSelectionOkBtn).click();
        Thread.sleep(5000);
        System.out.println("Wait to disappear message.");

        findElement(bookingsBtnInMenu).click();
        System.out.println("Go to Bookings page.");
        Thread.sleep(2000);

        findElement(fileUploadsBtnInMenu).click();
        System.out.println("Go to back to File uploads page.");
        Thread.sleep(2000);

        filterBookingReferenceAfterFileUpload(transactionNumber);
        System.out.println("Filter the transaction number.");

        findElement(checkBoxAfterUploadFromBuyer).click();
        System.out.println("Checkbox selected.");
        Thread.sleep(2000);

        findElement(commitBtn).click();
        System.out.println("Commit button clicked.");
        Thread.sleep(2000);



    }


    //Method to navigate Bookings
    public void navigatesToBookings () throws InterruptedException {
        //webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(alertMessageAfterUpload));
        Thread.sleep(15000);
        findElement(bookingsBtnInMenu).click();
        Thread.sleep(1000);
    }

    //Method to check transactions
    public void checkCommitedTransactions () throws InterruptedException {
        //TODO
        Thread.sleep(3000);
    }

    //Method to logout
    public void logout() {
        findElement(logoutBtn).click();
        //quit();
    }

    // Given a transaction number and return the number of the row which contains the transaction
    public int whichNumberOfTheRow(String transactionNumber) {
        /*
        // identify table
        WebElement myTable = findElement(By.xpath("//table/tbody"));
        //identify rows of table.
        List<WebElement> l = myTable.findElements(By.tagName("tr"));

        String b_xpath = "//table[2]/tbody/tr[";
        String a_xpath = "]/td[5]";

        int i;
        for (i = 1; i <= l.size(); i++) {
            String n = findElement(By.xpath(b_xpath + i + a_xpath)).getText();
            if (n.contains(transactionNumber)) {
                // get text of matching cell
                String celtxt = findElement(By.xpath("//table[2]/tbody/tr[" + i + "]/td[5]")).getText();
                System.out.println("The transaction " + celtxt + " is in " + i + " row.");
                return i;
            }
        }
        return i;

         */
        return 1;
    }

    //Method to click on blank status transaction and change to Accepted
    public void clickOnBlankStatusFieldAndSelectAcceptedStatus(String transactionNumber) throws InterruptedException {
        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).click();
        log.println("Checkbox clicked.");
        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div")).click();
        log.println("ACCEPTED selected.");
        assertTrue(findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("ACCEPTED"));
        log.println("ACCEPTED checked and it success.");

        Thread.sleep(2000);
        findElement(fileUploadsBtnInMenu).click();
        log.println("Navigate to another page.");
        Thread.sleep(2000);

        findElement(bookingsBtnInMenu).click();
        log.println("Navigate back to Booking page.");
        Thread.sleep(2000);

        findElement(quickViewDropDown).click();
        findElement(buyerAllDueOption).click();
        Thread.sleep(2000);

        filterBookingReference(transactionNumber);
        Thread.sleep(2000);

        assertTrue(findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("ACCEPTED"));
        Thread.sleep(2000);
        log.println("ACCEPTED checked and it success.");
    }

    //Method to click on blank status transaction and change to Rejected
    public void clickOnBlankStatusFieldAndSelectRejectedStatus(String transactionNumber) throws InterruptedException {
        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).click();
        log.println("Checkbox clicked.");
        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div[2]/div[3]/ul/li[3]")).click();

        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[14]/div/div[2]/div[3]/ul/li[5]")).click();

        log.println("REJECTED selected.");
        assertTrue(findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("REJECTED"));
        log.println("REJECTED checked and it success.");

        Thread.sleep(2000);
        findElement(fileUploadsBtnInMenu).click();
        log.println("Navigate to another page.");
        Thread.sleep(2000);

        findElement(bookingsBtnInMenu).click();
        log.println("Navigate back to Booking page.");
        Thread.sleep(2000);

        findElement(quickViewDropDown).click();
        findElement(buyerAllDueOption).click();
        Thread.sleep(2000);

        filterBookingReference(transactionNumber);
        Thread.sleep(2000);

        assertTrue(findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("REJECTED"));
        Thread.sleep(2000);
        log.println("REJECTED checked and it success.");
    }

    //Method to click on blank status transaction and change to Rejected
    public void clickOnBlankStatusFieldAndSelectAmendedStatus(String transactionNumber) throws InterruptedException {
        Thread.sleep(4000);
        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[12]/div/div/input")).sendKeys("200");
        log.println("Set amount to 200");
        Thread.sleep(4000);
        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).click();
        log.println("Checkbox clicked.");
        Thread.sleep(4000);

        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[14]/div/div[2]/div[3]/ul/li[5]")).click();
        //table[2]/tbody/tr[12]/td[12]/div/div[2]/div[3]/ul/li[5]
        //table[2]/tbody/tr/td[14]/div/div[2]/div[3]/ul/li[5]
        Thread.sleep(4000);
        log.println("AMENDED selected, reason code set.");




        assertTrue(findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("AMENDED"));
        log.println("AMENDED checked and it success.");

        Thread.sleep(2000);
        findElement(fileUploadsBtnInMenu).click();
        log.println("Navigate to another page.");
        Thread.sleep(2000);

        findElement(bookingsBtnInMenu).click();
        log.println("Navigate back to Booking page.");
        Thread.sleep(2000);

        findElement(quickViewDropDown).click();
        findElement(buyerAllDueOption).click();
        Thread.sleep(2000);

        filterBookingReference(transactionNumber);
        Thread.sleep(2000);

        assertTrue(findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("AMENDED"));
        Thread.sleep(2000);
        log.println("AMENDED checked and it success.");
    }

    // Validating Tx Status dropdown elements
    public void isFoundAllOptions(String transactionNumber) throws InterruptedException {
        System.out.println(whichNumberOfTheRow(transactionNumber));
        findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).click();
        System.out.println("Clicked the dropbox");
        WebElement status = findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div[2]/div[3]/ul"));
        List<WebElement> links = status.findElements(By.tagName("li"));
        for (int i = 0; i < links.size(); i++) {
            assertTrue(links.get(i).getText().equals("ACCEPTED") || links.get(i).getText().equals("AMENDED") || links.get(i).getText().equals("REJECTED"));
        }
        System.out.println("Assertation of ACCEPTED, AMENDED, REJECTED Tx status are passed.");
        action.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(2000);
    }

    public void filterBookingReference(String transactionNumber) throws InterruptedException {
        findElement(bookingRefernceFilterFieldFromBuyer).sendKeys(transactionNumber);
        Thread.sleep(2000);
    }

    public void filterBookingReferenceAfterFileUpload(String transactionNumber) throws InterruptedException {
        findElement(bookingRefernceFilterFieldAfterUpload).sendKeys(transactionNumber);
        Thread.sleep(2000);
    }

    public void filterBookingReferenceFromSellerSide(String transactionNumber) throws InterruptedException {
        findElement(bookingRefernceFilterFieldFromSeller).sendKeys(transactionNumber);
        Thread.sleep(4000);
    }



    public void waitForLoadingMainPage() throws InterruptedException {
        // 15 sec sleep for 2FA
        Thread.sleep(15000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getFileUploadsBtnInMenu()));
    }


}
