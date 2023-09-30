package com.example.demo.Service;

import com.example.demo.Entity.Contact;

import java.util.List;

public interface IContactService {

    Contact saveContact(Contact contact);
    List<Contact> allContacts();
    void deleteById(Long id);
}
