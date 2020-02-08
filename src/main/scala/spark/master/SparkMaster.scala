package spark.master

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import spark.common.{HeartBear, RegisterWorkerInfo, WorkerInfo}

import scala.collection.mutable

class SparkMaster extends Actor {

  val workers: mutable.Map[String, WorkerInfo] = mutable.Map[String, WorkerInfo]()

  override def receive: Receive = {
    case "start" => println("start master ...")
    case RegisterWorkerInfo(id, cpu, ram) =>
      if (!workers.contains(id)) {
        val workerInfo = new WorkerInfo(id, cpu, ram)
        workers += ((id, workerInfo))
        println("Server workers = " + workers)
        sender() ! RegisterWorkerInfo
      }
    case HeartBear(id) =>
      val workerInfo = workers(id)
      workerInfo.lastHeartBeat = System.currentTimeMillis()
      println("master update " + id + " hearBeat ...")
  }
}

object SparkMaster extends App {

  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=127.0.0.1
       |akka.remote.netty.tcp.port=10005
       |""".stripMargin)

  private val sparkMasterSystem: ActorSystem = ActorSystem("SparkMaster", config)
  private val sparkMasterRef: ActorRef = sparkMasterSystem.actorOf(Props[SparkMaster], "SparkMaster-01")

  sparkMasterRef ! "start"

}
