(ns wunderground.core
  (:gen-class)
  ; Why does this not work from project.clj?
  (:require [clj-http.client :as client]))

(defn -main
  [& args]
  ;(println "Args were: " args)
  (def response (client/head "http://www.wunderground.com/"))
  (prn (get-in response [:cookies "DT" :expires]))
  (response :status))
