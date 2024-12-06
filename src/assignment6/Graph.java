package assignment6;

import java.util.*;

public class Graph {
    class Vertex {
        private String id;
        private LinkedList<Edge> adjacencyList;
        private boolean visited;
        private int distance;

        public Vertex(String id) {
            this.id = id;
            adjacencyList = new LinkedList<>();
            visited = false;
        }
    }
    class Edge {
        private Vertex start;
        private Vertex end;
        private int cost;

        public Edge(Vertex start, Vertex end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    private Vertex[] vertices;
    private int numVertices;

    public Graph() {
        vertices = new Vertex[0];
        numVertices = 0;
    }

    public boolean addVertex(String id) {
        if (containsVertex(id)) {
            return false;
        }
        Vertex[] newVertices = new Vertex[numVertices + 1];
        if (numVertices >= 0) {
            System.arraycopy(vertices, 0, newVertices, 0, numVertices);
        }
        newVertices[numVertices] = new Vertex(id);
        vertices = newVertices;
        numVertices++;
        return true;
    }

    public boolean addEdge(String startId, String endId, int weight) {
        if (weight < 1) {
            return false;
        } else if (!containsVertex(startId) || !containsVertex(endId)) {
            return false;
        } else if (containsEdge(startId, endId)) {
            return false;
        }

        Vertex startVertex = getVertexById(startId);
        Vertex endVertex = getVertexById(endId);

        if (startVertex != null && endVertex != null) {
            startVertex.adjacencyList.add(new Edge(startVertex, endVertex, weight));
            endVertex.adjacencyList.add(new Edge(endVertex, startVertex, weight));
            return true;
        }
        return false;
    }

    public boolean addEdges(String startId, String[] endIdList, int[] weightList) {
        if (endIdList.length != weightList.length) {
            return false;
        }
        for (int weight : weightList) {
            if (weight < 1) {
                return false;
            }
        }

        for (int i = 0; i < endIdList.length; i++) {
            if (!addEdge(startId, endIdList[i], weightList[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean removeNode(String id) {
        Vertex vertexToRemove = getVertexById(id);
        if (vertexToRemove == null) {
            return false;
        }

        for (Vertex vertex : vertices) {
            vertex.adjacencyList.removeIf(edge -> edge.start.equals(vertexToRemove) || edge.end.equals(vertexToRemove));
        }

        Vertex[] newVertices = new Vertex[numVertices - 1];
        int index = 0;
        for (Vertex vertex : vertices) {
            if (!vertex.id.equals(id)) {
                newVertices[index++] = vertex;
            }
        }
        vertices = newVertices;
        numVertices--;

        return true;
    }

    public boolean removeEdge(String startId, String endId) {
        Vertex startVertex = getVertexById(startId);
        Vertex endVertex = getVertexById(endId);

        if (startVertex == null || endVertex == null) {
            return false;
        }

        boolean removedFromStart = startVertex.adjacencyList.removeIf(edge -> edge.end.equals(endVertex));
        boolean removedFromEnd = endVertex.adjacencyList.removeIf(edge -> edge.end.equals(startVertex));

        return removedFromStart && removedFromEnd;
    }

    public void printGraph() {
        List<Vertex> vertexList = new ArrayList<>(Arrays.asList(vertices));

        vertexList.sort(Comparator.comparing(v -> v.id));

        for (Vertex vertex : vertexList) {
            StringBuilder sb = new StringBuilder();
            sb.append(vertex.id);

            List<Edge> sortedEdges = new ArrayList<>(vertex.adjacencyList);
            sortedEdges.sort(Comparator.comparing(e -> e.end.id));

            for (Edge edge : sortedEdges) {
                sb.append(" ").append(edge.cost).append(" ").append(edge.end.id);
            }
            System.out.println(sb);
        }
    }

    public static Graph createGraph(String[][] input) {
        Graph graph = new Graph();
        for (String[] arr : input) {
            if (arr.length < 3) {
                return null;
            }
            try {
                int weight = Integer.parseInt(arr[2]);
                if (weight < 1) {
                    return null;
                }
                if (!graph.containsVertex(arr[0])) {
                    graph.addVertex(arr[0]);
                }
                if (!graph.containsVertex(arr[1])) {
                    graph.addVertex(arr[1]);
                }
                if (!graph.containsEdge(arr[0], arr[1])) {
                    graph.addEdge(arr[0], arr[1], weight);
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return graph;
    }

    public int shortestDistance(String startId, String endId) {
        if (!containsVertex(startId) || !containsVertex(endId)) {
            return -1;
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(v -> v.distance));

        for (Vertex vertex : vertices) {
            vertex.distance = (int) Double.POSITIVE_INFINITY;
            vertex.visited = false;
        }

        Vertex startVertex = getVertexById(startId);
        startVertex.distance = 0;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.visited) {
                continue;
            }
            current.visited = true;

            for (Edge edge : current.adjacencyList) {
                Vertex neighbor = edge.end;

                if (!neighbor.visited) {
                    int newDistance = current.distance + edge.cost;
                    if (newDistance < neighbor.distance) {
                        neighbor.distance = newDistance;
                        queue.add(neighbor);
                    }
                }
            }
        }

        Vertex endVertex = getVertexById(endId);
        if (endVertex.distance == (int) Double.POSITIVE_INFINITY) {
            return -1;
        }
        return endVertex.distance;
    }

    public List<String[]> minimumSpanningTree() {
        if (vertices.length == 0) {
            return null;
        }

        List<String[]> mstEdges = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        Vertex startVertex = vertices[0];
        visited.add(startVertex);
        edgeQueue.addAll(startVertex.adjacencyList);

        while (!edgeQueue.isEmpty() && visited.size() < vertices.length) {
            Edge edge = edgeQueue.poll();
            Vertex endVertex = edge.end;

            if (visited.contains(endVertex)) {
                continue;
            }

            mstEdges.add(new String[]{edge.start.id, edge.end.id, String.valueOf(edge.cost)});
            visited.add(endVertex);

            for (Edge nextEdge : endVertex.adjacencyList) {
                if (!visited.contains(nextEdge.end)) {
                    edgeQueue.add(nextEdge);
                }
            }
        }

        if (visited.size() < vertices.length) {
            return null;
        }

        return mstEdges;
    }



    public boolean containsVertex(String id) {
        for (Vertex v : vertices) {
            if (v.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsEdge(String startId, String endId) {
        for (Vertex vertex : vertices) {
            for (Edge edge : vertex.adjacencyList) {
                if (edge.start.id.equals(startId) && edge.end.id.equals(endId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Vertex getVertexById(String id) {
        for (Vertex v : vertices) {
            if (v.id.equals(id)) {
                return v;
            }
        }
        return null;
    }
}
