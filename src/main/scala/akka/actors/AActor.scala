package akka.actors

import akka.actor.{Actor, ActorRef}

class AActor(actorRef: ActorRef) extends Actor {

  val bActorRef: ActorRef = actorRef

  override def receive: Receive = {
    case "start" =>
      println("A: start")
      self ! "start"
    case "run" =>
      println("A: run")
      bActorRef ! "get"
    case "B: run" =>
      println("A: get")
      Thread.sleep(5000)
      bActorRef ! "A: get"
  }
}
