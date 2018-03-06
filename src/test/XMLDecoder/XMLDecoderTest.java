package test.XMLDecoder;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XMLDecoderTest {


    public static void main(String [] args){

        String path = Class.class.getClass().getResource("/").getPath();
//        System.out.println(path);

        ///home/mi/IdeaProjects/Coding/

//        getTheXML(path);
        outTheXML(path);


    }

    public static void outTheXML(String path){
        File file = new File(path +"test/XMLDecoder/out.xml");

        try {
            if (!file.exists()) {

                file.createNewFile();

            }
            Entity entity = new Entity();
            OutputStream out = new FileOutputStream(file);
            XMLEncoder xml = new XMLEncoder(out);
            xml.writeObject(entity);
            xml.flush();
        }catch (Exception err){
            System.out.println(err.toString());
        }


    }

    public static void getTheXML(String path){

        File file = new File(path +"test/XMLDecoder/test.xml");

        try {
            FileInputStream out = new FileInputStream(file);
            XMLDecoder xml = new XMLDecoder(out);

            Entity entity = (Entity) xml.readObject();

            System.out.println(xml.toString());
            System.out.println(entity.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
