package com.example.graphs.warshallAlg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final Vertex[] vertexList;
    private int numElems;
    private final int[][] adjTab;
    private final Stack<Integer> stack;
    private final Queue<Integer> queue;

    Graph(int max) {
        numElems = 0;
        vertexList = new Vertex[max];
        adjTab = new int[max][max];
        stack = new Stack<>();
        queue = new LinkedList<>();
    }

    public void addVertex(char label) {
        vertexList[numElems++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjTab[start][end] = 1;
        adjTab[end][start] = 1;
    }

    public void addOneWayEdge(int start, int end) {
        adjTab[start][end] = 1;
    }

    private void display(int v) {
        vertexList[v].dispVertex();
    }

    public void transit() {
        for (int i = 0; i < numElems; i++)
            for (int j = 0; j < numElems; j++)
                if (adjTab[i][j] == 1)
                    for (int z = 0; z < numElems; z++)
                        if (adjTab[z][i] == 1) {
                            adjTab[z][j] = 1;
                            adjTab[j][z] = 1;
                        }
    }

    public void bfs() {
        vertexList[0].setVisited(true);
        int curVert;
        int v;
        queue.add(0);

        while (!queue.isEmpty()) {
            curVert = queue.remove();

            while ((v = getLinkedVertex(curVert)) != -1) {
                display(curVert);
                display(v);
                queue.add(v);
                vertexList[v].setVisited(true);
                System.out.println();
            }
        }
        clearList();
    }


    public void dfs() {
        vertexList[0].setVisited(true);
        display(0);
        stack.push(0);

        while (!stack.empty()) {
            int v = getLinkedVertex(stack.peek());

            if (v == -1)
                stack.pop();
            else {
                stack.push(v);
                display(v);
                vertexList[v].setVisited(true);
            }
        }
        clearList();
    }

    private void clearList() {
        for (int i = 0; i < numElems; i++)
            vertexList[i].setVisited(false);
    }

    public int getLinkedVertex(int v) {
        for (int i = 0; i < numElems; i++)
            if (adjTab[v][i] == 1 && !vertexList[i].isVisited())
                return i;
        return -1;
    }
}
