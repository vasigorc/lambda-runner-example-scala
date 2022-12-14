# Lambda runner example

A simple async Lambda client example that uses:
- Local `~/.aws/credentials` file to authenticate
- AWS Java SDK `DefaultAsyncLambdaClient` to make the request to some lambda (`failing-lambda-test` for now)