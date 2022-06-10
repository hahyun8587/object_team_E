package com.util;

import java.util.ArrayList;

import com.record.manager.RecordManager;
import com.record.records.Record;
import com.record.records.Recorded;

import java.sql.SQLException;

/**
 * Class that mediates managers and managers.
 * This class is applied mediator design pattern.
 */
public class RecordManagerMediator implements Mediator {
    private ArrayList<RecordManager>[] managers;

    /**
     * Constructs <code>Mediator</code> object with <code>managers</code>.
     * @param managers array list of array list of record manger
     */
    public RecordManagerMediator(ArrayList<RecordManager>[] managers) {
        this.managers = managers;
    }
    
    @Override
    public int sendRegisteration(String id, String[] args, int i) throws SQLException{
        RecordManager manager = findManager(id, i);

        if(manager == null)
            return -1;
        
        manager.register(args);
        
        return 0; 
    } 

    @Override
    public int sendDeletion(String id, int i, String recordName) throws SQLException {
        RecordManager manager = findManager(id, i);
        
        if(manager == null)
            return -1;
        
        ArrayList<Recorded> recordeds = manager.getRecordeds(); 
        int n = recordeds.size();
        int j;

        for(j = 0; j < n; j++) {
            if(recordeds.get(j).getRecord().getName().equals(recordName))
                break;
        }
        manager.delete(j);

        return 0;
    }

    @Override
    public ArrayList<Record> sendAllList(int i) {
        ArrayList<Record> records = new ArrayList<Record>();

        for(RecordManager manager : managers[i]) {
            for(Recorded recorded : manager.getRecordeds()) {
                Record record = recorded.getRecord();

                if(!records.contains(record))
                    records.add(record);
            }
        }
        return records;        
    }

    private RecordManager findManager(String id, int i) {
        for(RecordManager manager : managers[i]) {
            if(id.equals(manager.getRecordeds().get(0).getParticipant().getId()))
                return manager;
        }
        return null;
    }
}
