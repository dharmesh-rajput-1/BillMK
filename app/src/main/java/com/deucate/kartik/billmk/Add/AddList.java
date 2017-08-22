package com.deucate.kartik.billmk.Add;

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

public class AddList extends AppCompatActivity {

    ListView mListView;

    List<AddGS> mAddGSes;
    AddGS mAddGS;
    AddAdapter mAdapter;

    FirebaseDatabase mDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        mAddGS = new AddGS();
        mAddGSes = new ArrayList<>();

        mDatabase = FirebaseDatabase.getInstance();
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mReference = mDatabase.getReference().child("Add").child(uid);

        mListView = (ListView) findViewById(R.id.addListView);

        mAdapter = new AddAdapter(this,R.layout.add_list,mAddGSes);
        mListView.setAdapter(mAdapter);

        mReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                mAddGS = dataSnapshot.getValue(AddGS.class);
                mAdapter.add(mAddGS);

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
