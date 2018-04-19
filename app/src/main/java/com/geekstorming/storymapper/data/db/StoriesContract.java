package com.geekstorming.storymapper.data.db;

import android.provider.BaseColumns;

/**
 * Contract for stories PSFs
 */

public class StoriesContract {

    private StoriesContract() {
    }

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "stories.db";

    public static class AdviceItem implements BaseColumns {

        public static final String TABLE = "advices";
        public static final String ADVICE = "advice";

        public static final String[] ALLCOLUMNS = { BaseColumns._ID, ADVICE };

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL)",
                TABLE,
                BaseColumns._ID,
                ADVICE);

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String SQL_INSERT_TOTABLE = String.format("INSERT INTO %s (%s) VALUES ('%s'), ('%s'), ('%s'), ('%s'), ('%s'), ('%s')",
                TABLE, ADVICE,
                "Empieza con algo sencillo",
                "La organización es clave",
                "No tengas miedo a experimentar",
                "No te obsesiones con la perfección",
                "Escribe para ti",
                "Escribe para ser feliz"
        );
    }

    public static class UserItem implements BaseColumns {
        public static final String TABLE = "users";
        public static final String USER = "user";
        public static final String USERNAME = "username";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";

        public static final String[] ALLCOLUMNS = { BaseColumns._ID, USER, USERNAME, EMAIL, PASSWORD };
        public static final String[] SEARCHCOLUMNS = { USER, PASSWORD };

        public static final String DEFAULT_SORT = USER;

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL) ",
                TABLE, BaseColumns._ID,
                USER,
                USERNAME,
                EMAIL,
                PASSWORD);

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String SQL_INSERT_TOTABLE = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s'), ('%s', '%s', '%s', '%s')",
                TABLE,
                USER, USERNAME, EMAIL, PASSWORD,
                "Beelzenef", "Elena G", "elena.guzbla@gmail.com", "elenagb",
                "moronlu", "Lourdes", "moronlu@gmail.com", "moronlu");
    }

    public static class BookItem implements BaseColumns {
        public static final String TABLE = "book";
        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String GENRE = "genre";
        public static final String NWORDS = "nwords";
        public static final String USER = "user";

        public static final String[] ALL_COLUMNS = {
                BaseColumns._ID, TITLE, DESCRIPTION, GENRE, NWORDS, USER
        };

        public static final String DEFAULT_SORT = TITLE;

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT NOT NULL," +
                "%s TEXT NOT NULL," +
                "%s TEXT," +
                "%s INTEGER, " +
                "%s INTEGER)",
                TABLE,
                BaseColumns._ID,
                TITLE,
                DESCRIPTION,
                GENRE,
                NWORDS,
                USER);

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String SQL_INSERT_TOTABLE = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s')",
                TABLE,
                TITLE, DESCRIPTION, GENRE, NWORDS, USER,
                "Ocaso", "Una historia de muerte y estrellas", "Space Opera", "20000", "1");
    }

    public static class CharacterItem implements BaseColumns {

        public static final String TABLE = "character";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String HOME = "home";
        public static final String FACTION = "faction";
        public static final String BOOKID = "book";

        public static final String[] ALL_COLUMNS = {
                BaseColumns._ID, NAME, DESCRIPTION, HOME, FACTION, BOOKID
        };

        public static final String DEFAULT_SORT = NAME;

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT NOT NULL," +
                "%s TEXT NOT NULL," +
                "%s INTEGER, " +
                "%s INTEGER, " +
                "%s INTEGER NOT NULL, " +
                " FOREIGN KEY (%s) REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT)",
                TABLE,
                BaseColumns._ID,
                NAME,
                DESCRIPTION,
                HOME,
                FACTION,
                BOOKID,
                BOOKID, BookItem.TABLE, BookItem._ID);

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String SQL_INSERT_TOTABLE = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s')",
                TABLE,
                NAME, DESCRIPTION, HOME, FACTION, BOOKID,
                "Personaje 1", "Descripcion", "1", "1", "1");
    }

    public static class FactionItem implements BaseColumns {

        public static final String TABLE = "factions";
        public static final String NAME = "name";
        public static final String OBJECTIVE = "objective";
        public static final String BOOKID = "bookid";

        public static final String[] ALLCOLUMNS = { BaseColumns._ID, NAME, OBJECTIVE, BOOKID };

        public static final String[] SEARCHCOLUMN = { NAME };
        public static final String DEFAULT_SORT = NAME;

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        " FOREIGN KEY (%s) REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT)",
                TABLE, BaseColumns._ID,
                NAME,
                OBJECTIVE,
                BOOKID,
                BOOKID, BookItem.TABLE, BookItem._ID);

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String SQL_INSERT_TOTABLE = String.format("INSERT INTO %s (%s, %s, %s) VALUES ('%s', '%s', '%s')",
                TABLE,
                NAME, OBJECTIVE, BOOKID,
                "Faccion 1", "Una faccion cualquiera", "1");
    }

    public static class ChapterItem implements BaseColumns {

        public static final String TABLE = "chapter";
        public static final String NAME = "name";
        public static final String PROGRESS = "progress";
        public static final String BOOKID = "bookid";

        public static final String[] ALLCOLUMNS = { BaseColumns._ID, NAME, PROGRESS, BOOKID};

        public static final String[] SEARCHCOLUMN = { NAME };
        public static final String DEFAULT_SORT = NAME;

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        " FOREIGN KEY (%s) REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT)",
                TABLE, BaseColumns._ID,
                NAME,
                PROGRESS,
                BOOKID,
                BOOKID, BookItem.TABLE, BookItem._ID);

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);



    }

    public static class LocationItem implements BaseColumns {

        public static final String TABLE = "locations";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String BOOKID = "bookid";

        public static final String[] ALLCOLUMNS = { BaseColumns._ID, NAME, DESCRIPTION, BOOKID };

        public static final String[] SEARCHCOLUMN = { NAME };
        public static final String DEFAULT_SORT = NAME;

        public static final String SQL_CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        " FOREIGN KEY (%s) REFERENCES %s (%s) ON UPDATE CASCADE ON DELETE RESTRICT)",
                TABLE, BaseColumns._ID,
                NAME,
                DESCRIPTION,
                BOOKID,
                BOOKID, BookItem.TABLE, BookItem._ID);

        public static final String SQL_INSERT_TOTABLE = String.format("INSERT INTO %s (%s, %s, %s) VALUES ('%s', '%s', '%s')",
                TABLE,
                NAME, DESCRIPTION, BOOKID,
                "Lugar 1", "Un lugar cualquiera", "1");

        public static final String SQL_DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE);
    }
}
