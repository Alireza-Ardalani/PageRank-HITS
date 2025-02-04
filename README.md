# HITS and PageRank Algorithm Implementation  

## 🚀 Run  

To execute the algorithms, use the following commands:  

```sh
java pgrk4607.java input1 input2 input3

java hits4607.java input1 input2 input3
```


## Example Usage

```sh
java pgrk4607.java 15 -1 somegraph.txt  

java hits4607.java 0 -1 large.txt

```

## 📥 Input Format

The first line of input.txt contains the number of nodes and edges, separated by a space.

Each subsequent line represents an edge, specifying a connection from node1 to node2.

Use only spaces for separation—no parentheses or additional characters.

3 3  

0 1  

0 2  

1 2 

The first line (3 3) indicates 3 nodes (0, 1, 2) and 3 edges.

The following lines define edges:

0 → 1

0 → 2

1 → 2

## 📖 Background
This implementation was originally developed in 2023 as part of my PhD Algorithm Course (CS610 - NJIT).
