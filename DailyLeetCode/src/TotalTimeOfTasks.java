import java.util.*;

public class TotalTimeOfTasks {
    class Task {
        String name;
        List<String> subTasks;
        int completionTime;

        Task(String n, List<String> sTasks) {
            name = n;
            subTasks = sTasks;
            completionTime = -1;
        }
    }

    public int getTotalCompletionTime(Map<String, List<String>> taskGraph) {
        HashMap<String, Task> tasks = new HashMap<>();


        for (var entry : taskGraph.entrySet()) {
            tasks.computeIfAbsent(entry.getKey(), k -> new Task(k, new ArrayList<>()));
            for (String sub : entry.getValue()) {
                tasks.computeIfAbsent(sub, k -> new Task(k, new ArrayList<>()));
            }
            tasks.get(entry.getKey()).subTasks.addAll(entry.getValue());
        }


        Set<String> allTasks = new HashSet<>(tasks.keySet());
        Set<String> subTasks = new HashSet<>();
        for (Task t : tasks.values()) {
            subTasks.addAll(t.subTasks);
        }
        allTasks.removeAll(subTasks);

        int totalTime = 0;
        for (String root : allTasks) {
            totalTime += computeTime(tasks, root);
        }
        return totalTime;
    }

    private int computeTime(Map<String, Task> tasks, String curr) {
        Task task = tasks.get(curr);

        if (task.completionTime != -1)
            return task.completionTime;

        if (task.subTasks.isEmpty()) {
            task.completionTime = 1;
            return 1;
        }

        List<Integer> subTimes = new ArrayList<>();
        for (String sub : task.subTasks) {
            subTimes.add(computeTime(tasks, sub));
        }

        boolean allSame = subTimes.stream().allMatch(x -> x.equals(subTimes.get(0)));

        if (allSame) {
            task.completionTime = subTimes.get(0);
        } else {
            task.completionTime = subTimes.stream().mapToInt(Integer::intValue).sum();
        }

        return task.completionTime;
    }
}
