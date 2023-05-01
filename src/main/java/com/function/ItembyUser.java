package com.function;

import java.util.Optional;

import com.common.Item;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;

public class ItembyUser {
        @FunctionName("ItembyUser")
        public HttpResponseMessage run(
                @HttpTrigger(
                        name = "req", 
                        methods = { HttpMethod.GET }, 
                        authLevel = AuthorizationLevel.ANONYMOUS) 
                        HttpRequestMessage<Optional<String>> request,
                @SQLInput(
                        name = "items", 
                        commandText = "SELECT * FROM dbo.items WHERE [user] = @user", 
                        commandType = "Text", 
                        parameters = "@user={user}", 
                        connectionStringSetting = "SqlConnectionString") 
                        Item[] items) {
                                
                return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(items).build();
        }
}
