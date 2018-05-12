package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CarteiraDAO {
    private HashMap<String, Carteira> cacheCarteiras = new HashMap<>();
    private String fileName = "carteiras.cla";

    public CarteiraDAO() {
        try{
            FileInputStream fin = new  FileInputStream(fileName); // tenta abrir fluxo de dados
            fin.close();
        } catch(FileNotFoundException ex) {
            //se deu ruim
            new File(this.fileName);
            this.persist();
        } catch (IOException ex) {
            System.out.println(ex);
            //Logger.getLogger(MapeadorEleitor.class.getName()).log(Level.SEVERE, null, ex);  
        }
        this.load();
    }

    public void put(Carteira Carteira){
        this.cacheCarteiras.put(Carteira.getCpf(), Carteira);
        this.persist();
    }

    private void persist() {
        try{
            FileOutputStream fOutStream = new FileOutputStream(fileName);
            ObjectOutputStream obOutStream = new ObjectOutputStream(fOutStream);

            obOutStream.writeObject(this.cacheCarteiras);

            obOutStream.flush();
            fOutStream.flush();

            obOutStream.close();
            fOutStream.close();
        } catch(FileNotFoundException ex) {
            System.out.println(ex);
            //Logger.getLogger(CarteiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex) {
            System.out.println(ex);
            //Logger.getLogger(CarteiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void load() {
        try{
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oi = new ObjectInputStream(fin);

            this.cacheCarteiras = (HashMap<String, Carteira>) oi.readObject();

            oi.close();
            fin.close();

        } catch(ClassNotFoundException ex) {
            System.out.println(ex);
        } catch(FileNotFoundException ex) {
            System.out.println(ex);
            //Logger.getLogger(CarteiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex) {
            System.out.println(ex);
            //Logger.getLogger(CarteiraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Carteira get(String matricula){
        return this.cacheCarteiras.get(matricula);
    }

    public void remove(Carteira Carteira) {
        this.cacheCarteiras.remove(Carteira.getCpf(), Carteira);
        this.persist();

    }

    public Collection<Carteira> getList() {
        return this.cacheCarteiras.values();
    }

    public ArrayList<Carteira> getCarteiras(){
        return new ArrayList<Carteira>(this.getList());
    }

    public boolean isEmpty() {
        return false;
    }
}
