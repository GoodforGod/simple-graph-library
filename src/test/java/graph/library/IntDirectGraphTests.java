package graph.library;

import graph.library.graph.DirectGraph;
import graph.library.graph.impl.IntDirectGraph;
import graph.library.model.impl.DirectEdge;
import graph.library.model.impl.IntVertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author GoodforGod
 * @since 13.11.2019
 */
class IntDirectGraphTests extends Assertions {

    private DirectGraph<IntVertex> getGraph() {
        return new IntDirectGraph();
    }

    @Test
    void addVertexSuccess() {
        final DirectGraph<IntVertex> graph = getGraph();
        final IntVertex vertex = new IntVertex(1);
        assertTrue(graph.addVertex(vertex));
    }

    @Test
    void addVertexDuplicateFail() {
        final DirectGraph<IntVertex> graph = getGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(1);
        assertTrue(graph.addVertex(v1));
        assertFalse(graph.addVertex(v2));
    }

    @Test
    void addEdgeSuccess() {
        final DirectGraph<IntVertex> graph = getGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(2);
        assertTrue(graph.addVertex(v1));
        assertTrue(graph.addVertex(v2));
        assertTrue(graph.addEdge(v1, v2));
    }

    @Test
    void addEdgeNonExistEdgeFail() {
        final DirectGraph<IntVertex> graph = getGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(2);
        assertTrue(graph.addVertex(v1));
        assertFalse(graph.addEdge(v1, v2));
    }

    @Test
    void getPathSuccess() {
        final DirectGraph<IntVertex> graph = getGraph();
        final IntVertex v11 = new IntVertex(11);
        final IntVertex v12 = new IntVertex(12);
        final IntVertex v21 = new IntVertex(21);
        final IntVertex v22 = new IntVertex(22);
        final IntVertex v31 = new IntVertex(31);
        final IntVertex v32 = new IntVertex(32);
        final IntVertex v41 = new IntVertex(41);
        assertTrue(graph.addVertex(v11));
        assertTrue(graph.addVertex(v12));
        assertTrue(graph.addVertex(v21));
        assertTrue(graph.addVertex(v22));
        assertTrue(graph.addVertex(v31));
        assertTrue(graph.addVertex(v32));
        assertTrue(graph.addVertex(v41));
        assertTrue(graph.addEdge(v11, v21));
        assertTrue(graph.addEdge(v21, v31));
        assertTrue(graph.addEdge(v31, v41));
        assertTrue(graph.addEdge(v12, v22));
        assertTrue(graph.addEdge(v22, v32));

        final List<DirectEdge<IntVertex>> p1 = graph.getPath(v11, v41);
        assertEquals(3, p1.size());
        final List<DirectEdge<IntVertex>> p11 = graph.getPath(v41, v11);
        assertTrue(p11.isEmpty());

        final List<DirectEdge<IntVertex>> p2 = graph.getPath(v11, v21);
        assertEquals(1, p2.size());
        final List<DirectEdge<IntVertex>> p22 = graph.getPath(v21, v11);
        assertTrue(p22.isEmpty());
        final List<DirectEdge<IntVertex>> p3 = graph.getPath(v12, v32);
        assertEquals(2, p3.size());
        final List<DirectEdge<IntVertex>> p33 = graph.getPath(v32, v12);
        assertTrue(p33.isEmpty());
        assertNotEquals(p3.get(0), p3.get(1));
        assertNotEquals(p3.get(0).hashCode(), p3.get(1).hashCode());

        final List<DirectEdge<IntVertex>> p4 = graph.getPath(v11, v32);
        assertTrue(p4.isEmpty());
    }

    @Test
    void getPathNotFound() {
        final DirectGraph<IntVertex> graph = getGraph();
        final IntVertex v11 = new IntVertex(11);
        final IntVertex v12 = new IntVertex(12);
        final IntVertex v21 = new IntVertex(21);
        final IntVertex v22 = new IntVertex(22);
        final IntVertex v31 = new IntVertex(31);
        final IntVertex v32 = new IntVertex(32);
        final IntVertex v41 = new IntVertex(41);
        assertTrue(graph.addVertex(v11));
        assertTrue(graph.addVertex(v12));
        assertTrue(graph.addVertex(v21));
        assertTrue(graph.addVertex(v22));
        assertTrue(graph.addVertex(v31));
        assertTrue(graph.addVertex(v32));
        assertTrue(graph.addVertex(v41));
        assertTrue(graph.addEdge(v11, v21));
        assertTrue(graph.addEdge(v21, v31));
        assertTrue(graph.addEdge(v31, v41));
        assertTrue(graph.addEdge(v12, v22));
        assertTrue(graph.addEdge(v22, v32));

        final List<DirectEdge<IntVertex>> p4 = graph.getPath(v11, v32);
        assertTrue(p4.isEmpty());
    }

    @Test
    void traverseAppliedToAll() {
        final DirectGraph<IntVertex> graph = getGraph();
        final IntVertex v11 = new IntVertex(11);
        final IntVertex v12 = new IntVertex(12);
        final IntVertex v21 = new IntVertex(21);
        final IntVertex v22 = new IntVertex(22);
        final IntVertex v31 = new IntVertex(31);
        final IntVertex v32 = new IntVertex(32);
        final IntVertex v41 = new IntVertex(41);
        assertTrue(graph.addVertex(v11));
        assertTrue(graph.addVertex(v12));
        assertTrue(graph.addVertex(v21));
        assertTrue(graph.addVertex(v22));
        assertTrue(graph.addVertex(v31));
        assertTrue(graph.addVertex(v32));
        assertTrue(graph.addVertex(v41));

        final AtomicInteger counter = new AtomicInteger();
        graph.traverse(v -> counter.addAndGet(v.getId()));
        assertEquals(170, counter.get());
    }
}
