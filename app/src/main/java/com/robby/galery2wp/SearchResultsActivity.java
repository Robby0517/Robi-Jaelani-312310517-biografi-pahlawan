package com.robby.galery2wp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewResults;
    private TextView noResultsText;
    private SearchResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Initialize UI components
        recyclerViewResults = findViewById(R.id.recycler_view_results);
        noResultsText = findViewById(R.id.no_results_text);

        // Set up RecyclerView
        recyclerViewResults.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SearchResultsAdapter(new ArrayList<>());
        recyclerViewResults.setAdapter(adapter);

        // Load search results
        List<String> searchResults = getSearchResults();

        if (searchResults.isEmpty()) {
            noResultsText.setVisibility(View.VISIBLE);
            recyclerViewResults.setVisibility(View.GONE);
        } else {
            noResultsText.setVisibility(View.GONE);
            recyclerViewResults.setVisibility(View.VISIBLE);
            adapter.updateData(searchResults);
        }
    }

    private List<String> getSearchResults() {
        // Simulate search results (replace with actual search logic)
        List<String> results = new ArrayList<>();
        results.add("Result 1");
        results.add("Result 2");
        results.add("Result 3");
        return results;
    }
}
