package com.example.demo.Service;

import com.example.demo.Entity.Contact;
import com.example.demo.Repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements IContactService{
    @Autowired
    private IContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }
    @Override
    public List<Contact> allContacts() {
        return contactRepository.findAll();
    }
    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
