package com.manpower.restdoc.controller;

import com.manpower.restdoc.model.Character;
import com.manpower.restdoc.service.CharacterService;
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



//@Api(value = "characters", description = "Movie Characters")
@Controller
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    public Collection<Character> select() {
        return characterService.select();
    }

    @ResponseBody
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Character get(@PathVariable Long id) {
        return characterService.get(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Character character,HttpServletResponse response) {
        characterService.add(character);
        String location = ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}").buildAndExpand(character.getId())
                .toUriString();

        response.setHeader("Location",location);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id,@RequestBody Character character) {
        character.setId(id);
        characterService.update(character);
    }

}
