package helpers.mock.billingBM.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import helpers.HelpFunc;
import helpers.jdbc.bfetch.MockJDBC;
import helpers.mock.billingBM.pojo.RootBilling;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class BillingBMMock {

    public static String DATE_CALENDAR1;
    public static String DATE_CALENDAR2;
    public static String DATE_CALENDAR3;

    public static void addMock(String ctn, int ...billingSum) throws IOException, SQLException {

        Calendar calendar1 = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();
        Calendar calendar3 = new GregorianCalendar();

        addDaysToDate(calendar2,3);
        addDaysToDate(calendar3,8);

        setTime24(calendar1);
        setTime24(calendar2);
        setTime24(calendar3);

        DATE_CALENDAR1 = HelpFunc.convertDateToString(calendar1);
        DATE_CALENDAR2 = HelpFunc.convertDateToString(calendar2);
        DATE_CALENDAR3 = HelpFunc.convertDateToString(calendar3);

        ctn = HelpFunc.addSevenToCtn(ctn);

        File f = new File("src\\main\\resources\\mock\\mockBilling" + ctn + ".json");

        ObjectMapper myObjectMapper = new ObjectMapper();
        myObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        List<RootBilling> rootBillingArrays = myObjectMapper.readValue(f, new TypeReference<>(){});

        if(!rootBillingArrays.isEmpty()){

//            for(int i = 0; i < billingSum.length; i++){
//                rootBillingArrays.get(i).getRecurringChargePeriod().get(0).getChargeAmount().getValue().setValue(billingSum[i]);
//            }
            //Установка суммы
            rootBillingArrays.get(0).getRecurringChargePeriod().get(0).getChargeAmount().getValue().setValue(billingSum[0]);
            rootBillingArrays.get(1).getRecurringChargePeriod().get(0).getChargeAmount().getValue().setValue(billingSum[1]);
            rootBillingArrays.get(2).getRecurringChargePeriod().get(0).getChargeAmount().getValue().setValue(billingSum[2]);

            //Установка даты
            rootBillingArrays.get(0).getRecurringChargePeriod().get(0).getNextTarificationDate().setTimestampUTC(convertToUnix(calendar1));
            rootBillingArrays.get(1).getRecurringChargePeriod().get(0).getNextTarificationDate().setTimestampUTC(convertToUnix(calendar2));
            rootBillingArrays.get(2).getRecurringChargePeriod().get(0).getNextTarificationDate().setTimestampUTC(convertToUnix(calendar3));
        }

        String mockString = myObjectMapper.writeValueAsString(rootBillingArrays);

        MockJDBC.insertMockTable(ctn, mockString, "billing");
    }

    public static void addMockDefault(String ctn) throws IOException, SQLException {

        Calendar calendar1 = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();
        Calendar calendar3 = new GregorianCalendar();

        addDaysToDate(calendar2,3);
        addDaysToDate(calendar3,8);

        setTime24(calendar1);
        setTime24(calendar2);
        setTime24(calendar3);

        ctn = HelpFunc.addSevenToCtn(ctn);

        File f = new File("src\\main\\resources\\mock\\mockBilling" + ctn + ".json");

        ObjectMapper myObjectMapper = new ObjectMapper();
        myObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        List<RootBilling> rootBillingArrays = myObjectMapper.readValue(f, new TypeReference<>(){});

        if(!rootBillingArrays.isEmpty()){
            //Установка суммы
            rootBillingArrays.get(0).getRecurringChargePeriod().get(0).getChargeAmount().getValue().setValue(1000);
            rootBillingArrays.get(1).getRecurringChargePeriod().get(0).getChargeAmount().getValue().setValue(2000);
            rootBillingArrays.get(2).getRecurringChargePeriod().get(0).getChargeAmount().getValue().setValue(3000);

            //Установка даты
            rootBillingArrays.get(0).getRecurringChargePeriod().get(0).getNextTarificationDate().setTimestampUTC(convertToUnix(calendar1));
            rootBillingArrays.get(1).getRecurringChargePeriod().get(0).getNextTarificationDate().setTimestampUTC(convertToUnix(calendar2));
            rootBillingArrays.get(2).getRecurringChargePeriod().get(0).getNextTarificationDate().setTimestampUTC(convertToUnix(calendar3));
        }

        String mockString = myObjectMapper.writeValueAsString(rootBillingArrays);

        MockJDBC.insertMockTable(ctn, mockString, "billing");
    }

    public static void deleteBillingMock(String ctn) throws SQLException {
        ctn = HelpFunc.addSevenToCtn(ctn);
        MockJDBC.deleteFromMockTable(ctn, "billing");
    }

    private static void setTime24(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }

    private static void addDaysToDate(Calendar calendar, int day){
        calendar.add(Calendar.DAY_OF_MONTH, day);
    }

    private static int convertToUnix(Calendar calendar){
        return (int) (calendar.getTimeInMillis() / 1000);
    }

}
