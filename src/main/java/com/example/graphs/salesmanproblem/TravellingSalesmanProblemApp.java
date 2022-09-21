package com.example.graphs.salesmanproblem;

public class TravellingSalesmanProblemApp {
    public static void main(String[] args) {
        GraphSalesman graph = new GraphSalesman(10);
        graph.addVertex('A');//0
        graph.addVertex('B');//1
        graph.addVertex('C');//2
        graph.addVertex('D');//3
        graph.addVertex('E');//4


        graph.addEdge(0, 1, 91);
        graph.addEdge(0, 2, 62);
        graph.addEdge(0, 3, 55);
        graph.addEdge(1, 4, 31);
        graph.addEdge(1, 2, 44);
        graph.addEdge(3, 2, 52);
        graph.addEdge(2, 4, 45);
        graph.addEdge(3, 4, 83);

        graph.salesmanProb(0);
    }
}

