/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Huy Trường
 */
public class HandlerException extends Exception {
    private String message;

    public HandlerException(String message) {
        this.message = message;
    }
    
}
