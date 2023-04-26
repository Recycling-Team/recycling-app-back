package com.function;

import com.common.User;
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

import java.io.IOException;
import java.time.LocalDateTime;
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
            User[] users,
            @SQLOutput(
                name = "update",
                commandText = "dbo.users",
                connectionStringSetting = "SqlConnectionString")
            OutputBinding<User> user) throws JsonParseException, JsonMappingException, IOException {
        if (users.length == 0) {
            //String msg = String.format("{\"msg\": \"User not found\" }");
            return request.createResponseBuilder(HttpStatus.NOT_FOUND).header("Content-Type", "application/json").build();
        } else {
            
            User p = users[0];
            p.setLast_login(LocalDateTime.now().toString());
            user.setValue(p);
            return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(users[0]).build();
        }
    }
            
}
