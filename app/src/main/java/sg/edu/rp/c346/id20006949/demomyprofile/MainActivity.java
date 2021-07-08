package sg.edu.rp.c346.id20006949.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name;
    TextView gpa;
    EditText editname;
    EditText editgpa;

    @Override
    protected void onPause() {
        super.onPause();
        String strName = editname.getText().toString();
        float gpa1= Float.parseFloat(editgpa.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name" , strName);
        prefEdit.putFloat("gpa" , gpa1);
        prefEdit.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name", "John");
        float gpa1 = prefs.getFloat("gpa", 4 );
        editname.setText(strName);
        editgpa.setText(gpa1 + "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname = findViewById(R.id.editname);
        editgpa = findViewById(R.id.editgpa);
        name = findViewById(R.id.name);
        gpa = findViewById(R.id.gpa);

    }
}