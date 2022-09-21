package com.example.graphs.floydAlg;

public class FloydAlgLASTapp {
    public static void main(String[] args) {
        FloydGraph graph = new FloydGraph(10);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 5);
        graph.addEdge(2, 5, 6);
        graph.addEdge(3, 4, 12);
        graph.addEdge(4, 5, 7);

        graph.makeShortsMap();
        graph.displayMap();
    }
}

