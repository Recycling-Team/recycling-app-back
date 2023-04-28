package com.function;

import com.common.Item;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;
import com.microsoft.azure.functions.sql.annotation.SQLOutput;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

public class DeleteItem {
    @FunctionName("DeleteItem")
    public void run(
        @TimerTrigger(name = "timerInfo", schedule = "0 0 0 * * *") String timerInfo,
        @SQLInput(
            name = "items",
            commandText =  "SELECT * FROM dbo.items WHERE available = 'True'",
            connectionStringSetting = "SqlConnectionString") List<Item> items,
        @SQLOutput(
            name = "item",
            commandText = "dbo.items",
            connectionStringSetting = "SqlConnectionString") OutputBinding <Item> Item,
        final ExecutionContext context) {

            for (Item item : items) {
                LocalDate twoWeeksAgo = LocalDate.now(ZoneOffset.UTC).minusWeeks(2);
                LocalDate itemListingDate = LocalDate.parse(item.getListing_date());
                
                if (itemListingDate.isBefore(twoWeeksAgo)) {
                    item.setAvailable("False");
                }
            }
    }
}