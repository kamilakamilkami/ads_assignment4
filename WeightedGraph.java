import java.util.*;

public class WeightedGraph<Vertex> {
    // Indicates if the graph is undirected. If true, edges are bidirectional.
    private final boolean undirected;

    // Map to store adjacency lists for each vertex.
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    // Default constructor creates an undirected graph.
    public WeightedGraph() {
        this(true);
    }

    // Constructor allows specifying if the graph is directed or undirected.
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    // Adds a vertex to the graph.
    public void addVertex(Vertex v) {
        // If the vertex already exists, do nothing.
        if (hasVertex(v))
            return;

        // Add the vertex with an empty adjacency list.
        map.put(v, new LinkedList<>());
    }

    // Adds an edge to the graph with a given weight.
    public void addEdge(Vertex source, Vertex dest, double weight) {
        // If the source vertex doesn't exist, add it.
        if (!hasVertex(source))
            addVertex(source);

        // If the destination vertex doesn't exist, add it.
        if (!hasVertex(dest))
            addVertex(dest);

        // If the edge already exists or it's a self-loop, do nothing.
        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops

        // Add the edge from source to destination.
        map.get(source).add(new Edge<>(source, dest, weight));

        // If the graph is undirected, also add the reverse edge.
        if (undirected)
            map.get(dest).add(new Edge<>(dest, source, weight));
    }

    // Returns the number of vertices in the graph.
    public int getVerticesCount() {
        return map.size();
    }

    // Returns the number of edges in the graph.
    public int getEdgesCount() {
        int count = 0;
        // Sum up the size of each vertex's adjacency list.
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }

        // If the graph is undirected, divide the count by 2.
        if (undirected)
            count /= 2;

        return count;
    }

    // Checks if the graph contains a vertex.
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    // Checks if there is an edge from source to destination.
    public boolean hasEdge(Vertex source, Vertex dest) {
        // If the source vertex doesn't exist, there can't be an edge.
        if (!hasVertex(source)) return false;

        // Check if the edge exists in the adjacency list of the source vertex.
        return map.get(source).contains(new Edge<>(source, dest));
    }

    // Returns the list of adjacent vertices of a given vertex.
    public List<Vertex> adjacencyList(Vertex v) {
        // If the vertex doesn't exist, return null.
        if (!hasVertex(v)) return null;

        // Create a list of adjacent vertices.
        List<Vertex> vertices = new LinkedList<>();
        for (Edge<Vertex> e : map.get(v)) {
            vertices.add(e.getDest());
        }

        return vertices;
    }

    // Returns the edges of a given vertex.
    public Iterable<Edge<Vertex>> getEdges(Vertex v) {
        // If the vertex doesn't exist, return null.
        if (!hasVertex(v)) return null;

        // Return the adjacency list of the vertex.
        return map.get(v);
    }
}
