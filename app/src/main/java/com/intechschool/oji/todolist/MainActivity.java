package com.intechschool.oji.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.activeandroid.query.Select;

import java.util.List;

public class MainActivity extends Activity {

    ToDoDB mToDoDB;
    EditText mTodo;
    Button createDo;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.listView);
        createDo = (Button)findViewById(R.id.create_do);
        mTodo = (EditText)findViewById(R.id.createToDo);
        mToDoDB = new ToDoDB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();

        setToDoList();
    }

    public void createDo(View v) {
        saveToDo();
    }

    void saveToDo() {
        mToDoDB.todo=mTodo.getText().toString();
        mToDoDB.save();
    }

    void setToDoList() {
        List<ToDoDB> todoList = new Select().from(ToDoDB.class).execute();
        ArrayAdapter<ToDoDB> adapter = new ArrayAdapter<> (getApplicationContext(), R.layout.todo_row, todoList);
        mListView.setAdapter(adapter);
    }
}
