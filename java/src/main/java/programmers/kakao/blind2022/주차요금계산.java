package programmers.kakao.blind2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 주차요금계산 {

    public int[] solution(int[] fees, String[] records) {

        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int extraTime = fees[2];
        int extraFee = fees[3];
        int maxTime = 23 * 60 + 59;

        Map<String, Integer> parkinglot = new LinkedHashMap<>();
        Map<String, Integer> times = new LinkedHashMap<>();
        List<String> cars = new ArrayList<>();

        for (String record : records) {
            String[] splitRecord = record.split(" ");
            String[] splitTime = splitRecord[0].split(":");

            int time = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
            String carNumber = splitRecord[1];
            String type = splitRecord[2];

            if (!cars.contains(carNumber)) {
                cars.add(carNumber);
                times.put(carNumber, 0);
            }

            if (type.equals("OUT")) {
                int parkingTotalTime = time - parkinglot.get(carNumber);
                times.put(carNumber, times.get(carNumber) + parkingTotalTime);
                parkinglot.remove(carNumber);
            }else{
                parkinglot.put(carNumber, time);
            }
        }

        if (!parkinglot.isEmpty()) {
            for (Entry<String, Integer> carEntry : parkinglot.entrySet()) {
                times.put(carEntry.getKey(), times.get(carEntry.getKey()) + (maxTime - parkinglot.get(carEntry.getKey())));
            }
        }

        int[] answer = new int[cars.size()];
        Collections.sort(cars);

        for (int i = 0; i < cars.size(); i++) {
            String carNumber = cars.get(i);
            int totalTime = times.get(carNumber);

            if (totalTime <= defaultTime) {
                answer[i] = defaultFee;
                continue;
            }

            answer[i] =
                (int) (defaultFee + Math.ceil((totalTime - defaultTime) / (extraTime * 1.0)) * extraFee);
        }

        return answer;
    }

}
