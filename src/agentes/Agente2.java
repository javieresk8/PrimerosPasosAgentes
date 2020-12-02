/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//            /*El agente 2 recibe info del agente 1
//            por tanto debemos tener el ACL bloqueado hasta que llegue ese mensaje*/
//            /*Puedo tambien bloquear por tiempo o por un Template*/
//            ACLMessage acl = blockingReceive();
//            System.out.println("Hola, un gusto " + acl.getSender() + ", yo soy el agente " + getAgent().getName());
//            /*Fijate que el codigo de la conversacion es el mismo*/
//            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag3", getAgent(), "Hola Agente, soy " + getAgent().getName(), "COD001");
//            

            /*==============================Parte 2 Comunicacion==============================*/
            
            try {
                ACLMessage acl = blockingReceive();
                String c_id = acl.getConversationId();
                /*aqui es donde podemos controlar el flujo de las conversaciones
                ern vez de usar un if, tu usas un switch case para cada conversacion
                asi tienes un comportamioento para cada mensaje que te manden
                dependiente del id de la conversacion*/
                /*==============================ests son las reglas de condicion y accion del agente*/
                
                if(c_id.equalsIgnoreCase("CODAg1-Ag2")){
                     /*Ojo con el metodo que utilizamos*/
                    Persona p = (Persona)acl.getContentObject();
                    System.out.println(acl);
                    System.out.println(p.getApellido());
                    System.out.println(p.getNombre());

                } else 
                    System.out.println("Ese no es el codigo");
               
                
            } catch (UnreadableException ex) {
                Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

       
        
    }

  
    
}
