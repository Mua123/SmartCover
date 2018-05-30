package com.cover.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
 
public class Two {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String file = null;
        int lastIndex = 0;
        int errorLine = 0;
        HashMap<String, ErrLog> hashMap = new HashMap<String, ErrLog>();
        ErrLog errLog = null;
        String key = null;
        StringBuilder sbBuilder = new StringBuilder();
        while (!cin.hasNext("#")) {
            file = cin.next();
            errorLine = cin.nextInt();
            lastIndex = file.lastIndexOf('\\');
            sbBuilder
                .append(lastIndex < 0 ? file : file.substring(lastIndex + 1))
                .append(" ").append(errorLine);
            key = sbBuilder.toString();
            sbBuilder.setLength(0);
            errLog = hashMap.get(key);
            if (errLog == null) {
                hashMap.put(key, new ErrLog(key, 1));
            } else errLog.size++; 
        }
        cin.close();
        ArrayList<ErrLog> list = new ArrayList<ErrLog>(hashMap.values());
        Comparator<ErrLog> cmp = new Comparator<ErrLog>() {
            @Override
            public int compare(ErrLog o1, ErrLog o2) {
                return o2.size - o1.size == 0 ? (o1.queueMark - o2.queueMark)
                    : o2.size - o1.size;
            }
        };
        Collections.sort(list, cmp);
        int lens = 8 > list.size() ? list.size() : 8;
        for (int i = 0; i < lens; i++) {
            errLog = list.get(i);
            lastIndex = errLog.name.lastIndexOf(" ");
            lastIndex = lastIndex - 16 < 0 ? 0 : lastIndex - 16;
            System.out.println((lastIndex == 0 ? errLog.name : errLog.name
                .substring(lastIndex)) + " " + errLog.size);
        }
    }
}
 
class ErrLog {
    static int mark; 
    String name;
    int queueMark; 
    int size; 
 
    public ErrLog(String name, int size){
        super();
        this.name = name;
        this.queueMark = mark++;
        this.size = size;
    }
}