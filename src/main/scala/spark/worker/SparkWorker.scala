package spark.worker

import java.util.UUID

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import spark.common.RegisterWorkerInfo

class SparkWorker(masterHost: String, masterPort: Int) extends Actor {

  var masterProxy: ActorSelection = _
  val id: String = UUID.randomUUID().toString

  override def preStart(): Unit = {
    println("preStart start ...")
    masterProxy = context.actorSelection(s"akka.tcp://SparkMaster@$masterHost:$masterPort/user/SparkMaster-01")
    println("masterProxy = " + masterProxy)
  }

  override def receive: Receive = {
    case "start" =>
      println("start worker ...")
      masterProxy ! RegisterWorkerInfo(id, 16, 16 * 1024)
    case RegisterWorkerInfo =>
      println("workerId = " + id + "success")
  }
}

object SparkWorker extends App {

  val workerHost = "127.0.0.1"
  val port = 10001
  val masterHost = "127.0.0.1"
  val masterPort = 10005

  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=127.0.0.1
       |akka.remote.netty.tcp.port=10002
       |""".stripMargin)

  private val sparkWorkerSystem: ActorSystem = ActorSystem("SparkWorker", config)
  private val sparkWorkerRef: ActorRef = sparkWorkerSystem.actorOf(Props(new SparkWorker(masterHost, masterPort)), "SparkWorker-01")


  sparkWorkerRef ! "start"

}
