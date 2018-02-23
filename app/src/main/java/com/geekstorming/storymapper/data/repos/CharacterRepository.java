package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.base.daos.CharacterDAO;
import com.geekstorming.storymapper.data.dao.CharacterDAOImpl;
import com.geekstorming.storymapper.data.pojo.Book;
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

    CharacterDAOImpl dao;

    // Constructor
    static {
        characterRepository = new CharacterRepository();
    }

    private CharacterRepository() {
        characters = new ArrayList<>();
        dao = new CharacterDAOImpl();
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
        dao.add(c);
    }

    public ArrayList<Character> getCharacters(Book book) {
       characters = dao.loadAll(book);
       return characters;
    }

    public static CharacterRepository getInstance() {
        return characterRepository;
    }

    public void removeCharacter(Character c) {
        dao.delete(c);
    }

    public void editCharacter(Character c) {
        dao.update(c);
    }
}