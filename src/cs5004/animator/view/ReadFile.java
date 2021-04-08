

// IGNORE FOR NOW DONT THINK WE NEED IT!!


package cs5004.animator.view;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
  private String path;

  public ReadFile(String filePath) {
    this.path = filePath;
  }

  public String[] OpenFile() throws IOException {
    FileReader fr = new FileReader(this.path);
    BufferedReader textReader = new BufferedReader(fr);

    int numberOfLines = 3;
    String[] textData = new String[numberOfLines];

    int i;
    for (i= 0; i < numberOfLines; i++) {
      textData[i] = textReader.readLine();
    }
    textReader.close();
    return textData;
  }

  /**
   * helper method that helps parse however
   * many lines in the file being read.
   * @return number of lines, int
   * @throws IOException
   */
  int readLines() throws IOException {
    FileReader fileToRead = new FileReader(this.path);
    BufferedReader bf = new BufferedReader(fileToRead);

    String aLine;
    int numberOfLines = 0;

    while ((aLine = bf.readLine()) != null) {
      numberOfLines++;
    }
    bf.close();
    return numberOfLines;
  }
}
