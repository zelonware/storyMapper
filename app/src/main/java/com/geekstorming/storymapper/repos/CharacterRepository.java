package com.geekstorming.storymapper.repos;

import com.geekstorming.storymapper.pojo.Character;

import java.util.ArrayList;

/**
 * Character repository, character list
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

    private CharacterRepository()
    {
        characters = new ArrayList<>();
        initializeCharacters();
    }

    // Methods

    private void initializeCharacters(){

        addCharacter(new Character(1, "Lisbeth Salander", "Descripcion de Salander", 1, 1));
        addCharacter(new Character(2, "Miriam Wu", "Descripcion de Wu", 1, 2));
    }

    private void addCharacter(Character c)
    {
        characters.add(c);
    }

    public ArrayList<Character> getCharacters()
    {
        return characters;
    }

    public static CharacterRepository getInstance()
    {
        return characterRepository;
    }
}