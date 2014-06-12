package com.manpower.restdoc.service;

import com.manpower.restdoc.model.Character;

import java.util.Collection;

/**
 * Created by sbert on 11/06/2014.
 */

public interface CharacterService {

    Collection<Character> select();

    Character get(Long id);

    Character add(Character contact);

    Character update(com.manpower.restdoc.model.Character contact);

}
