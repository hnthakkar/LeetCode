package priorityQueue.SIngleThreadedCPU1834;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}});
        // sol.getOrder(new int[][]{{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}});
        sol.getOrder(new int[][]{{5, 2}, {7, 2}, {9, 4}, {6, 3}, {5, 10}, {1, 1}});
    }

    public int[] getOrder(int[][] tasks) {
        int noOfTasks = tasks.length;

        List<TaskInfo> taskInfoList = new ArrayList<>();
        PriorityQueue<TaskInfo> allTask = new PriorityQueue<>(new AllTaskQueueComparator());

        for (int i = 0; i < noOfTasks; i++) {
            TaskInfo taskInfo = new TaskInfo(i, tasks[i][0], tasks[i][1]);
            allTask.add(taskInfo);
        }

        PriorityQueue<TaskInfo> readyTask = new PriorityQueue<>(new ReadyTaskQueueComparator());

        TaskInfo currentTask = allTask.poll();
        readyTask.add(currentTask);

        int currentTime = currentTask.availableFromTime;

        int[] result = new int[noOfTasks];
        int resultIndex = 0;

        while (!allTask.isEmpty() || !readyTask.isEmpty()) {
            while (!allTask.isEmpty() && allTask.peek().availableFromTime <= currentTime) {
                readyTask.add(allTask.poll());
            }

            if (readyTask.isEmpty() && !allTask.isEmpty()) {
                currentTime = allTask.peek().availableFromTime;
                readyTask.add(allTask.poll());
            }

            TaskInfo curReadyTask = readyTask.poll();

            result[resultIndex++] = curReadyTask.index;
            currentTime += curReadyTask.duration;
        }

        return result;
    }
}

class TaskInfo {
    int index;
    int availableFromTime;
    int duration;

    public TaskInfo(int pIndex, int pAvailableFromTime, int pDuration) {
        index = pIndex;
        availableFromTime = pAvailableFromTime;
        duration = pDuration;
    }
}

class AllTaskQueueComparator implements Comparator<TaskInfo> {

    @Override
    public int compare(TaskInfo task1, TaskInfo task2) {
        if (task1.availableFromTime != task2.availableFromTime) {
            return task1.availableFromTime - task2.availableFromTime;
        }

        return task1.duration - task2.duration;
    }
}

class ReadyTaskQueueComparator implements Comparator<TaskInfo> {

    @Override
    public int compare(TaskInfo task1, TaskInfo task2) {
        if (task1.duration != task2.duration) {
            return task1.duration - task2.duration;
        }

        return task1.index - task2.index;
    }
}