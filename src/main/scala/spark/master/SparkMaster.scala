package spark.master

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import spark.common._

import scala.collection.mutable
import scala.concurrent.duration._

class SparkMaster extends Actor {

  val workers: mutable.Map[String, WorkerInfo] = mutable.Map[String, WorkerInfo]()

  override def receive: Receive = {
    case "start" =>
      println("start master ...")
      self ! StartTimeOutWorker
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
    case StartTimeOutWorker =>
      println("start Heartbeat detection ...")
      import context.dispatcher
      context.system.scheduler.schedule(0 millis, 9000 millis, self, RemoveTimeOutWorker)
    case RemoveTimeOutWorker =>
      val workerInfos = workers.values
      val nowTime = System.currentTimeMillis()
      workerInfos.filter(info => nowTime - info.lastHeartBeat > 6000).foreach(info => workers.remove(info.id))
      println("active : " + workers.size)
  }
}

object SparkMaster extends App {

  if (args.length != 3) {
    println("input host, port, sparkMasterActorName")
    sys.exit()
  }

  val host = args(0)
  val port = args(1)
  val name = args(2)

  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
       |""".stripMargin)

  private val sparkMasterSystem: ActorSystem = ActorSystem("SparkMaster", config)
  private val sparkMasterRef: ActorRef = sparkMasterSystem.actorOf(Props[SparkMaster], s"$name")

  sparkMasterRef ! "start"

}
