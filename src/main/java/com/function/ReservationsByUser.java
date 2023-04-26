package com.function;

import java.util.Optional;

import com.common.Reservation;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;


public class ReservationsByUser {
    @FunctionName("reservations-by-user")
    public HttpResponseMessage run(
                @HttpTrigger(name = "req", methods = {
                    HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
                @SQLInput(name = "reservations", 
                    commandText = "SELECT * FROM dbo.reservations WHERE user_id = @user_id", 
                    commandType = "Text", parameters = "@user_id={user_id}", 
                    connectionStringSetting = "SqlConnectionString") Reservation[] reservations) {
                return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(reservations).build();
        }
}

