/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Task {
    String nv,mt,td;
    Date dl;

    public Task(String nv, String mt, String td, Date dl) {
        this.nv = nv;
        this.mt = mt;
        this.td = td;
        this.dl = dl;
    }

    public String getNv() {
        return nv;
    }

    public void setNv(String nv) {
        this.nv = nv;
    }

    public String getMt() {
        return mt;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }

    public Date getDl() {
        return dl;
    }

    public void setDl(Date dl) {
        this.dl = dl;
    }
    
    
}
