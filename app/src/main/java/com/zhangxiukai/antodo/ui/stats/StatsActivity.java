package com.zhangxiukai.antodo.ui.stats;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.zhangxiukai.antodo.R;
import com.zhangxiukai.antodo.databinding.ActivityStatsBinding;

import java.util.ArrayList;
import java.util.List;

public class StatsActivity extends AppCompatActivity {
    private ActivityStatsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStatsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("10d", 10));
        data.add(new ValueDataEntry("9d", 11));
        data.add(new ValueDataEntry("8d", 12));
        data.add(new ValueDataEntry("7d", 13));
        data.add(new ValueDataEntry("6d", 14));
        data.add(new ValueDataEntry("5d", 14));
        data.add(new ValueDataEntry("4d", 13));
        data.add(new ValueDataEntry("3d", 12));
        data.add(new ValueDataEntry("2d", 11));
        data.add(new ValueDataEntry("Today", 20));

        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Finished Todo History In Last 10 Days");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Day");
        cartesian.yAxis(0).title("Todo Count");

        anyChartView.setChart(cartesian);

    }
}
