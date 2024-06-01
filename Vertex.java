import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjVertices;

    // Constructor with no parameters
    public Vertex() {
        this.adjVertices = new HashMap<>();
    }

    // Constructor with data parameter
    public Vertex(T data) {
        this.data = data;
        this.adjVertices = new HashMap<>();
    }

    // Constructor with data and adjVertices parameters
    public Vertex(T data, Map<Vertex<T>, Double> adjacentVertices) {
        this.data = data;
        this.adjVertices = adjacentVertices;
    }

    // Getter
    public T getData() {
        return data;
    }

    // Setter
    public void setData(T data) {
        this.data = data;
    }

    // Getter for adjVertices
    public Map<Vertex<T>, Double> getAdjVertices() {
        return adjVertices;
    }



    // Method to add an adjacent vertex
    public void addAdjVertex(Vertex<T> vertex, Double weight) {
        this.adjVertices.put(vertex, weight);
    }



    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }



    // toString method
    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", adjacentVertices=" + adjVertices +
                '}';
    }
}
