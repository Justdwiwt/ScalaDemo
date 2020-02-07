package akka.cs.server

import java.text.SimpleDateFormat
import java.util.Date

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.cs.common.{ClientMsg, ServerMsg}
import com.typesafe.config.ConfigFactory

class akServer extends Actor {
  override def receive: Receive = {
    case "start" =>
      println("start server ...")
      println("success !")
    case ClientMsg(msg) => msg match {
      case "test" => sender() ! ServerMsg("test success !")
      case "time" => sender() ! ServerMsg(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date))
      case _ => sender() ! ServerMsg("error !")
    }
  }
}

object akServer extends App {

  val host = "127.0.0.1"
  val port = "9999"

  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
       |""".stripMargin)

  private val serverActorSystem: ActorSystem = ActorSystem("Server", config)
  private val akServerRef: ActorRef = serverActorSystem.actorOf(Props[akServer], "akServer")

  akServerRef ! "start"

}
