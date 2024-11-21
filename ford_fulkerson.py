from collections import deque
from edgeweighteddigraph import EdgeWeightedDigraph
import sys


infinity = float("inf")


def make_graph():
    # identical graph as the YouTube video: https://youtu.be/Tl90tNtKvxs
    return [
            [0, 10, 0, 10, 0, 0],
            [0, 0, 4, 2, 8, 0],
            [0, 0, 0, 0, 0, 10],
            [0, 0, 0, 0, 9, 0],
            [0, 0, 6, 0, 0, 10],
            [0, 0, 0, 0, 0, 0],
        ]


# find paths from source to sink with breadth-first search
def bfs(G, source, sink, parent):
    visited = set()

    queue = deque()
    queue.append(source)

    visited.add(source)
 
    while queue:
        node = queue.popleft()

        for i in range(len(G[node])):
            if i not in visited and G[node][i] > 0:
                queue.append(i)
                visited.add(i)
                parent[i] = node
 
    return sink in visited


def ford_fulkerson(G, source, sink):
    # This array is filled by breadth-first search (bfs) and stores path
    parent = [-1] * (len(G))
    max_flow = 0

    while bfs(G, source, sink, parent):

        print(parent)
        # sys.exit(1)
        path_flow = infinity
        s = sink
 
        while s != source:
            # Find the minimum value in selected path
            path_flow = min(path_flow, G[parent[s]][s])
            print(f"s: {s}, peso aresta: {G[parent[s]][s]}, fluxo: {path_flow}")
            s = parent[s]

        max_flow += path_flow
        v = sink
 
        # add or subtract flow based on path
        while v != source:
            u = parent[v]
            G[u][v] -= path_flow
            G[v][u] += path_flow
            v = parent[v]
    
        parent = [-1] * (len(G))

    print(parent)
    print(G)
    return max_flow

def convertToEWG(G):
    ewg = EdgeWeightedDigraph()
    for row in range(len(G)):
        for col in range(len(G[row])):
            v = row
            w = col
            weight = G[row][col]
            ewg.addEdge(str(v),str(w),weight)
    return ewg

def main():
    G = make_graph()
    source = 0
    sink = 5
    ewg = convertToEWG(G) 
    print(ewg.toDot())
    max_flow = ford_fulkerson(G, source, sink)
    print(f'Maximum flow: {max_flow}')

    ewg_final = convertToEWG(G) 
    print(ewg_final.toDot())

main()
