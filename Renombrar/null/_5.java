import java.io.*;
import java.util.*;
import java.net.*;

class Servidor1 {
	/*puerto del servidor*/
	static final int puerto=5000;
	
	public Servidor1() {
		String respuesta = "Hola soy el servidor";
		String respuesta1 = "Muy bien";
		String respuesta2 = "Hasta luego";
		try {
			//creamos el socket
			ServerSocket SkServidor = new ServerSocket(puerto);
			System.out.println("Escuchamos el puerto " + puerto);
			
			while (true) {
				Socket skCliente = SkServidor.accept();
				OutputStream test = skCliente.getOutputStream();
				DataOutputStream flujo = new DataOutputStream(test);
				InputStream aux = skCliente.getInputStream();	
				DataInputStream flujos = new DataInputStream(aux);
				System.out.println("Cliente: " + flujos.readUTF());
				flujo.writeUTF(respuesta);
				respuesta = respuesta1;
				respuesta1 = respuesta2;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void main (String [] arg) {
		new Servidor1();
	}
}
