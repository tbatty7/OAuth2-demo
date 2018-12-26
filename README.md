# OAuth2-demo
Using OAuth2 and Spring Boot to create a resource server that consumes an okta Authorization Server

Spring Boot AuthN resource server is only hit once the client has already gotten a token by whatever grant type specified.
The token comes on http header of Authorization with value Bearer 1280efjlwaf340...
