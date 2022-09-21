package com.example.graphs.warshallAlg;

public class Vertex {
    private boolean isVisited;
    private char label;
    public boolean isInTree;

    public Vertex(char label) {
        this.label = label;
        this.isVisited = false;
        this.isInTree = false;
    }

    public void dispVertex () {
        System.out.print("/" + label);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }
}




