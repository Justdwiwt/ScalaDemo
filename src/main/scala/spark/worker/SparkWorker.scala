package spark.worker

import java.util.UUID

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import spark.common.{HeartBear, RegisterWorkerInfo, SendHeartBeat}

import scala.concurrent.duration._

class SparkWorker(masterHost: String, masterPort: Int, masterName: String) extends Actor {

  var masterProxy: ActorSelection = _
  val id: String = UUID.randomUUID().toString

  override def preStart(): Unit = {
    println("preStart start ...")
    masterProxy = context.actorSelection(s"akka.tcp://SparkMaster@$masterHost:$masterPort/user/$masterName")
    println("masterProxy = " + masterProxy)
  }

  override def receive: Receive = {
    case "start" =>
      println("start worker ...")
      masterProxy ! RegisterWorkerInfo(id, 16, 16 * 1024)
    case RegisterWorkerInfo =>
      println("workerId = " + id + "success")
      import context.dispatcher
      context.system.scheduler.schedule(0 millis, 3000 millis, self, SendHeartBeat)
    case SendHeartBeat =>
      println("worker = " + id + " send to master ...")
      masterProxy ! HeartBear(id)
  }
}

object SparkWorker extends App {

  if (args.length != 6) {
    println("input workerHost, workerPort, workerName, masterHost, masterPort, masterName")
    sys.exit()
  }

  val workerHost = args(0)
  val workerPort = args(1)
  val workerName = args(2)
  val masterHost = args(3)
  val masterPort = args(4)
  val masterName = args(5)

  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$workerHost
       |akka.remote.netty.tcp.port=$workerPort
       |""".stripMargin)

  private val sparkWorkerSystem: ActorSystem = ActorSystem(s"$workerName", config)
  private val sparkWorkerRef: ActorRef = sparkWorkerSystem.actorOf(Props(new SparkWorker(masterHost, masterPort.toInt, masterName)), s"$workerName")

  sparkWorkerRef ! "start"

}
