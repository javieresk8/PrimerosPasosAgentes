/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
/**
 *
 * @author uuse
 */
public class Contenedor {

    AgentController agenteController; //Este aun no sabemos que es lo que hace, no influye en el contenedor, es para arrancar los agentes
    AgentContainer mainContainer; //ojo que viene de wrapern no del CORE 
    
    public void contenedor(){
        /*Creamos una rutina, hace una ejecucion en segundo plano, en este caso el core de jade, es decir el contenedor*/
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        runtime.setCloseVM(true);
        System.out.println("Runtime ha sido creado");
        
        /*Perfil de implemnetacion que va a tener la maquina*/
        /*Si vamos a comunicar contenedores debemos abrir reglas de firewall*/
        /*Creamos el perfil con IP y el nombre en null para que tome los de la maquina*/
        Profile profile = new ProfileImpl(null, 1099, null);
        System.out.println("Perfil por defecto creado");
        
        /*Creamos el contenedor principal, donde estaran los agentes,
        recibe como parametro el perfil creado*/
        mainContainer = runtime.createMainContainer(profile);
        System.out.println(String.format("Contenedor creado %s", profile.toString()));
        
        
    }
    
    public static void main(String[] args) {
        new Contenedor().contenedor();
        
        /*Recuerda que si sale algun error de direcciones, es por que 
        dejamos el puerto abierto , nos dice que ya esta utilizado el puerto
        debemos cerrar el proceso con el stop de Netbeans*/
    }
    
}
