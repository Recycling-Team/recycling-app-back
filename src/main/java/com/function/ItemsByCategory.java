package com.function;

import com.common.Item;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;

import java.util.Optional;

public class ItemsByCategory {

    @FunctionName("itemsByCategory")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS,
                route = "items/category/{category}")
            HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "items",
                commandText = "SELECT * FROM dbo.items INNER JOIN (SELECT * FROM dbo.users) hlo ON dbo.items.[user] = hlo.user_id WHERE dbo.items.available = 'true' AND dbo.items.category = {category}",
                commandType = "Text",
                connectionStringSetting = "SqlConnectionString")
            Item[] items,
            @BindingName("category")
            String category) {
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(items).build();
    }
}