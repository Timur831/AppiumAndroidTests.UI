package helpers;

import helpers.mock.billingBM.service.BillingBMMock;

import java.util.Calendar;

public class HelpFunc {

    public static String addSevenToCtn(String ctn){
        if(!(ctn.startsWith("08"))){
            return 7 + ctn;
        }
        return ctn;
    }

    public static String convertDateToString(Calendar calendar){
        int monthInt = calendar.get(Calendar.MONTH);
        int dayInt = calendar.get(Calendar.DAY_OF_MONTH);
        String monthString;

        switch (monthInt){
            case (0):
                monthString = "Января";
                break;
            case (1):
                monthString = "Февраля";
                break;
            case (2):
                monthString = "Марта";
                break;
            case (3):
                monthString = "Апреля";
                break;
            case (4):
                monthString = "Мая";
                break;
            case (5):
                monthString = "Июня";
                break;
            case (6):
                monthString = "Июля";
                break;
            case (7):
                monthString = "Августа";
                break;
            case (8):
                monthString = "Сентября";
                break;
            case (9):
                monthString = "Октября";
                break;
            case (10):
                monthString = "Ноября";
                break;
            case (11):
                monthString = "Декабря";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + monthInt);
        }

        return dayInt + " " + monthString;
    }


    /**
     Выбор даты следующего списания, в зависимости от суммы Общего баланса
     */
    public static String selectDateDependOnSumUB(int sumUB, int billingSum){
        String date;
        if(sumUB <= billingSum/3){
            date = BillingBMMock.DATE_CALENDAR1;
        } else if(sumUB <= billingSum * 2/3){
            date = BillingBMMock.DATE_CALENDAR2;
        } else{
            date = BillingBMMock.DATE_CALENDAR3;
        }
        return date;
    }

}
