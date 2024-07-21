package com.azbj.fm2002.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuestionnaireValidationUtil {

    private static boolean globalPregnancyStatus = false;
    private static boolean globalAlcoholStatus = false;
    private static boolean globalTobaccoStatus = false;

    public static boolean validateAnswerType(String answerType, String answer) {
        switch (answerType) {
            case "BY":
            case "BN":
                return "Y".equalsIgnoreCase(answer) || "N".equalsIgnoreCase(answer);
            case "D":
                return isValidDate(answer);
            case "NN":
            case "NY":
                return isValidNumber(answer);
            default:
                return false;
        }
    }

    public static boolean validateSpecificConditions(int questionId, String answer) {
        switch (questionId) {
            case 53:
            case 59:
                globalPregnancyStatus = "Y".equalsIgnoreCase(answer);
                return true;
            case 47:
                globalAlcoholStatus = "Y".equalsIgnoreCase(answer);
                return true;
            case 46:
                globalTobaccoStatus = "Y".equalsIgnoreCase(answer);
                return true;
            default:
                return true;
        }
    }

    public static boolean validateNonNullAnswers(int questionId, int subQuestionId, String answer) {
        if ((questionId == 59 && subQuestionId == 5) || (questionId == 6 && subQuestionId == 5)) {
            return answer != null && !answer.trim().isEmpty();
        }
        return true;
    }

    public static void deleteRowsForAnswerN(int questionId, String answer) {
        if ("N".equalsIgnoreCase(answer)) {
            // Logic to delete rows from the internal group
            // This is a placeholder for actual deletion logic
        }
    }

    public static String generateErrorMessage(String errorCode) {
        switch (errorCode) {
            case "INVALID_BY_BN":
                return "Answer should be in Y or N";
            case "INVALID_DATE":
                return "Please enter valid date in the format DD-MM-YY";
            case "INVALID_NUMBER":
                return "Please enter valid number";
            case "HUSBAND_INSURANCE_NULL":
                return "Husband Insurance cannot be null";
            case "CHECK_PREGNANCY_STATUS":
                return "Please check pregnancy status";
            case "INVALID_PREGNANCY_ENTRY":
                return "She is not pregnant... Invalid Entry";
            case "INVALID_PREGNANCY_MONTH":
                return "The Pregnancy months can be between 1 and 12";
            case "NULL_PREGNANCY_MONTH":
                return "Please enter the month of pregnancy";
            case "CHECK_ALCOHOLISM_QUESTION":
                return "Please check Alcoholism Question";
            case "INVALID_ALCOHOL_ENTRY":
                return "The person does not drink alcohol... Invalid answer";
            case "NULL_ALCOHOL_DETAILS":
                return "Please give in details of the drinking habits";
            default:
                return "Unknown error";
        }
    }

    private static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            Date parsedDate = sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean isValidNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
