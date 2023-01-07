package id.ac.e020320033.task3_53_materialme_resource;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Sport> mSportsData;
    private SportsAdapter mAdapter;
    private static final String BUNDLE_KEY = "Sports_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Yumna - Task3 MaterialMe-Re");
        setContentView(R.layout.activity_main);


        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(
                this, gridColumnCount));


        mSportsData = new ArrayList<>();

        mAdapter = new SportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);
//        if (savedInstanceState != null) {
//            mSportsData.clear();
//            mSportsData = savedInstanceState.getParcelableArrayList(BUNDLE_KEY);
//        }
//        else{
        initializeData();

        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        ItemTouchHelper helper = new ItemTouchHelper(new
         ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT |
                 ItemTouchHelper.RIGHT |
                 ItemTouchHelper.DOWN | ItemTouchHelper.UP,
                 swipeDirs) {
             //     }
             @Override
             public boolean onMove(@NonNull RecyclerView recyclerView,
                                   @NonNull RecyclerView.ViewHolder viewHolder,
                                   @NonNull RecyclerView.ViewHolder target) {
                 int from = viewHolder.getAdapterPosition();
                 int to = target.getAdapterPosition();
                 Collections.swap(mSportsData, from, to);
                 mAdapter.notifyItemMoved(from, to);
                 return true;
             }

             @Override
             public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                 mSportsData.remove(viewHolder.getAdapterPosition());
                 mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
             }

         });
        helper.attachToRecyclerView(mRecyclerView);
    }
    /**
     * Initialize the sports data from resources.
     */
    @SuppressLint("NotifyDataSetChanged")
    private void initializeData() {
        String[] sportsList = getResources()
                .getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources()
                .getStringArray(R.array.sports_info);
        String[] sportsDetails = getResources().getStringArray(R.array.sports_details);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);

        // Clear the existing data (to avoid duplication).
        mSportsData.clear();


        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for (int i = 0; i < sportsList.length; i++) {
            mSportsData.add(new Sport(sportsList[i], sportsInfo[i],
                    sportsImageResources.getResourceId(i, 0), sportsDetails[i]));
        }
        sportsImageResources.recycle();
        mAdapter.notifyDataSetChanged();
    }

    public void resetSports(View view) {
        initializeData();
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putParcelableArrayList(BUNDLE_KEY, mSportsData);
//    }


}