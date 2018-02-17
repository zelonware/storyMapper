package com.geekstorming.storymapper.data.db;

import android.provider.BaseColumns;

/**
 * Contract for stories PSFs
 */

public class StoriesContract {

    private StoriesContract() {
    }

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "stories.db";

    public static class BookItem implements BaseColumns {
        public static final String TABLE = "book";
        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String GENRE = "genre";
        public static final String NWORDS = "nwors";

        public static final String[] ALL_COLUMNS = {
                BaseColumns._ID, TITLE, DESCRIPTION, GENRE, NWORDS
        };

        public static final String DEFAULT_SORT = TITLE;

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT NOT NULL," +
                "%s TEXT NOT NULL," +
                "%s TEXT," +
                "%s INTEGER)",
                TABLE,
                BaseColumns._ID,
                TITLE,
                DESCRIPTION,
                GENRE,
                NWORDS);

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);
    }

    public static class CharacterItem implements BaseColumns {

        public static final String TABLE = "character";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String HOME = "home";
        public static final String FACTION = "faction";

        public static final String[] ALL_COLUMNS = {
                BaseColumns._ID, NAME, DESCRIPTION, HOME, FACTION
        };

        public static final String DEFAULT_SORT = NAME;

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT NOT NULL," +
                "%s TEXT NOT NULL," +
                "%s INTEGER, " +
                "%s INTEGER)",
                TABLE,
                BaseColumns._ID,
                NAME,
                DESCRIPTION,
                HOME,
                FACTION);

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);
    }
}
