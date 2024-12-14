package helpers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RunTestAgain implements IRetryAnalyzer {
    private int nowCount=0;
    private int maxCount=1;


    @Override
    public boolean retry(ITestResult result) {
        if(!result.isSuccess()){
            if (nowCount<maxCount) {
                nowCount++;
                return true;
            }
        }
        return false;
    }
}
