package com.example.graphs.warshallAlg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AlgorithmWarshallApp {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addOneWayEdge(0, 1);
        graph.addOneWayEdge(1, 2);
        graph.addOneWayEdge(2, 3);
        graph.transit();
        graph.bfs();
    }
}

