import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class PanelDibujo extends JPanel implements ActionListener
{
	private Image fondo;
	private JButton[] botones;
	private Icon 	icono1,
					icono2,
					icono3,
					icono4;
	private JFrame ventana1;
	private JPanel panel1;
	private String nombre;
	private double 	ph,
					humedad,
					temperaturaA,
					temperaturaT,
					densidad,
					presion,
					iluminacion,
					imagenes;
	private double 	tph,
					thumedad,
					ttemperaturaA,
					ttemperaturaT,
					tdensidad,
					tpresion,
					tiluminacion,
					timagenes;
	private final JTable tabla;
	private JScrollPane scrollPane;
	private String[] columnNames = {"Datos Medidos","Datos Ideales","Unidades"};
	private Object[][] data = 	{
								{this.ph, this.tph,"pH"},
								{this.humedad, this.thumedad,"%"},
								{this.temperaturaA, this.ttemperaturaA,"C"},
								{this.temperaturaT, this.ttemperaturaT,"C"},
								{this.densidad, this.tdensidad,"mg/m3"},
								{this.presion, this.tpresion,"atm"},
								{this.iluminacion, this.tiluminacion,"cd"},
								{this.imagenes, this.timagenes,""}
								};
	private JLabel 	label1,
					label2,
					label3,
					label4,
					label5,
					label6,
					label7;

	public PanelDibujo()
	{
		super();
		this.setPreferredSize(new Dimension(700, 600));
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panel1=new JPanel();
		this.ventana1=new JFrame();
		this.ventana1.setSize(700, 600);
		this.ventana1.setLocation(200,50);
		this.ventana1.setTitle("MEDICIONES");
		this.icono1=new ImageIcon("cana.jpg");
		this.icono2=new ImageIcon("jitomate.jpg");
		this.icono3=new ImageIcon("maiz.jpg");
		this.icono4=new ImageIcon("trigo.jpg");
		this.fondo=new ImageIcon("2.jpg").getImage();
		this.botones=new JButton[4];
		this.botones[0]=new JButton("Caña",this.icono1);
		this.botones[1]=new JButton("Jitomate",this.icono2);
		this.botones[2]=new JButton("Maiz",this.icono3);
		this.botones[3]=new JButton("Trigo",this.icono4);
		for(int i=0; i<this.botones.length;i++)
		{
			this.botones[i].addActionListener(this);
		}
		this.tabla = new JTable(data, columnNames);
        this.tabla.setPreferredScrollableViewportSize(new Dimension(400, 130));
        this.tabla.setFillsViewportHeight(true);
        this.scrollPane = new JScrollPane(this.tabla);
        this.panel1.add(this.scrollPane);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
        this.tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
        this.tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
        
        this.label1=new JLabel("PH está fuera del rango");
        this.label2=new JLabel("Humedad está fuera del rango");
        this.label3=new JLabel("Temperatura del Medio Ambiente está fuera del rango");
        this.label4=new JLabel("Temperatura del Terreno está fuera del rango");
        this.label5=new JLabel("Densidad está fuera del rango");
        this.label6=new JLabel("Presion está fuera del rango");
        this.label7=new JLabel("Imagenes están fuera del rango");
        
	}
	
	public void remover()
	{
		this.removeAll();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), null);
		this.llenarBoton0();
		this.llenarBoton1();
		this.llenarBoton2();
		this.llenarBoton3();
	}
	
	private void llenarBoton0()
	{
		this.botones[0].setBounds(50, 50, 200, 200);
		this.add(this.botones[0]);
	}
	
	private void llenarBoton1()
	{
		this.botones[1].setBounds(450, 50, 200, 200);
		this.add(this.botones[1]);
	}
	
	private void llenarBoton2()
	{
		this.botones[2].setBounds(50, 350, 200, 200);
		this.add(this.botones[2]);
	}
	
	private void llenarBoton3()
	{
		this.botones[3].setBounds(450, 350, 200, 200);
		this.add(this.botones[3]);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.ventana1.setVisible(true);
		this.ventana1.add(this.panel1);
		if(e.getSource()== this.botones[0])
		{
			this.playAudio(1);
			this.leerDatos("cana");
			this.tph=6.5;
			this.thumedad=80;
			this.ttemperaturaA=15;
			this.ttemperaturaT=12;
			this.tdensidad=893;
			this.tpresion=1;
			this.tiluminacion=65;
			this.timagenes=0;
		}
		else if(e.getSource()== this.botones[1])
		{
			this.playAudio(1);
			this.leerDatos("jitomate");
			this.tph=6.6;
			this.thumedad=70;
			this.ttemperaturaA=23;
			this.ttemperaturaT=20;
			this.tdensidad=893;
			this.tpresion=1;
			this.tiluminacion=70;
			this.timagenes=0;
		}
		else if(e.getSource()== this.botones[2])
		{
			this.playAudio(1);
			this.leerDatos("maiz");
			this.tph=6.5;
			this.thumedad=67;
			this.ttemperaturaA=27;
			this.ttemperaturaT=23;
			this.tdensidad=893;
			this.tpresion=1;
			this.tiluminacion=80;
			this.timagenes=0;
		}
		else
		{
			this.playAudio(1);
			this.leerDatos("trigo");
			this.tph=7;
			this.thumedad=45;
			this.ttemperaturaA=17;
			this.ttemperaturaT=15;
			this.tdensidad=893;
			this.tpresion=1;
			this.tiluminacion=75;
			this.timagenes=0;
		}
		this.tabla.setValueAt(this.ph, 0, 0);
		this.tabla.setValueAt(this.tph, 0, 1);
		this.tabla.setValueAt(this.humedad, 1, 0);
		this.tabla.setValueAt(this.thumedad, 1, 1);
		this.tabla.setValueAt(this.temperaturaA, 2, 0);
		this.tabla.setValueAt(this.ttemperaturaA, 2, 1);
		this.tabla.setValueAt(this.temperaturaT, 3, 0);
		this.tabla.setValueAt(this.ttemperaturaT, 3, 1);
		this.tabla.setValueAt(this.densidad, 4, 0);
		this.tabla.setValueAt(this.tdensidad, 4, 1);
		this.tabla.setValueAt(this.presion, 5, 0);
		this.tabla.setValueAt(this.tpresion, 5, 1);
		this.tabla.setValueAt(this.iluminacion, 6, 0);
		this.tabla.setValueAt(this.tiluminacion, 6, 1);
		this.tabla.setValueAt(this.imagenes, 7, 0);
		this.tabla.setValueAt(this.timagenes, 7, 1);
		
		this.panel1.setLayout(new GridLayout(3,0,5,5));
		
		if(this.ph!=this.tph)
		{
			this.panel1.add(this.label1);
		}
		
		if(this.humedad!=this.thumedad)
		{
			this.panel1.add(this.label2);
		}
		
		if(this.temperaturaA!=this.ttemperaturaA)
		{
			this.panel1.add(this.label3);
		}
		
		if(this.temperaturaT!=this.ttemperaturaT)
		{
			this.panel1.add(this.label4);
		}
		
		if(this.presion!=this.tpresion)
		{
			this.panel1.add(this.label5);
		}
		
		if(this.iluminacion!=this.tiluminacion)
		{
			this.panel1.add(this.label6);
		}
		
		if(this.imagenes!=this.timagenes)
		{
			this.panel1.add(this.label7);
		}
	}
	
	private void leerDatos(String busqueda)
	{
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Ruben\\workspace\\Proyecto\\mediciones.txt"));
			StringTokenizer st;
			String linea;
			this.nombre="";
			this.ph=0;
			this.humedad=0;
			this.temperaturaA=0;
			this.temperaturaT=0;
			this.densidad=0;
			this.presion=0;
			this.iluminacion=0;
			this.imagenes=0;		
			br.readLine();
			while((linea=br.readLine()) !=null)															
			{
				st=new StringTokenizer(linea, ",");
				this.nombre=st.nextToken();
				if(this.nombre.equals(busqueda))
				{
					this.ph=Double.parseDouble(st.nextToken());
					this.humedad=Double.parseDouble(st.nextToken());
					this.temperaturaA=Double.parseDouble(st.nextToken());
					this.temperaturaT=Double.parseDouble(st.nextToken());
					this.densidad=Double.parseDouble(st.nextToken());
					this.presion=Double.parseDouble(st.nextToken());
					this.iluminacion=Double.parseDouble(st.nextToken());
					this.imagenes=Double.parseDouble(st.nextToken()); 
				}
			}
			br.close();
		}
		
		catch(FileNotFoundException f)
		{
			JOptionPane.showMessageDialog(this, "No se encontro el archivo de texto" + f, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
		}
		
		catch(IOException g)
		{
			JOptionPane.showMessageDialog(this, "Error en el archivo de texto" + g, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void playAudio(int status)
	{
		String soundName;
		if(status==1)
		{
			soundName="correcto.wav";
		}
		else if(status==2)
		{
			soundName="incorrecto.wav";
		}
		else
		{
			soundName="terminado.wav";
		}
		AudioInputStream audioInputStream;
		try
		{
			audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}

		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{ 		
			e.printStackTrace();
		}
	}
}