package gabriellee.project.buisnessbooks.util;

import android.util.Log;
import java.util.List;
import gabriellee.project.buisnessbooks.model.Book;

public class Testing {

    public static void printBooks(List<Book>list, String tag){
        for(Book book: list){
            Log.d(tag, "onChanged: " + book.getTitle());
            Log.d(tag, "onChanged" + book.getRank());
        }
    }
}
