package core.sms;


import core.util.RequestUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ApiGet {
    private static final Logger LOGGER = LogManager.getLogger(ApiGet.class);

    private final String endpoint;
    private final List<NameValuePair> queryParams = new ArrayList<>();

    public ApiGet(String endpoint) {
        this.endpoint = endpoint;
    }

    public ApiGet set(String queryParam, String queryParamValue) {
        queryParams.add(new BasicNameValuePair(queryParam, queryParamValue));
        return this;
    }

    public String send() throws IOException {
        String url = RequestUtil.API_URL + endpoint + "?" + URLEncodedUtils.format(queryParams, StandardCharsets.UTF_8);
        LOGGER.info("Sending request to URL: {}", url);

        HttpGet request = new HttpGet(url);
        request.addHeader("Content-Type", "application/json; charset=UTF-8");

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(RequestUtil.API_CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(RequestUtil.API_CONNECT_TIMEOUT)
                .setSocketTimeout(RequestUtil.API_CONNECT_TIMEOUT)
                .build();

        try (CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
             BufferedReader rd = new BufferedReader(new InputStreamReader(client.execute(request).getEntity().getContent(), StandardCharsets.UTF_8))) {

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            String resp = result.toString();
            return new String(resp.getBytes(), StandardCharsets.UTF_8);
        }
    }
}
