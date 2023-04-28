package com.function;

import com.common.Item;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;
import com.microsoft.azure.functions.sql.annotation.SQLOutput;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class HideOldItems {
    @FunctionName("HideOldItems")
    public void run(
        @TimerTrigger(name = "hideOldItems", schedule = "0 0 * * * *")  String timerInfo,
        @SQLInput(
            name = "items",
            commandText =  "SELECT * FROM dbo.items WHERE available = 'True'",
            connectionStringSetting = "SqlConnectionString") Item[] items,
        @SQLOutput(
            name = "item",
            commandText = "dbo.items",
            connectionStringSetting = "SqlConnectionString") OutputBinding <Item[]> changedItems,
        final ExecutionContext context) {
            for (Item item : items) {
                String date = item.getListing_date().replace("Z","");
                LocalDateTime twoWeeksAgo = LocalDateTime.now(ZoneOffset.UTC).minusWeeks(2);
                LocalDateTime itemListingDate = LocalDateTime.parse(date);
                if (itemListingDate.isBefore(twoWeeksAgo)) {
                    item.setAvailable("False");
                }
            }
            changedItems.setValue(items);
    }
}
