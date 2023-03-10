package com.function;

import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;


import java.util.Optional;

public class GetConditions {

    @FunctionName("GetConditions")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "conditions",
                commandText = "SELECT * FROM dbo.conditions",
                commandType = "Text",
                connectionStringSetting = "SqlConnectionString")
                Condition[] conditions) {
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(conditions).build();
    }
}
