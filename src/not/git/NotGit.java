/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package not.git;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


/*
**
 *
 * @author Administrator
 */
public class NotGit {
 static doublelinked db=new doublelinked();
    static boolean fileFound=false;
    static String fileName="";
    static  String path="";
    // StringBuilder sb = new StringBuilder();
    //   JFileChooser filechooser=new JFileChooser();
    //*
    //* @param args the command line arguments
    public static void main(String[] args) {
        File ng = new File("C:\\Users\\Administrator\\Documents\\Not-git");
        StringBuilder sb = new StringBuilder();
        if (!ng.exists()) {
            Path paths = Paths.get("C:\\Users\\Administrator\\Documents\\Not-git");
            try {
                Files.createDirectory(paths);
            } catch (IOException ex) {
                Logger.getLogger(NotGit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        new menu().setVisible(true);
        Scanner s = new Scanner(System.in);
        File file = new File("C:\\Users\\Administrator\\Documents");
        String command = s.nextLine();
        while (!command.equals("end")) {
            if (command.substring(0, 3).equals("add")) {
                String temp=command.substring(4);
                for(int i=0;i<temp.length();i++)
                    if(temp.charAt(i)!='"')
                        fileName+=temp.charAt(i);
                if(searchFile(file, fileName)){
                    System.out.println(temp+" is being tracked");
                    File addfile=new File(path);
                   doublelinked db=new doublelinked();
                    db.addlast(addfile);
                   db.showcontent(addfile);
                }
            } else if (command.substring(0, 6).equals("revert")) {
                int revid = Integer.parseInt(command.substring(7));
            } else if (command.substring(0, 5).equals("status")) {

            } else if (command.substring(0, 6).equals("commit")) {

            } else if (command.substring(0, 3).equals("log")) {

            }

            
            command = s.nextLine();
        }
    }

    public static boolean searchFile(File f, String name) //File f is "C:\\"
    {
        fileFound=false;
        try {
            if (f.isDirectory()) {
                File[] fi = f.listFiles();
                for (int i = 0; i < fi.length; i++) {
                    if (fileFound == true) {
                        break;
                    }
               //      System.out.println(fi[i].getName());
                    searchFile(fi[i], name);
                }
            } else {
                if (f.getName().equals(name)) {
                    path=f.getAbsolutePath();
                    fileFound = true;
                    File fil=new File(path);
                     db.addlast(fil);
                     db.showcontent(fil);
                }
            }
        } catch (Exception e) {
           
        }
        return fileFound;
    }
  

    /*public void pickme() {
   // File ng = new File("C:\\Users\\Administrator\\Documents\\Not-git");
   java.io.File file = filechooser.getSelectedFile();
        try {

            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                sb.append(s.nextLine());
                sb.append("\n");
              //  s.close();
            }
            s.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(openfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/
}
