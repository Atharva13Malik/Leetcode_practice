class DSU {

    int[] parent;
    int[] rank;

    DSU(int n) {

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x) {

        if (parent[x] == x)
            return x;

        parent[x] = find(parent[x]);

        return parent[x];
    }

    void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        }
        else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        }
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}

class Solution {

    public int makeConnected(int n, int[][] connections) {

        // Agar edges hi kam hain to kabhi connect nahi kar sakte
        if (connections.length < n - 1)
            return -1;

        DSU dsu = new DSU(n);

        int extra = 0;

        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) == dsu.find(v))
                extra++;
            else
                dsu.union(u, v);
        }

        int components = 0;

        for (int i = 0; i < n; i++) {

            if (dsu.find(i) == i)
                components++;
        }

        if (extra >= components - 1)
            return components - 1;

        return -1;
    }
}
