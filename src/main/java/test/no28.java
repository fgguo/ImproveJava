package main.java.test;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @className: no28
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/12/4
 **/
public class no28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String sub = scanner.nextLine();
        String [] strs = str.split(" ");
        char[] chars = sub.toCharArray();
        int i = 0, j = chars.length - 1;
        while(i < j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        String reverseSub = new String(chars);
        String res = "";
        for(i = 0; i < strs.length; i++){
            if(strs[i].equals(sub)){
                strs[i] = reverseSub;
            }
            res += strs[i];
            if(i != strs.length - 1){
                res += " ";
            }
        }
        System.out.println(res);
    }
}
