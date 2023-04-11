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
import com.microsoft.azure.functions.sql.annotation.SQLOutput;

public class DeleteItem {

    @FunctionName("DeleteItem")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "delete-item") HttpRequestMessage<Optional<String>> request,
            @SQLOutput(name = "item", commandText = "items", connectionStringSetting = "SqlConnectionString") OutputBinding<Item> item)
            throws JsonParseException, JsonMappingException, IOException {
    
        if (item == null) {
            return request.createResponseBuilder(HttpStatus.NOT_FOUND).body("Item with id " + item_id + " not found.").build();
        }
    
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime itemDateTime = item.getTimestamp();
    
        long hoursElapsed = ChronoUnit.HOURS.between(itemDateTime, currentDateTime);
    
        if (hoursElapsed >= 24) {
            item.available = no;
            return request.createResponseBuilder(HttpStatus.OK).body("Item with id " + item_name + " hidden successfully.").build();
        } else {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Item with id " + item_name + " cannot be hidden yet.").build();
        }
    }
}
    
