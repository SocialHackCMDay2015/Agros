import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelControl extends JPanel implements ActionListener
{
	private JButton[] botones;
	private int seleccion;
	
	public PanelControl()
	{
		super();
		this.setLayout(new GridLayout(7, 1));
		this.setPreferredSize(new Dimension(150, 400));
		
		this.botones=new JButton[7];
		for(int i=0; i<this.botones.length;i++)
		{
			this.botones[i]=new JButton();
			this.botones[i].addActionListener(this);
			this.add(this.botones[i]);
		}
		
		this.botones[0].setText("Inicio");
		this.botones[1].setText("Cultivos");
		this.botones[2].setText("Riego");
		this.botones[3].setText("");
		this.botones[3].setVisible(false);
		this.botones[4].setText("Estadisticas");
		this.botones[5].setText("Ajustes");
		this.botones[6].setText("Salir");
		this.botones[1].doClick();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for (int i=0; i<this.botones.length;i++)
		{
			if(e.getSource()==this.botones[i])
			{
				this.botones[i].setBackground(new Color(174,240,155));
				this.seleccion=i;
			}
			else
			{
				this.botones[i].setBackground(new Color(255,197,168));
			}
		}
		
		if(this.seleccion==6)
		{
			int n = JOptionPane.showConfirmDialog(null, "¿Deceas salir?", "SALIR", JOptionPane.YES_NO_OPTION);
			if(n==0)
			{
				System.exit(0);
			}
			else
			{
				this.botones[1].doClick();
			}
		}
	}	
	
	public int getSeleccion()
	{
		return this.seleccion;
	}
}