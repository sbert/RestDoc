package com.manpower.restdoc.controller;

import com.manpower.restdoc.model.Contact;
import com.manpower.restdoc.service.ContactService;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by sbert on 11/06/2014.
 */



@Api(value = "contacts", description = "contacts")
@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    public Collection<Contact> select() {
        return contactService.select();
    }

    @ResponseBody
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Contact get(@PathVariable Long id) {
        return contactService.get(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Contact contact,HttpServletResponse response) {
        contactService.add(contact);
        String location = ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}").buildAndExpand(contact.getId())
                .toUriString();

        response.setHeader("Location",location);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id,@RequestBody Contact contact) {
        contact.setId(id);
        contactService.update(contact);
    }

}
