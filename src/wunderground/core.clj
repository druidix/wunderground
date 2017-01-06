(ns wunderground.core
  (:gen-class)
  (:require [org.httpkit.client :as client]
            [clojure.data.json :as json])
  )

(defn parse-int [s]
  (Integer. (re-find #"\d+" s)))

(defn -main
  [& args]
  (def api-key "367af81f6daa0a7b")
  (def api-base-url "http://api.wunderground.com/api/")
  (def weather-query "/conditions/q/CA/94558.json")
  (def query-url (str api-base-url api-key weather-query))
                                        ;(prn 'URL  query-url)
  (client/get query-url
          (fn [{:keys [status headers body error]}] ;; asynchronous response handling
            (if error
              (println "Failed, exception is " error)
              (do
                                        ;(println "Async HTTP GET status: " status)
                                        ;(println "Async HTTP GET headers: " headers)
                                        ;(println "Async HTTP GET body: " body)
                (let [body-map (json/read-str body)]
                  (do
                    (println "Current temp in" (parse-int (str args)) ":  "
                             (get-in body-map ["current_observation" "temp_c"]) "C\n"
                             "Station ID:  " (get-in body-map ["current_observation" "station_id"]) "\n"))))))))
