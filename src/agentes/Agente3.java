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
public class Agente3 extends Agent{

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
            /*Ag3 tambien tiene que esperar el mensaje de ag2*/
            ACLMessage acl = blockingReceive();
            System.err.println("Hola, que gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag4", getAgent(), "Hola agente, soy " + getAgent().getName(),
                    "COD0001");
        }
        
    }
  
    
}
