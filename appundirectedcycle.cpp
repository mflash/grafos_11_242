#include <iostream>
#include "graph.h"
#include "undirectedcycle.h"

using namespace std;

int main()
{
  // Graph g("exemplos/tinyG.txt");
  Graph g;
  g.addEdge("A", "B");
  g.addEdge("B", "C");
  g.addEdge("C", "D");
  // g.addEdge("D", "A");
  g.addEdge("C", "E");
  g.addEdge("F", "G");
  g.addEdge("G", "H");
  g.addEdge("H", "F");
  UndirectedCycle ucycle(g);

  cout << "Tem ciclo? " << ucycle.containsCycle() << endl;
}
