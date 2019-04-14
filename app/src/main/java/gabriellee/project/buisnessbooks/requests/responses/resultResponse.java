package gabriellee.project.buisnessbooks.requests.responses;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class resultResponse {

    @SerializedName("results")
    @Expose
    private BookResponse results;

    public BookResponse getResults() {
        return results;
    }

    public void setResults(BookResponse results) {
        this.results = results;
    }
}
