public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "New York");
        outputPath(djk, "Texas");


        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "New York");
        outputPath(dfs, "Texas");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "New York");
        outputPath(bfs, "Texas");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("New York", "Michigan"); // 16 - 19
        graph.addEdge("Ohio", "Los Angeles");
        graph.addEdge("Los Angeles", "Michigan");
        graph.addEdge("New York", "Ohio");
        graph.addEdge("Ohio", "Michigan");
        graph.addEdge("Michigan", "Washington");
        graph.addEdge("Ohio", "Texas");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("New York", "Michigan", 2.2);
        graph.addEdge("Ohio", "Los Angeles", 6.9);
        graph.addEdge("Los Angeles", "Michigan", 9.7);
        graph.addEdge("New York", "Ohio", 7.8);
        graph.addEdge("Ohio", "Michigan", 6.5);
        graph.addEdge("Michigan", "Washington", 3.9);
        graph.addEdge("Ohio", "Texas", 4.7);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}