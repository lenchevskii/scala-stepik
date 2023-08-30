package lectures.week2oop

import java.io.ObjectInputFilter.Config

class Button(val label: String) {
  def this() = this("test")
  def click() = s"button -${label}- has been clicked"
}

class RoundedButton(override val label: String) extends Button {
  override def click(): String = s"rounded button -${label}- has been clicked"
}

class TestButton extends Button {
  override def click(): String = s"rounded button -test- has been clicked"
}

abstract class Event {
  def trigger(eventName: String): Unit
}

class Listener(val eventName: String, var event: Event) extends Event {
  def register(evt: Event): Unit = event = evt
  def sendNotification(): Unit = event.trigger(eventName)
  override def trigger(eventName: String): Unit = println(
    s"trigger $eventName event"
  )
}

// ----------------------------------------------------------------

trait Configs {
  val ACCOUNT_TYPE_DEFAULT = "free"
  val ACCOUNT_TYPE_PAID = "paid"
  val SUBSCRIPTION_STATUS = "active"
}

object Settings {
  case class AccountSettings(email: String, password: String, picture: String)

  case class SubscriptionSettings(
      payment: String,
      notifications: String,
      expiration: String
  )
}

trait Subscriber {
  def subscribe(settings: Settings.SubscriptionSettings): Unit = println(
    "subscribed"
  )
}

trait Unsubscriber {
  def unsubscribe(): Unit = println("unsubscribed")
}

abstract class Account(accountID: String, settings: Settings.AccountSettings) {
  def info(): Unit
}

class FreeAccount(
    accountID: String,
    settings: Settings.AccountSettings
) extends Account(accountID, settings)
    with Configs
    with Subscriber {

  override def info(): Unit = println(s"Account Type: ${ACCOUNT_TYPE_DEFAULT}")
}

class PaidAccount(accountID: String, settings: Settings.AccountSettings)
    extends Account(accountID, settings)
    with Configs
    with Unsubscriber {

  override def info(): Unit = {
    println(s"Account Type: $ACCOUNT_TYPE_PAID")
    println(s"Subscription Status: $SUBSCRIPTION_STATUS")
  }
}

object Inheritance extends App {
  // val button = RoundedButton("ROUNDED")
  // println(button.click())

  // val notification: Listener = new Listener("mousedown", null)

  // notification.register(new Event {
  //   override def trigger(eventName: String): Unit =
  //     println(s"trigger $eventName event")
  // })

  println(Int.MaxValue + 1)
}
