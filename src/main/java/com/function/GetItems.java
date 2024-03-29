package com.function;

import com.common.Item;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;

import java.util.Optional;
/**
 * Azure Functions with HTTP Trigger.
 */
public class GetItems {
    /**
     * This function listens at endpoint "/api/HttpTriggerDatabase". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTriggerDatabase
     * 2. curl {your host}/api/HttpTriggerDatabase?name=HTTP%20Query
     */
    @FunctionName("items")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "items",
                commandText = "SELECT * FROM dbo.items WHERE dbo.items.available = 'true'",
                commandType = "Text",
                connectionStringSetting = "SqlConnectionString")
                Item[] items) {
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(items).build();
    }
}