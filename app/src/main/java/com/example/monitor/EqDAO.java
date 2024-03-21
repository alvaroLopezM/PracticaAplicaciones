package com.example.monitor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.monitor.Earthquake;
import java.util.List;
@Dao
public interface EqDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Earthquake> eqList);

    @Query("SELECT * FROM earthquakes")
    LiveData<List<Earthquake>> getEarthquakes();

    @Query("SELECT * FROM earthquakes WHERE magnitude > :mag")
    LiveData<List<Earthquake>> getEarthquakesWithMagnitudeAbove(double mag);

}