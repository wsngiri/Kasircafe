/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 62838
 */
public class Menu {
    
    public int id_menu;
    public String nama;
    Kategori kat =  new Kategori();
    public int harga;

    public Menu() {
    }

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }


    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKat(Kategori kat) {
        this.kat = kat;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getId_menu() {
        return id_menu;
    }

    public String getNama() {
        return nama;
    }

    public Kategori getKat() {
        return kat;
    }

    public int getHarga() {
        return harga;
    }
        public Menu getById(int id) {
        Menu men = new Menu();
        ResultSet rs = Query.selectQuery("SELECT "
                + "m.id_menu as idmenu, "
                + "m.id_kategori as idkategori, "
                + "m.nama as nama, "
                + "m.harga as harga,"
                + "k.id_kategori as idkategori, "
                + "k.nama_kategori as namakat, "
                + "k.deskripsi as deskripsi "
                + "FROM menu m "
                + "INNER JOIN kategori k ON m.id_kategori = k.id_kategori "
                + "WHERE m.id_menu= '" + id + "'");
        try {
            while (rs.next()) {
                men = new Menu();
                men.setId_menu(rs.getInt("idmenu"));
                men.setNama(rs.getString("nama"));
                men.setHarga(rs.getInt("harga"));
                men.getKat().setId_kategori(rs.getInt("idkategori"));
                men.getKat().setNama_kategori(rs.getString("namakat"));
                men.getKat().setDeskripsi(rs.getString("deskripsi"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return men;
    }

    public ArrayList<Menu> getAll() {
        ArrayList<Menu> ListMenu = new ArrayList();
        ResultSet rs = Query.selectQuery("SELECT "
                + "m.id_menu as idmenu, "
                + "m.id_kategori as idkategori, "
                + "m.nama as nama, "
                + "m.harga as harga,"
                + "k.id_kategori as idkategori, "
                + "k.nama_kategori as namakat, "
                + "k.deskripsi as deskripsi "
                + "FROM menu m "
                + "INNER JOIN kategori k ON m.id_kategori = k.id_kategori ");
        try {
            while (rs.next()) {
                Menu men = new Menu();
                men.setId_menu(rs.getInt("idmenu"));
                men.setNama(rs.getString("nama"));
                men.setHarga(rs.getInt("harga"));
                men.getKat().setId_kategori(rs.getInt("idkategori"));
                men.getKat().setNama_kategori(rs.getString("namakat"));
                men.getKat().setDeskripsi(rs.getString("deskripsi"));
                ListMenu.add(men);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMenu;
    }

    public ArrayList<Menu> search(String keyword) {
        ArrayList<Menu> ListMenu = new ArrayList();
        ResultSet rs = Query.selectQuery("SELECT "
                + "m.id_menu as idmenu, "
                + "m.id_kategori as idkategori, "
                + "m.nama as nama, "
                + "m.harga as harga,"
                + "k.id_kategori as idkategori, "
                + "k.nama_kategori as namakat, "
                + "k.deskripsi as deskripsi "
                + "FROM menu m "
                + "INNER JOIN kategori k ON m.id_kategori = k.id_kategori "
                + "WHERE m.nama LIKE '%" + keyword + "%' "
                + "OR k.nama_kategori LIKE '%" + keyword + "%' "
                + "OR k.deskripsi LIKE '%" + keyword + "%' ");
        try {
            while (rs.next()) {
                Menu men = new Menu();
                men.setId_menu(rs.getInt("idmenu"));
                men.setNama(rs.getString("nama"));
                men.setHarga(rs.getInt("harga"));
                men.getKat().setId_kategori(rs.getInt("idkategori"));
                men.getKat().setNama_kategori(rs.getString("namakat"));
                men.getKat().setDeskripsi(rs.getString("deskripsi"));
                ListMenu.add(men);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMenu;
    }

    public void save() {
        if (getById(id_menu).getId_menu()== 0) {
            String sql = "INSERT INTO menu (id_kategori, nama, harga) VALUES ("
                    + " '" + this.getKat().getId_kategori() + "',"
                    + " '" + this.nama + "', "
                    + " '" + this.harga + "')";
            this.id_menu = Query.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE menu SET "
                    +" id_kategori = '"+this.getKat().getId_kategori()+"', "
                    +" nama = '"+this.nama+"', "
                    +" harga = '"+this.harga+"' "
                    +" WHERE id_menu = '"+this.id_menu+"'";
            Query.executeQuery(sql);
        }
    }

    public void delete() {
        String sql = "DELETE FROM menu WHERE id_menu = '" + this.id_menu + "'";
        Query.executeQuery(sql);
    }
    public String toString(){
        return nama;
    }
        
}
