public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        // Iterate over all adjacent vertices
        for (Vertex v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) { // If the adjacent vertex has not been visited
                edgeTo.put(v, current);// Record the edge from the current vertex to this adjacent vertex
                dfs(graph, v);// Recursively perform DFS on the adjacent vertex
            }
        }
    }
}
