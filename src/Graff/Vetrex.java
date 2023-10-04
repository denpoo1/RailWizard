package Graff;

public class Vetrex {
   /**This is a Java code for a Vertex class used in graph algorithms. The class has two private instance variables: "city", which is a string representing the name of the city, and "isVisited", which is a boolean value indicating whether the vertex has been visited or not. The class has a constructor that takes a "city" string as an argument and initializes the "isVisited" value to false.

    There are three methods in the class:

    The overridden toString() method that returns a string representation of the vertex with its city name.
    The getCity() method returns the city name of the vertex.
    The isVisited() method returns a boolean value indicating if the vertex has been visited or not. The setVisited() method allows setting the "isVisited" value to true or false.
    This class can be used to represent a vertex/node in a graph data structure and keep track of whether the vertex has been visited during graph traversal or not.*/
    private String city;
    private boolean isVisited;

    Vetrex(String city) {
        this.city = city;
        isVisited = false;
    }

    @Override
    public String toString() {
        return "city='" + city ;
    }

    public String getCity() {
        return city;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
