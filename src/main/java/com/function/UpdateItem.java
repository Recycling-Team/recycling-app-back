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


public class UpdateItem {

    @FunctionName("UpdateItem")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
            HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "update-item") HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "updateItem",
                commandType = "Text",
                commandText = "SELECT * FROM dbo.items WHERE id = @itemId",
                connectionStringSetting = "SqlConnectionString" 
            )
            @SQLOutput(
            name = "item",
            commandText = "UPDATE dbo.items WHERE id = @itemId SET available = 'false'",
            connectionStringSetting = "SqlConnectionString") OutputBinding <Item> item)
            throws JsonParseException, JsonMappingException, IOException {

         // Get the itemId from the request query parameter
    String itemId = request.getQueryParameters().get("itemId");
    
    // Update the SQL query commandText with the itemId parameter
    ((SQLOutputBinding<Item>) item).setCommandText("UPDATE dbo.items SET available = 'false' WHERE id = '" + itemId + "'");
    
    // Execute the SQL query
    item.setValue(new Item());
    
    HttpResponseMessage response = request.createResponseBuilder(HttpStatus.OK)
            .body("Item available set to false successfully")
            .build();

    return response;
    }
}