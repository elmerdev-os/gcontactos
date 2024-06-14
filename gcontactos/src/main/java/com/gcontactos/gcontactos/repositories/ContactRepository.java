package com.gcontactos.gcontactos.repositories;

import com.gcontactos.gcontactos.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
