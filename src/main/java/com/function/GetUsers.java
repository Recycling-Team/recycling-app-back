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

public class GetUsers {
    /**
     * This function listens at endpoint "/api/GetAllUsers". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/GetAllUsers
     * 2. curl {your host}/api/GetAllUsers?name=HTTP%20Query
     */
    @FunctionName("GetUsers")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "users",
                commandText = "SELECT * FROM dbo.users",
                commandType = "Text",
                connectionStringSetting = "SqlConnectionString")
                User[] users) {
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(users).build();
    }
}
