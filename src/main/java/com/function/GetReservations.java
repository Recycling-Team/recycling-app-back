package com.function;

import com.common.Reservation;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;


import java.util.Optional;

public class GetReservations {
    @FunctionName("GetReservations")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            @SQLInput(
                name = "reservations",
                commandText = "SELECT * FROM dbo.reservations",
                commandType = "Text",
                connectionStringSetting = "SqlConnectionString")
                Reservation[] reservations) {
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(reservations).build();
    }
}
