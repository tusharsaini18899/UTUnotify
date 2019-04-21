package students.afor.app.android.notify.utu.utunotify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class Branch extends AppCompatActivity {

    TextInputLayout course,branch,name,email;
    Button submit,skip;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.branch);

        final TextInputLayout course=(TextInputLayout)findViewById(R.id.course);
        final TextInputLayout branch=(TextInputLayout)findViewById(R.id.branch);

        final TextInputLayout name=(TextInputLayout)findViewById(R.id.name);
        final TextInputLayout email=(TextInputLayout)findViewById(R.id.branch);

        Button skip=(Button)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(Branch.this,MainActivity.class);
                startActivity(ii);
            }
        });


        Button submit=(Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String course1=course.getEditText().getText().toString();
              String branch1=branch.getEditText().getText().toString();

                String name1=name.getEditText().getText().toString();
                String email1=email.getEditText().getText().toString();

              if (course1.equals("") || name1.equals("") || email.equals(" "))
              {
                  Toast.makeText(Branch.this, "Please !Enter your Details", Toast.LENGTH_SHORT).show();
              }
              else if ((course1.equals("btech") || course1.equals("B.TECH") || course1.equals("BTECH") || course1.equals("B.tech") || course1.equals("Btech") || course1.equals("B.Tech")) && branch1.equals(""))
              {
                  Toast.makeText(Branch.this, "Please !Enter your Btech branch", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Intent intent=new Intent(Branch.this,MainActivity.class);
                  startActivity(intent);
                  Toast.makeText(Branch.this,"Hello "+name1,Toast.LENGTH_SHORT).show();
              }
            }
        });



        }
}

