package gabriellee.project.buisnessbooks;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import gabriellee.project.buisnessbooks.adapters.BookRecyclerAdapter;
import gabriellee.project.buisnessbooks.util.BaseActivity;
import gabriellee.project.buisnessbooks.util.VerticalSpacingItemDecorator;
import gabriellee.project.buisnessbooks.viewmodels.BookListViewModel;

public class BookListActivity extends BaseActivity {

    private static final String TAG = "BookListActivity";

    private BookListViewModel mBookListViewModel;
    private RecyclerView mRecyclerView;
    private BookRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        mRecyclerView = findViewById(R.id.book_list);

        mBookListViewModel = ViewModelProviders.of(this).get(BookListViewModel.class);

        initRecyclerView();

    }

    private void initRecyclerView() {
        mAdapter = new BookRecyclerAdapter();
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(30);
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
