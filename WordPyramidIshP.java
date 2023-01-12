import javax.swing.*; 
import java.awt.Font;
import javax.swing.UIManager;
/**
 * Word Pyramid
 *
 * ///////////////////////////////////////////////////////////////
 * 
 * @author Pierre Ishak
 * 
 * @version Dec 16, 2020
 */
public class WordPyramidIshP
{
  /**
   * Boolean to track whether cancel button has been pressed
   */
  public static boolean isCancelPressed = false; // class variable to keep track of cancel button press, assume not pressed
  
  public static void main(String[] args) 
  {
    UIManager.put("OptionPane.messageFont", new Font("Calibri", Font.PLAIN, 16));
    String word,pyramid,pyramidNextLine="";
    int pos=0,counter=0;
    
    printProgramDescription();
    word = getOrginalWord();
    pyramid = createAPyramid(word,pyramidNextLine,pos,counter);
    System.out.println(pyramid);
  }
  /**
   * Prints out program description to the user
   */
  public static void printProgramDescription()
  {
    //Prints Program Description
    JOptionPane.showMessageDialog(null,"Hello!\nThis program ","Build a Word Pyramid",JOptionPane.INFORMATION_MESSAGE);
  }
  public static String getOrginalWord()
  {
    String inputStr="",errMsg;
    boolean isNotValidCode = true;
    
    do
    {  
      inputStr = JOptionPane.showInputDialog(null,"Enter a word.","Build a Word Pyramid",JOptionPane.QUESTION_MESSAGE);
      
      errMsg = "Sorry, \" " + inputStr + " \" is empty";
      
      if (inputStr == null)
      {
        isCancelPressed = true;
        break;
      }
      
      try
      {   
        if(inputStr.trim().replaceAll(" ","").isEmpty())
        {
          Integer.parseInt("a");
        }
        
        isNotValidCode = false;  
      }
      catch (NumberFormatException error)
      {
        System.out.print(errMsg);
      }
      
    }while(isNotValidCode);
    
    return inputStr;
  }
  public static String createAPyramid(String wordPyramid, String pyramidNextLine, int pos, int counter) 
  {
    if (isCancelPressed==false) //if cancel button not pressed
    {
      for (int i=0; i < wordPyramid.length()/2-counter; i++)
      {
        pyramidNextLine += " ";
      }
      
      if (pyramidNextLine.contains(wordPyramid.substring(1,wordPyramid.length()-1)))
      {
        
        pyramidNextLine += wordPyramid;
        
        return pyramidNextLine;
      }
      else
      {
        pos = wordPyramid.length()/2;
        
        if (wordPyramid.length()%2 == 0)
        {
          pyramidNextLine += wordPyramid.substring(pos-1-counter,pos+1+counter)+ "\n";
        }
        else
        {
          pyramidNextLine += wordPyramid.substring(pos-counter,pos+1+counter)+ "\n";
        }
        counter++;
        return createAPyramid(wordPyramid,pyramidNextLine,pos,counter);
      }
    }
    return "";
  }
}