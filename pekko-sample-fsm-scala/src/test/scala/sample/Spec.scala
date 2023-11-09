package sample

import java.time.{Duration => JavaDuration}

import org.scalatest.freespec.AnyFreeSpec

import scala.concurrent.Await
import scala.concurrent.duration._

class Spec extends AnyFreeSpec {

  private def timing[T](f: () => T) = {
    val before = System.nanoTime()
    f()
    val after = System.nanoTime()
    JavaDuration.ofNanos(after - before)
  }

  "work" in {
    {
      val took = timing(() => {
        val actorSystem = DiningHakkers.actorSystem()
        actorSystem.terminate()
        Await.result(actorSystem.whenTerminated, Duration.Inf)
      })
      println(s"Done in [$took]")
    }
    {
      val took = timing(() => {
        val actorSystem = DiningHakkers.actorSystem()
        actorSystem.terminate()
        Await.result(actorSystem.whenTerminated, Duration.Inf)
      })
      println(s"Done in [$took]")
    }
    {
      val took = timing(() => {
        val actorSystem = DiningHakkers.actorSystem()
        actorSystem.terminate()
        Await.result(actorSystem.whenTerminated, Duration.Inf)
      })
      println(s"Done in [$took]")
    }
  }
}
