package com.function;
import com.common.Item;
import com.common.Reservation;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;
import com.microsoft.azure.functions.sql.annotation.SQLOutput;

public class RemoveOldReservations {
    @FunctionName("RemoveOldReservations")
    public void run(
        @TimerTrigger(name = "removeOldReservations", schedule = "0 0 * * * *")  String timerInfo,
        @SQLInput(
            name = "reservations",
            commandText =  "DELETE  FROM dbo.reservations WHERE date < (GETDATE() -7)",
            connectionStringSetting = "SqlConnectionString") Reservation[] reservations,
        @SQLInput(
            name = "items",
            commandText =  "SELECT * FROM dbo.items WHERE listing_date > (GETDATE() -14)",
            connectionStringSetting = "SqlConnectionString") Item[] items,
        @SQLOutput(
            name = "item",
            commandText = "dbo.items",
            connectionStringSetting = "SqlConnectionString") OutputBinding <Item[]> changedItems,
        final ExecutionContext context) {
        for (Item item : items) {
            for (Reservation reservation : reservations) {
                if (item.getItem_id() == reservation.getItem_id()) {
                    item.setAvailable("True");
                }
            }
        }
        changedItems.setValue(items);
    }
}
