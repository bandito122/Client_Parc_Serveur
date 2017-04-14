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

public class NuagePoint extends JPanel
{

	private static final long serialVersionUID = 1L;

	/* titre : Le titre du graphique affiché en haut */
	private String titre;
	
	/* ordonnee : le nom de l'axe des ordonnées */
	private String ordonnee;
	/* abscisses : le nom de l'axe des abscisses */
	private String abscisse;
	private List<Double> valeurs;
	/* series : la liste des séries */
	private List<Double> valeurs1;
	/* categories : la liste des categories */
	
	private boolean legende;
	/* couleurFond : la couleur du fond */
	
	

	 
 /*Constructeur */
	 


	public NuagePoint(String titre, List<Double> valeurs, List<Double> valeurs1,  boolean legende) 
        {
		//super(new GridLayout(1,0));
		this.titre=titre;
		this.valeurs=valeurs;
		this.valeurs1=valeurs1;
		this.legende=legende;
		initialiser();
	}

	

	 
 //Initialise le graphique
	 


	private void initialiser()
        {
                XYSeries dataset = new XYSeries("Relation vision-dextérité");
		//DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                
                    //serieObs.add((double)data.get(i),(double)data.get(i+1)); //xi,yi
  
                                       
		for (int i=0; i<valeurs.size(); i++)
                {
                    //dataset.add((double)data.get(i),(double)data.get(i+1)); //xi,yi
                    dataset.add((double)valeurs.get(i),(double)valeurs1.get(i));

		}
                XYSeriesCollection dsxy = new XYSeriesCollection();
                dsxy.addSeries(dataset);
                //chart = ChartFactory.createLineChart("Graphique linéaire", "Mois", "Chiffre d'affaire (en euros)", dcdl, PlotOrientation.VERTICAL, true, true, false);
                              //chart = ChartFactory.createScatterPlot ("Perception + dextérité manuelle", "réponse à un stimulus visuel", "dextérité manuelle",dsxy,PlotOrientation.VERTICAL ,true, true,false);
                                                   
		JFreeChart chart = ChartFactory.createScatterPlot(
				titre,   			// chart title
				abscisse,			// domain axis label
				ordonnee,   			// range axis label
				dsxy,    			// data
				PlotOrientation.VERTICAL, 	// orientation
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