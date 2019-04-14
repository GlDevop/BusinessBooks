package gabriellee.project.buisnessbooks.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import gabriellee.project.buisnessbooks.model.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "book_db";

    private static BookDatabase instance;

    public static BookDatabase getInstance(final Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    BookDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return instance;
    }

    public abstract BookDao getBookDao();
}
