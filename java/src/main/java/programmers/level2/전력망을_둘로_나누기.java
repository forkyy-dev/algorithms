package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 전력망을_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        Map<Integer, Container> m =new HashMap<>();
        int answer = n;
        //모든 송전탑 생성
        for (int i = 1; i <= n; i++) {
            m.put(i, new Container());
        }

        //각 송전탑 연결
        for (int[] wire : wires) {
            Container container1 = m.get(wire[0]);
            Container container2 = m.get(wire[1]);

            container1.add(container2);
            container2.add(container1);
        }

        for (Container c : m.values()) {
            
        }

        return 1;
    }

    class Container {
        List<Container> group = new ArrayList<>();

        public void add(Container c) {
            group.add(c);
        }

        public int size() {
            return group.size();
        }
    }
}


//각 노드별로 부모 노드만 찾아내면 되는듯?
//가장 연결이 많은 송전탑을 기준으로 삼는다.
//기준점에서 연결을 가진 자식 송전탑들 중 가장 연결이 많은 놈을 끊어낸다.

//
