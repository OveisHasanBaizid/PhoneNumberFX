package com.example.phonenumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Contact> contacts = new ArrayList<>();
    public static Contact editContact = null;
    public static boolean existContact(Contact contact){
        for (Contact c:contacts) {
            if (c.getName().equals(contact.getName()) && c.getPhoneNumber().equals(contact.getPhoneNumber()))
                return true;
        }
        return false;
    }
    public static void delete(Contact contact) throws IOException {
        contacts.remove(contact);
        write();
    }
    public static void edit(Contact contact1 ,  Contact contact2){
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).equals(contact1)){
                contacts.set(i,contact2);
            }
        }
    }
    public static ArrayList<Contact> getContacts(String text){
        if (text==null || text.equals(""))
            return contacts;
        ArrayList<Contact> contactList = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(text.toLowerCase()))
                contactList.add(c);
        }
        return contactList;
    }
    public static void write() throws IOException {
        FileWriter fileWriter = new FileWriter("contacts.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (Contact c:contacts) {
            stringBuilder.append(c.toString()+"\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }
    public static void read() throws IOException {
        FileReader fileReader = new FileReader("contacts.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = "";
        while ((s = bufferedReader.readLine())!=null){
            contacts.add(new Contact(s));
        }
        fileReader.close();
    }
    public static void saveToFile(Contact contact) throws IOException {
        FileWriter fileWriter = new FileWriter("contacts.txt",true);
        fileWriter.append(contact.toString()+"\n");
        fileWriter.close();
    }
}
