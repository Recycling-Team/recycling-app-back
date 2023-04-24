package com.function;

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
import com.common.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;



public class AddUser {
    

    @FunctionName("AddUser")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "add-user") HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "users",
                commandText = "SELECT * FROM dbo.users WHERE username = @username", 
                commandType = "Text",
                parameters = "@username={username}",
                connectionStringSetting = "SqlConnectionString")    
            User[] users,
            @SQLOutput(
                name = "user", 
                commandText = "users", 
                connectionStringSetting = "SqlConnectionString") 
                OutputBinding<User> user)
            throws JsonParseException, JsonMappingException, IOException {
        if (users.length == 0) {
            String json = request.getBody().get();
            ObjectMapper mapper = new ObjectMapper();
            User u = mapper.readValue(json, User.class);
            user.setValue(u);
            // Return a response indicating success
            return request.createResponseBuilder(HttpStatus.OK).build();
        } else {
            return request.createResponseBuilder(HttpStatus.FORBIDDEN).build();
        }
    }

}
