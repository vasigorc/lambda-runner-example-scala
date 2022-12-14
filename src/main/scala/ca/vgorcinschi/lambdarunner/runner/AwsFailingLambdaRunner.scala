package ca.vgorcinschi.lambdarunner.runner

import ca.vgorcinschi.lambdarunner.modules.{AwsServicesModule, ConfigModule}
import software.amazon.awssdk.core.SdkBytes
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient
import software.amazon.awssdk.services.lambda.LambdaAsyncClient
import software.amazon.awssdk.services.lambda.model.{InvocationType, InvokeRequest, InvokeResponse}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.jdk.DurationConverters._
import scala.jdk.FutureConverters._
import scala.language.postfixOps

class AwsFailingLambdaRunner[Deps <: ConfigModule with AwsServicesModule](dependencies: Deps) {

  private[this] val lambdaClient = LambdaAsyncClient
    .builder()
    .httpClient(
      NettyNioAsyncHttpClient
        .builder()
        .readTimeout((3 seconds).toJava)
        .build()
    )
    .credentialsProvider(dependencies.getCredentialsProvider)
    .build()

  def runJob(): Unit = {

    val invokeRequest = InvokeRequest
      .builder()
      .invocationType(InvocationType.REQUEST_RESPONSE)
      .functionName(dependencies.getConfig.getString("aws.function-name"))
      .payload(SdkBytes.fromUtf8String("{}"))
      .build()

    val response: InvokeResponse = Await.result(lambdaClient.invoke(invokeRequest).asScala, 30 seconds)

    println(response.logResult())
  }
}
