package com.example.graphs.salesmanproblem;

import com.example.graphs.warshallAlg.Vertex;

import java.util.Arrays;

class GraphSalesman {
    private final Vertex[] vertexList;
    private final int[][] adjTab;
    private int numElems;
    int[] outArr;
    int[] tempArr;
    int start;
    int totalCost;


    public GraphSalesman(int size) {
        vertexList = new Vertex[size];
        adjTab = new int[size][size];
        numElems = 0;
        totalCost = 0;
    }


    public void addVertex(char label) {
        vertexList[numElems++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjTab[start][end] = weight;
        adjTab[end][start] = weight;
    }


    private void disp() {
        System.out.print(0);
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i]);
        }
        System.out.print(0);
        System.out.println();
    }


    public void salesmanProb(int start) {
        this.start = start;
        int count = 0;
        tempArr = new int[numElems - 1];

        for (int i = 0; i < tempArr.length; i++) {
            if (count == start)
                count++;
            tempArr[i] = count++;
        }

        anagrams(tempArr.length);
    }

    private void anagrams(int newSize) {
        if (newSize == 1)
            return;

        for (int i = 0; i < newSize; i++) {
            anagrams(newSize - 1);
            if (newSize == 2) {
                gamilCycle();
            }
            move(newSize);
        }
    }

    private void move(int newSize) {
        int position = tempArr.length - newSize;
        int temp = tempArr[position];
        int i;

        for (i = position + 1; i < tempArr.length; i++)
            tempArr[i - 1] = tempArr[i];

        tempArr[i - 1] = temp;
    }

    private void check() {
        int tempCost = 0;
        for (int i = 1; i < tempArr.length; i++) {
            if (adjTab[tempArr[i - 1]][tempArr[i]] == 0)
                return;
            tempCost += adjTab[tempArr[i - 1]][tempArr[i]];
        }

        if (adjTab[start][tempArr[0]] == 0 || adjTab[tempArr[tempArr.length - 1]][start] == 0)
            ;
        else {

            tempCost += adjTab[start][tempArr[0]] + adjTab[tempArr[tempArr.length - 1]][start];

            if (tempCost < totalCost || totalCost == 0) {
                totalCost = tempCost;
                outArr = Arrays.copyOf(tempArr, tempArr.length);
            }
        }
    }

    private void gamilCycle() {
        for (int i = 1; i < tempArr.length; i++)
            if (adjTab[tempArr[i - 1]][tempArr[i]] == 0)
                return;

        if (adjTab[start][tempArr[0]] != 0 && adjTab[tempArr[tempArr.length - 1]][start] != 0) {
            System.out.print(vertexList[start].getLabel() + " ");
            for (int i : tempArr)
                System.out.print(vertexList[i].getLabel() + " ");
            System.out.print(vertexList[start].getLabel());
            System.out.println();
        }
    }
}
