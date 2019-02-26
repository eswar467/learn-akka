package com.allaboutscala.learn.akka.http.routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import com.allaboutscala.learn.akka.http.jsonsupport.{Donut, JsonSupport}
import com.typesafe.scalalogging.LazyLogging
import akka.http.scaladsl.server.Directives._

/**
  * Created by Nadim Bahadoor on 28/06/2016.
  *
  *  Tutorial: Learn How To Use Akka HTTP
  *
  * [[http://allaboutscala.com/scala-frameworks/akka/]]
  *
  * Copyright 2016 Nadim Bahadoor (http://allaboutscala.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
  * use this file except in compliance with the License. You may obtain a copy of
  * the License at
  *
  *  [http://www.apache.org/licenses/LICENSE-2.0]
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  * License for the specific language governing permissions and limitations under
  * the License.
  */
class DonutRoutes extends JsonSupport with LazyLogging {

  def route(): Route = {
    path("create-donut") {
      post {
        entity(as[Donut]) { donut =>
          logger.info(s"creating donut = $donut")
          complete(StatusCodes.Created, s"Created donut = $donut")
        }
      } ~ delete {
          complete(StatusCodes.MethodNotAllowed, "The HTTP DELETE operation is not allowed for the create-donut path.")
        }
      }
    }
}