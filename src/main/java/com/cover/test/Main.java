package com.cover.test;

import java.util.*;
class MyObject implements Comparable<MyObject>{//自定义的类，并自定义比较规则
    String nameNo;
    int count;
    
    @Override
    public int compareTo(MyObject o) {
      return o.count-this.count;
    }
 
    public MyObject(String nameNo, int count) {
        super();
        this.nameNo = nameNo;
        this.count = count;
    }
 
    public String getNameNo() {
        return nameNo;
    }
 
    public void setNameNo(String nameNo) {
        this.nameNo = nameNo;
    }
 
    public int getCount() {
        return count;
    }
 
    public void setCount(int count) {
        this.count = count;
    }
    
 
}
public class Main {
     
    public static void main(String[] args) {
 
        Scanner sc=new Scanner(System.in);
        ArrayList<MyObject> ob=new ArrayList<MyObject>();
        while(sc.hasNextLine()){
            String line=sc.nextLine();                 
            String nameNo=line.trim().substring(line.trim().lastIndexOf("\\")+1);//文件名和行号
            boolean flag=false;
            for (int j = 0; j <ob.size(); j++) {
            if(ob.get(j).getNameNo().equals(nameNo)){//存在
                MyObject temp=ob.get(j);
                temp.setCount(temp.getCount()+1);
                ob.set(j, temp);
                    flag=true;
                    break;
                 }     
             
            }//end of for
            if(flag==false){//不存在
            MyObject o=new MyObject(nameNo, 1);
            ob.add(o);
            }
    }//数据处理完毕
        //sc.close();  
         
         Collections.sort(ob);//稳定排序
             int coun=0;
            while(coun<8&&coun<ob.size()){
                String[] temp=ob.get(coun).getNameNo().split(" ");
                String filename=temp[0].substring(temp[0].lastIndexOf("\\")+1);
                if(filename.length()>16) filename=filename.substring(filename.length()-16);
                System.out.println(filename+" "+temp[1]+" "+ob.get(coun).getCount());
                coun++;
            }
       }   
    }