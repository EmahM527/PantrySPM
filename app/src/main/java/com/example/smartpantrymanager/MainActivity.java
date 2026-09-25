package com.example.smartpantrymanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import adapter.IngredientAdapter;
import database.DatabaseHelper;
import model.Ingredient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnAddIngredient;
    Button btnRecipes;
    Button btnSettings;
    TextView txtEmpty;

    DatabaseHelper databaseHelper;

    ArrayList<Ingredient> ingredientList;

    IngredientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewIngredients);
        btnAddIngredient = findViewById(R.id.btnAddIngredient);
        btnRecipes = findViewById(R.id.btnRecipes);
        btnSettings = findViewById(R.id.btnSettings);
        txtEmpty = findViewById(R.id.txtEmpty);

        databaseHelper = new DatabaseHelper(this);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        btnAddIngredient.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    AddEditIngredientActivity.class
            );

            startActivity(intent);
        });

        btnRecipes.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    SuggestedRecipesActivity.class
            );

            startActivity(intent);
        });

        btnSettings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    SettingsActivity.class
            );

            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadIngredients();
    }

    private void loadIngredients() {

        ingredientList = databaseHelper.getAllIngredients();

        adapter = new IngredientAdapter(
                this,
                ingredientList
        );

        recyclerView.setAdapter(adapter);

        if (ingredientList.isEmpty()) {

            txtEmpty.setVisibility(TextView.VISIBLE);

        } else {

            txtEmpty.setVisibility(TextView.GONE);
        }
    }
}