/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.mycompany.entites.Evenement;
import com.mycompany.services.ServiceEvenement;
import java.util.ArrayList;

/**
 *
 * @author safa
 */
public class stat {
  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ASUS
 */

    
    
    
       private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(50);
        renderer.setLegendTextSize(50);
        renderer.setMargins(new int[]{20, 30, 15});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
       
            
            series.add("fun", values[0]);            
        series.add("ll", values[1]);
        series.add("plaisir", values[2]);


        return series;
    }

    public Form createPieChartForm() {
       ServiceEvenement ps = new ServiceEvenement();
        ArrayList<Evenement>participanst=ps.getAllEvents();
                
        // Generate the values
        double[] values = new double[]{ps.nbLike("fun"),ps.nbLike("ll"),ps.nbLike("plaisir")};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(30);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);
        
        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Type Event", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Form f = new Form("Type Event");
        f.setLayout(new BorderLayout());
        f.addComponent(BorderLayout.CENTER, c);
        return f;
    }
}  
