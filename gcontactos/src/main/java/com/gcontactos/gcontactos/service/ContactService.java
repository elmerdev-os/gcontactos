package com.gcontactos.gcontactos.service;

import com.gcontactos.gcontactos.entity.Contact;

import java.util.List;

public interface ContactService     {
    Contact saveContact(Contact contact);
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact updateContact(Contact contact);
    void deleteContact(Long id);
}
