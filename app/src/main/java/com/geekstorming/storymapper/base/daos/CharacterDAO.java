package com.geekstorming.storymapper.base.daos;

import com.geekstorming.storymapper.data.pojo.Character;

import java.util.ArrayList;

/**
 * Character DAO interface
 */

public interface CharacterDAO {
    ArrayList<Character> loadAll();
    long add(Character character);
    boolean exists(Character v);
    long delete (Character character);
    long update(Character character);
}
