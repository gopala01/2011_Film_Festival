package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int numJudges = 6;
        final int numFilms = 2;

        String[] filmNames = new String[numFilms];
        int[] voteCounts = new int[numFilms];
        int[] judgeNum = new int[numJudges];



        filmNames = enter(filmNames);

        voteCounts = voting(filmNames, voteCounts, judgeNum);

        print("The winner is " + winner(filmNames,voteCounts));


    }

    public static String[] enter(String[] filmNames)
    {
        for (int i = 0; i < filmNames.length; i++) {
            String filmName = inputString("What is the film name?");
            filmNames[i] = filmName;
        }

        return filmNames;
    }

    public static int[] voting(String[] filmNames, int[] voteCounts, int[] judgeNum)
    {
        for (int i = 0; i < judgeNum.length; i++) {
            int judge = inputInt("What is your judge number");
            int arrayNum = judge-1;
            try {
                judgeNum[arrayNum]++;
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                judge = inputInt("Enter a proper name");
            }
        }


        return voteCounts;
    }


    public static String winner(String[] filmNames, int[] voteCounts) {
        String winningMovie = "";

        for (int i = 0; i < voteCounts.length; i++) {
            for (int j = 1; j < voteCounts.length; j++) {
                if (voteCounts[j] > voteCounts[i]) {
                    winningMovie = filmNames[j];
                }
            }
        }
        return winningMovie;
    }

    public static void print(String m)
    {
        System.out.println(m);
    }

    public static String inputString(String m)
    {
        String answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextLine();
        return answer;
    }

    public static int inputInt(String m)
    {
        int answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextInt();
        return answer;
    }
}
