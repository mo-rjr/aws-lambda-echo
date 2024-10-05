# aws-lambda-echo

Uses RequestStreamHandler implementation to make it clear exactly what input it received.

Helpful when you need to set up a lambda whose input you don't control, e.g. an S3Event-driven lambda &c, 
to help understand what inputs the lambda will receive, and for capturing test inputs.

## handler
uk.co.littlestickyleaves.LambdaEchoingHandler::handleRequest
 