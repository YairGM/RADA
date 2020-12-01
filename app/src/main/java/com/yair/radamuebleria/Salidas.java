package com.yair.radamuebleria;

public class Salidas {
    private String uid;
    private String linea;
    private String claveproducto;
    private String motivoSalida;
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

    public String getmotivoSalida(){
        return motivoSalida;
    }

    public void setmotivoSalida(String MotivoSalida){
        motivoSalida=MotivoSalida;
    }

    public String getautoriza(){
        return autoriza;
    }

    public void setautoriza(String Autoriza){
        autoriza=Autoriza;
    }

    public Salidas(String lineaaS, String claveeS, String motivoS, String autorizaaS){
        this.linea=lineaaS;
        this.claveproducto=claveeS;
        this.motivoSalida=motivoS;
        this.autoriza=autorizaaS;
    }
    public Salidas(){

    }

    @Override
    public String toString() {
        return "Linea: " + this.linea + " Clave: " + claveproducto + " Motivo salida: " + motivoSalida;
    }
}
