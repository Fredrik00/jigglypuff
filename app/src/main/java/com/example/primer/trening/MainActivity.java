package com.example.primer.trening;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton contest;
    ImageButton update;
    ButtonPress bp = new ButtonPress();
    ArrayList<Integer> colors = new ArrayList<>();
    PieChart dailyPie;
    PieChart activePie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors.add(getResources().getColor(R.color.colorPrimary));
        colors.add(getResources().getColor(R.color.lightGray));

        contest = (ImageButton) findViewById(R.id.contest_button);
        update = (ImageButton) findViewById(R.id.update_button);

        dailyPie = (PieChart) findViewById(R.id.chart_daily);
        activePie = (PieChart) findViewById(R.id.chart_active);

        drawCharts();
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

    public void drawCharts(){
        dailyPie.invalidate();
        activePie.invalidate();

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4000f, 0));
        entries.add(new Entry(6000f, 1));

        PieDataSet dataset = new PieDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Done");
        labels.add("Remaining");

        PieData data = new PieData(labels, dataset);
        dataset.setColors(colors);

        dailyPie.setDescription("");
        dailyPie.setData(data);
        dailyPie.setHoleRadius(10);
        Legend legend = dailyPie.getLegend();
        legend.setEnabled(false);

        dailyPie.animateY(3000);

        activePie.setDescription("");
        activePie.setData(data);
        activePie.setHoleRadius(10);
        Legend legend2 = activePie.getLegend();
        legend2.setEnabled(false);

        activePie.animateY(3000);
    }
}
