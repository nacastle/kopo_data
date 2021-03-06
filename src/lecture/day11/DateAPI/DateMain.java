package lecture.day11.DateAPI;

import java.util.Calendar;
import java.util.Date;

public class DateMain {
    public static void main(String[] args) {

        // 오늘은 2020년 04월 27일(월요일)입니다
        Calendar c = Calendar.getInstance();
        System.out.println("c : " + c);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
//        date = c.get(Calendar.DAY_OF_MONTH);
        int day = c.get(Calendar.DAY_OF_WEEK);	// 1(일) ~ 7(토)
        String[] dayArr = {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};

        System.out.println("오늘은 " + year + "년 " + month + "월 " + date + "일(" + dayArr[day] + ")입니다");

        // 2023년 10월 9일 무슨요일???
        c.set(2023, 10-1, 9); // 시각 설정
        day = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("2023년 10월 9일은 " + dayArr[day] + "입니다");


        Date d = c.getTime(); // c 기준으로 시각 설정
        System.out.println(d);

        System.out.println(c); // c.set(2023, 10-1, 9); 기준으로 출력

        d = new Date(); // 현재 시각 알려줌
        c.setTime(d); // d 기준으로 시각 설정
        System.out.println(c);

        // 요번달(4월)의 마지막날수 ???
        month = c.get(Calendar.MONTH) + 1;
        int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(month + "월의 마지막 날은 " + lastDay + "일입니다");
        System.out.println("마지막월은 : " + (c.getActualMaximum(Calendar.MONTH) + 1));

        /*
		// 오늘은 2020년 04월 27일입니다
		Date d = new Date();

		System.out.println("d : " + d);
//		System.out.println("d : " + d.toString());

		int year = d.getYear() + 1900;
		int month = d.getMonth() + 1;
		int date = d.getDate();

		System.out.println("오늘은 " + year + "년 " + month + "월 " + date + "일입니다");
		*/

    }
}
