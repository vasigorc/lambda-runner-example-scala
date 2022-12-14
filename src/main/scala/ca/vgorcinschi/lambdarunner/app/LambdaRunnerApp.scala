package ca.vgorcinschi.lambdarunner.app

import ca.vgorcinschi.lambdarunner.modules.{AwsServicesModule, ConfigModule}
import ca.vgorcinschi.lambdarunner.runner.AwsFailingLambdaRunner

object LambdaRunnerApp extends App with AwsServicesModule {

  val dependencies = new ConfigModule with AwsServicesModule

  val lambdaRunner = new AwsFailingLambdaRunner(dependencies)

  lambdaRunner.runJob()
}
