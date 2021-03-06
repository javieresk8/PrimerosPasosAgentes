/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uuse
 */
public class EnviarMensaje {
    
    public static void enviarMensajeObject(int tipoMsj, String receptor, Agent agenteEmisor,
            Serializable contenido, String conversationID){
        /*ACL = Agent communication language, es un mensaje que tiene varios componentes dentro
        como receptor, emisor, lengujae, contenido, id */
        /*Armamos el ACL, el paquetito */
        /*configuramos AID de emisor y receptor*/
        ACLMessage acl = new ACLMessage(tipoMsj);
        AID id = new AID(); //JADE Agent Identifier
        id.setLocalName(receptor);
        acl.addReceiver(id);
        acl.setSender(agenteEmisor.getAID());
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        
        /*Metemos el contenido en el ACL*/
        try {
            acl.setContentObject(contenido);
        } catch (IOException e) {
            Logger.getLogger(EnviarMensaje.class.getName()).log(Level.SEVERE, null, e);
            
        }
        /*Identificamos y mandamos*/
        acl.setConversationId(conversationID);
        agenteEmisor.send(acl);
        
        
        
    }
    
    public void enviarMensajeString(int tipoMsj, String receptor,
            Agent agenteEmisor, String contenido, String conversationID){
        /*El ID de la conversacion debe ser unica, por que es el que localiza quien se esta comunicando*/
        ACLMessage acl = new ACLMessage(tipoMsj);
        /*Identificador de agente*/
        AID id = new AID();
        id.setLocalName(receptor);
        acl.addReceiver(id);
        acl.setSender(agenteEmisor.getAID());
        /*puede ser cualquier lenguaje este caso es el Standard Language*/
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        /*Contenido cualquier tipo String*/
        acl.setContent(contenido);
        acl.setConversationId(conversationID);
        agenteEmisor.send(acl);
    }
    
}
