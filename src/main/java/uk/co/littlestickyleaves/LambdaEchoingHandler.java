package uk.co.littlestickyleaves;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.*;
import java.util.stream.Collectors;

public class LambdaEchoingHandler implements RequestStreamHandler {
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        LambdaLogger logger = context.getLogger();
        logger.log("LambdaEchoingHandler got this input:");

        // read input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String input = bufferedReader.lines().collect(Collectors.joining("\n"));
        logger.log(input);

        // write to output
        OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
        streamWriter.write(input);
        streamWriter.flush();
    }
}
