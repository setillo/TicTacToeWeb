package es.art83.ticTacToe.view;

import java.util.Map;

import javax.faces.bean.ManagedProperty;


public abstract class Bean {

    @ManagedProperty(value = "#{sessionScope}")
    private Map<String, Object> sessionMap;

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }
    
}
