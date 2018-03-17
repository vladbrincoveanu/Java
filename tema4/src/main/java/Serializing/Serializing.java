package Serializing;

import Banca.Banca;

import java.io.*;

public class Serializing {

    public static void Serialize(Object e) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("aaa.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println();
            System.out.printf("Serialized data is saved in aaa.ser");
            System.out.println();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Banca Deserialize() {
        Banca e;
        try {
            FileInputStream fileIn = new FileInputStream("aaa.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Banca) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
            return null;
        }
        return e;
    }
}
