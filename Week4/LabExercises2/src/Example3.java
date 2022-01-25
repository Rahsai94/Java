/*
Convert the day of the week from a numeric value into it's name (assuming the first day of the week is Monday.)
If the day of the week is invalid (not between 1 and 7) output an error message to the user.
 */
public class Example3 {
    public static void main(String[] args) {
        int dayOfTheWeekNum = 3;
        String dayOfTheWeekStr = "";


        switch (dayOfTheWeekNum){
            case 1:
                dayOfTheWeekStr = "Monday";
                break;
            case 2:
                dayOfTheWeekStr = "Tueday";
                break;
            case 3:
                dayOfTheWeekStr = "Wensday";
                break;
            case 4:
                dayOfTheWeekStr = "Thursday";
                break;
            case 5:
                dayOfTheWeekStr = "Friday";
                break;
            case 6:
                dayOfTheWeekStr = "Saturday";
                break;
            case 7:
                dayOfTheWeekStr = "Sunday";
                break;
            default:
                dayOfTheWeekStr = "Day of the week is Invalid";
                break;
        }


        System.out.println("Day of the Week : "+dayOfTheWeekStr);

    }
}
