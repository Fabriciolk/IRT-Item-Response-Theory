package File;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;

class DataFile
{
    private final String fileName;

    DataFile(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return fileName;
    }

    public File getDataFile()
    {
        try
        {
            return new File(getFileName());
        }
        catch (NullPointerException e)
        {
            System.out.println("Null pointer exception.");
        }

        return null;
    }

    public BufferedReader allLinesReader() throws IOException
    {
        Path path = FileSystems.getDefault().getPath(getFileName());
        return Files.newBufferedReader(path);
    }
}
