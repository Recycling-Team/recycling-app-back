package com.function;

import java.io.IOException;
import java.util.Optional;

import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLOutput;


import com.common.Item;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Azure Function with HTTP trigger to add an item to an Azure SQL database.
 */
public class AddItem {
    /**
     * This function listens at endpoint "/api/add-item" and adds an item to the
     * "Item" table in an Azure SQL database.
     */
    @FunctionName("add-item")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "add-item") HttpRequestMessage<Optional<String>> request,
            @SQLOutput(name = "item", commandText = "items", connectionStringSetting = "SqlConnectionString") OutputBinding<Item> item)
            throws JsonParseException, JsonMappingException, IOException {

        String json = request.getBody().get();
        ObjectMapper mapper = new ObjectMapper();
        Item i = mapper.readValue(json, Item.class);
        item.setValue(i);

        // Return a response indicating success
        return request.createResponseBuilder(HttpStatus.OK).build();
    }
}
