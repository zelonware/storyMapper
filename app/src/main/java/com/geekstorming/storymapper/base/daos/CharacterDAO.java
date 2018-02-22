package com.geekstorming.storymapper.base.daos;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;

import java.util.ArrayList;

/**
 * Character DAO interface
 */

public interface CharacterDAO {
    ArrayList<Character> loadAll(Book bookID);
    long add(Character character);
    boolean exists(Character character);
    long delete (Character character);
    long update(Character character);
}
