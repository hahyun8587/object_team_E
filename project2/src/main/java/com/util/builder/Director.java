package com.util.builder;

import java.util.ArrayList;

import com.DB.DAO;
import com.record.manager.RecordManager;
import com.util.GlobalVariables;
import com.util.Mediator;

import java.sql.SQLException;

/**
 * Class that uses a specific builder class to create a specific record manager class.
 * This class is applied builder design pattern.
 */
public class Director {
    private RecordManagerBuilder builder;
    private Mediator mediator;

    /**
     * Constructs <code>Director</code> object with <code>builder</code> and <code>mediator</code>.
     * @param builder a specific record manager builder
     * @param mediator <code>Mediator</code> object
     */
    public Director(RecordManagerBuilder builder, Mediator mediator) {
        this.builder = builder;
        this.mediator = mediator;
    }

    /**
     * Constructs <code>Director</code> object with <code>builder</code>.
     * @param builder a specific record manager builder
     */
    public Director(RecordManagerBuilder builder) {
        this.builder = builder;
    }

    /**
     * Creates a specific record manager for mediator.
     * @return a specific record manager for mediator
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public RecordManager manager4Mediator() throws ClassNotFoundException, SQLException {
        return builder.addObserver(DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL, GlobalVariables.ID, GlobalVariables.PASSWORD)).build();
    }

    /**
     * Creates a specific record manager for selector.
     * @return a specific record manager for selector
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public RecordManager manager4Selector() throws ClassNotFoundException, SQLException {
        return builder.setMediator(mediator).addObserver(DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL, GlobalVariables.ID, GlobalVariables.PASSWORD)).build();
    }
}
