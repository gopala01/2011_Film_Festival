package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int numJudges = 12;
        final int numFilms = 5;

        String[] filmNameArray = new String[numFilms];
        int[] voteCountArray = new int[numFilms];
        int[] judgeNumArray = new int[numJudges];



        filmNameArray = enter(filmNameArray);

        voteCountArray = voting(judgeNumArray, filmNameArray, voteCountArray);

        print("The winner is " + winner(filmNameArray,voteCountArray));


    }

    public static String[] enter(String[] filmNameArray)
    {
        for (int i = 0; i < filmNameArray.length; i++) {
            String filmName = inputString("What is the film name?");
            filmNameArray[i] = filmName;
        }

        return filmNameArray;
    }


    public static int[] voting(int[] judgeNumArray, String[] filmNameArray, int[] voteCountArray)
    {
        for (int i = 0; i < judgeNumArray.length; i++) {
            int numOfJudge = inputInt("What is your judge number?");
            while (numOfJudge < 1 || numOfJudge > judgeNumArray.length)
            {
                numOfJudge = inputInt("Choose your judge number");
            }

            while (judgeNumArray[numOfJudge-1] > 0)
            {
                numOfJudge = inputInt("Choose an unused judge number");
            }
            judgeNumArray[numOfJudge-1]++;
            for (int j = 0; j < filmNameArray.length; j++) {
                print((j+1) + " - " + filmNameArray[j]);
            }
            int choice = inputInt("What is your choice?");
            while (choice < 1 || choice > filmNameArray.length+1)
            {
                choice = inputInt("Choose a number from the choices");
            }
            int numArray2 = choice -1;

            voteCountArray[numArray2]++;
        }
        return voteCountArray;
    }


    public static String winner(String[] filmNames, int[] voteCounts) {
        String winningMovie = filmNames[0];

        for (int i = 0; i < voteCounts.length; i++) {
            for (int j = 1; j < voteCounts.length; j++) {
                if (voteCounts[j] > voteCounts[i])
                {
                    winningMovie = filmNames[j];
                }
                else
                {
                    winningMovie = filmNames[i];
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
