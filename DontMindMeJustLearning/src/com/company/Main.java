package com.company;

import java.io.*;

class linstring

{

    String[] array = new String[10];
    String a = "";
    public void linsearch()
    {
        String[] string = array;
        String search = a;

        int i;
        int flag = 0;
        for(i = 0; i<10; i++)
        {
            if (search.equals(string[i]))
            {
                flag = 1;
                break;
            }

        }
        if (flag ==1)
        {
            System.out.println("Name found at position " +(i+1));
        }
        else
        {
            System.out.println("Name not found.");
        }
    }

    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        linstring obj = new linstring();
        System.out.println("Enter any 10 Names.");

        String[] enter = new String[10];
        int i;
        for (i = 0; i<10; i++)
        {

            enter[i] = br.readLine();

        }
        System.out.println("Enter Name to be searched.");
        String search1 = br.readLine();
        obj.linsearch();
    }
}
