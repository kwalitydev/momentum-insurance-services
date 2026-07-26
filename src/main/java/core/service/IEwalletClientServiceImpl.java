package core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.beans.EwalletRequest;
import core.beans.EwalletResponse;
import core.util.Util;
import dao.enums.PaymentMethodStatus;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

import static core.util.RequestUtil.EMOLA_URL;
import static core.util.RequestUtil.MPESA_URL;

@ApplicationScoped
public class IEwalletClientServiceImpl implements IEwalletClientService {

    private static final Logger logger = LoggerFactory.getLogger(IEwalletClientServiceImpl.class);

    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public IEwalletClientServiceImpl() {
        this.mapper = new ObjectMapper();
        this.client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    @Override
    public EwalletResponse transferToEwallet(EwalletRequest requestDto, PaymentMethodStatus paymentMethod) {

        long start = System.currentTimeMillis();

        String ewalletUrl = paymentMethod.equals(PaymentMethodStatus.MPESA) ?
                MPESA_URL : EMOLA_URL;
        try {
            String json = mapper.writeValueAsString(requestDto);

            logger.info("[ E-wallet REQUEST] url={} payload={}", ewalletUrl, json);

            RequestBody body = RequestBody.create(
                    json, MediaType.parse("application/json"));

            Request request = new Request
                    .Builder()
                    .url(ewalletUrl)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .build();

            try (Response response = client.newCall(request).execute()) {

                long duration = System.currentTimeMillis() - start;

                String responseBody = response.body() != null
                        ? response.body().string()
                        : "";

                logger.info("[ {} RESPONSE] code={} duration={}ms body={}",
                        paymentMethod, response.code(), duration, responseBody);

                EwalletResponse ewalletResponse =
                        mapper.readValue(responseBody, EwalletResponse.class);

                if (!Util.SUCCESS.equals(ewalletResponse.getStatus())) {
                    logger.warn("[{} BUSINESS ERROR] status={} message={}", paymentMethod,
                            ewalletResponse.getStatus(),
                            ewalletResponse.getMessage());
                }
                return ewalletResponse;
            }

        } catch (Exception e) {
            logger.error("[{} ERROR] Unexpected error API", paymentMethod, e);
            throw new RuntimeException("[E-wallet ERROR] Unexpected error E-wallet API", e);
        }
    }

}