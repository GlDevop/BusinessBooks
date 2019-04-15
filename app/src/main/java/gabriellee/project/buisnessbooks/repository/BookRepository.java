package gabriellee.project.buisnessbooks.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import gabriellee.project.buisnessbooks.model.Book;
import gabriellee.project.buisnessbooks.persistence.BookDao;
import gabriellee.project.buisnessbooks.persistence.BookDatabase;
import gabriellee.project.buisnessbooks.requests.responses.ApiResponse;
import gabriellee.project.buisnessbooks.requests.responses.BookResponse;
import gabriellee.project.buisnessbooks.requests.NetworkBoundResource;
import gabriellee.project.buisnessbooks.requests.Resource;
import gabriellee.project.buisnessbooks.requests.ServiceGenerator;
import gabriellee.project.buisnessbooks.requests.responses.resultResponse;
import gabriellee.project.buisnessbooks.util.AppExecutors;

import static gabriellee.project.buisnessbooks.util.Constants.API_KEY;

public class BookRepository {

    private static final String TAG = "BookRepository";
    private static BookRepository instance;
    private BookDao bookDao;

    public static BookRepository getInstance(Context context) {
        if(instance == null) {
            instance = new BookRepository(context);
        }
        return instance;
    }

    private BookRepository(Context context) {
        bookDao = BookDatabase.getInstance(context).getBookDao();
    }

    public LiveData<Resource<List<Book>>> searchBookApi() {
        return new NetworkBoundResource<List<Book>, resultResponse>(AppExecutors.getInstance()) {

            @Override
            protected void saveCallResult(@NonNull resultResponse item) {
                if (item.getResults().getBooks() != null) {

                    Book[] books = new Book[item.getResults().getBooks().size()];

                    int index = 0;
                    for (long rowid: bookDao.insertBooks((Book[]) (item.getResults().getBooks().toArray(books)))){
                        Log.d(TAG, "saveCallResult: " + books[index].getTitle());
                        Log.d(TAG, "saveCallResult: " + books[index].getRank());
                        if(rowid == -1) {
                            Log.d(TAG, "saveCallResult: CONFLICT... This book is already in the cache");
                            // if the book already exists .... dont set timestamp
                            // they will be erased
                            bookDao.updateBook(
                                    books[index].getTitle(),
                                    books[index].getAuthor(),
                                    books[index].getBook_image(),
                                    books[index].getPublisher(),
                                    books[index].getRank()

                            );
                        }
                        index++;
                    }
                }
                else {
                    Log.e(TAG, "saveCallResult: No DATA READ IN");
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Book> data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<List<Book>> loadFromDb() {
                return bookDao.getBooks();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<resultResponse>> createCall() {

                return ServiceGenerator.getBookApi().getBook(API_KEY);

            }
        }.getAsLiveData();
    }
}
