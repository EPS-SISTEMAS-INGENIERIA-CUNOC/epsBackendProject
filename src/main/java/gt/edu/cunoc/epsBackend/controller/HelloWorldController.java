/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.cunoc.epsBackend.controller;

import javax.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author teodoro
 */
@RestController
public class HelloWorldController {
    
    @RequestMapping("/user")
    @RolesAllowed("backend-user")
    public String helloUser() {
        return "Hola Mundo User!!";
    }
    
    @RequestMapping("/user/{id}")
    public String helloAdmin() {
        return "Hola Mundo Admin!!";
    }
    
}
