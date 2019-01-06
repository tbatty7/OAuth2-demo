# Example of OAuth2 Auth server that dispenses jwt tokens when given a client id and secret
This project uses OAuth2 and Spring Boot to create an Authorization Server.
- The Authorization server expects a client id and secret
- To get a token from this server after firing it up, use this curl:
    - curl service-account-1:service-account-1-secret@localhost:8080/auth/oauth/token -d grant_type=client_credentials
        - This sends the client id and secret before the protocol and url and the -d adds the grant type
- I had to tweak the config to encode the client secret due to the latest version of Security
- It is set up to send jwt tokens with scopes and roles (authorities) encoded in them.

In an OAuth2 scenario, the client must first hit the Auth server to get a token.
Spring Boot AuthN resource server is only hit once the client has already gotten a token by whatever grant type specified.
The token comes on http header of Authorization with value 
Bearer [whatever the token is, but not in square brackets]

##To test this, use the resource-server repo and start this up first, then the resource server.
* Get a token with this curl:
    * curl service-account-1:service-account-1-secret@localhost:8080/auth/oauth/token -d grant_type=client_credentials
        * copy the token from the response
* Set the token to an environment variable like this:
    * export TOKEN="token"
        * Paste token in quotes instead of typing the word token there.
* Send token in GET request to resource server with this curl:
    * curl -H "Authorization: Bearer $TOKEN" -v localhost:9090
        * This should give a response of "Hello world!"
* Send token in this POST request to modify a field in the resource server:
    * curl -H "Content-Type: application/json" -H "Authorization: Bearer $TOKEN" -X POST -d    “Bonjour monde” -v localhost:9090
        * This does not give a response, but changes the response from "Hello world!" to "Bonjour monde"
* Make GET request again
    * curl -H "Authorization: Bearer $TOKEN" -v localhost:9090
        * This should now give a response of "Bonjour monde"
* Make this GET request to get details assigned to token (or encoded into it?)
    * curl -H "Authorization: Bearer $TOKEN" -v localhost:9090/user
        * This should give you the values in the decoded jwt token.



