package com.example.henry.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {
    private ArrayList<String> todolist;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        ListView list = (ListView)findViewById(R.id.to_do_list);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                todolist.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        todolist = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                todolist
        );
        list.setAdapter(adapter);
    }


    public void addTask(View view) {
        EditText taskField = (EditText) findViewById(R.id.task);
        String newTask = taskField.getText().toString();
        taskField.setText("");

        todolist.add(newTask);
        adapter.notifyDataSetChanged();
    }
}
