package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private EditText nameText = null;
    private EditText groupText = null;
    private EditText displayText = null;
    private Button navigateButton = null;
    private Button displayButton = null;
    private CheckBox nameCheck = null;
    private CheckBox groupCheck = null;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.display_button:
                    String studentName =null;
                    String studentGroup =null;
                    if (nameCheck.isChecked()) {
                        studentName = nameText.getText().toString();
                    }
                    if (groupCheck.isChecked()) {
                        studentGroup = groupText.getText().toString();
                    }
                    displayText.setText(studentName + " " + studentGroup);
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecActivity.class);
                    String name = nameText.getText().toString();
                    String group = groupText.getText().toString();
                    intent.putExtra("name", name);
                    intent.putExtra("group", group);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        nameText = (EditText)findViewById(R.id.name_edit_text);
        groupText = (EditText)findViewById(R.id.group_edit_text);

        navigateButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        displayButton = (Button)findViewById(R.id.display_button);

        displayText = (EditText)findViewById(R.id.display_edit_text);

        nameCheck = (CheckBox)findViewById(R.id.name_check_box);
        groupCheck = (CheckBox)findViewById(R.id.group_check_box);

        displayButton.setOnClickListener(buttonClickListener);

        navigateButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("name")) {
                nameText.setText(savedInstanceState.getString("name"));
            } else {
                nameText.setText("");
            }
            if (savedInstanceState.containsKey("group")) {
                groupText.setText(savedInstanceState.getString("group"));
            } else {
                groupText.setText("");
            }
            if (savedInstanceState.containsKey("display")) {
                displayText.setText(savedInstanceState.getString("display"));
            } else {
                displayText.setText("");
            }
        } else {
            nameText.setText("");
            groupText.setText("");
            displayText.setText("");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("name", nameText.getText().toString());
        savedInstanceState.putString("group", groupText.getText().toString());
        savedInstanceState.putString("display", displayText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("name")) {
            nameText.setText(savedInstanceState.getString("name"));
        } else {
            nameText.setText("");
        }
        if (savedInstanceState.containsKey("group")) {
            groupText.setText(savedInstanceState.getString("group"));
        } else {
            groupText.setText("");
        }
        if (savedInstanceState.containsKey("display")) {
            displayText.setText(savedInstanceState.getString("display"));
        } else {
            displayText.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var03_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
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
}
