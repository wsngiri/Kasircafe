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

import java.util.ArrayList;
import java.sql.*;

public class Transaksi {

    public int id_transaksi;
    public Menu menu = new Menu();
    public int jumlah;
    public int total_harga;
    public int jumlah_bayar;
    public int kembalian;
    public String tanggal;

    public Transaksi() {
        
    }

    public Transaksi(int jumlah, int total_harga, int jumlah_bayar, int kembalian, String tanggal) {
        this.menu = menu;
        this.jumlah = jumlah;
        this.total_harga = total_harga;
        this.jumlah_bayar = jumlah_bayar;
        this.kembalian = kembalian;
        this.tanggal = tanggal;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public void setJumlah_bayar(int jumlah_bayar) {
        this.jumlah_bayar = jumlah_bayar;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public int getJumlah_bayar() {
        return jumlah_bayar;
    }

    public int getKembalian() {
        return kembalian;
    }

    public String getTanggal() {
        return tanggal;
    }
    
    
    
    

    public Transaksi getById(int id) {
        Transaksi tr = new Transaksi();
        ResultSet rs = Query.selectQuery("SELECT "
                + "t.id_transaksi as idtrans,"
                + "m.id_menu as idmenu,"
                + "m.nama as nama, "
                + "m.harga as harga, "
                + "t.jumlah as jumlah, "
                + "t.total_harga as totalharga,"
                + "t.jumlah_bayar as jumlahbayar, "
                + "t.kembalian as kembalian, "
                + "t.tanggal as tanggal "
                + "FROM menu m "
                + "INNER JOIN transaksi t ON t.id_menu = m.id_menu "
                + "WHERE t.id_transaksi = '" + id + "'");
        try {
            while (rs.next()) {
                tr = new Transaksi();
                tr.setId_transaksi(rs.getInt("idtrans"));
                tr.getMenu().setId_menu(rs.getInt("idmenu"));
                tr.getMenu().setNama(rs.getString("nama"));
                tr.getMenu().setHarga(rs.getInt("harga"));
                tr.setJumlah(rs.getInt("jumlah"));
                tr.setTotal_harga(rs.getInt("totalharga"));
                tr.setJumlah_bayar(rs.getInt("jumlahbayar"));
                tr.setKembalian(rs.getInt("kembalian"));
                tr.setTanggal(rs.getString("tanggal"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tr;
    }

    public ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        ResultSet rs = Query.selectQuery("SELECT "
                + "t.id_transaksi as idtrans,"
                + "m.id_menu as idmenu,"
                + "m.nama as nama, "
                + "m.harga as harga, "
                + "t.jumlah as jumlah, "
                + "t.total_harga as totalharga,"
                + "t.jumlah_bayar as jumlahbayar, "
                + "t.kembalian as kembalian, "
                + "t.tanggal as tanggal "
                + "FROM menu m "
                + "INNER JOIN transaksi t ON t.id_menu = m.id_menu ");
        try {
            while (rs.next()) {
                Transaksi tr = new Transaksi();
                tr.setId_transaksi(rs.getInt("idtrans"));
                tr.getMenu().setId_menu(rs.getInt("idmenu"));
                tr.getMenu().setNama(rs.getString("nama"));
                tr.getMenu().setHarga(rs.getInt("harga"));
                tr.setJumlah(rs.getInt("jumlah"));
                tr.setTotal_harga(rs.getInt("totalharga"));
                tr.setJumlah_bayar(rs.getInt("jumlahbayar"));
                tr.setKembalian(rs.getInt("kembalian"));
                tr.setTanggal(rs.getString("tanggal"));
                ListTransaksi.add(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaksi;
    }

    public ArrayList<Transaksi> searchMenu(String keyword) {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        ResultSet rs = Query.selectQuery("SELECT "
                + "m.id_menu as idmenu, "
                + "m.nama as nama, "
                + "m.harga as harga "
                + "FROM menu m "
                + "WHERE m.nama LIKE '%" + keyword + "%' ");
        try {
            while (rs.next()) {
                Transaksi tr = new Transaksi();
                tr.getMenu().setId_menu(rs.getInt("idmenu"));
                tr.getMenu().setNama(rs.getString("nama"));
                tr.getMenu().setHarga(rs.getInt("harga"));
                ListTransaksi.add(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaksi;
    }

    public ArrayList<Transaksi> searchTransaksi(String keyword) {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        ResultSet rs = Query.selectQuery("SELECT "
                + "t.id_transaksi as idtrans,"
                + "m.id_menu as idmenu,"
                + "m.nama as nama, "
                + "m.harga as harga, "
                + "t.jumlah as jumlah, "
                + "t.total_harga as totalharga,"
                + "t.jumlah_bayar as jumlahbayar, "
                + "t.kembalian as kembalian, "
                + "t.tanggal as tanggal "
                + "FROM menu m "
                + "INNER JOIN transaksi t ON t.id_menu = m.id_menu "
                + "WHERE m.nama LIKE '%" + keyword + "%' ");
        try {
            while (rs.next()) {
                Transaksi tr = new Transaksi();
                tr.setId_transaksi(rs.getInt("idtrans"));
                tr.getMenu().setId_menu(rs.getInt("idmenu"));
                tr.getMenu().setNama(rs.getString("nama"));
                tr.getMenu().setHarga(rs.getInt("harga"));
                tr.setJumlah(rs.getInt("jumlah"));
                tr.setTotal_harga(rs.getInt("totalharga"));
                tr.setJumlah_bayar(rs.getInt("jumlahbayar"));
                tr.setKembalian(rs.getInt("kembalian"));
                tr.setTanggal(rs.getString("tanggal"));
                ListTransaksi.add(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaksi;
    }
    

    public void save() {
        if (getById(id_transaksi).getId_transaksi()== 0) {
            String sql = "INSERT INTO transaksi (id_menu, jumlah, total_harga, jumlah_bayar, kembalian, tanggal) VALUES ("
                    + " '" + this.getMenu().getId_menu()+ "', "
                    + " '" + this.jumlah + "',"
                    + " '" + this.total_harga + "', "
                    + " '" + this.jumlah_bayar + "', "
                    + " '" + this.kembalian + "', "
                    + " '" + this.tanggal + "')";
            this.id_transaksi = Query.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE transaksi SET "
                    + " id_menu = '" + this.getMenu().getId_menu() + "', "
                    + " jumlah = '" + this.jumlah + "', "
                    + " total_harga = '" + this.total_harga + "', "
                    + " jumlah_bayar = '" + this.jumlah_bayar + "', "
                    + " kembalian = '" + this.kembalian+ "', "
                    + " tanggal = '" + this.tanggal + "' "
                    + " WHERE id_transaksi = '" + this.id_transaksi + "'";
            Query.executeQuery(sql);
        }
    }

    public void delete() {
        String sql = "DELETE FROM transaksi WHERE id_transaksi = '" + this.id_transaksi + "'";
        Query.executeQuery(sql);
    }
}
