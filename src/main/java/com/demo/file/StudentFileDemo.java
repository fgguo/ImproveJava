package com.demo.file;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: StudentFileDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/23
 **/
public class StudentFileDemo {
    public static void writeStudents(List<com.demo.file.Student> students) throws IOException {
        //PrintWriter
        PrintWriter writer = new PrintWriter("students.txt");
        try {
            for(com.demo.file.Student student : students){
                writer.println(student.getName() + "," + student.getAge() + "," + student.getScore());
            }
        }
        finally {
            writer.close();
        }
        //BufferedWriter实现
//        BufferedWriter writer = null;
//        try {
//            writer = new BufferedWriter(new FileWriter("students.txt"));
//            for(Student student : students){
//                writer.write(student.getName() + "," + student.getAge() + "," + student.getScore());
//                writer.newLine();
//            }
//        }
//        finally {
//            if(writer != null){
//                writer.close();
//            }
//        }
//        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("student.dat"));
//        try {
//            outputStream.writeInt(students.size());
//            for (Student student : students) {
//                outputStream.writeUTF(student.getName());
//                outputStream.writeInt(student.getAge());
//                outputStream.writeDouble(student.getScore());
//            }
//        } finally {
//            outputStream.close();
//        }
    }

    public static List<com.demo.file.Student> readStudents() throws IOException{
        //BufferedReader
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("students.txt"));
            List<com.demo.file.Student> students = new ArrayList<>();
            String line = reader.readLine();
            while (line != null){
                String [] fields = line.split(",");
                com.demo.file.Student student = new com.demo.file.Student();
                student.setName(fields[0]);
                student.setAge(Integer.parseInt(fields[1]));
                student.setScore(Double.parseDouble(fields[2]));
                students.add(student);
                line = reader.readLine();
            }
            return students;
        }
        finally {
            if(reader != null){
                reader.close();
            }
        }


//        DataInputStream inputStream = new DataInputStream(new FileInputStream("student.dat"));
//        try {
//            int size = inputStream.readInt();
//            List<Student> students = new ArrayList<>(size);
//            for(int i = 0; i < size; i++){
//                Student s = new Student();
//                s.setName(inputStream.readUTF());
//                s.setAge(inputStream.readInt());
//                s.setScore(inputStream.readDouble());
//                students.add(s);
//            }
//            return students;
//        }
//        finally {
//            inputStream.close();
//        }
    }


    public static void main(String[] args) throws IOException {
        List<com.demo.file.Student> students = Arrays.asList(new com.demo.file.Student[]{new com.demo.file.Student("张三",16,60d),new com.demo.file.Student("李四",16,70d),new com.demo.file.Student("王五",16,66d)});
        StudentFileDemo.writeStudents(students);

        //读
        List<com.demo.file.Student> readStudents = StudentFileDemo.readStudents();
        for(com.demo.file.Student s : readStudents){
            System.out.println(s.toString());
        }
    }
}
