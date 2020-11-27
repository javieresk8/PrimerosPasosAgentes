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
public class Agente2 extends Agent{

     @Override
    protected void setup() {
        /*Configuracion inicial del agente*/
        super.setup();
         addBehaviour(new Comportamiento());
        
    }
    
    @Override
    protected void takeDown() {
        System.out.println("Voy a morir");
    } 
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            /*El agente 2 recibe info del agente 1
            por tanto debemos tener el ACL bloqueado hasta que llegue ese mensaje*/
            ACLMessage acl = blockingReceive();
            System.out.println("Hola, un gusto " + acl.getSender() + ", yo soy el agente " + getAgent().getName());
            /*Fijate que el codigo de la conversacion es el mismo*/
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag3", getAgent(), "Hola Agente, soy " + getAgent().getName(), "COD001");
            
        }

       
        
    }

  
    
}
