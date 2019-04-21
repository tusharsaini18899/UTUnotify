package students.afor.app.android.notify.utu.utunotify;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;

    Button ac,downloads,locateus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ac=(Button)findViewById(R.id.ac);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://uktech.ac.in/wp-content/uploads/2017/07/Acedamic-Calender-2017-18-Autumn-Semester.pdf"));
                startActivity(intent);
            }
        });
        Button downloads=(Button)findViewById(R.id.Downloads);
        downloads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Intent.ACTION_VIEW,Uri.parse("http://uktech.ac.in/downloads/"));
                startActivity(i1);
            }
        });

        Button locateus=(Button)findViewById(R.id.locateus);
        locateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Intent.ACTION_VIEW,Uri.parse("http://uktech.ac.in/contact/"));
                startActivity(i2);
            }
        });

        int images[]={R.drawable.slider0,R.drawable.slider1,R.drawable.slider2,R.drawable.slider3};
        v_flipper=(ViewFlipper)findViewById(R.id.v_fliper);


        for (int image: images)
        {
            fliperImage(image);
        }

    }
    public void fliperImage(int image)
    {
        ImageView imageView=new ImageView(MainActivity.this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(MainActivity.this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(MainActivity.this,android.R.anim.slide_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.home:
                Intent intent=new Intent(MainActivity.this,UTUweb.class);
                startActivity(intent);
                break;

            case R.id.exit:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                builder.setTitle("Alert !");
                builder.setMessage("Do You want to Exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Intent.ACTION_MAIN);
                        i.addCategory(Intent.CATEGORY_HOME);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
