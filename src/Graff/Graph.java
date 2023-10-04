package Graff;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Graph {
    /**This code is an implementation of an undirected graph using an adjacency matrix.
    The Graph class contains a list of vertices vertexList and an adjacency matrix mas.
    Each vertex is represented by an object of the Vetrex class, which contains the name of the city corresponding to the vertex.

    The graph can be modified by adding and removing vertices, as well as adding and removing edges.
    Methods for locking and unlocking graph edges are also implemented using objects of the Semaphore class.

    The addVertex method adds a new vertex to the graph's list of vertices.
    The addVetrexMenu method increases the size of the vertex list, adjacency matrix, and semaphore array by 1 and copies all elements from the old arrays to the new ones.
    The removeVertexMenu method removes a vertex from the vertex list, adjacency matrix, and semaphore array, and reduces the size of the vertex list, adjacency matrix, and semaphore array by 1.

    The addEdge method adds an edge between two vertices and sets the weight of the edge in the adjacency matrix.
    The blockRoad and unblockRoad methods block and unblock the corresponding semaphores corresponding to an edge between two vertices.

    The getVertexList method returns the index of a vertex in the list of graph vertices by its name, and the getVertexList method returns the name of the city corresponding to the vertex by its index.

    The check method is used in depth-first search.
    It looks for the next vertex to traverse that has not yet been visited, returning the index of the vertex that is edge-connected to the current vertex.

    The getIndex method returns the index of a vertex in the list of graph vertices by its name.

    It also uses a stack to implement a depth-first search algorithm that traverses the graph and searches for connected components.*/
    private static int maxN = 101;
    public volatile static int[][] mas;
    private static Vetrex[] vertexList;
    private static int countN;
    private static Stack stack = new Stack();
    private static Semaphore[][] semaphore;

    public static Vetrex[] getVertexList() {
        return vertexList;
    }

    public Graph() {
        vertexList = new Vetrex[maxN];
        mas = new int[maxN][maxN];
        countN = 0;
        semaphore = new Semaphore[maxN][maxN];
        for (int x = 0; x < mas.length; x++) {
            for (int y = 0; y < mas.length; y++) {
                semaphore[x][y] = new Semaphore(1);
            }
        }
    }
    public static void addVertex(String city) {//Adding a Vertex
        vertexList[countN++] = new Vetrex(city);
    }

    public static void addVetrexMenu(String city) {//Adding a vertex, increasing all arrays
        Vetrex[] menuVetrex = new Vetrex[++maxN];
        System.arraycopy(vertexList, 0, menuVetrex, 0, vertexList.length);
        int[][] mas1 = new int[maxN][maxN];
        for (int x = 0; x < mas.length; x++) {
            System.arraycopy(mas[x], 0, mas1[x], 0, mas[x].length);
        }
        Semaphore[][] semaphores = new Semaphore[maxN][maxN];
        for (int x = 0; x < mas1.length; x++) {
            for (int y = 0; y < mas1.length; y++) {
                semaphores[x][y] = new Semaphore(1);
            }
        }

        vertexList = menuVetrex;
        mas = mas1;
        semaphore = semaphores;
    }

    public static void removeVertexMenu(int index) {
        int indexToRemove = index;
        if (indexToRemove == -1) {
            System.out.println("Город не найден");
            return;
        }

        // Remove a vertex from the list of vertices
        Vetrex[] newVertexList = new Vetrex[maxN - 1];
        int newIndex = 0;
        for (int i = 0; i < maxN; i++) {
            if (i == indexToRemove) {
                continue;
            }
            newVertexList[newIndex++] = vertexList[i];
        }

        // Remove vertex from adjacency matrix
        int[][] newMas = new int[maxN - 1][maxN - 1];
        int newRow = 0, newCol = 0;
        for (int i = 0; i < maxN; i++) {
            if (i == indexToRemove) {
                continue;
            }
            newCol = 0;
            for (int j = 0; j < maxN; j++) {
                if (j == indexToRemove) {
                    continue;
                }
                newMas[newRow][newCol] = mas[i][j];
                newCol++;
            }
            newRow++;
        }

        // Remove top from semaphore array
        Semaphore[][] newSemaphore = new Semaphore[maxN - 1][maxN - 1];
        newRow = 0;
        for (int i = 0; i < maxN; i++) {
            if (i == indexToRemove) {
                continue;
            }
            newCol = 0;
            for (int j = 0; j < maxN; j++) {
                if (j == indexToRemove) {
                    continue;
                }
                newSemaphore[newRow][newCol] = semaphore[i][j];
                newCol++;
            }
            newRow++;
        }

        // Update class variables
        vertexList = newVertexList;
        mas = newMas;
        semaphore = newSemaphore;
        maxN--;
    }

    public static void addEdge(int start, int end, int val) {
        mas[start][end] = val;
        mas[end][start] = val;

    }

    public static void blockRoad(int start, int stop) {
        try {
            semaphore[start][stop].acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void unblockRoad(int start, int stop) {
        semaphore[start][stop].release();
    }

    public static int getVertexList(String city) {
        for (int x = 0; x < vertexList.length; x++) {
            if (vertexList[x].getCity().equals(city)) {
                return x;
            }
        }
        return -1;
    }

    public static String getVertexList(int index) {
        if (vertexList.length >= index) {
            return vertexList[index].getCity();
        } else {
            return null;
        }
    }

    static int check(int val) {
        for (int x = 0; x < countN; x++) {
            if (mas[val][x] != 0 && !vertexList[x].isVisited()) {
                return x;
            }
        }
        return -1;
    }

    public static int getIndex(String city) {
        for (int x = 0; x < vertexList.length - 1; x++) {
            if (vertexList[x].getCity().equals(city)) {
                return x;
            }
        }
        return -1;
    }

    public static void passInDeep(int index) {
        vertexList[index].setVisited(true);
        stack.push(index);

        while (!stack.isEmpty()) {
            int n = check(stack.peek());
            if (n == -1) {
                n = stack.pop();
            } else {
                vertexList[n].setVisited(true);
                stack.push(n);
            }
        }
        for (int x = 0; x < vertexList.length; x++) {
            vertexList[x].setVisited(false);
        }
    }

    public static List<Integer> dijkstra(int source, int stop) {
        int numVertices = mas.length;
        int[] distance = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        List<List<Integer>> paths = new ArrayList<>(numVertices);

        // Initialize distance array with infinity
        for (int i = 0; i < numVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            paths.add(new ArrayList<>());
        }

        distance[source] = 0;
        paths.get(source).add(source);

        for (int i = 0; i < numVertices - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find the unvisited vertex with the smallest distance
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && distance[j] < minDistance) {
                    minDistance = distance[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && mas[minIndex][j] != 0 && distance[minIndex] != Integer.MAX_VALUE && distance[minIndex] + mas[minIndex][j] < distance[j]) {
                    distance[j] = distance[minIndex] + mas[minIndex][j];
                    paths.set(j, new ArrayList<>(paths.get(minIndex)));
                    paths.get(j).add(j);
                }
            }
        }

        return paths.get(stop);
    }
}