//package Sendit;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
public class ChooseFile
{
    JFileChooser fileChooser = new JFileChooser();
    StringBuilder sb = new StringBuilder();

    public void PickFile() throws IOException
    {
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
         //get file
         java.io.File file = fileChooser.getSelectedFile();

         //create scanner for the file
         Scanner in = new Scanner(file);

         //read text from file
         while (in.hasNext()){ sb.append(in.nextLine()); sb.append("\n");}
         in.close();
        }else {sb.append("No file was selected");}

    }

}
