/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author uuse
 */
public class Agente1 extends Agent{

     @Override
    protected void setup() {
        /*Configuracion inicial del agente*/
        super.setup();
        /*=====================IMPORTANTE========================*/
        /*Debemos anadir el comportamineto cuando se construye el agente*/
         addBehaviour(new Comportamiento());
        
         /*System.out.println(getName());
         System.out.println(getLocalName());
         System.out.println(getAgentState());
         System.out.println(getContentManager());*/
         
        
    }
    
    @Override
    protected void takeDown() {
        System.out.println("Voy a morir Ag1");
    }
    
    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            /*Enviamos un mensaje al agente 2*/
            /*Invocamos al agente 2 para en su comportamiento obtener el mensaje*/
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag2", getAgent(), "Hola agente, soy " + getAgent().getName(), "COD001");
            
            /*Como el agente va a recibir un mensaje del agente 4, tenemos que bloquear el ACL hasta 
            que reciba ese mensaje 4*/
            ACLMessage acl = blockingReceive();
            /*Una vez que recibe, se sigue ejecutando el codigo y mostramos el contenido del ACL*/
            System.out.println("Ciclo completado recibi: " + acl.getContent());
            
            /*Una vez que recibe el mensaje ahora si lo matamos para que no se vaya al infinito
            recuerda el flujo de trabajo de los agentes*/
            doDelete();
        }
        
    }
  
    
}
