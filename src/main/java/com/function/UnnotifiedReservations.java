package com.function;

import com.common.FatReservation;
import com.common.Item;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;

import java.util.Optional;


public class UnnotifiedReservations {
    @FunctionName("unnotified-reservations")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
                @SQLInput(
                        name = "items", 
                        commandText = "SELECT * FROM dbo.items WHERE [user] = @user_id", 
                        parameters = "@user_id={user_id}", 
                        commandType = "Text", 
                        connectionStringSetting = "SqlConnectionString") Item[] items,
                @SQLInput(
                        name = "reservations", 
                        commandText = "SELECT * FROM dbo.reservations JOIN dbo.items ON dbo.reservations.item_id = dbo.items.item_id WHERE notification = 'True' AND [user] = @user_id", 
                        parameters = "@user_id={user_id}", 
                        commandType = "Text", 
                        connectionStringSetting = "SqlConnectionString") FatReservation[] reservations) {
                        for (Item item : items) {
                                for (FatReservation fatReservation : reservations)
                                        if (item.getItem_id() == fatReservation.getItem_id()) {
                                                fatReservation.setItem(item);
                                }
                        }
        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(reservations).build();
    }
}
