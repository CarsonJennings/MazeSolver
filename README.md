# MazeSolver

This Project is an extension of a Maze Solver assignment I completed in my CSC 115 course. The MazeSolver program helps to visualize how DFS and BFS algorithms work by attempting to solve any given maze using DFS and BFS. After the program is executed it will create files called "BFS-Solution.txt" and "DFS-Solution.txt" which contain the solution to the maze if it is solvable and each iteration of the respective algorithm.

**How to run the program:**
  1.  Download all the files into a single directory.
  2.  Compile the MazeSolver.java file.
      Example: javac MazeSolver.java
  3.  Run the binary with your mazeInput.txt.
      Example: java MazeSolver <mazeInput.txt>

**Maze input files:**
Maze files must follow a specific format.
The first line is the maze dimension formatted as (Height Width)
The second line is the starting position formatted as (Row Column)
The third line is the finish position formatted as (Row Column)
All of the following lines are layout of the actual maze. The 'H' character represents a wall and the ' ' character represents a path
Below is an example maze file:

9 11
0 1
8 9
H HHHHHHHHH
H     H   H
HHH H HHH H
H   H   H H
HHHHHHH H H
H     H   H
H HHHHHHH H
H         H
HHHHHHHHH H
