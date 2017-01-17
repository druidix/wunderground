(ns wunderground.core
  (:gen-class)
  (:require [org.httpkit.client :as client]
            [clojure.data.json :as json])
  )

(defn parse-int [s]
  (Integer. (re-find #"\d+" s)))

(defn -main
  [args]
   (def api-key "367af81f6daa0a7b")
   (def api-base-url "http://api.wunderground.com/api/")
   (def weather-query (str "/conditions/q/" (parse-int (str args)) ".json"))
   (def query-url (str api-base-url api-key weather-query))
                                        ;(prn 'URL  query-url)
   (let [{:keys [status headers body error] :as resp} @(client/get query-url)]
            (if error
              (println "Failed, exception is " error)
              (do
                                        ;(println "Async HTTP GET status: " status)
                                        ;(println "Async HTTP GET headers: " headers)
                                        ;(println "Async HTTP GET body: " body)
                (let [body-map (json/read-str body)]
                  (do
                    (println "\nCurrent temp in" (parse-int (str args))
                             (str '\( (get-in body-map ["current_observation" "display_location" "full"]) "): " )
                             (str (get-in body-map ["current_observation" "temp_c"]) " C\n")
                             (str "Station ID:  " (get-in body-map ["current_observation" "station_id"]) "\n"))))))))
