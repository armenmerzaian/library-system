package com.senecacollege.assignment1;

import java.io.*;

public class RequestWriter {

    private static ObjectOutput output;

    public static void main(String[] args) {

        File f = new File("requests.sir");
        try {
            output = new ObjectOutputStream(new FileOutputStream(f, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Request request1 = new Request(12345, 1001);
        try {
            output.writeObject(request1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
