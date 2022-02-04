package com.localbuses.transportation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<TransactionsList> transactions_myLists;
    RecyclerView transactions_rv;
    TransactionsAdapter transactions_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        transactions_rv = (RecyclerView) findViewById(R.id.transactions_rec);
        transactions_rv.setHasFixedSize(true);
        transactions_rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        transactions_myLists = new ArrayList<>();

        transactions_myLists.add(new TransactionsList(null, null));


        transactions_adapter = new TransactionsAdapter(transactions_myLists, MainActivity.this);
        transactions_rv.setAdapter(transactions_adapter);
        transactions_adapter.notifyDataSetChanged();


    }
}