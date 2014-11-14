package com.witmergers.basictodoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    public List<String> list ;
   public  ArrayAdapter<String> arrayAdapter;
    public ListView listView;

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            list = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            list = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readItems();
        // Lets Go
       list  = new ArrayList<String>();
       listView = (ListView)findViewById(R.id.listView1);
       arrayAdapter = new ArrayAdapter<String>(
               this,
               android.R.layout.simple_list_item_1,
               list);

        listView.setAdapter(arrayAdapter);

        list.add("Call Ma at 3:00");
        list.add("Bakery shop");

        lognClickEvent();

            }

    private void lognClickEvent() {

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                list.remove(i);
                //list.notifyAll();
                writeItems();
            arrayAdapter.notifyDataSetChanged();

                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAddNnoteClick(View view) {
        EditText editText = (EditText)findViewById(R.id.editText);
        NoteClass n = new NoteClass();
        //n.setDate();

        list.add(editText.getText().toString());
        editText.setText("");
        writeItems();


    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.editText);
        String itemText = etNewItem.getText().toString();
        arrayAdapter.add(itemText);
        etNewItem.setText("");
        arrayAdapter.notifyDataSetChanged();
        writeItems(); // <---- Add this line
    }
}
