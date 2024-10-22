#include <iostream>
#include "graph.h"
#include "undirectedcycle.h"

using namespace std;

int main()
{
  Graph g("exemplos/tinyG.txt");
  UndirectedCycle ucycle(g);

  cout << "Tem ciclo? " << ucycle.containsCycle() << endl;
}
