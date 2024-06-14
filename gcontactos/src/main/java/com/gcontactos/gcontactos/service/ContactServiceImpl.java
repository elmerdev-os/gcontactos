package com.gcontactos.gcontactos.service;

import com.gcontactos.gcontactos.entity.Contact;
import com.gcontactos.gcontactos.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }
    @Override
    public Contact updateContact(Contact contact) {
        // Verifica si el contacto existe antes de actualizarlo
        if (contactRepository.existsById(contact.getId())) {
            return contactRepository.save(contact);
        }
        return null;
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
