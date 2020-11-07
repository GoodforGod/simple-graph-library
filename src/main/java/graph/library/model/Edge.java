package graph.library.model;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public interface Edge<V extends Vertex> {

    V getFrom();

    V getTo();
}
