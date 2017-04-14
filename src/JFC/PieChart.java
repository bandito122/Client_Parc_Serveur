package JFC;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Bob
 */
public class PieChart extends JPanel
{

    private static final long serialVersionUID = 1L;
    /* titre : Le titre du graphique affiché en haut */
    private String titre;
    /* valeurs : les valeurs à afficher */
    private List<Double> valeurs;
    /* categories : la liste des categories */
    private List<String> categories;
    /* legende : booleen vrai si on affiche la légende */
    private boolean legende;

    /*Constructeur */
    public PieChart(String titre, List<Double> valeurs, List<String> listeCategory, boolean legende)
    {
        //super(new GridLayout(1,0));
        this.titre = titre;
        this.valeurs = valeurs;
        this.categories = listeCategory;
        this.legende = legende;
        initialiser();
    }

    //Initialise le graphique
    private void initialiser()
    {
        DefaultPieDataset dataset = new DefaultPieDataset();

        int k = 0;
        for (int j = 0; j < categories.size(); j++)
        {
            dataset.setValue(categories.get(j), valeurs.get(k));
            k++;
        }

        JFreeChart chart = ChartFactory.createPieChart(
                titre, // chart title
                dataset, // data
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
