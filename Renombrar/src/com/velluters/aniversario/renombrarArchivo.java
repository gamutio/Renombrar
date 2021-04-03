/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velluters.aniversario;
import java.io.*;
import java.util.regex.Pattern;
import javax.swing.*;
import org.apache.commons.io.*;

/**
 *
 * @author Guille
 */
public class renombrarArchivo {
    private String rutaInicio;
    private String rutaDestino;
    
    public renombrarArchivo(){
        
    }
    
    public void Copiamos(String origen, String destino, String patron){
        //Copiamos los archivos de la carpeta origen a la carpeta destino
        File inFile = new File(origen);
        File outFile = new File(destino); 
        try {
            FileUtils.copyDirectory(inFile, outFile); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        //Renombramos los archivos copiados en el nuevo directorio
        String path = destino;

        File directory = new File(path);
        String[] files = directory.list();
        File f1,f2;
        String filename, filenameModif;
        String cutindex;
        for (int i = 0; i < files.length; i++) {

            filename = files[i];
            f1 = new File(path+"/"+filename);
            String[] AD = filename.split(Pattern.quote("."));
            cutindex = AD[1];
            if (cutindex != "")
            {
                filenameModif = patron + "_"+ i + "." + cutindex;
                f2 = new File(path+"/"+filenameModif);
                f1.renameTo(f2);
            }
        }
        
        
    }

    //Seleccion de directorio de Origen
    public void seleccionarDirectorio(){
     JFileChooser f = new JFileChooser();
     //Seleccionamos la ruta donde están los archivos
     f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
     f.showSaveDialog(null); 
     //Almaceno la ruta de origen
     File fichero = f.getSelectedFile();
     rutaInicio = fichero.getPath();
    }
    //seleccion de directorio de Destino
    public void seleccionarDestino(){
     JFileChooser f = new JFileChooser();
     //Seleccionamos la ruta donde están los archivos
     f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
     f.showSaveDialog(null); 
     //Almaceno la ruta de origen
     File fichero = f.getSelectedFile();
     rutaDestino = fichero.getPath();
    }

    public String getRutaInicio() {
        return rutaInicio;
    }

    public void setRutaInicio(String rutaInicio) {
        this.rutaInicio = rutaInicio;
    }

    public String getRutaDestino() {
        return rutaDestino;
    }

    public void setRutaDestino(String rutaDestino) {
        this.rutaDestino = rutaDestino;
    }
    
}
