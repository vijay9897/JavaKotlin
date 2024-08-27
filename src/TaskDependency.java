import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TaskDependency {

    static HashMap<Character, List<Character>> map = new HashMap<>();
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("Q,P");
        input.add("S,Q");
        input.add("Q,R");
//        input.add("D,C");
//        input.add("B,E");

        String task = "R";

        Arrays.fill(visited, false);


        System.out.println(getSequence(input, task));

    }

    public static String getSequence(List<String> input, String task) {
        for (String s : input) {
            String[] dep = s.split(",");
            Character dependency = dep[1].toCharArray()[0];
            Character dependent = dep[0].toCharArray()[0];

            if (map.containsKey(dependency)) {
                List<Character> existing = map.get(dependency);
                existing.add(dependent);
                map.put(dependency, existing);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(dependent);
                map.put(dependency, list);
            }
            System.out.println(map);
        }

        System.out.println(map);

        String[] tasks = task.split(",");
        for (int i = 0; i < tasks.length; i++) {
            markVisited(tasks[i].toCharArray()[0]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                stringBuilder.append((char) (i + 'A'));
        }
        return stringBuilder.toString();
    }

    public static void markVisited(char node) {
        visited[node - 'A'] = true;
        if (map.containsKey(node)) {
            List<Character> edges = map.get(node);
            for (int i = 0; i < edges.size(); i++) {
                if (!visited[edges.get(i) - 'A'])
                    markVisited(edges.get(i));
            }
        }
    }

}
