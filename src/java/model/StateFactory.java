/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gabriel
 */
public class StateFactory {
    public static CarroEstado create(String state) {
        CarroEstado actionObject = null;
        String nomeClasse = "model.CarroEstado" + state;
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof CarroEstado)) {
            return null;
        }
        actionObject = (CarroEstado) objeto;
        return actionObject;
    }
}
