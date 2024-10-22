from graph import Graph

class UndirectedCycle:
    def __init__(self, g):
        self.g = g
        self.marked = {}
        self.edges = set()
        self.hasCycle = False
        for v in g.getVerts():
            if v not in self.marked:
                print("Testando",v)
                self.hasCycle = self.__containsCycle(v)
                if self.hasCycle:
                    break

    def __containsCycle(self, v):
        print("estou em", v)
        self.marked[v] = True
        for u in self.g.getAdj(v):
            e = u + "-" + v
            print("e:",e)
            if u not in self.marked:
                self.edges.add(e)
                res = self.__containsCycle(u)
                if res:
                    return res
            elif v + "-" + u not in self.edges:
                return True
        return False

if __name__ == "__main__":

    # g = Graph("exemplos/tinyG.txt")
    g = Graph();
    g.addEdge("A", "B")
    g.addEdge("B", "C")
    g.addEdge("C", "D")
    # g.addEdge("D", "A")
    g.addEdge("C", "E")
    g.addEdge("F", "G")
    g.addEdge("G", "H")
    g.addEdge("H", "F")

    uc = UndirectedCycle(g)

    print("Tem ciclo?", uc.hasCycle)
    print()
