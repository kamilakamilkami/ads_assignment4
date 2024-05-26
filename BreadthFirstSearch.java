import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {
    public BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        // Create a queue for BFS and add the source vertex to it
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current);

        // Process the queue until it's empty
        while (!queue.isEmpty()) {
            // Remove the next vertex from the queue
            Vertex v = queue.remove();

            // Iterate over all adjacent vertices
            for (Vertex vertex : graph.adjacencyList(v)) {
                // If the adjacent vertex has not been visited
                if (!marked.contains(vertex)) {
                    marked.add(vertex);// Mark it as visited
                    edgeTo.put(vertex, v);// Record the edge from the current vertex to this adjacent vertex
                    queue.add(vertex);// Add the adjacent vertex to the queue for further processing
                }
            }
        }
    }
}
