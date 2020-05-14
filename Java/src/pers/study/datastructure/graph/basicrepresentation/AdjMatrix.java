package pers.study.datastructure.graph.basicrepresentation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/28 9:28
 * @title 图的邻接矩阵表示法
 * 定义邻接矩阵，有值赋值为1，无为0，数据第一行是 结点-边数，下面是连通的路径
 * 简单图，没有自环边，没有平行边
 * 优点：时间复杂度低 建图O(E) 查询两点是否相邻O(1) 求相邻节点O(V)
 * 缺点，空间负责度高 O(v^2) 稀疏图时，用邻接表解决
 *
 * 图的生成树（是一个稀疏图）边数最少
 * 原图相对的不一定是（稠密图） ---> 怎么判断？看节点有限时稠密图时线多的，稠密图不多见，但是完全图一定是稠密图
 * 现实中大多数是稀疏图
 *
 * 邻接表：每个结点后带着一个链表（链表结点是相邻的点）
 */
public class AdjMatrix {
    private int V;
    private int E;
    private int[][] adj;
    private AdjMatrix(String filename){
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            if (V < 0){
                throw new IllegalArgumentException("V error < 0");
            }
            adj = new int[V][V];
            E = scanner.nextInt();
            if (E < 0){
                throw new IllegalArgumentException("E error < 0");
            }
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                //去电自环边
                if (a == b){
                    throw new IllegalArgumentException("Self Loop error");
                }
                //去掉平行边
                if (adj[a][b] == 1){
                    throw new IllegalArgumentException("Parallel edge error");
                }
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**检测是否合法*/
    private void validateVertex(int v){
        if (v < 0 || v >= V){
            throw new IllegalArgumentException("vertex" + v +"error");
        }
    }

    @Override
    public String toString(){
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(String.format(" V = %d, E = %d\n",V,E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                stringBuilder.append(String.format(" %d ",adj[i][j]));
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
    /**返回私有V*/
    private int v(){
        return V;
    }
    /**返回私有E*/
    private int e(){
        return E;
    }

    /**是否存在某条边，查询*/
    private boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }


    /**返回合v相邻的顶点，利用arrayList，
     * @param v 传入的顶点
     * i 表示相邻结点，后期的度也可以复用它
     */
    public ArrayList<Integer> adj(int v){
        //检测v是否合法
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (adj[v][i] == 1){
                res.add(i);
            }
        }
        return res;
    }

    /**求顶点的度（），顶点右多少的邻边*/
    public int degree(int v){
        return adj(v).size();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("src\\pers\\study\\txt\\test1.txt");
        System.out.println(adjMatrix);
    }
}
