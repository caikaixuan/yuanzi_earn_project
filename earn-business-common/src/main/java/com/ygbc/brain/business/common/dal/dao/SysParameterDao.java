package com.ygbc.brain.business.common.dal.dao;

import com.ygbc.brain.business.common.dal.data.SysParameterData;

public interface SysParameterDao extends BaseDao {

    SysParameterData selectOnlyOne(int ver);
}
