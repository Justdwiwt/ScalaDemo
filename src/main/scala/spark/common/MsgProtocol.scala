package spark.common

case class RegisterWorkerInfo(id: String, cpu: Int, ram: Int)

class WorkerInfo(val id: String, val cpu: Int, val ram: Int)

case object RegisterWorkerInfo
