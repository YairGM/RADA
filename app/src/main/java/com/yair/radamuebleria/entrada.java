package com.yair.radamuebleria;

public class entrada {
    private String uid;
    private String linea;
    private String claveproducto;
    private String Cantidadproducto;
    private String autoriza;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getlinea(){
        return linea;
    }

    public void setlinea (String Linea){linea=Linea; }

    public String getclaveproducto(){
        return claveproducto;
    }

    public void setclaveproducto (String ClaveProducto){ claveproducto=ClaveProducto; }

    public String getcantidadproducto(){
        return Cantidadproducto;
    }

    public void setcantidadproducto (String CantidadProducto){
        Cantidadproducto=CantidadProducto;
    }

    public String getautoriza(){
        return autoriza;
    }

    public void setautoriza(String Autoriza){
        autoriza=Autoriza;
    }

    public entrada(String lineaa, String clavee, String cantidaad, String autorizaa){
        this.linea=lineaa;
        this.claveproducto=clavee;
        this.Cantidadproducto=cantidaad;
        this.autoriza=autorizaa;
    }
    public entrada(){

    }
    @Override
    public String toString() {
        return "Linea " + this.linea + " Clave: " + claveproducto + " Cantidad: " + Cantidadproducto;
    }
}
