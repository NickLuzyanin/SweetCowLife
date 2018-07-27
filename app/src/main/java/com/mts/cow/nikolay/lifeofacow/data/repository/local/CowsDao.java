package com.mts.cow.nikolay.lifeofacow.data.repository.local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mts.cow.nikolay.lifeofacow.models.Cows;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;

import java.util.List;

@Dao
public interface CowsDao {


    @Query("SELECT * FROM cows")
    List<Cows> getCows();

    @Query("SELECT * FROM cows_params")
    List<CowTTX> getCowsTTX();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCows(Cows cows);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insertCowsTTX(CowTTX cowttx);






    /**
     * Select a task by id.
     *
     * @param cowsId the task id.
     * @return the task with taskId.
     */
    @Query("SELECT * FROM Cows WHERE entryid = :cowsId")
    Cows getCowsById(String cowsId);

    /**
     * Insert a task in the database. If the task already exists, replace it.
     *
     * @param task the task to be inserted.
     */


    /**
     * Update a task.
     *
     * @param task task to be updated
     * @return the number of tasks updated. This should always be 1.
     */
    @Update
    int updateCows(Cows task);

    /**
     * Update the complete status of a task
     *
     * @param taskId    id of the task
     * @param completed status to be updated
     */
    @Query("UPDATE cows SET completed = :completed WHERE entryid = :taskId")
    void updateCompleted(String taskId, boolean completed);

    /**
     * Delete a task by id.
     *
     * @return the number of tasks deleted. This should always be 1.
     */
    @Query("DELETE FROM cows WHERE entryid = :taskId")
    int deleteCowsById(String taskId);

    /**
     * Delete all tasks.
     */
    @Query("DELETE FROM cows")
    void deleteCows();

    /**
     * Delete all completed tasks from the table.
     *
     * @return the number of tasks deleted.
     */
    @Query("DELETE FROM cows WHERE completed = 1")
    int deleteCompletedCows();






}
