/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velluters.aniversario;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Guille
 */
public class crearVentana {
    private final JFrame miVentana;
    private final JButton btnRutaInicio, btnRutaDestino;
    private final JButton btnConvertir, btnExit;
    private final JLabel RutaIn, RutaDest, Label1, Info;
    private final JTextField nombreFicheros;
    private renombrarArchivo archivo = new renombrarArchivo();
    private renombrarArchivo destino = new renombrarArchivo();
    private renombrarArchivo copia = new renombrarArchivo();
    
    public crearVentana(){
        //Creamos la ventana
        miVentana = new JFrame("Copiar y Renombrar ficheros de un directorio en otro");
        
        //Creamos los elementos que se verán en la ventana
        Label1 = new JLabel(" -- @gamutio --");
        btnRutaInicio = new JButton("Ruta de origen");
        btnRutaDestino = new JButton("Ruta de destino");
        RutaIn = new JLabel("Selecciona ruta...");
        RutaDest = new JLabel("Selecciona ruta...");
        Info = new JLabel("Patrón a asignar a los ficheros (*)");
        nombreFicheros = new JTextField();
        btnConvertir = new JButton("Renombrar");
        btnExit = new JButton("Salir");
        
        //Posiciono en la ventana los elementos
        Label1.setBounds(150, 5, 90, 40);
        btnRutaInicio.setBounds(60, 55, 250, 30);
        btnRutaDestino.setBounds(60, 110, 250, 30);
        RutaIn.setBounds(60, 75, 250, 40);
        RutaDest.setBounds(60, 130, 250, 40);
        Info.setBounds(60, 155, 250, 40);
        nombreFicheros.setBounds(60, 185, 250,30);
        btnConvertir.setBounds(60, 220, 250, 30);
        btnExit.setBounds(60, 300, 250, 30);
        miVentana.setLayout(null);
        
        //Incluyo los listener de cada botón
        btnRutaInicio.addActionListener(new Escuchador());
        btnRutaInicio.setToolTipText("Selecciona un archivo del directorio en el que quieres ejecutar el cambio de nombre de los archivos");
        btnRutaDestino.addActionListener(new Guardar());
        btnRutaDestino.setToolTipText("Selecciona un archivo del directorio en el que quieres guardar el cambio de nombre de los archivos");
        btnExit.addActionListener(new Salida());
        btnConvertir.addActionListener(new Convertir());
        
        //agrego los elementos a la ventana y le doy tamaño
        miVentana.add(Label1);
        miVentana.add(btnRutaInicio);
        miVentana.add(RutaIn);
        miVentana.add(RutaDest);
        miVentana.add(Info);
        miVentana.add(nombreFicheros);
        miVentana.add(btnRutaDestino);
        miVentana.add(btnConvertir);
        miVentana.add(btnExit);
        miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        miVentana.setSize(380, 380 );
        miVentana.setVisible( true );       
        
    }
    
    private class Escuchador implements ActionListener
    {//escuchamos el botón de selección de directorio de origen
        @Override
        public void actionPerformed( ActionEvent e ){
            archivo.seleccionarDirectorio();
            RutaIn.setText(archivo.getRutaInicio());
        }
    }
    private class Salida implements ActionListener
    {//Escuchamos el botón de salida de la app
        @Override
        public void actionPerformed( ActionEvent e ){
            System.exit(0);
        }
    }
    private class Guardar implements ActionListener
    {//Escuchamos el botón de selección del destino de los ficheros
        @Override
        public void actionPerformed( ActionEvent e ){
            destino.seleccionarDestino();
            RutaDest.setText(destino.getRutaDestino());
        }
    }
    private class Convertir implements ActionListener
    {//Escuchamos el botón de solicitud de conversión de archivos
        @Override
        public void actionPerformed( ActionEvent e ){
            String origen = archivo.getRutaInicio() + "\\";
            String nuevaCarpeta = destino.getRutaDestino() + "\\";
            copia.Copiamos(origen, nuevaCarpeta, nombreFicheros.getText());
            
        }
    }
}
