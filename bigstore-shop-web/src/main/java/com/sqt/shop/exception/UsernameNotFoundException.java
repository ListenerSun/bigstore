package com.sqt.shop.exception;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-14  15:23
 */
public class UsernameNotFoundException  extends RuntimeException{

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException() {
    }
}
