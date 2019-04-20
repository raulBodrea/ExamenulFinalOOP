package Service;

import Repo.IRepo;
import Repo.Repo;
import UI.Common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
    /**
     * writes into file
     * @param filename
     * @param repo
     */
    public void writeToFile(String filename, Repo repo){
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            for (Object elId : repo.getAll()) {
                out.writeObject(repo.get((String) elId));
            }
            out.close();
            file.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
