package gabriellee.project.buisnessbooks.requests;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import gabriellee.project.buisnessbooks.model.Book;

public class BookResponse {

    @SerializedName("books")
    @Expose()
    private List<Book> books;

    @Nullable
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "books=" + books +
                '}';
    }
}
