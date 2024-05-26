import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final Set<Vertex> unsettledNodes;
    private final Map<Vertex, Double> distances;
    private final WeightedGraph<Vertex> graph;
    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    public void dijkstra() {
        // Initialize the distance to the source node as 0
        distances.put(source, 0D);
        unsettledNodes.add(source);

        // Process the unsettled nodes until there are none left
        while (!unsettledNodes.isEmpty()) {
            // Get the node with the smallest known distance
            Vertex currentNode = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            // Iterate over its adjacent vertices
            for (Vertex neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                // If a shorter path to the neighbor is found
                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);// Update the shortest distance to this neighbor
                    edgeTo.put(neighbor, currentNode);// Record the path to reach this neighbor
                    unsettledNodes.add(neighbor);// Add the neighbor to the unsettled nodes for further processing
                }
            }
        }
    }

    // Method to get the distance between two nodes
    private double getDistance(Vertex node, Vertex target) {
        for (Edge<Vertex> edge : graph.getEdges(node)) { // Iterate over all edges of the node
            if (edge.getDest().equals(target))// If the edge leads to the target node, return its weight
                return edge.getWeight();
        }

        throw new RuntimeException("Edge not found!");
    }

    // Method to get the vertex with the smallest known distance from the source
    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }
        return minimum;
    }

    // Method to get the shortest known distance to a given destination
    private double getShortestDistance(Vertex destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
