package model;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.JOptionPane;

import view.GenerarMatrizBotones;
import view.VentanaPrincipal;
/**
 * Clase principal del mundo
 * @author
 *
 */
public class Parqueadero
{

   //---------------------------------------------------------------------------
   //ATRIBUTOS
   //---------------------------------------------------------------------------
   private Puesto misPuestos[][];
   private ArrayList<Vehiculo> misVehiculos;
   private ArrayList<Registro> misRegistros;

   /**
    * Constructor de la clase Parqueadero
    * @param tamanio El tamanio del parqueadero, tamanio>5
    */
   public Parqueadero(int tamanio)
   {
	   misPuestos=new Puesto[tamanio][tamanio];
	   misVehiculos= new ArrayList<Vehiculo>();
	   misRegistros=new ArrayList();
	   iniciarMatriz();
   }

   public int verificarVehiculo(Vehiculo miV)
   {
	   int pos=-1;
	   boolean centinela=false;
	   for(int i=0; i<misVehiculos.size()&&centinela==false; i++)
	   {
		 String placaVehiculoActual=misVehiculos.get(i).getPlaca();
		 String placa2=miV.getPlaca();
		 if(placaVehiculoActual.equals(placa2))
		 {
			 pos=i; centinela=true;
		 }
	}
	  return pos;



   }





   /**
    * M�todo sin parametros para inicializar la matriz
    */
   public void iniciarMatriz()
   {   int numDividir=0;
       Posicion miP=new Posicion(0,0);
	   numDividir=(int)misPuestos.length/2;
	   /**
	    * Los puestos pueden ser 0,1, 2
	    */
	   int anexo=0, anexo2=misPuestos.length-1;

	   for(int i=0; i<misPuestos.length; i++)
	   {
		   for(int j=0; j<misPuestos.length; j++)
		   {
			     miP=new Posicion(i, j);
				//misPuestos[i][j].setMiP(miP);;
			   if(numDividir==j)
			   {
				   misPuestos[i][j]=new Puesto(1,miP);
			   }
			   else
			   {

				   misPuestos[i][j]=new Puesto(0,miP);
			   }

			   if((i==1)&&(j==(misPuestos.length-1)))
				{
				   misPuestos[i][j]=new Puesto(2,miP);
				}
		   }
	   }

	   for(int m=misPuestos.length-1; m>numDividir; m--)
	   {
		   for(int s=anexo; s<numDividir; s++)
		   {
			   misPuestos[m][s]=new Puesto(1,miP);
		   }

		   anexo=anexo+1;
	   }

	   for(int x=misPuestos.length-1; x>numDividir; x--)
	   {
		   for(int z=anexo2; z>numDividir; z--)
		   {
			   misPuestos[x][z]=new Puesto(1, miP);
		   }

		   anexo2=anexo2-1;
	   }
   }

   /**
    * Verifica si hay vehiculo en el puesto i, j
    * @param i La posicion i
    * @param j la posicion j
    * @return un boolean, true si el puesto esta disponible
    */
   public boolean verificarDisponibilidadPuesto(int i, int j)
   {
	   boolean centinela=false;
	   if(misPuestos[i][j].getMiVehiculo()==null)
	   {
		   centinela=true;
	   }
	   return centinela;

   }
   /**
    * M�todo para ubicar un vehiculo dentro del puesto
    * @param miVehiculo El vehiculo,  miVehiculo!=null
    */
   public void agregarVehiculo(Vehiculo miVehiculo)
   {  //se asume que llega un carro
	  int tipo=miVehiculo.getTipo();
	  boolean guardar=false;


	  for(int i = 0; i < misPuestos.length&&guardar==false; i++)
	  {
		for(int j = 0; j < misPuestos.length&&guardar==false; j++)
		{
			if(guardar==false)
			{


				    if((misPuestos[i][j].getTipo()==tipo) && (misPuestos[i][j].getMiVehiculo()==null))
					{
						misPuestos[i][j].setMiVehiculo(miVehiculo);
						guardar=true;
						int res=verificarVehiculo(miVehiculo);
						if(res==-1)
						{
							misVehiculos.add(miVehiculo);
						}
						Registro miRegistro=new Registro(misPuestos[i][j], miVehiculo);
						misRegistros.add(miRegistro);

					}


			}
		}

	  }
   }

   /**
    *
    *
    * @param miV
    * @return
    */
   /**public int contarParqueosDelVehiculo(Vehiculo miV)
   {



   }

   public Vehiculo hallarVehiculoMasParquea()
   {




   }*/


   /**
    * M�todo para eliminar un vehiculo del parqueadero
    * @param guardaI La posicion i dentro del arreglo bidimensional en donde est� el vehiculo, i>=0
    * @param guardaJ La posicion j dentro del arreglo bidimensional en donde est� el vehiculo, j>=0
    */
   public void eliminarVehiculo(int guardaI, int guardaJ)
   {
       misPuestos[guardaI][guardaJ].setMiVehiculo(null);
   }

/**
 * Devuelve el arreglo de puestos
 * @return El arreglo de Pestos del parqueadero
 */
public Puesto[][] getMisPuestos() {
	return misPuestos;
}

/**
 * Permite fijar el arreglo de puestos
 * @param misPuestos
 */
public void setMisPuestos(Puesto[][] misPuestos) {
	this.misPuestos = misPuestos;
}

/**
 * Devuelve le propietario del vehiculo ubicado en la posicion i, j
 * @param i La fila del puesto solicitado
 * @param j La columna del puesto solicitado
 * @return El propietario del vehiculo en el puesto solicitado
 */
 public Propietario getPropietario (int i, int j )
 {
	 return misPuestos[i][j].getMiVehiculo().getDuenio();

 }
 /**
  * Devuelve el vehiculo que est� en la posicion i, j
  * @param i La fila del puesto solicitado
  * @param j La columna del puesto solicitado
  * @return el vehiculo
  */
 public Vehiculo getMiVehiculo (int i, int j )
 {
	 return misPuestos[i][j].getMiVehiculo();

 }

 public ArrayList <Vehiculo> listarVehiculoModeloSup2016()
 {
	ArrayList<Vehiculo> misV=new ArrayList<Vehiculo>();
	for(int i = 0; i < misPuestos.length; i++)
	  {
		for(int j = 0; j < misPuestos.length; j++)
		{
			Vehiculo miV= misPuestos[i][j].getMiVehiculo();
			if(miV!=null)
			{
				misV.add(miV);
			}
		}
		}

	return misV;
 }

 public String[][] toStringVehiculos(ArrayList <Vehiculo> misV)
 {
String matriz[][]= new String[1][4];
/*matriz[0][0]="fdsf1212";
matriz[0][1]="1";
matriz[0][2]="2017";
matriz[0][3]="Pepe";	 */

for(int i=0; i<misV.size(); i++)
{
	Vehiculo miVehiculo=misV.get(i);
	matriz[0][0]=miVehiculo.getPlaca();
	matriz[0][1]=""+miVehiculo.getTipo();
	matriz[0][2]=""+miVehiculo.getModelo();
	matriz[0][3]=miVehiculo.getDuenio().toString();
}

 return matriz;
 }




 public ArrayList<Vehiculo> devolverLista(int fil)
 {

	 ArrayList<Vehiculo> misVehiculoFila=new ArrayList();

	 for(int j=0; j< misPuestos.length; j++)
	 {
		 Vehiculo miVehiculo=misPuestos[fil][j].getMiVehiculo();
		 if(miVehiculo!=null&&miVehiculo.getModelo()>2016)
		 {
			 misVehiculoFila.add(miVehiculo);
		 }
	}
	 return misVehiculoFila;
 }
 /*
 public ArrayList<ArrayList<Vehiculo>> devolverLista()
 {
	 ArrayList<ArrayList<Vehiculo>> misV= new ArrayList();
	 for(int i=0; i<misPuestos.length; i++)
	 {
		 ArrayList<Vehiculo> vehiculosFila=devolverLista(i);
		 misV.add(vehiculosFila);
	 }
return misV;
 }
 public String[] devolverListado(ArrayList<ArrayList<Vehiculo>> misV)
 {
	String arreglo[]=new String [misV.size()];
	String info="";
	for(int i=0; i<misV.size(); i++)
	{
		ArrayList<Vehiculo> vehiculos= misV.get(i);
		info="";
		for(int j=0; j<vehiculos.size(); j++)
		{ Vehiculo miVehiculo=vehiculos.get(j);
		  info=info+miVehiculo.getPlaca()+" ";
		}
	arreglo[i]=info;
	}
	return arreglo;

 }
 */
 public int verificarEstaPosicion(int i, int j, ArrayList<Posicion> misP)
 {//retorna -1 si la posicion no est� en el arreglo, de lo contrario la posici�n i dentro del arraylist donde est�
 int posicion=-1;





return posicion;
 }
 public ArrayList<Posicion> devolverListadoPosicionesOrdenadoMotoCarro (Propietario miP)
 {   //aqu� se invoca a verificarEstaPosicion
	 ArrayList<Posicion> misP=new ArrayList<Posicion>();





     return misP;
 }
/**
 * Haga un m�todo que, devuelva un listado sin repeticiones y ordenado con
 *  todos los propietarios que han estado en el parqueadero y que han
 *  repetido en m�nimo  2 puestos (1.2). Ejemplo Pedro se ha parqueado en
(0,0) (0,2) (0,0) (1,1) (0,4) (2,3) (4,1) (1,1). Pedro se agrega al listado porque repiti� en el
 puesto (0,0) y en el puesto (1,1,).
 Luis se ha parqueado en (2,0) (0,2) (0,0) (1,3) (0,4) (2,3) (4,1) (1,1), no repiti� en m�nimo 2 puestos por lo que no podr� ser agregado al arraylist.
 */


 public int contarVecesPropietarioParqueaEnPuesto(Propietario miP, Posicion miPosicion)
 {int c=0;



 return c;
 }

 public void ordenarBurbujaPorNombre(ArrayList<Propietario> misT)
 {




 }
 public ArrayList<Propietario> devolverListadoOrdenadoPropietarios()
 {ArrayList<Propietario> misP=new ArrayList<Propietario>();
  //podria ser conveniente invocar al metodo devolverListadoPosicionesOrdenadoMotoCarro


  return misP;
 }
/*
 B�sese en este m�todo para construir el m�todo anterior
 public static void ordenarBurbuja(int arreglo[])
     {
         for(int i = 0; i < arreglo.length - 1; i++)
         {
             for(int j = 0; j < arreglo.length - 1; j++)
             {
                 if (arreglo[j] < arreglo[j + 1])
                 {
                     int tmp = arreglo[j+1];
                     arreglo[j+1] = arreglo[j];
                     arreglo[j] = tmp;
                 }    }     }   }*/

}
