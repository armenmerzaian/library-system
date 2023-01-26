/**********************************************
 Workshop #2
 Course:BTP400
 Last Name:Merzaian
 First Name:Armen
 ID:060207024
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 Date:Feb 15, 2022
 **********************************************/

package com.senecacollege.assignment1;

import java.io.*;


/**
 * ReadData program designed to read TransactionRecord objects and Account objects from serialized files.
 * @author Armen Merzaian
 */
public class ReadData {
    private static ObjectInputStream input;

    public static void main(String[] args) {
        openFile("accounts.sir");
        System.out.println("file opened");
        readLine();
        closeFile();
    }


    private static void openFile(String filename){

        try{
            input = new ObjectInputStream(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readLine(){

        System.out.println("Reading: ");

        try{
            while(true)
            {
                Object obj = input.readObject();
                Client cl = (Client) obj;
                if(cl instanceof Admin admin){
                    System.out.println("Admin: ");
                    System.out.println(admin.getEmployeeID() + ": " + admin.getFirstName() + " " + admin.getLastName());
                } else if(cl instanceof Librarian librarian){
                    System.out.println("Librarian: ");
                    System.out.println(librarian.getEmployeeID() + ": " + librarian.getFirstName() + " " + librarian.getLastName());
                } else if(cl instanceof Student student){
                    System.out.println("Student: ");
                    System.out.println(student.getFirstName() + " " + student.getLastName());
                    System.out.println(student.getCheckedOut());
                    System.out.println(student.getMyRequests());
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
    }


    private static void closeFile() {
        try{
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

