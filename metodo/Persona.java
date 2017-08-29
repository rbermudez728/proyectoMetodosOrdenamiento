package estructurasdedatos.cap1.tiposdedatos;

//ASÍ SE DEFINE UN TIPO ABSTRACTO DE DATO (UNA CLASE)
public class NuevoTipoAbstractoDeDato{ // IMPORTANTE MIRAR LAS LLAVES
  //ESPACIO PARA DEFINIR ATRIBUTOS
  private String atributo1; //EL TIPO DE DATO LO DEFINO SEGÚN MI NECESIDAD
  
  //CONSTRUCOTR OPCIONAL CON LE MISMO NOMBRE DE 
  //LA CLASE Y SIN TIPO DE RETORNO
  public NuevoTipoAbstractoDeDato(){
  	
  }
  
  //ESPACIO PARA DEFINIR MÉTODOS (FUNCIONES)
  //Así se encapsula un campo
  public String getAtributo1(){
  	String salida;
    salida = this.atributo;
    return salida;
  }
  
  public void setAtributo1(String entrada){
  	this.atributo1=entrada;
  }
