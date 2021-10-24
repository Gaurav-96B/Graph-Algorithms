class Solution {
     public int networkDelayTime(int[][] times, int N, int K) {
       double[][] distance = new double[N][N];
    for (int i = 0; i < N; i++) {
        Arrays.fill(distance[i], Double.POSITIVE_INFINITY);
    }
    for (int i = 0; i < N; i++) {
        distance[i][i] = 0;
    }
    for (int[] edge: times) {
        distance[edge[0] - 1][edge[1] - 1] = edge[2];
    }
    for (int k = 0; k < N; k++) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (distance[i][j] > distance[i][k] + distance[k][j])
                    distance[i][j] = distance[i][k] + distance[k][j];
            }
        }
    }
    double max = Double.MIN_VALUE;
    for (int i = 0; i < N; i++) {
        if (distance[K - 1][i] == Double.POSITIVE_INFINITY) return -1;
        max = Math.max(max, distance[K - 1][i]);
    }
    return (int) max;
}
}
