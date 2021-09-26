import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Cjl
 * @date 2021/8/31 17:39
 */
public class TestUpdate {

    @Test
    public void testInsertDataToES() throws IOException {

        //1.获得一个客户端
        RestHighLevelClient client = ESUtil.getClient();

        //2.指明索引和类型
        String index = "book_pro10086"; //name author
        String type = "it123";

        //3.准备数据
        Book book = new Book();
        book.setId(1001L);
        book.setName("言情小说");
        book.setAuthor("小高");

        //转换成json
        String json = JSON.toJSONString(book);
        long id = book.getId();
        String s = String.valueOf(id);
        //4.准备一个request对象
        IndexRequest request = new IndexRequest(index,type,s);
        request.source(json, XContentType.JSON);

        //5.用client去发送request——restful 得到响应结果
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }
}
