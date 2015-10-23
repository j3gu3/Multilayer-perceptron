/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MLP;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 * @param <T>
 */
public class DataSet<T> {
    private ArrayList<T> data = new ArrayList<>();
    private String className;

    public DataSet() {
    }

    public DataSet(ArrayList<T> data, String className) {
        this.data = data;
        this.className = className;
    }
    
    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
}
