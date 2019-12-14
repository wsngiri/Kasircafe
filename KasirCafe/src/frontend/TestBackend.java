/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;
import backend.*;
/**
 *
 * @author 62838
 */
public class TestBackend {

    public static void main(String[] args) {
//        Kategori kat1 = new Kategori("Kopi", "Kopi");
//        Menu men = new Menu("Terserah",100);
        Transaksi tr =  new Transaksi(1, 1, 1,1, "2");
        
//        tr.save();
        // test insert
//        kat1.save();
//        kat2.save();
//        kat3.save();
//          men.save();

        // test update
//        kat2.save();
          
//
//        // test delete
//        kat3.delete();
//
//        // test select all
        for (Transaksi t : new Transaksi().getAll()) {
            System.out.println("Nama: " + t.getMenu().getNama()+ ", Harga: " + t.getMenu().getHarga());
        }
        // test search
//        for(Menu k : new Menu().search("t")){
//            System.out.println("Nama: " + k.getNama()+ ", Ket: " + k.getHarga());
//        }
//    }
    }
}

