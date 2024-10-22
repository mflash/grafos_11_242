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
        return False

if __name__ == "__main__":

    g = Graph("exemplos/tinyG.txt")

    uc = UndirectedCycle(g)

    print("Tem ciclo?", uc.hasCycle)
    print()
