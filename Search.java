import java.util.*;

public class Search<Vertex> {
    // Set to keep track of visited vertices
    protected Set<Vertex> marked;

    // Map to keep track of the paths (edges) from one vertex to another
    protected Map<Vertex, Vertex> edgeTo;

    // The starting vertex for the search
    protected final Vertex source;

    // Constructor initializes the source vertex and sets up the marked set and edgeTo map
    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    // Checks if there is a path to the given vertex by checking if it has been marked as visited
    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    // Returns an iterable of vertices representing the path from the source to the given vertex
    public Iterable<Vertex> pathTo(Vertex v) {
        // If there is no path to the vertex, return null
        if (!hasPathTo(v)) return null;

        // Use a linked list to store the path
        LinkedList<Vertex> ls = new LinkedList<>();

        // Traverse from the target vertex back to the source vertex using the edgeTo map
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i); // Add each vertex to the front of the list to get the correct order
        }

        // Finally, add the source vertex to the front of the list
        ls.push(source);

        return ls;
    }
}
