package tests;

import androidApp.helpers.drivers.DeviceDriver;
import api.clientAPI.unifiedBalanceProfile.Agreement;
import api.clientAPI.unifiedBalanceProfile.UnifiedBalance;
import api.clientAPI.usss.Sso;
import com.codeborne.selenide.Selenide;
import helpers.RunTestAgain;
import helpers.mock.balanceBM.service.BalanceBMMock;
import helpers.mock.billingBM.service.BillingBMMock;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;

import static androidApp.AppConfig.*;

public class BaseTest {

    private void addMock() throws SQLException, IOException {
        BalanceBMMock.deleteBalanceMock(FIRST_NUMBER);
        BalanceBMMock.deleteBalanceMock(SECOND_NUMBER);
        BalanceBMMock.deleteBalanceMock(THIRD_NUMBER);
        BalanceBMMock.deleteBalanceMock(FIRST_INAC);
        BalanceBMMock.deleteBalanceMock(SECOND_INAC);
        BalanceBMMock.deleteBalanceMock(BLOCK_INAC);
        BalanceBMMock.deleteBalanceMock(FIRST_NUMBER_G2);
        BalanceBMMock.deleteBalanceMock(SECOND_NUMBER_G2);
        BalanceBMMock.deleteBalanceMock(THIRD_NUMBER_G2);

        BillingBMMock.deleteBillingMock(FIRST_NUMBER);
        BillingBMMock.deleteBillingMock(SECOND_NUMBER);
        BillingBMMock.deleteBillingMock(THIRD_NUMBER);


        BalanceBMMock.addMock(FIRST_NUMBER, 200);
        BalanceBMMock.addMock(SECOND_NUMBER, 200);
        BalanceBMMock.addMock(THIRD_NUMBER, 200);
        BalanceBMMock.addMock(FIRST_INAC, 200);
        BalanceBMMock.addMock(SECOND_INAC, 200);
        BalanceBMMock.addMock(BLOCK_INAC, 200);
        BalanceBMMock.addMock(FIRST_NUMBER_G2, 200);
        BalanceBMMock.addMock(SECOND_NUMBER_G2, -2000);
        BalanceBMMock.addMock(THIRD_NUMBER_G2,200);

        BillingBMMock.addMockDefault(FIRST_NUMBER);
        BillingBMMock.addMockDefault(SECOND_NUMBER);
        BillingBMMock.addMockDefault(THIRD_NUMBER);
    }

    private void clearSsoList() throws NoSuchAlgorithmException, InvalidKeyException {
        Sso.deleteAllCtnFromSso(FIRST_NUMBER);
    }

    private void reformGroups() {
    }

    private void acceptAgreement() {
        Agreement.acceptAgreement(FIRST_NUMBER);
    }

    private void retry(ITestContext context){
        Arrays.stream(context.getAllTestMethods()).forEach(x->x.setRetryAnalyzerClass(RunTestAgain.class));
    }

    @BeforeSuite
    public void beforeSettings(ITestContext context) throws SQLException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        retry(context);
        //addMock();
        //acceptAgreement();
        //reformGroups();
        //clearSsoList();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DeviceDriver.initDriver();
    }

    @BeforeMethod
    public void reformUBBefore(){
        //UnifiedBalance.reformUB(FIRST_NUMBER);
    }

    @AfterMethod
    public void reformUBAfter(){
        //UnifiedBalance.reformUB(FIRST_NUMBER);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
