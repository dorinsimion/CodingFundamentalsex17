package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti luna");
        int month = input.nextInt();
        System.out.println("Introduceti anul");
        int year = input.nextInt();
        weekEnds(month, year);
        System.out.println("-------------");
        weekEnds2(month,year);

    }

    private static void weekEnds2(int month, int year) {
        LocalDate date = LocalDate.of(year,month,1);
        for(int i=1;i<=date.lengthOfMonth();i++){
            date=LocalDate.of(year,month,i);
            if(date.getDayOfWeek()== DayOfWeek.SATURDAY ||
                    date.getDayOfWeek()==DayOfWeek.SUNDAY){
                System.out.println(date);
            }
        }
    }

    private static void weekEnds(int month, int year) {
        LocalDate date = LocalDate.of(year,month,1);
        if(month==12){
            month=1;year++;
        }else {
            month++;
        }
        LocalDate finalDate = LocalDate.of(year,month,1);
        do{
            if(date.getDayOfWeek()== DayOfWeek.SATURDAY ||
            date.getDayOfWeek()==DayOfWeek.SUNDAY){
                System.out.println(date);
            }
            date =date.plusDays(1);
        }
        while(date.isBefore(finalDate));
    }
}
