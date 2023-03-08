package com.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.sql.annotation.SQLInput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS, route = "add-item") HttpRequestMessage<String> request,
            @SQLInput(name = "database", connectionStringSetting = "SqlConnectionString") Connection connection)
            throws SQLException {

        // Parse the item data from the request body
        String requestBody = request.getBody();
        String[] parts = requestBody.split(",");
        int item_id = Integer.parseInt(parts[0]);
        String item_name = parts[1];

        // Insert the new item into the database
        String sql = "INSERT INTO dbo.Item (item_id, item_name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, item_id);
        statement.setString(2, item_name);
        statement.executeUpdate();

        // Return a response indicating success
        return request.createResponseBuilder(HttpStatus.OK).build();
    }
}
