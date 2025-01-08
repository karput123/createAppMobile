package com.example.myapp_pertemuan4

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface BarangDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(barang: Barang)
    @Update
    fun update(barang: Barang)
    @Delete
    fun delete(barang: Barang)
    @Query("SELECT * from barang ORDER BY id ASC")
    fun getAllBarang(): LiveData<List<Barang>>
    @Query("SELECT * FROM barang WHERE id = :barangId")
    fun getBarangById(barangId: Int): Barang
}

##interface
