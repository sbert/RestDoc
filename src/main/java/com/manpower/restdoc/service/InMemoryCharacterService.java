/**
 * 
 */
package com.manpower.restdoc.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.manpower.restdoc.model.Character;
import org.springframework.stereotype.Service;

@Service
public class InMemoryCharacterService implements CharacterService {
	
	private AtomicLong idCounter = new AtomicLong();
	
	private Map<Long, Character> characters = new LinkedHashMap<Long, Character>();
	
	public InMemoryCharacterService() {
		Character character = new Character(idCounter.incrementAndGet(),"Bilbo","Le seigneur des Anneaux");
		characters.put(character.getId(),character);
		character = new Character(idCounter.incrementAndGet(),"Neo","Matrix");
		characters.put(character.getId(),character);
		character = new Character(idCounter.incrementAndGet(),"Leeloo","5ème Elément");
		characters.put(character.getId(),character);
		character = new Character(idCounter.incrementAndGet(),"Luc","Star Wars");
		characters.put(character.getId(),character);
	}

	@Override
	public Collection<Character> select() {
		return characters.values();
	}

	@Override
	public Character get(Long id) {
		return characters.get(id);
	}

	@Override
	public Character add(Character character) {
		character.setId(idCounter.incrementAndGet());
		characters.put(character.getId(), character);
		return character;
	}

	@Override
	public Character update(com.manpower.restdoc.model.Character character) {
		characters.put(character.getId(), character);
		return character;
	}

}
