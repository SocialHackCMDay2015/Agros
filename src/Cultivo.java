public class Cultivo
{
	private Planta[] plantas;
	private int numPlantas;
	
	public Cultivo()
	{
		this.plantas=new Planta[10];
		this.numPlantas=0;
	}
	
	public void agregarPlanta(Planta objeto)
	{
		Planta auxiliar=new Planta("","","","","","","","","");
		
		//Agregar Planta
		if (this.numPlantas>9)
		{
			this.aumentarArreglo();
		}
		this.plantas[this.numPlantas++]=objeto;
		
		//Ordenar plantas
		for(int i=0; i<this.numPlantas; i++)
		{
			for(int j=i; j<this.numPlantas; j++)
			{
				if((this.plantas[i].getNombre().toUpperCase()).compareTo(((this.plantas[j].getNombre())).toUpperCase())>0)
				{
					auxiliar=this.plantas[i];
					this.plantas[i]=this.plantas[j];
					this.plantas[j]=auxiliar;
				}
			}
		}
		
	}
	
	public boolean borrarPlanta(int numero)
	{
		if(numero<this.numPlantas)
		{	
			if (numero==plantas.length-1)
			{
				plantas[numero]=null;
			}
			else
			{
				for (int i=numero+1; i<plantas.length; i++)
				{
					plantas[i-1]=plantas[i];
				}
				plantas[this.numPlantas-1]=null;
			}
			this.numPlantas--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Mis metodos
	private void aumentarArreglo()
	{
		Planta[] nuevo=new Planta[this.plantas.length+10];
		for (int i=0; i<this.plantas.length; i++)
		{
			nuevo[i]=this.plantas[i];
		}
		this.plantas=nuevo;
	}
}