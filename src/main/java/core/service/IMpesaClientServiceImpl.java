package core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.beans.MpesaRequest;
import core.beans.MpesaResponse;
import core.util.Util;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

import static core.util.RequestUtil.MPESA_URL;

@ApplicationScoped
public class IMpesaClientServiceImpl implements IMpesaClientService {

    private static final Logger logger = LoggerFactory.getLogger(IMpesaClientServiceImpl.class);

    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public IMpesaClientServiceImpl() {
        this.mapper = new ObjectMapper();
        this.client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    @Override
    public MpesaResponse callMpesa(MpesaRequest requestDto) {

        long start = System.currentTimeMillis();

        try {
            String json = mapper.writeValueAsString(requestDto);

            logger.info("[M-PESA REQUEST] url={} payload={}", MPESA_URL, json);

            RequestBody body = RequestBody.create(
                    json, MediaType.parse("application/json"));

            Request request = new Request
                    .Builder()
                    .url(MPESA_URL)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .build();

            try (Response response = client.newCall(request).execute()) {

                long duration = System.currentTimeMillis() - start;

                String responseBody = response.body() != null
                        ? response.body().string()
                        : "";

                logger.info("[M-PESA RESPONSE] code={} duration={}ms body={}",
                        response.code(), duration, responseBody);

                MpesaResponse mpesaResponse =
                        mapper.readValue(responseBody, MpesaResponse.class);

                if (!Util.SUCCESS.equals(mpesaResponse.getStatus())) {
                    logger.warn("[M-PESA BUSINESS ERROR] status={} message={}",
                            mpesaResponse.getStatus(),
                            mpesaResponse.getMessage());
                }

                return mpesaResponse;
            }

        } catch (Exception e) {
            logger.error("[M-PESA ERROR] Unexpected error M-Pesa API", e);
            throw new RuntimeException("[M-PESA ERROR] Unexpected error M-Pesa API", e);
        }
    }

}