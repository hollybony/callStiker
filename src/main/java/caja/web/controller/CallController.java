/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.web.controller;


import caja.domain.Call;
import caja.services.CallService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Web controller that processes all the request related to roles
 * 
 * https://developer.chrome.com/extensions/desktop_notifications
 * 
 * @author Carlos Juarez
 */
@Controller
@RequestMapping("/callController/*")
public class CallController{

    /**
     * The logger
     */
    final org.slf4j.Logger logger = LoggerFactory.getLogger(CallController.class);
    
    private final List<Call> callsToDeliver = new ArrayList<Call>();
    

    /**
     * Stores the <code>Role</code> received as parameter
     * 
     * @param call
     * @param response - it is not used but required by Spring mapping
     * @return 
     */
    @RequestMapping(value = "submitCall", method = RequestMethod.POST)
    public @ResponseBody boolean submitCall(@Valid @RequestBody Call call, HttpServletResponse response) {
        logger.debug("submit call " + call);
        synchronized(callsToDeliver){
            callsToDeliver.add(call);
        } 
       return true;
    }
    
    /**
     * Updates the <code>Role</code> received as parameter
     * 
     * @param role - the role to update
     * @param response - it is not used but required by Spring mapping
     * @return 
     */
    @RequestMapping(value = "newCalls", method = RequestMethod.POST)
    public @ResponseBody List<Call> newCalls(HttpServletResponse response) {
        List<Call> calls = null;
        synchronized(callsToDeliver){
            calls = new ArrayList<Call>(callsToDeliver);
            callsToDeliver.clear();
        }
        logger.debug("new calls : " + calls);
        return calls;
    }
    
}
