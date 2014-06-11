package com.manpower.restdoc.service;

import com.manpower.restdoc.model.Contact;

import java.util.Collection;

/**
 * Created by sbert on 11/06/2014.
 */

public interface ContactService {

    Collection<Contact> select();

    Contact get(Long id);

    Contact add(Contact contact);

    Contact update(Contact contact);

}
