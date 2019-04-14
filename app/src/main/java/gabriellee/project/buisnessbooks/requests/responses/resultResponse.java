package gabriellee.project.buisnessbooks.requests.responses;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import gabriellee.project.buisnessbooks.model.Book;


public class resultResponse {

    @SerializedName("results")
    @Expose()
    private BookResponse bookresponse;


}
