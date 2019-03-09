package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.data.SysParameterData;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.common.utils.PropertiesUtils;
import com.ygbc.brain.common.utils.SpringUtils;

public class SysParameter extends AttributeEntity<SysParameter,SysParameterData> {

    private final static SysParameter instance = new SysParameter();

    public SysParameter() {

    }

    public SysParameter(SysParameterData data){
        super(data);
    }

    public SysParameterData getData() {
        if(data == null){
            PropertiesUtils propertiesUtils = SpringUtils.getBean(PropertiesUtils.class);
            SysParameterData parameterData = new SysParameterData();
            parameterData.setAppVersion(propertiesUtils.getIntValue("appVersion"));
            data = Platform.dbRead(new SysParameterData());
        }
        return data;
    }

    public void setData(SysParameterData data) {
        this.data = data;
    }

    public static SysParameter getInstance() {
        return instance;
    }


}
