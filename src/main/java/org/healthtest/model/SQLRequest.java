package org.healthtest.model;

public interface SQLRequest {
    /**
     * method required for adding table to DB
     * @return status whit String
     */
    String getTableCreationStatus();

    /**
     * @param name - specific name of dogs
     * @return count of dog's with specific name
     */
    Integer getInfo(String name);
}
