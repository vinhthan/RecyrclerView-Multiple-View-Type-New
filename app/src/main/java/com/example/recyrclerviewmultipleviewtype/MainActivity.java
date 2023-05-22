package com.example.recyrclerviewmultipleviewtype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcy;
    UserAdapter mUserAdapter;
    List<User> mList;
    GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcy = findViewById(R.id.rcy);
        mUserAdapter = new UserAdapter();
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mUserAdapter.getItemViewType(position) != UserAdapter.TYPE_RECTANGLE) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });
        rcy.setLayoutManager(layoutManager);

        mUserAdapter.setData(getListUser());
        rcy.setAdapter(mUserAdapter);

    }

    private List<User> getListUser() {
        mList = new ArrayList<>();
        mList.add(new User(R.drawable.a, "a", true));
        mList.add(new User(R.drawable.b, "b", false));
        mList.add(new User(R.drawable.c, "c", true));
        mList.add(new User(R.drawable.a, "a", false));
        mList.add(new User(R.drawable.b, "b", true));

        mList.add(new User(R.drawable.a, "a", false));
        mList.add(new User(R.drawable.b, "b", false));
        mList.add(new User(R.drawable.c, "c", true));
        mList.add(new User(R.drawable.a, "a", false));
        mList.add(new User(R.drawable.b, "b", false));

        mList.add(new User(R.drawable.a, "a", false));
        mList.add(new User(R.drawable.b, "b", false));
        mList.add(new User(R.drawable.c, "c", false));
        mList.add(new User(R.drawable.a, "a", false));
        mList.add(new User(R.drawable.b, "b", false));

        return mList;
    }
}