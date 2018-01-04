package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.data.pojo.Character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Character repository, character list
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class CharacterRepository {

    // Atts
    private ArrayList<Character> characters;
    private static CharacterRepository characterRepository;

    // Constructor
    static {
        characterRepository = new CharacterRepository();
    }

    private CharacterRepository() {
        characters = new ArrayList<>();
        initializeCharacters();
    }

    // Methods

    private void initializeCharacters() {

        addCharacter(new Character(1, "Lisbeth Salander", "Descripcion de Salander", 1, 1));
        addCharacter(new Character(2, "Miriam Wu", "Descripcion de Wu", 1, 2));
        addCharacter(new Character(3, "Noelia Eklund", "Descripcion de Noelia", 1, 2));
        addCharacter(new Character(4, "Rayan Norberg", "Descripcion de Rayan", 1, 2));
        addCharacter(new Character(5, "Flora Nyberg", "Descripcion de Flora", 1, 2));
        addCharacter(new Character(6, "Joacim Andreasson", "Descripcion de Joacim", 1, 2));
        addCharacter(new Character(7, "Tina Samuelsson", "Descripcion de Tina", 1, 2));
        addCharacter(new Character(8, "Beatrice Larsson", "Descripcion de Beatrice", 1, 2));
        addCharacter(new Character(9, "Amelia Söderberg", "Descripcion de Amelia", 1, 2));
        addCharacter(new Character(10, "Johanna Mårtensson", "Descripcion de Johanna", 1, 2));
    }

    public void addCharacter(Character c) {
        characters.add(c);
    }

    public ArrayList<Character> getCharacters() {

        Collections.sort(characters);
        return characters;
    }

    public static CharacterRepository getInstance() {
        return characterRepository;
    }

    public void removeCharacter(Character c) {

        Iterator<Character> iterator = characters.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getCharacterID() == c.getCharacterID()) {
                iterator.remove();
                break;
            }
        }

    }

    public void editCharacter(Character c) {
        for (Character character : characters) {
            if (character.getCharacterID() == c.getCharacterID()) {
                character.setCharacterName(c.getCharacterName());
                character.setCharacterDesc(c.getCharacterDesc());
                character.setCharacterFaction(c.getCharacterFaction());
                character.setCharacterHome(c.getCharacterHome());
                break;
            }
        }
    }
}