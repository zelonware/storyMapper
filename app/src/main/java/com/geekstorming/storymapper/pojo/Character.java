package com.geekstorming.storymapper.pojo;

/**
 * Character entity, acting and moving!
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Character {

    // Atts

    int characterID;
    String characterName;
    String characterDesc;

    int characterFaction;

    // Getters + Setters

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterDesc() {
        return characterDesc;
    }

    public void setCharacterDesc(String characterDesc) {
        this.characterDesc = characterDesc;
    }

    public int getCharacterFaction() {
        return characterFaction;
    }

    public void setCharacterFaction(int characterFaction) {
        this.characterFaction = characterFaction;
    }

    // Constructor

    public Character(int characterID, String characterName, String characterDesc, int characterFaction) {
        this.characterID = characterID;
        this.characterName = characterName;
        this.characterDesc = characterDesc;
        this.characterFaction = characterFaction;
    }

    // toString()

    @Override
    public String toString() {
        return "Character{" +
                "characterID=" + characterID +
                ", characterName='" + characterName + '\'' +
                ", characterDesc='" + characterDesc + '\'' +
                ", characterFaction=" + characterFaction +
                '}';
    }
}
