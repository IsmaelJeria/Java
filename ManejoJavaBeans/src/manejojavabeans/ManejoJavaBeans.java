package manejojavabeans;

import beans.PersonaBean;

public class ManejoJavaBeans {

    public static void main(String[] args){

        PersonaBean personaBean = new PersonaBean();

        personaBean.setEdad(21);
        personaBean.setNombre("ismael");

        System.out.println("Edad" + personaBean.getEdad() + "nombre " + personaBean.getNombre());

    }

}
