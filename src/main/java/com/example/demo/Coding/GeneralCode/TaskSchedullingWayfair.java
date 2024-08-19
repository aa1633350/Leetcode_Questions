package com.example.demo.Coding.GeneralCode;

import java.util.*;
class Task {
    int memory;
    int type;

    public Task(int memory, int type) {
        this.memory = memory;
        this.type = type;
    }
}
public class TaskSchedullingWayfair {

    public static int minProcessingTime(int[] task_memory, int[] task_type, int max_memory) {
        int n = task_memory.length;
        List<Task> tasks = new ArrayList<>();

        // Create Task objects and store them in a list
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(task_memory[i], task_type[i]));
        }

        // Sort tasks based on memory required
        Collections.sort(tasks, Comparator.comparingInt(t -> t.memory));

        int left = 0, right = n - 1;
        int time = 0;

        while (left <= right) {
            if (left == right) {
                // Process the last task
                time++;
                break;
            }

            // Check if we can pair tasks
            if (tasks.get(left).type == tasks.get(right).type &&
                    tasks.get(left).memory + tasks.get(right).memory <= max_memory) {
                // Process both tasks in parallel
                time++;
                left++;
                right--;
            } else {
                // Process the task at 'right' alone
                time++;
                right--;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] task_memory = {7, 2, 3, 9};
        int[] task_type = {1, 2, 1, 3};
        int max_memory = 10;

        int minTime = minProcessingTime(task_memory, task_type, max_memory);
        System.out.println("Minimum processing time: " + minTime); // Output: Minimum processing time: 3
    }
}
