package JFC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Bob
 */
public class NuagePoint extends JPanel
{

    /* titre : Le titre du graphique affiché en haut */
    private final String titre;
    /* ordonnee : le nom de l'axe des ordonnées */
    private String ordonnee;
    /* abscisses : le nom de l'axe des abscisses */
    private String abscisse;
    /* valeurs2 : la liste des xi */
    private final List<Double> valeurs;
    /* valeurs1 : la liste des yi */
    private final List<Double> valeurs1;
    /* legende : booleen vrai si on affiche la légende */
    private final boolean legende;
 

    /*Constructeur */
    public NuagePoint(String titre, List<Double> valeurs, List<Double> valeurs1, boolean legende)
    {
        //super(new GridLayout(1,0));
        this.titre = titre;
        this.valeurs = valeurs;
        this.valeurs1 = valeurs1;
        this.legende = legende;
        initialiser();
    }

    //Initialise le graphique
    private void initialiser()
    {
        XYSeries dataset = new XYSeries("Relation vision-dextérité");

        for (int i = 0; i < valeurs.size(); i++)
        {
            dataset.add((double) valeurs.get(i), (double) valeurs1.get(i));

        }
        XYSeriesCollection dsxy = new XYSeriesCollection();
        dsxy.addSeries(dataset);

        JFreeChart chart = ChartFactory.createScatterPlot(
                titre, // chart title
                abscisse, // domain axis label
                ordonnee, // range axis label
                dsxy, // data
                PlotOrientation.VERTICAL, // orientation
                legende, // include legend
                true, // tooltips
                false // URL
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);

        add(chartPanel);
    }

}
