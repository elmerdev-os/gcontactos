package com.gcontactos.gcontactos.view;

import com.gcontactos.gcontactos.entity.Contact;

public class ContactView {
    private Long id;
    private String nombreCompleto;
    private String email;
    private String telefono;

    public ContactView() {

    }

    public static ContactView fromContact(Contact contact) {
        ContactView contactView = new ContactView();
        contactView.setId(contact.getId());
        contactView.setNombreCompleto(contact.getNombre() + " " + contact.getApellido());
        contactView.setEmail(contact.getEmail());
        contactView.setTelefono(contact.getTelefono());
        return contactView;
    }

    public ContactView(Long id, String nombreCompleto, String email, String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
