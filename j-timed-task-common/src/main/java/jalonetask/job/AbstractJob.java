package jalonetask.job;

/**
 * @author Yamos
 * @description AbstractJob
 * @date 2021/3/4 0004 17:36
 */
public abstract class AbstractJob implements IJob {
    protected String groupId;
    protected String jobId;

    @Override
    public String getGroupId() {
        return null;
    }

    @Override
    public String getJobId() {
        return null;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public AbstractJob() {
    }

    public AbstractJob(String groupId, String jobId) {
        this.groupId = groupId;
        this.jobId = jobId;
    }
}
