package com.DB;

import java.util.ArrayList;

import com.DB.loader.Loader;

/**
 * Class that selects a <code>Loader</code> object to use.
 */
public class Selector {
    private ArrayList<Loader> loaders = new ArrayList<Loader>();

    /**
     * Adds specific loader to array list. 
     * @param handler a loader to add
     */
    private void addLoader(Loader loader) {
        loaders.add(loader);
    }



}
