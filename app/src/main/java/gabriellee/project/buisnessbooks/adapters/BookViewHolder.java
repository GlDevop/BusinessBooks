package gabriellee.project.buisnessbooks.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import gabriellee.project.buisnessbooks.R;

public class BookViewHolder extends RecyclerView.ViewHolder {

    TextView title, publisher, author, rank;
    AppCompatImageView image;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        publisher = itemView.findViewById(R.id.publisher);
        author = itemView.findViewById(R.id.author);
        rank = itemView.findViewById(R.id.rank);
        image = itemView.findViewById(R.id.image);

    }
}
