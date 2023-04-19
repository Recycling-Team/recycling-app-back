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
import com.microsoft.azure.functions.sql.annotation.SQLOutput;

import java.io.IOException;
import java.util.Optional;

public class ReservationNotified {
    @FunctionName("reservation-notified")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            @SQLOutput(
                name = "update",
                commandText = "dbo.reservations",
                connectionStringSetting = "SqlConnectionString")
            OutputBinding<Reservation> reservation) throws JsonParseException, JsonMappingException, IOException {
                String json = request.getBody().get();
                ObjectMapper mapper = new ObjectMapper();
                Reservation r = mapper.readValue(json, Reservation.class);
                r.setNotification("False");
                reservation.setValue(r);
                // Return a response indicating success
                return request.createResponseBuilder(HttpStatus.OK).build();
    }
}
