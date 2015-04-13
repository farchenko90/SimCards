package Utiles;

import Conexion.Conexion;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.border.DropShadowBorder;


public class Metodos {
    
    
    
    
    public void Solo_Numeros(JTextField a)
    {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char c = e.getKeyChar();
                if((Character.isLetter(c)))
                {
                   e.consume();
                }
                else
                {
                    if(((int)e.getKeyChar() != 20) && ((int)e.getKeyChar() != 44) && 
                            (((int)e.getKeyChar() < 48) || ((int)e.getKeyChar() > 57)))
                    {
                       e.consume();
                    }
                }
            }
        });
        
    }
    
    private void sombra_total_panel(JPanel jp){
        DropShadowBorder shadow = new DropShadowBorder();
        shadow.setShadowColor(Color.BLACK);
        shadow.setShowLeftShadow(false);
        shadow.setShowRightShadow(false);
        shadow.setShowBottomShadow(true);
        shadow.setShowTopShadow(false);
        shadow.setShadowSize(7);
        shadow.setShadowOpacity(0.3f);
        jp.setBorder(shadow);
    } 
    
    public String carptura_ext(String nom){
        String extension = "";
        String nomb = nom;
        int i = nomb.lastIndexOf('.');
            if (i > 0) {
                extension = nomb.substring(i+1);
            }
         return extension;
    }
    
    public void Limite_Caracteres(JTextField a,int limite)
    {
        final int limit = limite;
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                JTextField c =(JTextField) e.getComponent();
                if(c.getText().length() == limit)
                {
                    //getToolkit().beep(); //producir un sonido
                    e.consume();
                }  
            }
        });
    }
    
    public boolean Validar_Email (String email) 
    {
        // Establecer el patron
        Pattern p = Pattern.compile("[-\\w\\.]+@\\w+\\.\\w+");

        // Asociar el string al patron
        Matcher m = p.matcher(email);

       // Comprobar si encaja
        boolean estado = m.matches();
        if(!estado)
        {
            JOptionPane.showMessageDialog(null,"El correo electrónico es incorrecto, por favor digite un correo válido "
                    + ", por ejemplo:\n usuario_001@hotmail.com",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
       return estado;
    }
    
    public boolean campo_vacio(JTextField txt,String campo)
    {
        String cadena = txt.getText().trim();
        if(cadena.compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(null,"El campo '"+campo+"' se encuentra vacio, por favor ingrese un valor en dicho campo.",
                                          "Error",JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return true;
        }
        return false;
    }

public File Blob_a_File(Blob blob,String nombre,String extensio,int id) throws IOException
  { 
        FileOutputStream       outStream   = null;
        try {
            File              blobFile   = new File(nombre+String.valueOf(id)+"."+extensio);
            //blobFile.deleteOnExit();
            outStream = new FileOutputStream(blobFile);
            InputStream       inStream   = blob.getBinaryStream();
            
            int     length  = -1; 
            int     size    = (int)blob.length(); 
            byte[]  buffer  = new byte[size]; 

            while ((length = inStream.read(buffer)) != -1) 
            { 
              outStream.write(buffer, 0, length); 
              outStream.flush(); 
            } 
 
            inStream.close(); 
            outStream.close(); 
            return blobFile;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
  }  

 public void Abrir_Archivo(String ruta,String extencion)
    {
        try {
                
                Runtime app = Runtime.getRuntime();
                app.exec("cmd /C start "+ruta+"."+extencion);
                
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void ejecutar_archivo(File archivo) 
    {
        if(Desktop.isDesktopSupported()==true) {
        Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(archivo);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
        JOptionPane.showMessageDialog(null, "No se puede ejecutar el comando de apertura en este sistema operativo", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }   
    
}
