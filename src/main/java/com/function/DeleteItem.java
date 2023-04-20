package com.function;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

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
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.time.*;

/**
 * Azure Functions with Timer trigger.
 * https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-timer?tabs=java
 */
public class DeleteItem{
    /**
     * This function will be invoked periodically according to the specified schedule.
     * The below function is executed each time the minutes have a value divisible by five
     */
    @FunctionName("DeleteItem")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "add-item") HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                    name = "items",
                    commandText = "SELECT * FROM dbo.items INNER JOIN (SELECT * FROM dbo.users) hlo ON dbo.items.[user] = hlo.user_id",
                    commandType = "Text",
                    connectionStringSetting = "SqlConnectionString")  
            Item[] items,
            @SQLOutput(
                name = "item", 
                commandText = "items", 
                connectionStringSetting = "SqlConnectionString") 
                OutputBinding<Item> item,
            final ExecutionContext context)
            throws JsonParseException, JsonMappingException, IOException {
    
        LocalDateTime twoWeeksAgo = LocalDateTime.now().minus(2, ChronoUnit.WEEKS);
    
        for (Item i : items) {
            if (i.getCreatedAt().isBefore(twoWeeksAgo)) {
                i.setVisible(false);
            }
        }
    
        return request.createResponseBuilder(HttpStatus.OK).body("Items updated.").build();
    }
}