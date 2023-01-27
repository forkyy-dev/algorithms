package programmers.codingtest.kakaobank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution4 {

    public static void main(String[] args) {
        Solution4 app = new Solution4();
        app.solution(new int[][]{
            {1, 2, 1, 5},
            {2, 2, 3, 2},
            {3, 1, 3, 3},
            {5, 2, 1, 5},
            {7, 1, 1, 1},
            {9, 1, 1, 1},
            {10, 2, 2, 9},
        });
    }

    public int[] solution(int[][] jobs) {

        if (jobs.length == 1) {
            return new int[]{jobs[0][2]};
        }

        Job[] tasks = new Job[1_000_001];

        for (int[] j : jobs) {
            Job job = new Job(j[0], j[1], j[2], j[3]);
            tasks[job.intime] = job;
        }
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<JobList> q = new PriorityQueue<>();

        int clearTask = 0;
        int time = jobs[0][0];

        Job firstJob = tasks[time];
        answer.add(firstJob.type);

        JobList jobList = new JobList(firstJob.type);
        jobList.add(firstJob);

        q.add(jobList);

        Map<Integer, JobList> map = new HashMap<>();

        while (clearTask < jobs.length) {

            if (q.isEmpty()) {
                time++;
                if (tasks[time] != null) {
                    Job newTask = tasks[time];
                    JobList list = new JobList(newTask.type);
                    list.add(newTask);
                    map.put(newTask.type, list);
                }
            } else {
                JobList taskList = q.poll();
                map.remove(taskList.type);
                if (answer.get(answer.size() - 1) != taskList.type) {
                    answer.add(taskList.type);
                }

                while (!taskList.jobs.isEmpty()) {
                    Job j = taskList.jobs.poll();
                    clearTask++;
                    for (int i = 0; i < j.needtime; i++) {
                        time++;
                        if (tasks[time] != null) {
                            Job newTask = tasks[time];

                            if (newTask.type == taskList.type) {
                                taskList.add(newTask);
                            } else {
                                if (map.containsKey(newTask.type)) {
                                    map.get(newTask.type).add(newTask);
                                } else {
                                    JobList list = new JobList(newTask.type);
                                    list.add(newTask);
                                    map.put(newTask.type, list);
                                }
                            }
                        }
                    }
                }
            }
            q = new PriorityQueue<>(map.values());

        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    public class Job {

        int intime;
        int needtime;
        int type;
        int important;

        public Job(int intime, int needtime, int type, int important) {
            this.intime = intime;
            this.needtime = needtime;
            this.type = type;
            this.important = important;
        }
    }

    public class JobList implements Comparable<JobList>{

        int type;
        int priority = 0;
        Queue<Job> jobs = new LinkedList<>();

        public JobList(int type) {
            this.type = type;
        }

        void add(Job job) {
            jobs.add(job);
            priority += job.important;
        }

        @Override
        public int compareTo(JobList o) {
            if (priority == o.priority) {
                return type - o.type;
            }

            return o.priority - priority;
        }
    }
}

/*
작업별로 중요도를 가지고 있음
하나의 종류를 시작하면 해당 종류를 모두 끝내고 다음걸로 넘어감.
처리 중 or 끝낸 시점에 같은 종류가 새로 들어오면 이어서 작업

중요도 높은 순서대로 처리
중요도 합이 높은게 여러개면 분류 번호가 가장 낮은 분류먼저.

return : 처리한 분류 번호의 순서를 알아보고자 함.

 */


/*
- 가장 처음에 jobs를 순회하며 요청이 들어오는 초에 해당하는 작업을 넣기.
1. 처음은 가장 먼저 들어온 작업부터 진행
2. 처리하는 동안 대기 큐에 쌓임
3. 큐에서 중요도가 높은 작업을 꺼내서 작업 진행 (동일한 일이라면 분류번호 낮은 일로)
4.
 */


/*
public int[] solution(int[][] jobs) {

        Job[] tasks = new Job[1_000_001];

        for (int[] j : jobs) {
            Job job = new Job(j[0], j[1], j[2], j[3]);
            tasks[job.intime] = job;
        }
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<JobList> q = new PriorityQueue<>();

        int clearTask = 0;
        int time = 0;
        Job firstJob = tasks[time];
        answer.add(firstJob.type);

        JobList jobList = new JobList(firstJob.type);
        jobList.add(firstJob);
        q.add(jobList);
        while (clearTask < jobs.length) {
            Map<Integer, JobList> map = new HashMap<>();

            if (q.isEmpty()) {
                time++;
                if (tasks[time] != null) {
                    Job newTask = tasks[time];
                    JobList list = new JobList(newTask.type);
                    list.add(newTask);
                    map.put(newTask.type, list);
                }
            } else {
                JobList taskList = q.poll();
                if (answer.get(answer.size() - 1) != taskList.type) {
                    answer.add(taskList.type);
                }

                while (!taskList.jobs.isEmpty()) {
                    Job j = taskList.jobs.poll();
                    clearTask++;
                    for (int i = 0; i < j.needtime; i++) {
                        time++;
                        if (tasks[time] != null) {
                            Job newTask = tasks[time];

                            if (newTask.type == taskList.type) {
                                taskList.jobs.add(newTask);
                            } else {
                                if (map.containsKey(newTask.type)) {
                                    map.get(newTask.type).add(newTask);
                                } else {
                                    JobList list = new JobList(newTask.type);
                                    list.add(newTask);
                                    map.put(newTask.type, list);
                                }
                            }
                        }
                    }
                }
            }

            q.addAll(map.values());

        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        for (Integer integer : answer) {
            System.out.println("integer = " + integer);
        }
        return result;
    }

    class Job {

        int intime;
        int needtime;
        int type;
        int important;

        public Job(int intime, int needtime, int type, int important) {
            this.intime = intime;
            this.needtime = needtime;
            this.type = type;
            this.important = important;
        }
    }

    class JobList implements Comparable<JobList> {

        int type;
        int priority = 0;
        Queue<Job> jobs = new LinkedList<>();

        public JobList(int type) {
            this.type = type;
        }

        void add(Job job) {
            jobs.add(job);
            priority += job.important;
        }

        @Override
        public int compareTo(JobList o) {
            if (priority == o.priority) {
                return type - o.type;
            }

            return o.priority - priority;
        }
    }
 */