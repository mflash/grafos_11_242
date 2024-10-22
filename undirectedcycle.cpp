#include "undirectedcycle.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <set>

using namespace std;

UndirectedCycle::UndirectedCycle(Graph &g)
{
	hasCycle = false;
	for (auto const &w : g.getVerts())
	{
		if (marked.find(w) == marked.end())
		{
			hasCycle = containsCycle(g, w);
			if (hasCycle)
				break;
		}
	}
}

bool UndirectedCycle::containsCycle()
{
	return hasCycle;
}

bool UndirectedCycle::containsCycle(Graph &g, string v)
{
	return false;
}
