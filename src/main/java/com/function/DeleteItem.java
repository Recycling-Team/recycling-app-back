package com.function;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import com.common.Item;
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
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.time.*;

public class DeleteItem {

   
    public void run(
        //Timer which executes this function every day 0:00 midnight
        @TimerTrigger(name = "timer", schedule = "0 0 0 * * *") String timerInfo,
        @SQLInput(
            name = "items",
            commandText = "SELECT * FROM dbo.items INNER JOIN (SELECT * FROM dbo.users) hlo ON dbo.items.[user] = hlo.user_id",
            commandType = "Text",
            connectionStringSetting = "SqlConnectionString") Item[] items,
        @SQLOutput(
            name = "item",
            commandText = "UPDATE dbo.items SET visible = 'false' WHERE listing_date < DATEADD(week, -2, GETDATE())",
            connectionStringSetting = "SqlConnectionString") OutputBinding <Item> item,
        final ExecutionContext context)
    throws JsonParseException, JsonMappingException, IOException {

        }

    }