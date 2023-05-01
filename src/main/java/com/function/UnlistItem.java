package com.function;

import com.common.Item;
import com.common.Reservation;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;
import com.microsoft.azure.functions.sql.annotation.SQLOutput;
import com.common.Category;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;

import java.util.Optional;

public class UnlistItem {
    @FunctionName("UnlistItem")
        public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "items",
                commandText =  "SELECT * FROM dbo.items WHERE item_id = @item_id AND @item_id NOT IN(SELECT item_id FROM dbo.reservations)",
                commandType = "Text", 
                parameters = "@item_id={item_id}",
                connectionStringSetting = "SqlConnectionString") Item[] items,
            @SQLOutput(
                name = "item",
                commandText = "dbo.items",
                connectionStringSetting = "SqlConnectionString") OutputBinding <Item[]> changedItems,
                final ExecutionContext context) {
            if (items.length > 0) {
                items[0].setAvailable("False");
            }
        changedItems.setValue(items);
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").build();
    }
}
