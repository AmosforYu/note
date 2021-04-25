package jalonetask.job.biz;

import jalonetask.job.AbstractJob;

/**
 * @author Yamos
 * @description SendMsgJob
 * @date 2021/3/4 0004 17:43
 */
public class SendMsgJob extends AbstractJob {

    private String serviceName;

    public SendMsgJob(String groupId, String jobId, String serviceName) {
        super(groupId, jobId);
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

}
