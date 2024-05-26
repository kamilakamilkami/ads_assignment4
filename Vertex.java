import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    // Constructor with no parameters
    public Vertex() {
        this.adjacentVertices = new HashMap<>();
    }

    // Constructor with data parameter
    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    // Constructor with data and adjacentVertices parameters
    public Vertex(T data, Map<Vertex<T>, Double> adjacentVertices) {
        this.data = data;
        this.adjacentVertices = adjacentVertices;
    }

    // Getter for data
    public T getData() {
        return data;
    }

    // Setter for data
    public void setData(T data) {
        this.data = data;
    }

    // Getter for adjacentVertices
    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    // Setter for adjacentVertices
    public void setAdjacentVertices(Map<Vertex<T>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    // Method to add an adjacent vertex
    public void addAdjacentVertex(Vertex<T> vertex, Double weight) {
        this.adjacentVertices.put(vertex, weight);
    }

    // Method to remove an adjacent vertex
    public void removeAdjacentVertex(Vertex<T> vertex) {
        this.adjacentVertices.remove(vertex);
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    // toString method
    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", adjacentVertices=" + adjacentVertices +
                '}';
    }
}
