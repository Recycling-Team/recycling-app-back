# Recycling-app-back

The Recycling app is an application through which you can donate items you don't need anymore, also you can search for items yourself. You create an account and after that you can make a listing for an item you want to donate. After you reserve an item you want you can see message from the donator to see how to pick up the item or contact details. 

Here is a link to the front-side of the project. There will be a own README file that explains how to use it. 
https://github.com/Recycling-Team/recycling-app-front

The database is in the repository as file named: **[Database table creation scripts.txt](https://github.com/Recycling-Team/recycling-app-back/blob/main/Database%20table%20creation%20scripts.txt)** 

For our projects back-end we used this guide as a reference:


https://learn.microsoft.com/en-us/azure/azure-functions/create-first-function-vs-code-java


Before you get started, make sure you have the following requirements in place:

* An Azure account with an active subscription. 

* The Java Development Kit, version 11 or above.

* Apache Maven, version 3.0 or above.

* Azure Core tools 4.x or newer

* Visual Studio Code on one of the supported platforms.

* The Java extension pack

* The Azure Functions extension for Visual Studio Code.
  
  
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

You need to package your application:
   
    mvn clean package

To run the application:
   
    mvn azure-functions:run
