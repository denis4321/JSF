/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denis.common;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 *
 * @author prokopiukd
 */
public class MyAppListener implements SystemEventListener {

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        if (event instanceof PostConstructApplicationEvent) {
            System.out.println("###########PostConstruct");
        }
        if (event instanceof PreDestroyApplicationEvent) {
            System.out.println("###########PreDestroy");
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return (source instanceof Application);
    }

}
