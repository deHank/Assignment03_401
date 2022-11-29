import java.util.Scanner;
//David Ferrufino
//CMSC 401
//11/13/22
//Assignment 3 second cheapest path

public class cmsc401 {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Scanner in = new Scanner(System.in);
        //getting then no of cities
        int numCities = in.nextInt();
//in.nextLine();
        int numHighways = in.nextInt();

        int totalRuns = numHighways + numCities;
//in.nextLine();
        //creating adjacency matrix
        int[][] cities = new int[numCities][numCities];
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                cities[i][j] = 0;
                if (i == j) {
                    cities[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < numCities - 2; i++) {
            //getting the vertex and weight for each of the given motels
            int vertex = in.nextInt();
            int weight = in.nextInt();

            cities[vertex - 1][vertex - 1] = weight;
            //in.nextLine();
            totalRuns--;
        }


        /*System.out.println("I am printing out the array");
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                System.out.print(cities[i][j] + ", ");
            }
            System.out.println();
        }*/

//Getting the gas prices in between two cities
        while (numHighways > 0) {
            //System.out.println("You are in the while Loop");
            int vertexRow = in.nextInt();
            int vertexCol = in.nextInt();
            int weight = in.nextInt();
            cities[vertexRow - 1][vertexCol - 1] = weight;// + cities[vertexRow-1][vertexRow-1];//+ cities[vertexCol-1][vertexCol-1];
            cities[vertexCol - 1][vertexRow - 1] = weight;
            //in.next();
            numHighways--;

        }
        in.nextLine();
//for(int i = 0; i < cities.length; i++){
//	cities[i][i] = 0;
//}
        /*System.out.println("I am printing out the array");
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                System.out.print(cities[i][j] + ", ");
            }
            System.out.println();
        }*/
//for(int i = 0; i < cities.length; i++){
//	cities[i][i] = 0;
//}
        System.out.println(ShortestPath(cities, numCities, 0, 3));

    }

    //Dijktra's algorithm
    public static int ShortestPath(int[][] list, int nodes, int startVertex, int destVertex) {
        //int minDistance;
        int[] shortestDist = new int[list.length];
        int[] secondShortestDist = new int[list.length];
        //int nextNodeIndex = 0;
        //int w[list.length];
        //int currentNodeIndex;
        //int tempNodeIndex;
        Boolean[] visited = new Boolean[list.length];
        int n = visited.length;
        //setting all of the variables as unvisited
        //Initialize Single Source
        for (int i = 0; i < list.length; i++) {
            //prev[i] = -1;
            shortestDist[i] = Integer.MAX_VALUE;
            secondShortestDist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        shortestDist[0] = 0; //setting the vertex path to itself as 0
        //w[nextNodeIndex] = startVertex;
        //nextNodeIndex++;
        //shortestDist[startVertex] = 0; //setting the shortest dis from v to v = 0;

//	https://www.cs.uah.edu/~rcoleman/CS221/Graphs/ShortestPath.html

        //set the shortest distance and status from v to all nodes adjancent to it
        for (int i = 0; i < nodes - 1; i++) {
            int u = minDistance(shortestDist, visited, list.length); //sent to my minDistance method,


            visited[u] = true; //marking it as visited
            //for each edge adjacent to this one
            for (int v = 0; v < list.length; v++) {
                //if not visited, and vertice is adjacent, and it is less than the shortest path, update new shortest path
                if (list[u][v]!= Integer.MAX_VALUE) {
                    //relaxing the value
                    if (v == 1) {
                        //System.out.println("V IS EQUAL TO +" + v + " AND u IS EQUAL TO " + u);
                        //u = minDistance(shortestDist, visited, list.length);
                    }
                    //if(visited[v]==false && list[u][v] != Integer.MAX_VALUE){
                    //our second shortest dist will equal our shortest dis to compare to later

                    //setting our shortest distance
                    shortestDist[v] = shortestDist[u] + list[u][v] + list[v][v];// + list[v][v];
                    secondShortestDist[v] = shortestDist[v];
                    //}
                }
                printSolution(shortestDist);
                /*if(shortestDist[u] + list[u][v] < shortestDist[v]){
                    secondShortestDist[v] = shortestDist[v];
                    shortestDist[v] = shortestDist[u] + list[u][v];
                }*/
                /*else if(shortestDist[u] + list[u][v] < secondShortestDist[v]){
                    secondShortestDist[v] = shortestDist[u] + list[u][v];
                }*/
            }
            //visited[i] = true;
        }
        /*for (int i = 0; i < shortestDist.length; i++) {
            System.out.println(shortestDist[i]);
        }*/
        //System.out.println("COMBO BREAKER");
        /*for (int i = 0; i < shortestDist.length; i++) {
            System.out.println(secondShortestDist[i]);
        }*/
        return shortestDist[1];
    }
    public static int minDistance(int[] path, Boolean[] aVisited, int size) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < size; i++) {
            //if the neighbor is unvisited, and it is less than the minimum path prior, we make it the new min path
            if (!aVisited[i] && path[i] <= min) {
                min = path[i];
                min_index = i;
            }
        }
        aVisited[min_index]=false;
        return min_index;
    }

    public static void printSolution(int dist[])
    {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }


    //try to create a second array
}
