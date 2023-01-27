package programmers.codingtest.kakaomobility.test1;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.solution("2021:04:12:16:08:35", new String[]{"01:06:30:00", "01:04:12:00"});
    }

    public int[] solution(String s, String[] times) {
        int[] answer = new int[2];
        boolean status = true;
        int days = 1;

        int[] current = parseDate(s);

        for (String time : times) {
            int[] d = current;
            int[] t = parseTime(time);
            int[] nextDay = calculateNextDay(d, t);

            if (status) {
                if (d[1] == nextDay[1]) {
                    if (nextDay[2] - d[2] > 1) {
                        status = false;
                    }
                }else{
                    if (d[2] != 30 || nextDay[2] != 1) {
                        status = false;
                    }
                }
            }

            if (d[1] == nextDay[1]) {
                days += nextDay[2] - d[2];
            }else{
                days += 30 - (d[2] - nextDay[2]);
            }

            current = nextDay;
        }

        answer[0] = status ? 1: 0;
        answer[1] = days;
        return answer;
    }

    private int[] calculateNextDay(int[] d,int[] t) {
        int[] newDate = new int[6];

        int newSecond = t[3] + d[5];
        int newMinute = t[2] + d[4];
        int newHour = t[1] + d[3];
        int newDay = t[0] + d[2];
        int newMonth = d[1];
        int newYear = d[0];

        //초 계산
        if (newSecond >= 60) {
            newDate[5] = newSecond - 60;
            newMinute ++;
        }else{
            newDate[5] = newSecond;
        }

        //분 계산
        if (newMinute >= 60) {
            newDate[4] = newMinute - 60;
            newHour ++;
        }else{
            newDate[4] = newMinute;
        }

        //시간 계산
        if (newHour >= 24) {
            newDate[3] = newHour - 24;
            newDay ++;
        }else{
            newDate[3] = newHour;
        }

        //일 계산
        if (newDay > 30) {
            newDate[2] = newDay - 30;
            newMonth ++;
        }else{
            newDate[2] = newDay;
        }

        if (newMonth > 12) {
            newDate[1] = newMonth - 12;
            newYear++;
        }else{
            newDate[1] = newMonth;
        }

        newDate[0] = newYear;

        return newDate;

    }

    private int[] parseDate(String originDate) {
        String[] split = originDate.split(":");
        int[] d = new int[6];
        for (int i = 0; i < split.length; i++) {
            d[i] = Integer.parseInt(split[i]);
        }
        return d;
    }

    private int[] parseTime(String time) {
        String[] split = time.split(":");
        int[] t = new int[4];
        for (int i = 0; i < split.length; i++) {
            t[i] = Integer.parseInt(split[i]);
        }
        return t;
    }
}


//