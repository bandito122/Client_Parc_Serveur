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
import org.jfree.data.general.DefaultPieDataset;

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
	 


	public PieChart(String titre, List<Double> valeurs,List<String> listeCategory, boolean legende) 
        {
		//super(new GridLayout(1,0));
		this.titre=titre;
                this.valeurs=valeurs;
		this.categories=listeCategory;
		this.legende=legende;
		initialiser();
	}

	

	 
 //Initialise le graphique
	 


	private void initialiser()
        {
                DefaultPieDataset dataset = new DefaultPieDataset();
		//DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int k = 0;
		for (int j=0; j<categories.size(); j++)
                {
                    
                    dataset.setValue(categories.get(j),valeurs.get(k));
                    k++;

		}
                //chart = ChartFactory.createPieChart ("Répartitions des types d'appareils", ds, true, true, true);
		JFreeChart chart = ChartFactory.createPieChart(
				titre,   			// chart title
				dataset,    			// data
				legende,                        // include legend
				true,                     	// tooltips
				false                     	// URL
		);

		

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setFillZoomRectangle(true);
		chartPanel.setMouseWheelEnabled(true);
		//chartPanel.setPreferredSize(new Dimension(500, 270));

		add(chartPanel);
	}

	

	 
 //Création d'un graphique
	 


	public static void main(String[] a)
        {
		List<Double> donnees = new ArrayList<>();
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		l2.add("0");
		l1.add("1");
		l1.add("2");
		l1.add("3");
		l1.add("4");
		donnees.add(2.0);
		donnees.add(3.0);
		donnees.add(4.0);
		donnees.add(4.0);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(10,10,500,500);
		Histogramme g = new Histogramme("titre", "x", "y", donnees, Color.red, l2, l1, true);
		f.add(g);
		f.setVisible(true);
	}

}