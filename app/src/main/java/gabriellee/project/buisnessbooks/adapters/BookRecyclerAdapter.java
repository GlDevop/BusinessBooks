package gabriellee.project.buisnessbooks.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import gabriellee.project.buisnessbooks.R;
import gabriellee.project.buisnessbooks.model.Book;

public class BookRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Book> mBooks;

    public BookRecyclerAdapter() {
        mBooks = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_book_list_item, viewGroup, false);
        return new BookViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        Glide.with(viewHolder.itemView.getContext()).setDefaultRequestOptions(requestOptions)
                .load(mBooks.get(i).getBook_image())
                .into(((BookViewHolder)viewHolder).image);

        ((BookViewHolder)viewHolder).title.setText(mBooks.get(i).getTitle());
        ((BookViewHolder)viewHolder).rank.setText(String.valueOf(mBooks.get(i).getRank()));
        ((BookViewHolder)viewHolder).publisher.setText("Publisher: " + mBooks.get(i).getPublisher());
        ((BookViewHolder)viewHolder).author.setText("Author: " + mBooks.get(i).getAuthor());

    }

    @Override
    public int getItemCount() {
        if(mBooks != null) {
            return mBooks.size();
        }
        return 0;
    }

    public void setBooks(List<Book> books) {
        mBooks = books;
        notifyDataSetChanged();
    }
}
