package gabriellee.project.buisnessbooks.requests;

import android.arch.lifecycle.LiveData;

import gabriellee.project.buisnessbooks.requests.responses.ApiResponse;
import gabriellee.project.buisnessbooks.requests.responses.BookResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookApi {

    // GET BOOK REQUEST
    @GET("svc/books/v3/lists/current/business-books.json")
    LiveData<ApiResponse<BookResponse>> getBook(@Query("api-key") String key);

}
