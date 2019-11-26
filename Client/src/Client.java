/**
 *
 * Template client found on https://www.geeksforgeeks.org/socket-programming-in-java/
 * Using this for now
 */
// A Java program for a Client

import javax.xml.crypto.Data;
import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;


public class Client implements Runnable{
    // initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private PrintWriter out	 = null;
    private String line = "";
    private BufferedReader in = null;
    private boolean running;
	private JFileChooser ChooseDirectory = null;
	private String path = ""; 
    
	//changes here
	public ArrayList<Object> buffer;	//changed to object buffer
	//object input and output
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	
	

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection
		ChooseDirectory = new JFileChooser();
		ChooseDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        buffer = new ArrayList<Object>();
        try {
           running = true;
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//making the input and output stream for objects
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }


    }
    public void sendMessage(Object s) throws IOException {
        //out.println(s);
		oos.writeObject(s);
    }
    public void process(Object data){
        buffer.add(data);
    }

    public String getMessage(){
	  String ret = "";
      for(Object str : buffer){
		 if(str instanceof String){ 
			ret = ret + str.toString() + '\n';
		 }
		 else{
			ChooseDirectory.showDialog(null);
			path = ChooseDirectory.getCurrentDirectory().getPath();
			(File)str.move((File)str.getPath, path, StandardCopyOption.REPLACE_EXISTING);
			
		 }
	  }
      return ret;
   }

    public void run(){
      while(running){
         try{
            process(in.readLine());
			process(ois.readObject();
         }catch(Exception e){}
      }
   }

    public void stop(){
      try{
        running = false;
        input.close();
        out.close();
		oos.close();
		ois.close();
        socket.close();
        System.exit(0);
     }catch(Exception e){};
    }
}
