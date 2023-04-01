package com.function;

import com.common.User;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;


import java.util.Optional;

public class LoginCheck {
    @FunctionName("login")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "users",
                commandText = "SELECT * FROM dbo.users WHERE username = @username", 
                commandType = "Text",
                parameters = "@username={name}",
                connectionStringSetting = "SqlConnectionString")
            User[] users) {
        if (users.length == 0) {
            String msg = String.format("{\"msg\": \"User not found\" }");
            return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(msg).build();
        }
        else {
            return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(users).build();
        }
    }
}
