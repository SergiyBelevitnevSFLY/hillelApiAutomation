import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstAPICall {


    @Test
    public void firstApiCall() throws UnirestException {


        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://completion.amazon.com/api/2017/suggestions?session-id=142-6248772-8344838&customer-id=&request-id=X1R2RZE12FVH125Z2J3D&page-type=Search&lop=en_US&site-variant=desktop&client-info=amazon-search-ui&mid=ATVPDKIKX0DER&alias=aps&ks=undefined&prefix=teapot&event=onFocusWithSearchTerm&limit=11&b2b=0&fresh=0&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET&_=1628407771431")
                .header("Connection", "keep-alive")
                .header("sec-ch-ua", "\"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"")
                .header("Accept", "application/json, text/javascript, */*; q=0.01")
                .header("sec-ch-ua-mobile", "?0")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36")
                .header("Origin", "https://www.amazon.com")
                .header("Sec-Fetch-Site", "same-site")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Dest", "empty")
                .header("Referer", "https://www.amazon.com/")
                .header("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8")
                .asString();

//        HttpResponse<String> response1 = Unirest.post("").header("","");


        System.out.println(response.getBody().toString());

    }
    
    @Test
    public void okHTTP() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://completion.amazon.com/api/2017/suggestions?session-id=142-6248772-8344838&customer-id=&request-id=X1R2RZE12FVH125Z2J3D&page-type=Search&lop=en_US&site-variant=desktop&client-info=amazon-search-ui&mid=ATVPDKIKX0DER&alias=aps&ks=undefined&prefix=bag&event=onFocusWithSearchTerm&limit=11&b2b=0&fresh=0&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET&_=1628407771431")
                .method("GET", null)
                .addHeader("Connection", "keep-alive")
                .addHeader("sec-ch-ua", "\"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"")
                .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36")
                .addHeader("Origin", "https://www.amazon.com")
                .addHeader("Sec-Fetch-Site", "same-site")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Sec-Fetch-Dest", "empty")
                .addHeader("Referer", "https://www.amazon.com/")
                .addHeader("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
        
        
        
    }
}
