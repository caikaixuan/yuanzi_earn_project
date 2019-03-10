package earn.bussiness;

import com.ygbc.brain.business.common.enums.PoolRecordChartStatus;
import com.ygbc.brain.business.common.enums.UserPoolRecordStatus;
import com.ygbc.brain.business.management.api.dto.pool_record_chart.QueryPoolRecordChartListReqDTO;
import com.ygbc.brain.business.management.api.dto.user_pool_record.QueryUserPoolRecordListReqDTO;
import com.ygbc.brain.business.management.api.model.PoolRecordChartModel;
import com.ygbc.brain.business.management.api.model.UserPoolRecordModel;
import earn.bussiness.http.request.pool_record_chart.PoolRecordChartListRequest;
import earn.bussiness.http.request.user_pool_record.UserPoolRecordListRequest;
import earn.bussiness.thread.SimulatePoolRunThread;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimulatePoolRunThread simulatePoolRunThread = new SimulatePoolRunThread("pool thread");
        simulatePoolRunThread.start();


    }


}
