package com.geekstorming.storymapper.data.pojo;

import java.util.ArrayList;

/**
 * BookComponents, books + factions + characters + chapters
 */

public class BookComponents extends Book {

    private ArrayList<Character> characters;
    private ArrayList<Chapter> chapters;
    private ArrayList<Faction> factions;
    private int currentWords;

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public ArrayList<Faction> getFactions() {
        return factions;
    }

    public void setFactions(ArrayList<Faction> factions) {
        this.factions = factions;
    }

    public int getCurrentWords() {
        return currentWords;
    }

    public void setCurrentWords(int currentWords) {
        this.currentWords = currentWords;
    }

    public BookComponents(int bookID, String bookTitle, String bookDesc, String bookGenre, int nWords, int user) {
        super(bookID, bookTitle, bookDesc, bookGenre, nWords, user);
        characters = new ArrayList<>();
        chapters = new ArrayList<>();
        factions = new ArrayList<>();
        currentWords = 0;
    }


}
