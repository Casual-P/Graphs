package com.example.graphs.floydAlg;

import com.example.graphs.warshallAlg.Vertex;

class FloydGraph {
    private final Vertex[] vertices;
    private int numElems;
    private final int[][] adjTab;

    FloydGraph(int size) {
        vertices = new Vertex[size];
        numElems = 0;
        adjTab = new int[size][size];
    }

    public void addVertex(char label) {
        vertices[numElems++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjTab[start][end] = weight;
        adjTab[end][start] = weight;
    }

    public void makeShortsMap() {
        for (int i = 0; i < numElems; i++)
            for (int j = 0; j < numElems; j++)
                if (adjTab[i][j] != 0)
                    for (int k = 0; k < numElems; k++) {
                        if (k == j)
                            continue;
                        if (adjTab[k][i] != 0) {
                            int temp = adjTab[k][i] + adjTab[i][j];
                            if (adjTab[k][j] > temp || adjTab[k][j] == 0) {
                                adjTab[k][j] = temp;
                                adjTab[j][k] = temp;
                            }
                        }
                    }
    }

    public void displayMap() {
        for (int i = 0; i < numElems; i++)
            for (int j = 0; j < numElems; j++) {
                if (adjTab[i][j] != 0) {
                    vertices[i].dispVertex();
                    vertices[j].dispVertex();
                    System.out.println(" = " + adjTab[i][j]);
                }
            }
    }
}
