package graph.library;

import graph.library.model.Vertex;
import graph.library.model.impl.DirectEdge;

/**
 * @author GoodforGod
 * @since 13.11.2019
 */
public interface DirectGraph<V extends Vertex, E extends DirectEdge<V>> extends Graph<V, E> {

}
