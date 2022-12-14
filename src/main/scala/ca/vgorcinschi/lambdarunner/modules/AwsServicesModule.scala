package ca.vgorcinschi.lambdarunner.modules

import AwsServicesModule.profileCredentialsProvider
import software.amazon.awssdk.auth.credentials.{AwsCredentialsProvider, ProfileCredentialsProvider}
import software.amazon.awssdk.profiles.ProfileFile
import software.amazon.awssdk.profiles.ProfileFile.Type

import java.nio.file.Path

trait AwsServicesModule {
  def getCredentialsProvider: AwsCredentialsProvider = profileCredentialsProvider
}

object AwsServicesModule extends ConfigModule {
  private lazy val profileFile = ProfileFile
    .builder()
    .content(Path.of(getConfig.getString("aws.credentials-file-location")))
    .`type`(Type.CREDENTIALS)
    .build()

  private lazy val profileCredentialsProvider = ProfileCredentialsProvider
    .builder()
    .profileFile(profileFile)
    .profileName(getConfig.getString("aws.profile-name"))
    .build()
}
