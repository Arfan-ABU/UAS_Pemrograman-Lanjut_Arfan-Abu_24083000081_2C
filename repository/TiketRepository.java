/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Tiket;
import java.util.ArrayList;

public class TiketRepository {
    private ArrayList<Tiket> data = new ArrayList<>();

    public void tambah(Tiket tiket) {
        data.add(tiket);
    }

    public void update(int index, Tiket tiket) {
        data.set(index, tiket);
    }

    public void hapus(int index) {
        data.remove(index);
    }

    public ArrayList<Tiket> getAll() {
        return data;
    }
}
