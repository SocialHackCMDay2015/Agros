public class Planta
{
	private String 	nombre,
					ph,
 					humedad,
 					temperaturaA,
	 				temperaturaT,
	 				densidad,
	 				presion,
	 				iluminacion,
	 				imagenes;

	public Planta(String nombre, String ph, String humedad, String temperaturaA, String temperaturaT, String densidad, String presion, String iluminacion, String imagenes)
	{
		this.nombre=nombre;
		this.ph=ph;
		this.humedad=humedad;
		this.temperaturaA=temperaturaA;
		this.temperaturaT=temperaturaT;
		this.densidad=densidad;
		this.presion=presion;
		this.iluminacion=iluminacion;
		this.imagenes=imagenes;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
		
	public String getPh()
	{
		return this.ph;
	}
		
	public String getHumedad()
	{
		return this.humedad;
	}
		
	public String getTemperaturaA()
	{
		return this.temperaturaA;
	}
	
	public String getTemperaturaT()
	{
		return this.temperaturaT;
	}
		
	public String getDensidad()
	{
		return this.densidad;
	}
		
	public String getPresion()
	{
		return this.presion;
	}
		
	public String getIluminacion()
	{
		return this.iluminacion;
	}
	
	public String getImagenes()
	{
		return this.imagenes;
	}
	
	public String toString()
	{
		String cadena ="";
		
		if(!this.nombre.isEmpty())
		{
			 cadena=cadena + "Nombre: " + this.nombre + "\n";
		}
		if(!this.ph.isEmpty())
		{
			 cadena=cadena + "PH: " + this.ph + "\n";
		}
		
		if(!this.humedad.isEmpty())
		{
			 cadena=cadena + "Humedad: " + this.humedad + "\n";
		}
			
		if(!this.temperaturaA.isEmpty())
		{
			 cadena=cadena + "Temperatura Ambiente: " + this.temperaturaA + "\n";
		}
		
		if(!this.temperaturaT.isEmpty())
		{
			 cadena=cadena + "Temperatura Tierra: " + this.temperaturaT + "\n";
		}
		
		if(!this.densidad.isEmpty())
		{
			 cadena=cadena + "Densidad: " + this.densidad + "\n";
		}
		
		if(!this.presion.isEmpty())
		{
			 cadena=cadena + "Presion: " + this.presion + "\n";
		}
			
		if(!this.iluminacion.isEmpty())
		{
			 cadena=cadena + "Iluminacion: " + this.iluminacion + "\n";
		}
			
		return cadena;
	}
}