package com.function;

import com.common.Reservation;
import com.common.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Optional;

public class UnnotifiedReservations {
    @FunctionName("unnotified-reservations")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            @SQLInput(name = "reservations", commandText = "SELECT * FROM dbo.reservations WHERE user_id = @user_id AND notification = 'True'" , parameters = "@user_id={user_id}", commandType = "Text", connectionStringSetting = "SqlConnectionString") Reservation[] reservations) {
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json")
                .body(reservations).build();
    }
}
