package earn.bussiness.http.request.user;

import com.ygbc.brain.business.management.api.dto.user.QueryUserListReqDTO;
import com.ygbc.brain.business.management.api.model.UserModel;
import earn.bussiness.http.request.BaseRequest;

import java.util.List;

public class GetUsersRequest extends BaseRequest<QueryUserListReqDTO,List<UserModel>> {

    private final String url =  "/user/list";

    public GetUsersRequest() {
        this(new QueryUserListReqDTO());
    }

    public GetUsersRequest(QueryUserListReqDTO reqDTO) {
        super(reqDTO);
        init_HttpPost(url);
    }


    @Override
    public Class getRespDataClass() {
        return UserModel.class;
    }

}
