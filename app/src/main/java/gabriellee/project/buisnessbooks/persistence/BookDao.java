package gabriellee.project.buisnessbooks.persistence;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import gabriellee.project.buisnessbooks.model.Book;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface BookDao {

    @Insert(onConflict = IGNORE)
    long[] insertBooks(Book ...books);

    // { id1, id2, id3.. etc }
    // { -1, ID2, -1, }

    @Insert(onConflict = REPLACE)
    void insertRecipe(Book book);

    @Query("UPDATE books SET title = :title, author = :author, book_image = :book_image, publisher = :publisher, rank = :rank" +
            " WHERE rank = :rank")
    void updateBook(String title, String author, String book_image, String publisher, int rank);

    //Select all books from database
    @Query("SELECT * FROM books ORDER BY rank")
    LiveData<List<Book>> getBooks();


}
