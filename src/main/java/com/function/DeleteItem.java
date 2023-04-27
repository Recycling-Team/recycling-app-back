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
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLOutput;
import com.microsoft.azure.functions.ExecutionContext;

public class DeleteItem {

    @FunctionName("DeleteItem")
    public void run(
        // Timer which executes this function every day at 0:00 midnight
        @TimerTrigger(name = "timer", schedule = "0 0 0 * * *") String timerInfo,

        @SQLOutput(
            name = "item",
            commandText = "UPDATE dbo.items SET available = 'false' WHERE listing_date < DATEADD(week, -2, GETDATE())",
            connectionStringSetting = "SqlConnectionString") OutputBinding<Void> output,

        final ExecutionContext context)
        throws JsonParseException, JsonMappingException, IOException {


        }
}