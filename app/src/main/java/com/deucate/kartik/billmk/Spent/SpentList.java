package com.deucate.kartik.billmk.Spent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.deucate.kartik.billmk.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SpentList extends AppCompatActivity {

    private ListView mListView;

    private List<SpentGs> mSpentGses;
    private SpentGs mSpentGs;
    private SpentAdapter mAdapter;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spent_list);

        mDatabase = FirebaseDatabase.getInstance();
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mReference = mDatabase.getReference().child("Spent").child(uid);

        mSpentGses = new ArrayList<>();
        mSpentGs = new SpentGs();

        mListView = (ListView) findViewById(R.id.spentListView);

        mAdapter = new SpentAdapter(this,R.layout.spent_list,mSpentGses);
        mListView.setAdapter(mAdapter);

        mReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                mSpentGs = dataSnapshot.getValue(SpentGs.class);
                mAdapter.add(mSpentGs);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
