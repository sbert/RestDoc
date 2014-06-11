package com.manpower.restdoc.controller;

import com.manpower.restdoc.model.Person;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sbert on 11/06/2014.
 */
@Api(value = "api", description = "Lord of the Ring")
@Controller
@RequestMapping("/api")
public class RestController {

    @ApiOperation(value = "Creates a Book")
    @RequestMapping("/hobbit/bilbo")
    @ResponseBody
    public Person getHobbit() {
        return new Person("Bilbo", "Hobbit");
    }

}
