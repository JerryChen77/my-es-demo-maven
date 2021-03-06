import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Cjl
 * @date 2021/8/31 17:33
 */
public class ESUtil {
    private static String host = "192.168.140.129";
    private static int port = 9200;

    /**
     * 获得一个操作es的es客户端工具
     */
    public static RestHighLevelClient getClient(){
        HttpHost httpHost = new HttpHost(host,port);
        RestClientBuilder builder = RestClient.builder(httpHost);
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }

}
