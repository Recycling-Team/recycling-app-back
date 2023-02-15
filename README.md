# Prerequisites

* Java Developer Kit, version 17 or above
* Apache Maven, version 3.0 or above
* [Azure CLI](https://learn.microsoft.com/en-us/cli/azure)
* [Azure Functions Core Tools version 4](https://learn.microsoft.com/en-us/azure/azure-functions/functions-run-local#v4)

The [devcontainer.json](./.devcontainer/devcontainer.json) contains the prerequisities in a VS Code development container configuration file, which can be used in either local VS Code or GitHub codespaces.


> # Run the Function locally
>
> Before you deploy your application to Azure Function, let's first test it locally.
>
> First you need to package your application into a Jar file:
>
> ```sh
> mvn package
> ```
> Now that the application is packaged, you can run it using the azure-functions Maven plugin:
>
> ```sh
> mvn azure-functions:run
> ```
>
> https://learn.microsoft.com/en-us/azure/developer/java/spring-framework/getting-started-with-spring-cloud-function-in-azure
