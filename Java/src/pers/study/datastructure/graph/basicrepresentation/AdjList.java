package pers.study.datastructure.graph.basicrepresentation;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/28 10:41
 *
 * 在邻接矩阵基础修改
 * 原先的矩阵-二维数组替换为 linkedList
 * 空间复杂度： O(V+E)
 * 时间复杂度： 建图O(E*V) 查看O(degree(V))  求一个相邻点O(degree(v)) 改进用rbtree 或者hashset
 */
public class AdjList {
    private int V;
    private int E;
    //xiu
    private LinkedList<Integer> [] adj;
    private AdjList(String filename){
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            if (V < 0){
                throw new IllegalArgumentException("V error < 0");
            }
            adj = new LinkedList[V];
            //这儿加入泛型，Integer可加可不加
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
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
                if (adj[a].contains(b)){
                    throw new IllegalArgumentException("Parallel edge error");
                }
                //adj[a][b] = 1; 改写
                adj[a].add(b);
                adj[b].add(a);
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
    /**
     * i，j传所用访问数组下标（索引），w（表示顶点）直接返回给元素的值 foreach是迭代器，迭代返回元素
     **/
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("V = %d, E = %d\n",V,E));
        for (int v = 0; v < V; v++) {
            //显示是哪个节点，后面跟该节点的链表
            stringBuilder.append(String.format("%d:",v));
            for (int e : adj[v]) {
                //adj[v].get(i)  = j等价于数组索引访问
                stringBuilder.append(String.format("  %d  ",e));
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
        return adj[v].contains(w);
    }


    /**返回合v相邻的顶点，利用arrayList，
     * @param v 传入的顶点
     * i 表示相邻结点，后期的度也可以复用它
     */
    public LinkedList<Integer> adj(int v){
        //检测v是否合法
        validateVertex(v);
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int i = 0; i < v; i++) {
//            if (adj[v].contains(i)){
//                res.add(i);
//            }
//        }
        //不需要任何逻辑，链表本身节点已经代表连接的点，直接返回这个顶点自身的链表
        return adj[v];
    }

    /**求顶点的度（），顶点右多少的邻边*/
    public int degree(int v){

//        return adj[v].size(); 这种需要检测合法性
        return adj(v).size();
    }

    public static void main(String[] args) {
        AdjList adjList = new AdjList("src\\pers\\study\\txt\\test1.txt");
        System.out.println(adjList);
    }
}
