/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.Agent;

/**
 *
 * @author uuse
 */
public class Agente1 extends Agent{

     @Override
    protected void setup() {
        /*Configuracion inicial del agente*/
        super.setup();
         System.out.println(getName());
         System.out.println(getLocalName());
         System.out.println(getAgentState());
         System.out.println(getContentManager());
         
        
    }
    
    @Override
    protected void takeDown() {
        System.out.println("Voy a morir");
    }

  
    
}
