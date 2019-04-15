package gabriellee.project.buisnessbooks.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import gabriellee.project.buisnessbooks.model.Book;
import gabriellee.project.buisnessbooks.repository.BookRepository;
import gabriellee.project.buisnessbooks.requests.Resource;

public class BookListViewModel extends AndroidViewModel {

    private static final String TAG = "BookListViewModel";
    private static final String QUERY_EXHAUSTED = "Query is exhausted";

    private MediatorLiveData<Resource<List<Book>>> books = new MediatorLiveData<>();
    private BookRepository bookRepository;

    //query extras



    public BookListViewModel(@NonNull Application application) {
        super(application);
        bookRepository = BookRepository.getInstance(application);
    }

    public LiveData<Resource<List<Book>>> getBooks() {
        return books;
    }

    public void searchBooksApi() {
        final LiveData<Resource<List<Book>>> repositorySource = bookRepository.searchBookApi();

        books.addSource(repositorySource, new Observer<Resource<List<Book>>>() {
            @Override
            public void onChanged(@Nullable Resource<List<Book>> listResource) {
                if(listResource != null) {
                    books.setValue(listResource);
                    if(listResource.status == Resource.Status.SUCCESS) {
                        if(listResource.data != null) {
                            if(listResource.data.size() == 0) {
                                Log.d(TAG, "onChanged: query is exhausted...");
                                books.setValue(
                                        new Resource<List<Book>>(
                                                Resource.Status.ERROR,
                                                listResource.data,
                                                QUERY_EXHAUSTED
                                        )
                                );

                            }
                        }
                        books.removeSource(repositorySource);
                    }
                }
                else {
                    books.removeSource(repositorySource);
                }
            }
        });
    }

}
