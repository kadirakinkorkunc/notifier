package com.kkorkunc.notifier.infrastructure.message.rest.sender.client;

import com.kkorkunc.notifier.infrastructure.message.rest.sender.client.model.WebhookContent;
import com.kkorkunc.notifier.infrastructure.message.rest.sender.client.model.WebhookResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WebhookClient {

    @POST(".")
    Call<WebhookResult> send(@Body WebhookContent webhookContent);
}
