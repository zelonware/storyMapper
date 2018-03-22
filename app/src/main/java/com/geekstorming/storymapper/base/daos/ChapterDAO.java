package com.geekstorming.storymapper.base.daos;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Chapter;

import java.util.ArrayList;

public interface ChapterDAO {
    ArrayList<Chapter> loadAll(Book bookID);
    long add(Chapter chapter);
    boolean exists(Chapter chapter);
    long delete(Chapter chapter);
    long update(Chapter chapter);
}
