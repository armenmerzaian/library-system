package com.senecacollege.assignment1;

import java.io.*;

public class MaterialReader {

    private static ObjectInputStream input;

    public static void main(String[] args) {

        //OPEN FILE
        try{
            input = new ObjectInputStream(new FileInputStream("allMaterials.sir"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //READ FILE
        System.out.println("Reading: ");

        try{
            while(true)
            {
                Object obj = input.readObject();
                if(obj instanceof LibraryBook lb){
                    System.out.println("Library Book: " + lb.getTitle() + "\tMaterial Code: " + lb.getMaterialCode());
                } else if(obj instanceof DVD dv){
                    System.out.println("DVD: " + dv.getTitle() + "\tMaterial Code: " + dv.getMaterialCode());
                }else if(obj instanceof CD cd) {
                    System.out.println("CD: " + cd.getTitle() + "\tMaterial Code: " + cd.getMaterialCode());
                }else if(obj instanceof Magazine mg) {
                    System.out.println("Magazine: " + mg.getTitle() + "\tMaterial Code: " + mg.getMaterialCode());
                }
            }
        }catch(EOFException e)
        {
            System.out.println("No more records in the file to read");
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //CLOSE FILE
        try{
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    } //main
}
