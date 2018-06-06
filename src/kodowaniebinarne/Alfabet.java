/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodowaniebinarne;

/**
 *
 * @author root
 */
public class Alfabet implements Comparable<Alfabet> {

    private char litera;
    private int wystapienia;

    Alfabet(char litera,int wystapienia) {
        this.litera=litera;
        this.wystapienia=wystapienia;
    }

    /**
     * @return the litera
     */
    public char getLitera() {
        return litera;
    }

    /**
     * @param litera the litera to set
     */
    public void setLitera(char litera) {
        this.litera = litera;
    }

    /**
     * @return the wystapienia
     */
    public int getWystapienia() {
        return wystapienia;
    }

    /**
     * @param wystapienia the wystapienia to set
     */
    public void setWystapienia(int wystapienia) {
        this.wystapienia = wystapienia;
    }

    @Override
    public int compareTo(Alfabet t) {
        return this.wystapienia - t.wystapienia;
    }
    public String toString(){
        return wystapienia+" "+litera;   
    }
}
