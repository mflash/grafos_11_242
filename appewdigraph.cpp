#include <iostream>

#include "edgeweighteddigraph.h"

using namespace std;

int main() {
  EdgeWeightedDigraph g("exemplos/tinyEWD.txt");

  for (auto const& v : g.getVerts()) {
    cout << v << ": ";
    for (auto const& w : g.getAdj(v)) cout << w << " ";
    cout << endl;
  }

  cout << endl;
  cout << g.toDot();
}
