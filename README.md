# recycling-app-back

The Recycling app is an website where you can giveaway your unwanted belongings, also you can search for items yourself. You create an account and after that you can list a new item. The items are usually for free, but you can discuss if a payment is neccessary. After you find an item you want you can message the owner and you can arrange a day you go and pickup the item. 

Here is a link to the front-side of the project. There will be a own README file that explains how to use it. /https://github.com/Recycling-Team/recycling-app-front

We use our self made database LINK HERE 

For our projects back-end we used this guide as a reference:


https://learn.microsoft.com/en-us/azure/azure-functions/create-first-function-vs-code-java


Before you get started, make sure you have the following requirements in place:

  An Azure account with an active subscription. Create an account for free.

  The Java Development Kit, version 11 or 8.

  Apache Maven, version 3.0 or above.

  Visual Studio Code on one of the supported platforms.

  The Java extension pack

  The Azure Functions extension for Visual Studio Code.
  
  
# Run the Function locally

In order for the back-end to work locally you need to have specific key values in a local.settings.json file.
{
    "IsEncrypted": false,
    "Values": {
        "AzureWebJobsStorage": "",
        "FUNCTIONS_WORKER_RUNTIME": "java",
        "SqlConnectionString": insert your connection string here
    },
    "Host": {
        "LocalHttpPort": 7071,
        "CORS": "*"
    }
}

Before you deploy your application to Azure Function, let's first test it locally.

First you need to package your application into a Jar file:

mvn package

Now that the application is packaged, you can run it using the azure-functions Maven plugin:

mvn azure-functions:run
