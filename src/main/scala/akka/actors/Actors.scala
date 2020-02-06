package akka.actors

import akka.actor.{ActorRef, ActorSystem, Props}

object Actors extends App {

  private val actorFactory = ActorSystem("actorFactory")

  val bActorRef: ActorRef = actorFactory.actorOf(Props[BActor], "bActor")

  val aActorRef: ActorRef = actorFactory.actorOf(Props(new AActor(bActorRef)), "aActor")

  aActorRef ! "run"

}
