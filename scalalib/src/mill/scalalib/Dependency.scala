package mill.scalalib

import mill.T
import mill.define.{Discover, ExternalModule}
import mill.eval.Evaluator
import mill.main.EvaluatorTokenReader
import mill.scalalib.dependency.DependencyUpdatesImpl

object Dependency extends ExternalModule {

  /** Calculate possible dependency updates. */
  def updates(ev: Evaluator, allowPreRelease: Boolean = false) =
    T.command {
      DependencyUpdatesImpl(
        ev,
        implicitly,
        ev.rootModule,
        ev.rootModule.millDiscover,
        allowPreRelease
      )
    }

  /** Show possible dependency updates. */
  def showUpdates(ev: Evaluator, allowPreRelease: Boolean = false) = T.command {
    DependencyUpdatesImpl.showAllUpdates(updates(ev, allowPreRelease)())
  }

  lazy val millDiscover: Discover[Dependency.this.type] = Discover[this.type]
}
