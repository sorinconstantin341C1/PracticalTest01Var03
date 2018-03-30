package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecActivity extends AppCompatActivity {

    private TextView nameTextView = null;
    private TextView groupTextView = null;
    private Button okButton = null;
    private Button cancelButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.ok_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_t_secondary);

        nameTextView = (TextView)findViewById(R.id.name_text_view);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("name")) {
            String name = intent.getStringExtra("name");
            String group = intent.getStringExtra("group");
            nameTextView.setText(String.valueOf(name));
            groupTextView.setText(String.valueOf(group));
        }

        okButton = (Button)findViewById(R.id.ok_button);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}
