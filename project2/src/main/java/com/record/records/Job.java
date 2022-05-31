package com.record.records;

/**
 * Class that represents job.
 */
public class Job extends Record{
    private String dueDate;
    private int progress;
    private int priority;

    /**
     * Constructs <code>Job</code> object with <code>name</code>, <code>dueDate</code>, <code>progress</code>, <code>priority</code>.
     * @param name name of the job
     * @param dueDate dueDate of the job
     * @param progress progress of the job
     * @param priority priority of the job
     */
    public Job(String name, String dueDate, int progress, int priority) {
        super(name);
        this.dueDate = dueDate;
        this.progress = progress;
        this.priority = priority;
    }

    /**
     * Constructs <code>Job</code> object with <code>name</code>, <code>dueDate</code>, <code>priority</code>.
     * <code>progress</code> is initialized to 0. 
     * @param name name of the job
     * @param dueDate dueDate of the job;
     * @param priority priority of the job
     */
    public Job(String name, String dueDate, int priority) {
        super(name);
        
        this.dueDate = dueDate;
        progress = 0;
        this.priority = priority;
    }

    /**
     * Gets due date of job.
     * @return due date of job
     */
    public String getDueDate() {
        return dueDate;
    }

    public int getProgress() {
        return progress;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * Sets due date of the job.
     * @param dueDate due date of the job to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Sets progress of the job.
     * @param progress progress of the job to set
     */
    public void setProgress(int progress) {
        this.progress = progress;
    }

   /**
     * Sets priority of the job.
     * @param priority priority of the job to set
     */ 
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
