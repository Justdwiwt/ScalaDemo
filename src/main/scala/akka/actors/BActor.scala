package akka.actors

import akka.actor.Actor

class BActor extends Actor {
  override def receive: Receive = {
    case "get" =>
      println("B: start")
      sender() ! "B: run"
    case "A: get" =>
      println("B: get")
      Thread.sleep(5000)
      sender() ! "B: run"
  }
}
