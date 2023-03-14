# recycling-app-back

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

Before you deploy your application to Azure Function, let's first test it locally.

First you need to package your application into a Jar file:
mvn package
Now that the application is packaged, you can run it using the azure-functions Maven plugin:

mvn azure-functions:run
