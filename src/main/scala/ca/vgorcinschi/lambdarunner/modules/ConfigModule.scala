package ca.vgorcinschi.lambdarunner.modules

import com.typesafe.config.{Config, ConfigFactory}
import ConfigModule.root

trait ConfigModule {
  def getConfig: Config = root
}

object ConfigModule {
  lazy private val root = ConfigFactory.load
}
