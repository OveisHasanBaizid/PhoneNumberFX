package com.example.phonenumber;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Contact> contacts = new ArrayList<>();

    public static boolean existContact(Contact contact){
        for (Contact c:contacts) {
            if (c.getName().equals(contact.getName()) && c.getPhoneNumber().equals(contact.getPhoneNumber()))
                return true;
        }
        return false;
    }
}
