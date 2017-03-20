package com.ycx.mianshi;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * Created by apple on 2017/2/21.
 */
public class NumberDuyin {/*
    static String[] numArray={"零","一","二","三","四","五","六","七","八","九"};
    static String[] numName={"十","亿","千","百","十","万","千","百","十",""};
    protected static String GetString(int Num){
                 StringBuilder sb=new StringBuilder();    //存储结果
                 Integer iNum=new Integer(Num);           //int装箱
                 String source=iNum.toString();           //装箱后的String
                 int iLength=source.length();             //装箱后的String的长度
                 for(int i=0;i<iNum;i++){
                         if(Character.getNumericValue(source.charAt(i))!=0){
                             sb.append(numArray[Character.getNumericValue(source.charAt(i))]);
                             sb.append(numName[10-iLength+i]);
                             }
                         else{
                                 if(sb.toString().endsWith("零")==true)
                                         continue;
                                 else
                                     sb.append("零");
                             }
                     }
                 System.out.println(sb.toString());
                 return sb.toString();
             }
    public static void main(String[] args) {
        int a=0;
                 Scanner sc=new Scanner(System.in);
                 while(a!=-1){
                         System.out.println("输入：");
                         a=sc.nextInt();
                         GetString(a);
                     }

    }


    public void breadthFirst() {
        Deque<Map<String, Object>> nodeDeque = new ArrayDeque<Map<String, Object>>();
        Map<String, Object> node = new HashMap<String, Object>();
        nodeDeque.add(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.peekFirst();
            System.out.println(node);
            //获得节点的子节点，对于二叉树就是获得节点的左子结点和右子节点
            List<Map<String, Object>> children = null ; //getChildren(node);
            if (children != null && !children.isEmpty()) {
                for (Map child : children) {
                    nodeDeque.add(child);
                }
            }
        }
    }
    public static void toFayin(int[] number) {
        Stack s = new Stack();
        String[] ss = {"万","千","百","十",""};
        for (int x:number) {
            s.push(x);
        }
        for (int i = 0 ;i<s.size();i++) {
            System.out.print(s.pop()+ss[i]);
        }
    }*/
}
