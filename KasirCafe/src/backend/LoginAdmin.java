/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author 62838
 */
public class LoginAdmin implements Login {

    @Override
    public String userAdmin() {
        return "admin";
    }

    @Override
    public String passwordAdmin() {
        return "admin";
    }
    
}
  