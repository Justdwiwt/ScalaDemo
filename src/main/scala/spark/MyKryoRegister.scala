package spark

import com.esotericsoftware.kryo.Kryo
import org.apache.spark.serializer.KryoRegistrator

object MyKryoRegister extends KryoRegistrator {

  override def registerClasses(kryo: Kryo): Unit = {

  }

}
