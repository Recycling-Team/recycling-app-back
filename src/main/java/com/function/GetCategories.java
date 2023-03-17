package com.function;

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

public class GetCategories {
    @FunctionName("categories")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "categories",
                commandText = "SELECT * FROM dbo.categories",
                commandType = "Text",
                connectionStringSetting = "SqlConnectionString")
                Category[] categories) {
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(categories).build();
    }
}
