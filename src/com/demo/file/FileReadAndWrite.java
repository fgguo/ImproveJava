package com.demo.file;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @className: FileReadAndWrite
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/23
 **/
public class FileReadAndWrite  {

    public static void writeStringToFile(String file, String str) throws  IOException{
        OutputStream outputStream = new FileOutputStream(file);
        try{
            byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
        }
        finally {
            outputStream.close();
        }
    }

    public static String readStringFromFile(String file) throws IOException{
        InputStream inputStream = new FileInputStream(file);
        byte [] bytes = new byte[1024];
        String str;
//        int bytesRead = inputStream.read(bytes);
//        String str = new String(bytes, 0, bytesRead, "UTF-8");

        //可以使用批量读入且确保读到结尾
//        int off = 0, bytesRead = 0;
//        while ((bytesRead = inputStream.read(bytes, off, 1024 -off)) != -1){
//            off += bytesRead;
//        }
//        String str = new String(bytes, 0, off,"UTF-8" );

        //读入的数据先写入ByteArrayOutputStream中，读完后，再调用其toString方法获取完整数据。
//        try {
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//            int byteRead = 0;
//            while ((byteRead = inputStream.read(bytes)) != -1){
//                output.write(bytes,0, byteRead);
//            }
//            str = output.toString("UTF-8");
//        }
//        finally {
//            inputStream.close();
//        }

        //使用CharArrayWriter
        Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
        try {
            CharArrayWriter writer = new CharArrayWriter();
            char [] chars = new char[1024];
            int charRead = 0;
            while((charRead = reader.read(chars)) != -1){
                writer.write(chars, 0, charRead);
            }
            str = writer.toString();
        }
        finally {
            inputStream.close();
        }
        return str;
    }

    public static void main(String[] args) throws IOException{
        String str = "hello, 你好";
        String file = "str";
        FileReadAndWrite.writeStringToFile(file,str);

        System.out.println(FileReadAndWrite.readStringFromFile(file));
    }
}
