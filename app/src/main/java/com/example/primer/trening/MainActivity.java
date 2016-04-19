package com.example.primer.trening;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ImageButton contest;
    ImageButton update;
    ImageButton quit;
    SlidingDrawer drawer;
    ButtonPress bp = new ButtonPress();
    ArrayList<Integer> colors = new ArrayList<>();
    PieChart dailyPie;
    PieChart activePie;
    Handler handler;
    TextView timeLeft;
    TextView timeSpent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors.add(getResources().getColor(R.color.colorPrimary));
        colors.add(getResources().getColor(R.color.lightGray));

        contest = (ImageButton) findViewById(R.id.contest_button);
        update = (ImageButton) findViewById(R.id.update_button);
        quit = (ImageButton) findViewById(R.id.quit_button);

        drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);

        dailyPie = (PieChart) findViewById(R.id.chart_daily);
        activePie = (PieChart) findViewById(R.id.chart_active);

        drawCharts();

        timeLeft = (TextView) findViewById(R.id.time_left);
        timeSpent = (TextView) findViewById(R.id.time_spent);
        calculateTime();

        handler=new Handler();

        final Runnable updateTask=new Runnable() {
            @Override
            public void run() {
                calculateTime();
                handler.postDelayed(this,1000);
            }
        };

        handler.postDelayed(updateTask, 1000);
    }

    public void toContest(View view) {
        bp.Press(contest);

        Intent intent = new Intent(this, ContestActivity.class);

        startActivity(intent);
    }

    public void update(View view){
        bp.Press(update);
        drawCharts();
    }

    public void quit(View view){
        bp.Press(quit);
        drawer.animateClose();
    }

    public void drawCharts(){
        dailyPie.invalidate();
        activePie.invalidate();

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4000, 0));
        entries.add(new Entry(6000, 1));

        PieDataSet dataset = new PieDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Done");
        labels.add("Remaining");

        PieData data = new PieData(labels, dataset);
        dataset.setColors(colors);

        dailyPie.setDescription("");
        dailyPie.setData(data);
        dailyPie.setHoleRadius(30);
        dailyPie.setCenterText("Daily");
        Legend legend = dailyPie.getLegend();
        legend.setEnabled(false);

        dailyPie.animateY(3000);

        activePie.setDescription("");
        activePie.setData(data);
        activePie.setHoleRadius(30);
        activePie.setCenterText("Contest");
        Legend legend2 = activePie.getLegend();
        legend2.setEnabled(false);

        activePie.animateY(3000);
    }

    public void calculateTime() {
        // TODO Auto-generated method stub
        int dl = 0, hl = 0, ml = 0, sl = 0;
        int ds = 0, hs = 0, ms = 0, ss = 0;
        try
        {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-02-01 00:00:00");
            Date endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-06-01 00:00:00");
            Date currentDate = new Date();
            Long timeDiff1 = endDate.getTime() - currentDate.getTime();
            Long timeDiff2 = currentDate.getTime() - startDate.getTime();

            dl = (int) TimeUnit.MILLISECONDS.toDays(timeDiff1);
            hl = (int) (TimeUnit.MILLISECONDS.toHours(timeDiff1) - TimeUnit.DAYS.toHours(dl));
            ml = (int) (TimeUnit.MILLISECONDS.toMinutes(timeDiff1) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff1)));
            sl = (int) (TimeUnit.MILLISECONDS.toSeconds(timeDiff1) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeDiff1)));

            ds = (int) TimeUnit.MILLISECONDS.toDays(timeDiff2);
            hs = (int) (TimeUnit.MILLISECONDS.toHours(timeDiff2) - TimeUnit.DAYS.toHours(ds));
            ms = (int) (TimeUnit.MILLISECONDS.toMinutes(timeDiff2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff2)));
            ss = (int) (TimeUnit.MILLISECONDS.toSeconds(timeDiff2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeDiff2)));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        if(dl==0)
        {
            timeLeft.setText("Time left: " + hl + ":" + ml + ":" + sl);
        }
        else if(hl==0)
        {
            timeLeft.setText("Time left: " + ml + ":" + sl);
        }
        else
        {
            timeLeft.setText("Time left: " + dl + ":" + hl + ":" + ml + ":" + sl);
        }


        if(ds==0)
        {
            timeSpent.setText("Time spent: " + hs + ":" + ms + ":" + ss);
        }
        else if(hs==0)
        {
            timeSpent.setText("Time spent: " + ms + ":" + ss);
        }
        else
        {
            timeSpent.setText("Time spent: " + ds + ":" + hs + ":" + ms + ":" + ss);
        }
    }
}
