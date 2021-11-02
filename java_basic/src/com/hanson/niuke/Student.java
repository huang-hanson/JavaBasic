package com.hanson.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    public static void main(String[] args) {
        ArrayList<StudentSort> data = new ArrayList<>();
        StudentSort jby = new StudentSort("贾宝玉", 14, 88.5);
        StudentSort ldy = new StudentSort("林黛玉", 13, 88.5);
        StudentSort sxy = new StudentSort("史湘云", 13, 85);
        StudentSort xbc = new StudentSort("薛宝钗", 15, 91);
        data.add(jby);
        data.add(ldy);
        data.add(sxy);
        data.add(xbc);
        Collections.sort(data);
        for (StudentSort sort : data) {
            System.out.println(sort);
        }
        System.out.println("-----------------");
        Collections.sort(data, new comparator());
        for (StudentSort sort : data) {
            System.out.println(sort);
        }
    }

    static class StudentSort implements Comparable<StudentSort> {
        private String name;
        private int age;
        private double fraction;

        @Override
        public int compareTo(StudentSort o) {
            if (this.fraction > o.fraction) {
                return -1;
            } else if (this.fraction == o.fraction) {
                if (this.age > age) {
                    return 1;
                }
                return -1;
                /*return this.age-this.age ;*/
            } else {
                return 1;
            }
        }

        public StudentSort() {
        }

        public StudentSort(String name, int age, double fraction) {
            this.name = name;
            this.age = age;
            this.fraction = fraction;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getFraction() {
            return fraction;
        }

        public void setFraction(double fraction) {
            this.fraction = fraction;
        }

        @Override
        public String toString() {
            return "Sort{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", fraction=" + fraction +
                    '}';


        }


    }

    static class comparator implements Comparator<StudentSort> {

        @Override
        public int compare(StudentSort o1, StudentSort o2) {
            if (o1.fraction == o2.fraction) {
                return o1.age - o2.age;
            }
            if (o1.fraction > o2.fraction) {
                return -1;
            } else if (o1.fraction < o2.fraction) {
                return 1;
            } else {
                return 0;
            }

        }
    }
}
