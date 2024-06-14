package com.gcontactos.gcontactos.controllers;

import com.gcontactos.gcontactos.entity.Contact;
import com.gcontactos.gcontactos.service.ContactService;
import com.gcontactos.gcontactos.view.ContactView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<ContactView> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return contacts.stream()
                .map(ContactView::fromContact)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        return contact != null
                ? ResponseEntity.ok(contact)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.saveContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        Contact updatedContact = contactService.updateContact(contact);
        return updatedContact != null
                ? ResponseEntity.ok(updatedContact)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}