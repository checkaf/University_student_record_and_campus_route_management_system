import java.util.*;

public class CampusGraph {

    // Store the graph using an adjacency list
    private Map<String, List<String>> graph;

    public CampusGraph() {
        graph = new HashMap<>();
    }

    // Add a campus location
    public void addLocation(String location) {

        if (!graph.containsKey(location)) {
            graph.put(location, new ArrayList<>());
        }
    }

    // Add a route between two locations
    public void addRoute(String location1, String location2) {

        addLocation(location1);
        addLocation(location2);

        graph.get(location1).add(location2);
        graph.get(location2).add(location1);
    }

    // Display the graph
    public void displayGraph() {

        System.out.println("===== CAMPUS GRAPH =====");

        for (String location : graph.keySet()) {

            System.out.print(location + " -> ");

            for (String connectedLocation : graph.get(location)) {
                System.out.print(connectedLocation + " ");
            }

            System.out.println();
        }
    }

    // Breadth-First Search
    public void BFS(String startLocation) {

        if (!graph.containsKey(startLocation)) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startLocation);
        queue.add(startLocation);

        System.out.println("===== BFS TRAVERSAL =====");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            for (String neighbour : graph.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // Depth-First Search
    public void DFS(String startLocation) {

        if (!graph.containsKey(startLocation)) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.println("===== DFS TRAVERSAL =====");

        DFSRecursive(startLocation, visited);

        System.out.println();
    }

    // Recursive DFS
    private void DFSRecursive(
            String location,
            Set<String> visited) {

        visited.add(location);

        System.out.print(location + " ");

        for (String neighbour : graph.get(location)) {

            if (!visited.contains(neighbour)) {

                DFSRecursive(neighbour, visited);
            }
        }
    }
}