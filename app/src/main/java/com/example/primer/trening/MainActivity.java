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
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton contest;
    ImageButton update;
    ButtonPress bp = new ButtonPress();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contest = (ImageButton) findViewById(R.id.contest_button);
        update = (ImageButton) findViewById(R.id.update_button);

        PieChart pieChart = (PieChart) findViewById(R.id.chart_daily);
        PieChart pieChart2 = (PieChart) findViewById(R.id.chart_active);
        // creating data values
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4000f, 0));
        entries.add(new Entry(6000f, 1));

        PieDataSet dataset = new PieDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Done");
        labels.add("Remaining");

        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        pieChart.setDescription("");
        pieChart.setData(data);
        Legend legend = pieChart.getLegend();
        legend.setEnabled(false);

        pieChart.animateY(3000);

        pieChart2.setDescription("");
        pieChart2.setData(data);
        Legend legend2 = pieChart2.getLegend();
        legend2.setEnabled(false);

        pieChart2.animateY(3000);
    }

    public void toContest(View view) {
        bp.Press(contest);

        Intent intent = new Intent(this, ContestActivity.class);

        startActivity(intent);
    }

    public void update(View view){
        bp.Press(update);
        System.out.println("doing stuff");
    }
}
