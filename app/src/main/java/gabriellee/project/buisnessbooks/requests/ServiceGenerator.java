package gabriellee.project.buisnessbooks.requests;

import gabriellee.project.buisnessbooks.util.Constants;
import gabriellee.project.buisnessbooks.util.LiveDataCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static BookApi bookApi = retrofit.create(BookApi.class);

    public static BookApi getBookApi(){
        return bookApi;
    }
}
