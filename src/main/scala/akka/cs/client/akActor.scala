package akka.cs.client

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import akka.cs.common.{ClientMsg, ServerMsg}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

class akActor(serverHost: String, serverPost: Int) extends Actor {

  var serverActorRef: ActorSelection = _

  override def preStart(): Unit = {
    println("preStart start ...")
    serverActorRef = context.actorSelection(s"akka.tcp://Server@$serverHost:$serverPost/user/akServer")
    println("serverActorRef = " + serverActorRef)
  }

  override def receive: Receive = {
    case "start" =>
      println("start client ...")
      println("success !")
    case msg: String => serverActorRef ! ClientMsg(msg)
    case ServerMsg(msg) => println(s"get : $msg")
  }

}

object akActor extends App {

  val (clientHost, clientPort, serverHost, serverPort) = ("127.0.0.1", 9990, "127.0.0.1", 9999)

  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$clientHost
       |akka.remote.netty.tcp.port=$clientPort
       |""".stripMargin)

  private val clientActorSystem: ActorSystem = ActorSystem("Client", config)
  private val akClientRef: ActorRef = clientActorSystem.actorOf(Props(new akActor(serverHost, serverPort)), "akServer")

  akClientRef ! "start"

  while (true) {
    println("input:")
    val msg = StdIn.readLine()
    akClientRef ! msg
  }

}
