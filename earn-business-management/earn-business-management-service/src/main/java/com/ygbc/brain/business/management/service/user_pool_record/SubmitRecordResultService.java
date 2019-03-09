package com.ygbc.brain.business.management.service.user_pool_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.constants.BusinessConstants;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.entity.UserPoolRecord;
import com.ygbc.brain.business.common.enums.PoolProcessorEvent;
import com.ygbc.brain.business.common.enums.UserPoolRecordStatus;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user_pool_record.SubmitRecordResultReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubmitRecordResultService extends BaseExecutableService<Req<SubmitRecordResultReqDTO>,Resp> {

    @Autowired
    private PoolProcessor processor;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(Req<SubmitRecordResultReqDTO> req) throws Exception {
        SubmitRecordResultReqDTO reqDTO = req.getData();
        Pool pool = processor.getPool(reqDTO.getPoolId());
        UserPoolRecord userPoolRecord = pool.getUserPoolRecord(reqDTO.getUserId(), reqDTO.getUserPoolRecordId());
        userPoolRecord.setRightNum(reqDTO.getRightNum());
        userPoolRecord.setStatus(UserPoolRecordStatus.EFFECTIVE.getValue());
        Platform.sdbUpdate(userPoolRecord.getData());
        pool.put(BusinessConstants.ATTR_USER_POOL_RECORD,userPoolRecord);
        processor.notify(pool, PoolProcessorEvent.POOL_NEW_RECORD_DONE);
        if(userPoolRecord.getResult()){
            return Resp.build(Constants.SUCCESS_RESP_CODE,Constants.SUCCESS_RESP_DESC,BusinessConstants.RECORD_RESULT_SUCCESS_ADDITION);
        }
        return Resp.build(Constants.SUCCESS_RESP_CODE,Constants.SUCCESS_RESP_DESC,BusinessConstants.RECORD_RESULT_FAILED_ADDITION);
    }
}
