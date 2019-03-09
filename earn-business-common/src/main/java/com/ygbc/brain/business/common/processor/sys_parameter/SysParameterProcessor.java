package com.ygbc.brain.business.common.processor.sys_parameter;

import com.ygbc.brain.business.common.dal.dao.SysParameterDao;
import com.ygbc.brain.business.common.dal.data.SysParameterData;
import com.ygbc.brain.business.common.entity.SysParameter;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class SysParameterProcessor {

    private static Logger logger = LoggerFactory.getLogger(SysParameterProcessor.class);

    private SysParameter sysParameter = new SysParameter();

    public SysParameterProcessor(){

    }

    public SysParameterData getSysParameter() {
        return sysParameter.getData();
    }


}
