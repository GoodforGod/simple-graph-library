package graph.library;

import graph.library.graph.IndirectGraph;
import graph.library.graph.impl.IntIndirectGraph;
import graph.library.model.impl.IntVertex;
import graph.library.model.impl.IndirectEdge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author GoodforGod
 * @since 13.11.2019
 */
class IntIndirectGraphTests extends Assertions {

    private IndirectGraph<IntVertex> getGraph() {
        return new IntIndirectGraph();
    }

    @Test
    void addVertexSuccess() {
        final IndirectGraph<IntVertex> graph = getGraph();
        final IntVertex vertex = new IntVertex(1);
        assertTrue(graph.addVertex(vertex));
    }

    @Test
    void addVertexDuplicateFail() {
        final IndirectGraph<IntVertex> graph = getGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(1);
        assertTrue(graph.addVertex(v1));
        assertFalse(graph.addVertex(v2));
    }

    @Test
    void addEdgeSuccess() {
        final IndirectGraph<IntVertex> graph = getGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(2);
        assertTrue(graph.addVertex(v1));
        assertTrue(graph.addVertex(v2));
        assertTrue(graph.addEdge(v1, v2));
    }

    @Test
    void addEdgeNonExistEdgeFail() {
        final IndirectGraph<IntVertex> graph = getGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(2);
        assertTrue(graph.addVertex(v1));
        assertFalse(graph.addEdge(v1, v2));
    }

    @Test
    void getPathSuccess() {
        final IndirectGraph<IntVertex> graph = getGraph();
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

        final List<IndirectEdge<IntVertex>> p1 = graph.getPath(v11, v41);
        assertEquals(3, p1.size());
        final List<IndirectEdge<IntVertex>> p11 = graph.getPath(v11, v41);
        assertEquals(3, p11.size());
        assertEquals(p1.get(1), p11.get(1));

        final List<IndirectEdge<IntVertex>> p2 = graph.getPath(v11, v21);
        assertEquals(1, p2.size());
        final List<IndirectEdge<IntVertex>> p22 = graph.getPath(v11, v21);
        assertEquals(1, p22.size());
        assertEquals(p2.get(0), p22.get(0));
        final List<IndirectEdge<IntVertex>> p3 = graph.getPath(v12, v32);
        assertEquals(2, p3.size());
        final List<IndirectEdge<IntVertex>> p33 = graph.getPath(v32, v12);
        assertEquals(2, p33.size());
        assertEquals(p3.get(0), p33.get(1));
        assertEquals(p3.get(0).hashCode(), p33.get(1).hashCode());
    }

    @Test
    void getPathNotFound() {
        final IndirectGraph<IntVertex> graph = getGraph();
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

        final List<IndirectEdge<IntVertex>> p4 = graph.getPath(v11, v32);
        assertTrue(p4.isEmpty());
    }

    @Test
    void traverseAppliedToAll() {
        final IndirectGraph<IntVertex> graph = getGraph();
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
