package zhenyuyang.ucsb.edu.landassessmentfee;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = (Button)findViewById(R.id.button);
        final EditText editText_propertyValue = (EditText)findViewById(R.id.editText_propertyValue);
        final TextView textView_fee = (TextView)findViewById(R.id.textView_fee);
        context = getApplicationContext();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String editText_propertyValue_str = editText_propertyValue.getText().toString();
                    if (!editText_propertyValue_str.isEmpty()) {
                        double propertyValue = Double.parseDouble(editText_propertyValue_str);
                        double result = ZongDiDiJia(propertyValue);
                        textView_fee.setText(String.format("%.5f", result));
                    }
                }
                catch (Exception e){
                    Toast.makeText(context,"输入错误!",Toast.LENGTH_SHORT).show();
                }
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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

    double ZongDiDiJia(double input){
        double output = 0;

//        if(input<=100){
//            output+=0.004*input;
//            if(input-100>0) {
//                input-=100;
//                output+=0.003*input;
//                if(input-100>0) {
//            }
//        }

        if(input<=100){
            output+=0.004*input;
        }
        else if(input>=100&&input<=200){
            output+=0.004*(100);
            input-=100;

            output+=0.003*(input);
        }
        else if(input>=200&&input<=1000){
            output+=0.004*(100);
            input-=100;

            output+=0.003*(100);
            input-=100;

            output+=0.002*(input);
        }
        else if(input>=1000&&input<=2000){
            output+=0.004*(100);
            input-=100;

            output+=0.003*(100);
            input-=100;

            output+=0.002*(800);
            input-=800;

            output+=0.0015*(input);
        }
        else if(input>=2000&&input<=5000){
            output+=0.004*(100);
            input-=100;

            output+=0.003*(100);
            input-=100;

            output+=0.002*(800);
            input-=800;

            output+=0.0015*(1000);
            input-=1000;

            output+=0.0008*(input);
        }
        else if(input>=5000&&input<=10000){
            output+=0.004*(100);
            input-=100;

            output+=0.003*(100);
            input-=100;

            output+=0.002*(800);
            input-=800;

            output+=0.0015*(1000);
            input-=1000;

            output+=0.0008*(3000);
            input-=3000;

            output+=0.0004*(input);
        }
        else if(input>10000){
            output+=0.004*(100);
            input-=100;

            output+=0.003*(100);
            input-=100;

            output+=0.002*(800);
            input-=800;

            output+=0.0015*(1000);
            input-=1000;

            output+=0.0008*(3000);
            input-=3000;

            output+=0.0004*(5000);
            input-=5000;

            output+=0.0001*(input);
        }


    return output;

    }
}
