import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Principal extends JFrame implements ActionListener
{
	private Cultivo pla;
	private PanelControl pc;
	private PanelDibujo pd;
	private JMenuBar menu;
	private JMenu 	subMenuArchivo,
					subMenuAyuda;
	private JMenuItem 	menuItemAgregar,
						menuItemEliminar,
						menuItemCerrar,
						menuItemComoUsar,
						menuItemAcercaDeHackathon;
	
	public Principal()
	{
		super("Hackathon");
		this.setLocation(50, 50);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("1.jpg").getImage());
		
		this.pla=new Cultivo();
		this.pla.agregarPlanta(new Planta("a","","","","","","","",""));
		this.pla.agregarPlanta(new Planta("b","","","","","","","",""));
		this.pla.agregarPlanta(new Planta("c","","","","","","","",""));
		this.pla.agregarPlanta(new Planta("d","","","","","","","",""));
		
		this.pc=new PanelControl();
		this.pd=new PanelDibujo();
		this.add(this.pc, BorderLayout.WEST);
		this.add(this.pd, BorderLayout.EAST);
		
		this.menu=new JMenuBar();
		this.setJMenuBar(this.menu);
		
		this.subMenuArchivo=new JMenu("Archivo");
		this.menu.add(this.subMenuArchivo);
		this.menuItemAgregar=new JMenuItem("Agregar Planta");
		this.menuItemAgregar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		this.menuItemAgregar.addActionListener(this);
		this.subMenuArchivo.add(this.menuItemAgregar);
		this.menuItemEliminar=new JMenuItem("Eliminar Planta");
		this.menuItemEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		this.menuItemEliminar.addActionListener(this);
		this.subMenuArchivo.add(this.menuItemEliminar);
		this.menuItemCerrar=new JMenuItem("Cerrar Aplicacion");
		this.menuItemCerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
		this.menuItemCerrar.addActionListener(this);
		this.subMenuArchivo.add(this.menuItemCerrar);

		this.subMenuAyuda=new JMenu("Ayuda");
		this.menu.add(this.subMenuAyuda);
		this.menuItemComoUsar=new JMenuItem("Como Usar Hackathon");
		this.menuItemComoUsar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		this.menuItemComoUsar.addActionListener(this);
		this.subMenuAyuda.add(this.menuItemComoUsar);
		this.menuItemAcercaDeHackathon=new JMenuItem("Acerca de Hackathon");
		this.menuItemAcercaDeHackathon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		this.menuItemAcercaDeHackathon.addActionListener(this);
		this.subMenuAyuda.add(this.menuItemAcercaDeHackathon);
		
		this.pack();
	}
	
	public Planta pidePlanta()
	{
		String a;
		String b;
		String c;
		String d;
		String e;
		String f;
		String g;
		String h;
		String i;
		do
		{
			a=JOptionPane.showInputDialog("Nombre: ");
			b=JOptionPane.showInputDialog("PH: ");
			c=JOptionPane.showInputDialog("Humedad: ");
			d=JOptionPane.showInputDialog("Temperatura Ambiente: ");
			e=JOptionPane.showInputDialog("Temperatura Tierra: ");
			f=JOptionPane.showInputDialog("Densidad: ");
			g=JOptionPane.showInputDialog("Presion: ");
			h=JOptionPane.showInputDialog("Iluminacion: ");
			i=JOptionPane.showInputDialog("Imagenes: ");
		} while(a.isEmpty() && b.isEmpty() && c.isEmpty() && d.isEmpty() && e.isEmpty() && f.isEmpty() && g.isEmpty() && h.isEmpty() && i.isEmpty());
		Planta nuevo=new Planta(a, b, c, d, e, f, g, h,i);
		return nuevo;
	}
	
	public static void main(String[] args)
	{
		Principal ventana=new Principal();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==this.menuItemAgregar)
		{
			pla.agregarPlanta(pidePlanta());
		}
		else if(e.getSource()==this.menuItemEliminar)
		{
			try
			{
				int borrar=Integer.parseInt(JOptionPane.showInputDialog("Numero de planta que deceas borrar: "));
				if(pla.borrarPlanta(borrar))
				{
					System.out.println("Ha sido borrado con exito la planta");
				}
				else
				{
					System.out.println("Error: ese numero de planta no existe");
				}
			}

			catch (NumberFormatException f)
			{
				JOptionPane.showMessageDialog(this, "Por favor, ingresa un numero", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==this.menuItemCerrar)
		{
			System.exit(0);
		}
		else if(e.getSource()==this.menuItemComoUsar)
		{
			JOptionPane.showMessageDialog(this, "Por el momento no podemos mostrarte ningun acercamiento al software, espera nuestra actualizacion", "Como usar Agros", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource()==this.menuItemAcercaDeHackathon)
		{
			JOptionPane.showMessageDialog(this, "Agros fue diseñado por un grupo de jovenes talentosos", "Acerca de Agros", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			
		}
	}
}