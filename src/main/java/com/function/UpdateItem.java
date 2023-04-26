package com.function;

import com.common.Item;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;
import com.microsoft.azure.functions.sql.annotation.SQLOutput;
import com.microsoft.azure.functions.ExecutionContext;


import java.io.IOException;
import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class UpdateItem {
    /**
     * This function listens at endpoint "/api/HttpTriggerDatabase". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTriggerDatabase
     * 2. curl {your host}/api/HttpTriggerDatabase?name=HTTP%20Query
     */
    @FunctionName("UpdateItem")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
            HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "update-item") HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "inputItem",
                sqlConnectionStringSetting = "SqlConnectionString",
                commandText = "SELECT * FROM dbo.items WHERE id = @itemId",
                parameterBindings = {
            @SQLOutput(
            name = "item",
            commandText = "UPDATE dbo.items WHERE id = @itemId SET available = 'false'",
            connectionStringSetting = "SqlConnectionString") OutputBinding <Item> item)
            throws JsonParseException, JsonMappingException, IOException {

        HttpResponseMessage response = request.createResponseBuilder(HttpStatus.OK)
                .body("Item updated successfully")
                .build();
    
        return response;
    }
