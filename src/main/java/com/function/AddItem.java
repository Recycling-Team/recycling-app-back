package com.function;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.function.Item;

/**
 * Azure Function with HTTP trigger to add an item to an Azure SQL database.
 */
public class AddItem {
    /**
     * This function listens at endpoint "/api/add-item" and adds an item to the
     * "Item" table in an Azure SQL database.
     */
    @FunctionName("add-item")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "add-item") HttpRequestMessage<Optional<String>> request,
            // @SQLInput(name = "toDoItems", commandText = "SELECT * FROM dbo.Item",
            // commandType = "Text", connectionStringSetting = "SqlConnectionString")
            // Connection connection,
            @SQLOutput(name = "item", commandText = "items", connectionStringSetting = "SqlConnectionString") OutputBinding<Item> item)
            throws JsonParseException, JsonMappingException, IOException {

        /*
         * // Parse the item data from the request body
         * String requestBody = request.getBody();
         * String[] parts = requestBody.split(",");
         * int item_id = Integer.parseInt(parts[0]);
         * String item_name = parts[1];
         */

        /*
         * // Insert the new item into the database
         * String sql = "INSERT INTO dbo.Item (item_id, item_name) VALUES (?, ?)";
         * PreparedStatement statement = connection.prepareStatement(sql);
         * statement.setInt(1, item_id);
         * statement.setString(2, item_name);
         * statement.executeUpdate();
         */
        String json = request.getBody().get();
        ObjectMapper mapper = new ObjectMapper();
        Item i = mapper.readValue(json, Item.class);
        item.setValue(i);

        // Return a response indicating success
        return request.createResponseBuilder(HttpStatus.OK).build();
    }
}
