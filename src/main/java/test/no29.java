package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fuguo
 * @date 2021/10/25 7:36 下午
 */
public class no29 {
    final String SMALL = "small";
    final String MEDIUM = "medium";
    String name = "ds";
    enum Size {SMALL,MEDIUM};
    no29(String n){
        String name = n;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] strs = input.split(" ");
        //按字母顺序排列
        Arrays.sort(strs);
        int count = 1;
        // are are baby how old you you
        //do do how you
        //hou are you you
        for(int i = 0; i < strs.length; i++){
            if(i - 1 >= 0 && !strs[i].equals(strs[i-1]) && i + 1 < strs.length && !strs[i].equals(strs[i+1])){
                System.out.println(strs[i] + " " + 1);
            }
            else if(i - 1 >= 0 && strs[i].equals(strs[i-1])){
                count++;
                if(i == strs.length - 1||(i + 1 < strs.length && !strs[i].equals(i + 1))) {
                    System.out.println(strs[i] + " " + count);
                    count = 1;
                }
            }
            else if(i == 0 && !strs[i].equals(strs[i+1])){
                System.out.println(strs[i] + " " + 1);
            }
            else if(i == strs.length - 1 && strs[i].equals(strs[i-1])){
                count++;
                System.out.println(strs[i] + " " + count);
            }
            else if(i == strs.length - 1){
                System.out.println(strs[i] + " " + 1);
            }
        }
    }
}
