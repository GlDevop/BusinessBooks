package gabriellee.project.buisnessbooks.requests;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookApi {

    // GET BOOK REQUEST
    @GET("lists/current/business-books.json")
    Call<BookResponse> getBook(@Query("api-key") String key);

}
