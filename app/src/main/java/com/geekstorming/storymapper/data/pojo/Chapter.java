package com.geekstorming.storymapper.data.pojo;

import android.support.annotation.NonNull;

/**
 * Chapter entity
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Chapter implements Comparable {

    // Atts

    int IDChapter;
    String chapterName;
    String storyProgress;

    int IDBook;

    // Getters + Setters

    public int getIDChapter() {
        return IDChapter;
    }

    public void setIDChapter(int IDChapter) {
        this.IDChapter = IDChapter;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getStoryProgress() {
        return storyProgress;
    }

    public void setStoryProgress(String storyProgress) {
        this.storyProgress = storyProgress;
    }

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    // Constructor

    public Chapter(int IDChapter, String nombreCapitulo, String storyProgress, int bookID) {
        this.IDChapter = IDChapter;
        this.chapterName = nombreCapitulo;
        this.storyProgress = storyProgress;
        this.IDBook = bookID;
    }

    // toString()


    @Override
    public String toString() {
        return "Chapter{" +
                "IDChapter=" + IDChapter +
                ", chapterName='" + chapterName + '\'' +
                ", storyProgress='" + storyProgress + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return chapterName.compareTo(((Chapter) o).getChapterName());
    }
}
