package graph.library.model.impl;

import graph.library.model.Vertex;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public class IntVertex implements Vertex {

    private final int value;

    public IntVertex(int value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}
