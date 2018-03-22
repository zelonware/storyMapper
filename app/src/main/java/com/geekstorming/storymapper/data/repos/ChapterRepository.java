package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.data.dao.ChapterDAOImpl;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Chapter;

import java.util.ArrayList;

public class ChapterRepository {

    // Atts
    ArrayList<Chapter> chapters;
    private static ChapterRepository chapterRepository;

    ChapterDAOImpl dao;

    // Constructor
    static {
        chapterRepository = new ChapterRepository();
    }

    private ChapterRepository() {
        chapters = new ArrayList<>();
        dao = new ChapterDAOImpl();
    }

    public static ChapterRepository getInstance() {
        return chapterRepository;
    }

    public ArrayList<Chapter> getChapters(Book book) {
        chapters = dao.loadAll(book);
        return chapters;
    }

    public void addChapter(Chapter c) {
        dao.add(c);
    }

    public void removeChapter (Chapter c) {
        dao.delete(c);
    }

    public void editChapter (Chapter c) {
        dao.update(c);
    }
}
