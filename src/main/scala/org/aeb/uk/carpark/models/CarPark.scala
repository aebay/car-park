package org.aeb.uk.carpark.models

import org.apache.logging.log4j.scala.Logging

import scala.collection.mutable.ArrayStack

class CarPark( private var capacity: Int = 0 ) extends Logging {

  private val occupants: ArrayStack[String] = ArrayStack()

  def park( registration: String ): Unit = {

    if ( registration.length != 4 ) logger.warn( s"Registration ($registration) does not have 4 digits - cannot park car" )
    // Todo: check that registration only contains digits (regex)

    if ( occupants.length < capacity ) occupants.push( registration )
    else logger.warn( "Car park full, cannot park car" )

  }

  def depart(): Unit = occupants.pop()

  def smallest: String = {

    occupants.min // check with test, may need to convert array to integers beforehand

  }

  def resize( capacity: Int ): Unit = {

    this.capacity = capacity
    if ( capacity < occupants.length )
      occupants.slice( occupants.length - capacity, occupants.length )

  }

}