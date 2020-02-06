package akka.actor

object ActorDemo extends App {

  private val actorFactory: ActorSystem = ActorSystem("actorFactory")

  private val actorRef: ActorRef = actorFactory.actorOf(Props[Demo], "Demo")

  actorRef ! "success"
  actorRef ! "msg"
  actorRef ! "exit"

}

class Demo extends Actor {
  override def receive: Receive = {
    case "success" => println("success")
    case "exit" =>
      println("exit success")
      context.stop(self) // stop actorRef
      context.system.terminate() // stop actorSystem
    case _ => println("error")
  }
}
