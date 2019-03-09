package earn.bussiness.http.request.pool;

import com.ygbc.brain.business.management.api.dto.pool.GetCurrentPoolReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;
import earn.bussiness.http.request.BaseRequest;

public class GetCurrentPoolRequest extends BaseRequest<GetCurrentPoolReqDTO,PoolModel>{

    private final String url = "/pool/getCurrentPool";

    public GetCurrentPoolRequest() {
        this(new GetCurrentPoolReqDTO());
    }

    public GetCurrentPoolRequest(GetCurrentPoolReqDTO reqDTO) {
        super(reqDTO);
        init_HttpPost(url);
    }

    @Override
    public Class getRespDataClass() {
        return PoolModel.class;
    }


}
