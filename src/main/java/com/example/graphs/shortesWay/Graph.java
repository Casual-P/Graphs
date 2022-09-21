package com.example.graphs.shortesWay;

import com.example.graphs.warshallAlg.Vertex;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class Graph {
    private int numElems;
    private final Vertex[] vertexList;
    private final int[][] adjTab;
    private int nTree;
    private final DistPar[] sPath;
    private int currentVert;
    private int startToCurrent;

    public Graph(int size) {
        numElems = 0;
        nTree = 0;
        vertexList = new Vertex[size];
        adjTab = new int[size][size];
        Queue<Integer> stack = Collections.asLifoQueue(new ArrayDeque<>());
        sPath = new DistPar[size];
    }

    public void addVertex(char label) {
        vertexList[numElems++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjTab[start][end] = weight;
    }

    public void shortestForAll() {
        for (int i = 0; i < numElems; i++) {
            shortestWay(i);
            System.out.println();
        }
    }

    public void shortestWay(int startWay) {
        vertexList[startWay].isInTree = true;
        nTree++;

        for (int i = 0; i < numElems; i++) {
            int tempDist = adjTab[startWay][i];
            sPath[i] = new DistPar(startWay, tempDist);
        }

        while (nTree < numElems) {
            int minIndex = getMinIndex();
            int minDist = sPath[minIndex].distance;

            if (minDist == 0) {
                System.out.println("Not found any vertices");
                break;
            }

            currentVert = minIndex;
            vertexList[currentVert].isInTree = true;
            nTree++;
            startToCurrent = minDist;
            adj_Tree();
        }

        dispPath(startWay);

        nTree = 0;

        for (int i = 0; i < numElems; i++)
            vertexList[i].isInTree = false;

    }

    private void adj_Tree() {

        for (int col = 0; col < numElems; col++) {
            if (vertexList[col].isInTree)
                continue;
            int currentToNext = adjTab[currentVert][col];
            if (currentToNext == 0)
                continue;
            int startToNext = currentToNext + startToCurrent;
            int oldStartToNext = sPath[col].distance;
            if (startToNext < oldStartToNext || oldStartToNext == 0) {
                sPath[col].parentVert = currentVert;
                sPath[col].distance = startToNext;
            }
        }
    }

    private void dispPath(int startWay) {
        System.out.print("From " + vertexList[startWay].getLabel() + " to: ");
        for (int i = 0; i < numElems; i++) {
            if (sPath[i].distance == 0)
                continue;
            System.out.print(vertexList[i].getLabel() + " = " + sPath[i].distance + " (" + vertexList[sPath[i].parentVert].getLabel() + ") ");
        }
    }

    private int getMinIndex() {
        int index = 0;
        int minDist = 10000000;

        for (int i = 0; i < numElems; i++) {
            if (!vertexList[i].isInTree && sPath[i].distance < minDist) {
                if (sPath[i].distance != 0) {
                    minDist = sPath[i].distance;
                    index = i;
                }
            }
        }
        return index;
    }
}
