/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.web.controller;


import caja.domain.Call;
import caja.services.CallService;
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
    
    /**
     * The roleService
     */
    @Autowired
    private CallService roleService;
    

    /**
     * Stores the <code>Role</code> received as parameter
     * 
     * @param role - the role to store
     * @param response - it is not used but required by Spring mapping
     */
    @RequestMapping(value = "store", method = RequestMethod.POST)
    public void submitCall(@Valid @RequestBody Call call, HttpServletResponse response) {
        logger.debug("storeRole init");
    }
    
    /**
     * Updates the <code>Role</code> received as parameter
     * 
     * @param role - the role to update
     * @param response - it is not used but required by Spring mapping
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody List<Call> refresh(@Valid @RequestBody Call role, HttpServletResponse response) {
        roleService.updateRole(role);
        return null;
    }
    

    
}
