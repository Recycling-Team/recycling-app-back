package com.function;

import com.common.Item;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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


public class UpdateItem {
    @FunctionName("UpdateItem")
    public HttpResponseMessage run(
        @HttpTrigger(name = "req", methods = {
        HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "update-item") HttpRequestMessage<Optional<String>> request,
        @SQLOutput(
        name = "item",
        commandText = "dbo.items",
        connectionStringSetting = "SqlConnectionString") OutputBinding <Item> item)
        throws JsonParseException, JsonMappingException, IOException {
            String json = request.getBody().get();
            ObjectMapper mapper = new ObjectMapper();
            Item i = mapper.readValue(json, Item.class);
            i.setAvailable("False");
            item.setValue(i);

            return request.createResponseBuilder(HttpStatus.OK).build();
}
}