package org.esiea.sqalli_hiezely.ms_app;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

   public DatePickerDialog dpd;


   public void First_button(View v){
        Toast.makeText(getApplicationContext(),getString(R.string.msg),Toast.LENGTH_LONG).show();

    }
        public static final String BIERS_UPDATE = "com.octip.cours.inf4042_11.BIERS_UPDATE";

    public class BierUpdate extends BroadcastReceiver{
        @Override

        public void onReceive(Context context, Intent intent){
            Log.d("Tag",getIntent().getAction());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            TextView tv_hw = (TextView)findViewById(R.id.tv_hello_world);

                String h =getString(R.string.hello_world);
                String now = DateUtils.formatDateTime(getApplicationContext(),(new Date()).getTime(), DateFormat.FULL);
        DatePickerDialog.OnDateSetListener l = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        TextView tv_hw = (TextView)findViewById(R.id.tv_hello_world);
                        int Z = 1;
                        tv_hw.setText(getString(R.string.hello_world) + year +" / " + (monthOfYear+1)+ " / " + dayOfMonth);
                    }
                };
            //    dpd = new DatePickerDialog(this, l , int year, int month, int dayOfMonth);
        DatePickerDialog dpd = new DatePickerDialog(this,l,2016,11,07);
        dpd.show();

                        //DatePickerDialog.OnDateSeftListener listener, int year, int month, int dayOfMonth)


        notif();

        GetBiersServices.startActionget_all_biers(this, "","");
        IntentFilter intentFilter = new IntentFilter(BIERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(),intentFilter);















        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_biere);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));















    }


    public void Second_button(View v){

        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void Third_button(View v){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.fr"));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void notif(){
      NotificationCompat.Builder mBuilder =
              new NotificationCompat.Builder(this)
                      .setSmallIcon(R.drawable.notification_icon)
                      .setContentTitle("My notification")
                      .setContentText("Hello World!");

      NotificationManager mNotificationManager =
              (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
      mNotificationManager.notify(1, mBuilder.build());
  }


    private class BiersAdapter extends RecyclerView.Adapter<BierHolder>{


        @Override
        public BierHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(BierHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

}


