package earn.bussiness.http.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

public abstract class BaseRequest<T, M> {

    protected static final String BASE_REQUEST_URL = "http://127.0.0.1:8080/earn-business-management-web/";

    protected final HttpClient httpClient = HttpClientBuilder.create().build();

    protected HttpPost httpPost = new HttpPost();

    protected Req<T> req = new Req();


    {
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
    }

    public BaseRequest(T t) {
        this.req.setData(t);
    }

    public void init_HttpPost(String postURL){
        httpPost.setURI(URI.create(BASE_REQUEST_URL + postURL));
        StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(req), Charset.forName("UTF-8"));
        httpPost.setEntity(stringEntity);
    }

    public Resp<M> exec() {
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            StatusLine status = httpResponse.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                Resp<M> resp = JSON.parseObject(EntityUtils.toString(httpResponse.getEntity()), Resp.class);
                Object dataObject = resp.getData();
                if (dataObject instanceof JSONArray) {
                    M data = (M) JSONArray.parseArray(JSON.toJSONString(dataObject), getRespDataClass());
                    resp.setData(data);
                }
                if (dataObject instanceof JSONObject) {
                    M data = (M) JSON.parseObject(JSON.toJSONString(dataObject), getRespDataClass());
                    resp.setData(data);
                }
                return resp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public M execForModel(){
        Resp<M> resp = this.exec();
        if(resp != null){
            return resp.getData();
        }
        return null;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public abstract Class getRespDataClass();


}
