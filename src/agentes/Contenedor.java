/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;
import com.sun.istack.internal.logging.Logger;
import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
/**
 *
 * @author uuse
 */
public class Contenedor {

    AgentController agentController; //Este aun no sabemos que es lo que hace, no influye en el contenedor, es para arrancar los agentes
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
        iniciarAgentes();
        
    }
    
    private void iniciarAgentes(){
        try {
            /*Cuando creamos el agente, le pasamos un nickanme,el nombre de la clase en el que esta
            y el tercer parametro es el de CONOCIMIENTO PREVIO, el agente va a tener un conocimiento 
            de otro agente, de la computadora, una red neuronal o cualquier tipo de cosa*/
            /*Podemos hacer que el Agente muera y cree un hijo que le pase el conocimiento*/
            /*Start abre un hilo que invoca al setup del agente*/
            
            //El orde en el que arranquemos los agentes es importante, deende de la arq de los Agentes 
            //Debes fijarte en que deben existir receptores para luego crear emisores
            //De igual manera debemos arrancar primero los agentes que reciben y no los que envian
            mainContainer.createNewAgent("Ag4", Agente4.class.getName(), null).start();
            mainContainer.createNewAgent("Ag3", Agente3.class.getName(), null).start();
            mainContainer.createNewAgent("Ag2", Agente2.class.getName(), null).start();
            mainContainer.createNewAgent("Ag1", Agente1.class.getName(), null).start();
            
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName(), null).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Contenedor().contenedor();
        
        /*Recuerda que si sale algun error de direcciones, es por que 
        dejamos el puerto abierto , nos dice que ya esta utilizado el puerto
        debemos cerrar el proceso con el stop de Netbeans*/
    }
    
}
