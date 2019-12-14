/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author 62838
 */
import java.sql.*;
import java.util.ArrayList;

public class Kategori {
    
    private int id_kategori;
    private String nama_kategori;
    private String deskripsi;
    
    public Kategori() {
    }

    public Kategori(String nama_kategori, String deskripsi) {
        this.nama_kategori = nama_kategori;
        this.deskripsi = deskripsi;
    }

    

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public Kategori getById(int id) {
        Kategori kat = new Kategori();
        ResultSet rs = Query.selectQuery("SELECT * FROM kategori WHERE id_kategori = '" + id + "'");
        try {
            while (rs.next()) {
                kat = new Kategori();
                kat.setId_kategori(rs.getInt("id_kategori"));
                kat.setNama_kategori(rs.getString("nama_kategori"));
                kat.setDeskripsi(rs.getString("deskripsi"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kat;
    }

    public ArrayList<Kategori> getAll() {
        ArrayList<Kategori> ListKategori = new ArrayList();
        ResultSet rs = Query.selectQuery("SELECT * FROM kategori");
        try {
            while (rs.next()) {
                Kategori kat = new Kategori();
                kat.setId_kategori(rs.getInt("id_kategori"));
                kat.setNama_kategori(rs.getString("nama_kategori"));
                kat.setDeskripsi(rs.getString("deskripsi"));
                ListKategori.add(kat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }

    public ArrayList<Kategori> search(String keyword) {
        ArrayList<Kategori> ListKategori = new ArrayList();
        ResultSet rs = Query.selectQuery("SELECT * FROM kategori WHERE nama_kategori like '%"+keyword+"%' OR deskripsi LIKE '%"+keyword+"%'");
        try {
            while (rs.next()) {
                Kategori kat = new Kategori();
                kat.setId_kategori(rs.getInt("id_kategori"));
                kat.setNama_kategori(rs.getString("nama_kategori"));
                kat.setDeskripsi(rs.getString("deskripsi"));
                ListKategori.add(kat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public void save(){
        if(getById(id_kategori).getId_kategori()==0){
            String sql="INSERT INTO kategori (nama_kategori, deskripsi) VALUES ('"+this.nama_kategori+"', "+"'"+this.deskripsi+"')";
            this.id_kategori = Query.insertQueryGetId(sql);
        }else{
            String sql="UPDATE kategori SET nama_kategori = '"+this.nama_kategori+"', "+"deskripsi = '"+this.deskripsi+"' WHERE id_kategori = '"+this.id_kategori+"'";
            Query.executeQuery(sql);
        }
    }
    
    public void delete(){
        String sql="DELETE FROM kategori WHERE id_kategori = '"+this.id_kategori+"'";
        Query.executeQuery(sql);
    }
    
    @Override
    public String toString(){
        return nama_kategori;
    }    
    
    
}
